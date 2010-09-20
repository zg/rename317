import java.io.*;

public class FileOperations {

    public static int TotalRead = 0;
    public static int TotalWrite = 0;
    public static int CompleteWrite = 0;

    public FileOperations() {
    }
public static boolean FileExists(String s)
{
return new File(s).exists();
}
    public static final byte[] ReadFile(String s) {
        try {
            byte abyte0[];
            File file = new File(s);
            int i = (int) file.length();
            abyte0 = new byte[i];
            DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(new FileInputStream(s)));
            datainputstream.readFully(abyte0, 0, i);
            datainputstream.close();
            TotalRead++;
            //System.out.println("READ GOOD"+s) ;
            return abyte0;
        }
        catch (Exception e) {
            System.err.println("[Native File Accessor] Read error:" + s);
            return null;
        }
    }

    public static final void WriteFile(String s, byte abyte0[]) {
        try {
            FileOutputStream fileoutputstream = new FileOutputStream(s);
            fileoutputstream.write(abyte0, 0, abyte0.length);
            fileoutputstream.close();
            TotalWrite++;
            CompleteWrite++;
        }
        catch (Throwable throwable) {
            System.out.println((new StringBuilder()).append("Write Error: ").append(s).toString());
            throwable.printStackTrace();

        }
    }

    public static final void WriteFile(String s, byte abyte0[], int l) {
        try {
            FileOutputStream fileoutputstream = new FileOutputStream(s);
            fileoutputstream.write(abyte0, 0, l);
            fileoutputstream.close();
            TotalWrite++;
            CompleteWrite++;
        }
        catch (Throwable throwable) {
            System.out.println((new StringBuilder()).append("Write Error: ").append(s).toString());
            throwable.printStackTrace();

        }
    }
}