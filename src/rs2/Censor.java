package rs2;

public class Censor {

    public static void loadConfig(JagexArchive jagexArchive)
    {
        Packet fragmentsencStream = new Packet(jagexArchive.getDataForName("fragmentsenc.txt"));
        Packet badencStream = new Packet(jagexArchive.getDataForName("badenc.txt"));
        Packet domainencStream = new Packet(jagexArchive.getDataForName("domainenc.txt"));
        Packet tldlistStream = new Packet(jagexArchive.getDataForName("tldlist.txt"));
        readValues(fragmentsencStream, badencStream, domainencStream, tldlistStream);
    }

    private static void readValues(Packet fragmentsenc, Packet badenc, Packet domainenc, Packet tldlist)
    {
        readBadEnc(badenc);
        readDomainEnc(domainenc);
        readFragmentsEnc(fragmentsenc);
        readTldList(tldlist);
    }

    private static void readTldList(Packet stream)
    {
    	// Gets the number of tlds
        int length = stream.g4();
        //Creates the arrays
        tldList = new char[length][];
        tldArray = new int[length];
        for(int id = 0; id < length; id++)
        {
            tldArray[id] = stream.g1();
            char tld[] = new char[stream.g1()];
            for(int charID = 0; charID < tld.length; charID++)
                tld[charID] = (char) stream.g1();

            tldList[id] = tld;
        }

    }

    private static void readBadEnc(Packet stream)
    {
        int length = stream.g4();
        badenc = new char[length][];
        badencByte = new byte[length][][];
        initBadenc(stream, badenc, badencByte);
    }

    private static void readDomainEnc(Packet stream)
    {
        int length = stream.g4();
        domainenc = new char[length][];
            initDomainenc(domainenc, stream);
    }

    private static void readFragmentsEnc(Packet stream)
    {
        fragmentsenc = new int[stream.g4()];
        for(int id = 0; id < fragmentsenc.length; id++)
            fragmentsenc[id] = stream.g2();
    }

    private static void initBadenc(Packet stream, char badenc[][], byte badencComplexArray[][][])
    {
        for(int id = 0; id < badenc.length; id++)
        {
            char val[] = new char[stream.g1()];
            for(int charId = 0; charId < val.length; charId++)
                val[charId] = (char) stream.g1();

            badenc[id] = val;
            byte abyte1[][] = new byte[stream.g1()][2];
            for(int l = 0; l < abyte1.length; l++)
            {
                abyte1[l][0] = (byte) stream.g1();
                abyte1[l][1] = (byte) stream.g1();
            }

            if(abyte1.length > 0)
                badencComplexArray[id] = abyte1;
        }

    }

    private static void initDomainenc(char ac[][], Packet stream)
    {
        for(int j = 0; j < ac.length; j++)
        {
            char val[] = new char[stream.g1()];
            for(int k = 0; k < val.length; k++)
                val[k] = (char) stream.g1();

            ac[j] = val;
        }

    }

    private static void stripNonlegalChars(char chars[])
    {
        int writePos = 0;
        for(int readPos = 0; readPos < chars.length; readPos++)
        {
            if(charIsLegal(chars[readPos]))
                chars[writePos] = chars[readPos];
            else
                chars[writePos] = ' ';
            if(writePos == 0 || chars[writePos] != ' ' || chars[writePos - 1] != ' ')
                writePos++;
        }
        for(int padPos = writePos; padPos < chars.length; padPos++)
            chars[padPos] = ' ';

    }

    private static boolean charIsLegal(char c)
    {
        return c >= ' ' && c <= '\177' || c == ' ' || c == '\n' || c == '\t' || c == '\243' || c == '\u20AC';
    }

    public static String doCensor(String s)
    {
        long startTime = System.currentTimeMillis();//proberly for performance testing
        char chars[] = s.toCharArray();
        stripNonlegalChars(chars);
        String trimmed = (new String(chars)).trim();
        chars = trimmed.toLowerCase().toCharArray();
        String trimmedLowerCase = trimmed.toLowerCase();
        removeTlds(chars);
        processBadenc(chars);
        removeEmails(chars);
        censorLongNumbers(chars);
        for(int j = 0; j < exceptions.length; j++)
        {
            for(int exceptionPos = -1; (exceptionPos = trimmedLowerCase.indexOf(exceptions[j], exceptionPos + 1)) != -1;)
            {
                char exceptionChars[] = exceptions[j].toCharArray();
                System.arraycopy(exceptionChars, 0, chars, exceptionPos, exceptionChars.length);

            }

        }
        restoreOriginalCase(trimmed.toCharArray(), chars);
        fixCases(chars);
        long endTime = System.currentTimeMillis();
        return s;//return (new String(ac)).trim(); //xxx chat filter, return s to avoid
    }

    private static void restoreOriginalCase(char baseText[], char censoredText[])
    {
        for(int pos = 0; pos < baseText.length; pos++)
            if(censoredText[pos] != '*' && isUpperCaseLetter(baseText[pos]))
                censoredText[pos] = baseText[pos];
    }

    private static void fixCases(char chars[])
    {
        boolean skipToNextUppercase = true;
        for(int pos = 0; pos < chars.length; pos++)
        {
            char c = chars[pos];
            if(isLetter(c))
            {
                if(skipToNextUppercase)
                {
                    if(isLowerCaseLetter(c))
                        skipToNextUppercase = false;
                } else
                if(isUpperCaseLetter(c))
                    chars[pos] = (char)((c + 97) - 65);
            } else
            {
                skipToNextUppercase = true;
            }
        }
    }

    private static void processBadenc(char text[])
    {
        for(int i = 0; i < 2; i++)
        {
            for(int badencId = badenc.length - 1; badencId >= 0; badencId--)
                censorStringIn(badencByte[badencId], text, badenc[badencId]);

        }
    }

    private static void removeEmails(char ac[])
    {
        char textClone[] = ac.clone();
        char atSignString[] = {
            '(', 'a', ')'
        };
        censorStringIn(null, textClone, atSignString);
        char textClone2[] = ac.clone();
        char dotString[] = {
            'd', 'o', 't'
        };
        censorStringIn(null, textClone2, dotString);
        for(int id = domainenc.length - 1; id >= 0; id--)
            removeEmailFrom(ac, domainenc[id], textClone2, textClone);
    }

    private static void removeEmailFrom(char text[], char domain[], char dotRemovedText[], char atSignRemovedText[])
    {
        if(domain.length > text.length)
            return;
        int incrementAmount;
        for(int censorStart = 0; censorStart <= text.length - domain.length; censorStart += incrementAmount)
        {
            int censorEnd = censorStart;
            int numCharactersFound = 0;
            incrementAmount = 1;
            while(censorEnd < text.length) 
            {
                int incrementCensorEndBy;
                char charAtCensorEnd = text[censorEnd];
                char nextChar = '\0';
                if(censorEnd + 1 < text.length)
                    nextChar = text[censorEnd + 1];
                if(numCharactersFound < domain.length && (incrementCensorEndBy = checkForCharBasicLeetSpeak(charAtCensorEnd, domain[numCharactersFound], nextChar)) > 0)
                {
                    censorEnd += incrementCensorEndBy;
                    numCharactersFound++;
                    continue;
                }
                if(numCharactersFound == 0)
                    break;
                if((incrementCensorEndBy = checkForCharBasicLeetSpeak(charAtCensorEnd, domain[numCharactersFound - 1], nextChar)) > 0)
                {
                    censorEnd += incrementCensorEndBy;
                    if(numCharactersFound == 1)
                        incrementAmount++;
                    continue;
                }
                if(numCharactersFound >= domain.length || !isNotAlphanumeric(charAtCensorEnd))
                    break;
                censorEnd++;
            }
            if(numCharactersFound >= domain.length)
            {
                boolean doCensor = false;
                int test1 = isAtSignBeforeDomain(text, atSignRemovedText, censorStart);
                int test2 = isDotAfterDomain(dotRemovedText, censorEnd - 1, text);
                if(test1 > 2 || test2 > 2)
                    doCensor = true;
                if(doCensor)
                {
                    for(int pos = censorStart; pos < censorEnd; pos++)
                        text[pos] = '*';

                }
            }
        }

    }

    private static int isAtSignBeforeDomain(char text[], char fakeAtRemovedText[], int domainStart)
    {
        if(domainStart == 0)
            return 2;
        for(int pos = domainStart - 1; pos >= 0; pos--)
        {
            if(!isNotAlphanumeric(text[pos]))
                break;
            if(text[pos] == '@')
                return 3;
        }

        int numCensoredChars = 0;
        for(int pos = domainStart - 1; pos >= 0; pos--)
        {
            if(!isNotAlphanumeric(fakeAtRemovedText[pos]))
                break;
            if(fakeAtRemovedText[pos] == '*')
                numCensoredChars++;
        }

        if(numCensoredChars >= 3)
            return 4;
        return !isNotAlphanumeric(text[domainStart - 1]) ? 0 : 1;
    }

    private static int isDotAfterDomain(char dotRemovedText[], int domainEnd, char text[])
    {
        if(domainEnd + 1 == text.length)
            return 2;
        for(int pos = domainEnd + 1; pos < text.length; pos++)
        {
            if(!isNotAlphanumeric(text[pos]))
                break;
            if(text[pos] == '.' || text[pos] == ',')
                return 3;
        }
        int numCensoredChars = 0;
        for(int pos = domainEnd + 1; pos < text.length; pos++)
        {
            if(!isNotAlphanumeric(dotRemovedText[pos]))
                break;
            if(dotRemovedText[pos] == '*')
                numCensoredChars++;
        }

        if(numCensoredChars >= 3)
            return 4;
        return !isNotAlphanumeric(text[domainEnd + 1]) ? 0 : 1;
    }

    private static void removeTlds(char text[])
    {
        char textClone[] = text.clone();
        char dotString[] = {
            'd', 'o', 't'
        };
        censorStringIn(null, textClone, dotString);
        char textClone2[] = text.clone();
        char slashString[] = {
            's', 'l', 'a', 's', 'h'
        };
        censorStringIn(null, textClone2, slashString);
        for(int id = 0; id < tldList.length; id++)
            removeTldFrom(textClone2, tldList[id], tldArray[id], textClone, text);

    }

    private static void removeTldFrom(char slashRemovedText[], char tld[], int testtype, char dotRemovedText[], char rawText[])
    {
        if(tld.length > rawText.length)
            return;
        int incrementAmmount;
        for(int pos = 0; pos <= rawText.length - tld.length; pos += incrementAmmount)
        {
            int censorEnd = pos;
            int numCharactersFound = 0;
            incrementAmmount = 1;
            while(censorEnd < rawText.length) 
            {
                int incrementCensorEndBy;
                char rawTextChar = rawText[censorEnd];
                char nextChar = '\0';
                if(censorEnd + 1 < rawText.length)
                    nextChar = rawText[censorEnd + 1];
                if(numCharactersFound < tld.length && (incrementCensorEndBy = checkForCharBasicLeetSpeak(rawTextChar, tld[numCharactersFound], nextChar)) > 0)
                {
                    censorEnd += incrementCensorEndBy;
                    numCharactersFound++;
                    continue;
                }
                if(numCharactersFound == 0)
                    break;
                if((incrementCensorEndBy = checkForCharBasicLeetSpeak(rawTextChar, tld[numCharactersFound - 1], nextChar)) > 0)
                {
                    censorEnd += incrementCensorEndBy;
                    if(numCharactersFound == 1)
                        incrementAmmount++;
                    continue;
                }
                if(numCharactersFound >= tld.length || !isNotAlphanumeric(rawTextChar))
                    break;
                censorEnd++;
            }
            if(numCharactersFound >= tld.length)
            {
                boolean censor = false;
                int test1 = isDotBeforeTld(rawText, pos, dotRemovedText);
                int test2 = isSlashAfterTld(rawText, slashRemovedText, censorEnd - 1);
                if(testtype == 1 && test1 > 0 && test2 > 0)
                    censor = true;
                if(testtype == 2 && (test1 > 2 && test2 > 0 || test1 > 0 && test2 > 2))
                    censor = true;
                if(testtype == 3 && test1 > 0 && test2 > 2)
                    censor = true;
                //boolean _tmp = i == 3 && k1 > 2 && l1 > 0;//never used
                if(censor)
                {
                    int start = pos;
                    int end = censorEnd - 1;
                    if(test1 > 2)
                    {
                        if(test1 == 4)
                        {
                            boolean breakOnNextNonCensor = false;
                            for(int p = start - 1; p >= 0; p--)
                                if(breakOnNextNonCensor)
                                {
                                    if(dotRemovedText[p] != '*')
                                        break;
                                    start = p;
                                } else
                                if(dotRemovedText[p] == '*')
                                {
                                    start = p;
                                    breakOnNextNonCensor = true;
                                }

                        }
                        boolean breakOnNextNonAlphanumeric = false;
                        for(int p = start - 1; p >= 0; p--)
                            if(breakOnNextNonAlphanumeric)
                            {
                                if(isNotAlphanumeric(rawText[p]))
                                    break;
                                start = p;
                            } else
                            if(!isNotAlphanumeric(rawText[p]))
                            {
                                breakOnNextNonAlphanumeric = true;
                                start = p;
                            }

                    }
                    if(test2 > 2)
                    {
                        if(test2 == 4)
                        {
                            boolean breakOnNextNonCensor = false;
                            for(int p = end + 1; p < rawText.length; p++)
                                if(breakOnNextNonCensor)
                                {
                                    if(slashRemovedText[p] != '*')
                                        break;
                                    end = p;
                                } else
                                if(slashRemovedText[p] == '*')
                                {
                                    end = p;
                                    breakOnNextNonCensor = true;
                                }

                        }
                        boolean breakOnNextNonAlphanumeric = false;
                        for(int p = end + 1; p < rawText.length; p++)
                            if(breakOnNextNonAlphanumeric)
                            {
                                if(isNotAlphanumeric(rawText[p]))
                                    break;
                                end = p;
                            } else
                            if(!isNotAlphanumeric(rawText[p]))
                            {
                                breakOnNextNonAlphanumeric = true;
                                end = p;
                            }

                    }
                    for(int p = start; p <= end; p++)
                        rawText[p] = '*';

                }
            }
        }
    }

    private static int isDotBeforeTld(char rawText[], int startPos, char slashRemovedText[])
    {
        if(startPos == 0)
            return 2;
        for(int pos = startPos - 1; pos >= 0; pos--)
        {
            if(!isNotAlphanumeric(rawText[pos]))
                break;
            if(rawText[pos] == ',' || rawText[pos] == '.')
                return 3;
        }

        int numCensored = 0;
        for(int pos = startPos - 1; pos >= 0; pos--)
        {
            if(!isNotAlphanumeric(slashRemovedText[pos]))
                break;
            if(slashRemovedText[pos] == '*')
                numCensored++;
        }
        if(numCensored >= 3)
            return 4;
        return !isNotAlphanumeric(rawText[startPos - 1]) ? 0 : 1;
    }

    private static int isSlashAfterTld(char rawText[], char slashRemovedText[], int startPos)
    {
        if(startPos + 1 == rawText.length)
            return 2;
        for(int pos = startPos + 1; pos < rawText.length; pos++)
        {
            if(!isNotAlphanumeric(rawText[pos]))
                break;
            if(rawText[pos] == '\\' || rawText[pos] == '/')
                return 3;
        }

        int numCensored = 0;
        for(int pos = startPos + 1; pos < rawText.length; pos++)
        {
            if(!isNotAlphanumeric(slashRemovedText[pos]))
                break;
            if(slashRemovedText[pos] == '*')
                numCensored++;
        }

        if(numCensored >= 5)
            return 4;
        return !isNotAlphanumeric(rawText[startPos + 1]) ? 0 : 1;
    }

    private static void censorStringIn(byte complexArray[][], char text[], char textToCensor[])
    {
        if(textToCensor.length > text.length)
            return;
        //boolean flag = true;//never used
        int digitsGreaterThanLetters;
        for(int censorStart = 0; censorStart <= text.length - textToCensor.length; censorStart += digitsGreaterThanLetters)
        {
            int censorEnd = censorStart;
            int numCharactersFound = 0;
            int terminationCounter = 0;
            digitsGreaterThanLetters = 1;
            boolean endCharIsntAlphanumericOrApostrophee = false;
            boolean upcomingCharIsDigit = false;
            boolean endCharIsDigit = false;
            while(censorEnd < text.length && (!upcomingCharIsDigit || !endCharIsDigit)) 
            {
                int incrementCensorEndBy;
                char charAtEnd = text[censorEnd];
                char nextChar = '\0';
                if(censorEnd + 1 < text.length)
                    nextChar = text[censorEnd + 1];
                if(numCharactersFound < textToCensor.length && (incrementCensorEndBy = checkForCharAdvancedLeetspeak(nextChar, charAtEnd, textToCensor[numCharactersFound])) > 0)
                {
                    if(incrementCensorEndBy == 1 && isDigit(charAtEnd))
                        upcomingCharIsDigit = true;
                    if(incrementCensorEndBy == 2 && (isDigit(charAtEnd) || isDigit(nextChar)))
                        upcomingCharIsDigit = true;
                    censorEnd += incrementCensorEndBy;
                    numCharactersFound++;
                    continue;
                }
                if(numCharactersFound == 0)
                    break;
                if((incrementCensorEndBy = checkForCharAdvancedLeetspeak(nextChar, charAtEnd, textToCensor[numCharactersFound - 1])) > 0)
                {
                    censorEnd += incrementCensorEndBy;
                    if(numCharactersFound == 1)
                        digitsGreaterThanLetters++;
                    continue;
                }
                if(numCharactersFound >= textToCensor.length || !isDigitOrSymbol(charAtEnd))
                    break;
                if(isNotAlphanumeric(charAtEnd) && charAtEnd != '\'')
                    endCharIsntAlphanumericOrApostrophee = true;
                if(isDigit(charAtEnd))
                    endCharIsDigit = true;
                censorEnd++;
                if((++terminationCounter * 100) / (censorEnd - censorStart) > 90)
                    break;
            }
            if(numCharactersFound >= textToCensor.length && (!upcomingCharIsDigit || !endCharIsDigit))
            {
                boolean doCensor = true;
                if(!endCharIsntAlphanumericOrApostrophee)
                {
                    char beforeStart = ' ';
                    if(censorStart - 1 >= 0)
                        beforeStart = text[censorStart - 1];
                    char atEnd = ' ';
                    if(censorEnd < text.length)
                        atEnd = text[censorEnd];
                    byte codeOfBeforeStart = getCharCodeOfSomeSort(beforeStart);
                    byte codeOfAtEnd = getCharCodeOfSomeSort(atEnd);
                    if(complexArray != null && charCodesAllowCensoring(codeOfBeforeStart, complexArray, codeOfAtEnd))
                        doCensor = false;
                } else
                {
                    boolean beforeStartIsInvalid = false;
                    boolean endIsInvalid = false;
                    if(censorStart - 1 < 0 || isNotAlphanumeric(text[censorStart - 1]) && text[censorStart - 1] != '\'')
                        beforeStartIsInvalid = true;
                    if(censorEnd >= text.length || isNotAlphanumeric(text[censorEnd]) && text[censorEnd] != '\'')
                        endIsInvalid = true;
                    if(!beforeStartIsInvalid || !endIsInvalid)
                    {
                        boolean valid = false;
                        int pos = censorStart - 2;
                        if(beforeStartIsInvalid)
                            pos = censorStart;
                        for(; !valid && pos < censorEnd; pos++)
                            if(pos >= 0 && (!isNotAlphanumeric(text[pos]) || text[pos] == '\''))
                            {
                                char chars[] = new char[3];
                                int id;
                                for(id = 0; id < 3; id++)
                                {
                                    if(pos + id >= text.length || isNotAlphanumeric(text[pos + id]) && text[pos + id] != '\'')
                                        break;
                                    chars[id] = text[pos + id];
                                }

                                boolean passedOtherTests = true;
                                if(id == 0)
                                    passedOtherTests = false;
                                if(id < 3 && pos - 1 >= 0 && (!isNotAlphanumeric(text[pos - 1]) || text[pos - 1] == '\''))
                                    passedOtherTests = false;
                                if(passedOtherTests && !charsMatchFragment(chars))
                                    valid = true;
                            }

                        if(!valid)
                            doCensor = false;
                    }
                }
                if(doCensor)
                {
                    int numDigits = 0;
                    int numLetters = 0;
                    int lastLetterPos = -1;
                    for(int pos = censorStart; pos < censorEnd; pos++)
                        if(isDigit(text[pos]))
                            numDigits++;
                        else
                        if(isLetter(text[pos]))
                        {
                            numLetters++;
                            lastLetterPos = pos;
                        }

                    if(lastLetterPos > -1)
                        numDigits -= censorEnd - 1 - lastLetterPos;
                    if(numDigits <= numLetters)
                    {
                        for(int i3 = censorStart; i3 < censorEnd; i3++)
                            text[i3] = '*';

                    } else
                    {
                        digitsGreaterThanLetters = 1;
                    }
                }
            }
        }

    }

    private static boolean charCodesAllowCensoring(byte charCodeOfBeforeStart, byte complexArray[][], byte charCodeOfAtEnd)
    {
        int arrayPos = 0;
        if(complexArray[arrayPos][0] == charCodeOfBeforeStart && complexArray[arrayPos][1] == charCodeOfAtEnd)
            return true;
        int len = complexArray.length - 1;
        if(complexArray[len][0] == charCodeOfBeforeStart && complexArray[len][1] == charCodeOfAtEnd)
            return true;
        do
        {
            int newSpot = (arrayPos + len) / 2;
            if(complexArray[newSpot][0] == charCodeOfBeforeStart && complexArray[newSpot][1] == charCodeOfAtEnd)
                return true;
            if(charCodeOfBeforeStart < complexArray[newSpot][0] || charCodeOfBeforeStart == complexArray[newSpot][0] && charCodeOfAtEnd < complexArray[newSpot][1])
                len = newSpot;
            else
                arrayPos = newSpot;
        } while(arrayPos != len && arrayPos + 1 != len);
        return false;
    }

    private static int checkForCharBasicLeetSpeak(char firstChar, char find, char secondChar)
    {
        if(find == firstChar)
            return 1;
        if(find == 'o' && firstChar == '0')
            return 1;
        if(find == 'o' && firstChar == '(' && secondChar == ')')
            return 2;
        if(find == 'c' && (firstChar == '(' || firstChar == '<' || firstChar == '['))
            return 1;
        if(find == 'e' && firstChar == '\u20AC')
            return 1;
        if(find == 's' && firstChar == '$')
            return 1;
        return find != 'l' || firstChar != 'i' ? 0 : 1;
    }

    private static int checkForCharAdvancedLeetspeak(char secondChar, char firstChar, char find)
    {
        if(find == firstChar)
            return 1;
        if(find >= 'a' && find <= 'm')
        {
            if(find == 'a')
            {
                if(firstChar == '4' || firstChar == '@' || firstChar == '^')
                    return 1;
                return firstChar != '/' || secondChar != '\\' ? 0 : 2;
            }
            if(find == 'b')
            {
                if(firstChar == '6' || firstChar == '8')
                    return 1;
                return (firstChar != '1' || secondChar != '3') && (firstChar != 'i' || secondChar != '3') ? 0 : 2;
            }
            if(find == 'c')
                return firstChar != '(' && firstChar != '<' && firstChar != '{' && firstChar != '[' ? 0 : 1;
            if(find == 'd')
                return (firstChar != '[' || secondChar != ')') && (firstChar != 'i' || secondChar != ')') ? 0 : 2;
            if(find == 'e')
                return firstChar != '3' && firstChar != '\u20AC' ? 0 : 1;
            if(find == 'f')
            {
                if(firstChar == 'p' && secondChar == 'h')
                    return 2;
                return firstChar != '\243' ? 0 : 1;
            }
            if(find == 'g')
                return firstChar != '9' && firstChar != '6' && firstChar != 'q' ? 0 : 1;
            if(find == 'h')
                return firstChar != '#' ? 0 : 1;
            if(find == 'i')
                return firstChar != 'y' && firstChar != 'l' && firstChar != 'j' && firstChar != '1' && firstChar != '!' && firstChar != ':' && firstChar != ';' && firstChar != '|' ? 0 : 1;
            if(find == 'j')
                return 0;
            if(find == 'k')
                return 0;
            if(find == 'l')
                return firstChar != '1' && firstChar != '|' && firstChar != 'i' ? 0 : 1;
            if(find == 'm')
                return 0;
        }
        if(find >= 'n' && find <= 'z')
        {
            if(find == 'n')
                return 0;
            if(find == 'o')
            {
                if(firstChar == '0' || firstChar == '*')
                    return 1;
                return (firstChar != '(' || secondChar != ')') && (firstChar != '[' || secondChar != ']') && (firstChar != '{' || secondChar != '}') && (firstChar != '<' || secondChar != '>') ? 0 : 2;
            }
            if(find == 'p')
                return 0;
            if(find == 'q')
                return 0;
            if(find == 'r')
                return 0;
            if(find == 's')
                return firstChar != '5' && firstChar != 'z' && firstChar != '$' && firstChar != '2' ? 0 : 1;
            if(find == 't')
                return firstChar != '7' && firstChar != '+' ? 0 : 1;
            if(find == 'u')
            {
                if(firstChar == 'v')
                    return 1;
                return (firstChar != '\\' || secondChar != '/') && (firstChar != '\\' || secondChar != '|') && (firstChar != '|' || secondChar != '/') ? 0 : 2;
            }
            if(find == 'v')
                return (firstChar != '\\' || secondChar != '/') && (firstChar != '\\' || secondChar != '|') && (firstChar != '|' || secondChar != '/') ? 0 : 2;
            if(find == 'w')
                return firstChar != 'v' || secondChar != 'v' ? 0 : 2;
            if(find == 'x')
                return (firstChar != ')' || secondChar != '(') && (firstChar != '}' || secondChar != '{') && (firstChar != ']' || secondChar != '[') && (firstChar != '>' || secondChar != '<') ? 0 : 2;
            if(find == 'y')
                return 0;
            if(find == 'z')
                return 0;
        }
        if(find >= '0' && find <= '9')
        {
            if(find == '0')
            {
                if(firstChar == 'o' || firstChar == 'O')
                    return 1;
                return (firstChar != '(' || secondChar != ')') && (firstChar != '{' || secondChar != '}') && (firstChar != '[' || secondChar != ']') ? 0 : 2;
            }
            if(find == '1')
                return firstChar != 'l' ? 0 : 1;
            else
                return 0;
        }
        if(find == ',')
            return firstChar != '.' ? 0 : 1;
        if(find == '.')
            return firstChar != ',' ? 0 : 1;
        if(find == '!')
            return firstChar != 'i' ? 0 : 1;
        else
            return 0;
    }

    private static byte getCharCodeOfSomeSort(char character)
    {
        if(character >= 'a' && character <= 'z')
            return (byte)((character - 97) + 1);
        if(character == '\'')
            return 28;
        if(character >= '0' && character <= '9')
            return (byte)((character - 48) + 29);
        else
            return 27;
    }

    private static void censorLongNumbers(char text[])
    {
        int nextDigit;
        int nextNonDigit = 0;
        int numInvalidFound = 0;
        int posToCensorFrom = 0;
        while((nextDigit = getFirstDigit(text, nextNonDigit)) != -1)
        {
            boolean thereAreAlphanumericCharsBeforeNextDigit = false;
            for(int pos = nextNonDigit; pos >= 0 && pos < nextDigit && !thereAreAlphanumericCharsBeforeNextDigit; pos++)
                if(!isNotAlphanumeric(text[pos]) && !isDigitOrSymbol(text[pos]))
                    thereAreAlphanumericCharsBeforeNextDigit = true;

            if(thereAreAlphanumericCharsBeforeNextDigit)
                numInvalidFound = 0;
            if(numInvalidFound == 0)
                posToCensorFrom = nextDigit;
            nextNonDigit = getFirstNonDigit(text, nextDigit);
            int valueOfNextAlphaChars = 0;
            for(int pos = nextDigit; pos < nextNonDigit; pos++)
                valueOfNextAlphaChars = (valueOfNextAlphaChars * 10 + text[pos]) - 48;

            if(valueOfNextAlphaChars > 255 || nextNonDigit - nextDigit > 8)
                numInvalidFound = 0;
            else
                numInvalidFound++;
            if(numInvalidFound == 4)
            {
                for(int pos = posToCensorFrom; pos < nextNonDigit; pos++)
                    text[pos] = '*';

                numInvalidFound = 0;
            }
        }
    }

    private static int getFirstDigit(char text[], int startPos)
    {
        for(int pos = startPos; pos < text.length && pos >= 0; pos++)
            if(text[pos] >= '0' && text[pos] <= '9')
                return pos;

        return -1;
    }

    private static int getFirstNonDigit(char text[], int startPos)
    {
        for(int pos = startPos; pos < text.length && pos >= 0; pos++)
            if(text[pos] < '0' || text[pos] > '9')
                return pos;
            return text.length;
    }

    private static boolean isNotAlphanumeric(char c)
    {
        return !isLetter(c) && !isDigit(c);
    }

    private static boolean isDigitOrSymbol(char c)
    {
        return c < 'a' || c > 'z' || c == 'v' || c == 'x' || c == 'j' || c == 'q' || c == 'z';
    }

    private static boolean isLetter(char c)
    {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    private static boolean isDigit(char c)
    {
        return c >= '0' && c <= '9';
    }

    private static boolean isLowerCaseLetter(char c)
    {
        return c >= 'a' && c <= 'z';
    }

    private static boolean isUpperCaseLetter(char c)
    {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean charsMatchFragment(char chars[])
    {
        boolean letterFree = true;
        for(int pos = 0; pos < chars.length; pos++)
            if(!isDigit(chars[pos]) && chars[pos] != 0)
                letterFree = false;

        if(letterFree)
            return true;
        int code = hashCode(chars);
        int fragmentId = 0;
        int fragmentsLength = fragmentsenc.length - 1;
        if(code == fragmentsenc[fragmentId] || code == fragmentsenc[fragmentsLength])
            return true;
        do
        {
            int id = (fragmentId + fragmentsLength) / 2;
            if(code == fragmentsenc[id])
                return true;
            if(code < fragmentsenc[id])
                fragmentsLength = id;
            else
                fragmentId = id;
        } while(fragmentId != fragmentsLength && fragmentId + 1 != fragmentsLength);
        return false;
    }

    private static int hashCode(char chars[])
    {
        if(chars.length > 6)
            return 0;
        int code = 0;
        for(int l = 0; l < chars.length; l++)
        {
            char c = chars[chars.length - l - 1];
            if(c >= 'a' && c <= 'z')
                code = code * 38 + ((c - 97) + 1);
            else
            if(c == '\'')
                code = code * 38 + 27;
            else
            if(c >= '0' && c <= '9')
                code = code * 38 + ((c - 48) + 28);
            else
            if(c != 0)
                return 0;
        }

        return code;
    }

    private static int[] fragmentsenc;
    private static char[][] badenc;
    private static byte[][][] badencByte;
    private static char[][] domainenc;
    private static char[][] tldList;
    private static int[] tldArray;
    private static final String[] exceptions = {
        "cook", "cook's", "cooks", "seeks", "sheet", "woop", "woops", "faq", "noob", "noobs"
    };

}
