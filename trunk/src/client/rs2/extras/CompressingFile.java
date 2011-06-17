package rs2.extras;

import java.io.*;
import java.util.zip.*;

public class CompressingFile {
  public static void doCompressFile(String inFileName){
    try{
      File file = new File(inFileName);
      System.out.println(" you are going to gzip the  : " + file + "file");
      FileOutputStream fos = new FileOutputStream(file + ".gz");
      System.out.println(" Now the name of this gzip file is  : " + file + ".gz" );
      GZIPOutputStream gzos = new GZIPOutputStream(fos);
      System.out.println(" opening the input stream");
      FileInputStream fin = new FileInputStream(file);
      BufferedInputStream in = new BufferedInputStream(fin);
      System.out.println("Transferring file from" + inFileName + " to " + file + ".gz");
      byte[] buffer = new byte[1024];
      int i;
      while ((i = in.read(buffer)) >= 0){
        gzos.write(buffer,0,i);
      }
      System.out.println(" file is in now gzip format");
      in.close();
      gzos.close();
    }
    catch(IOException e){
      System.out.println("Exception is" + e);
    }
  }    


public static byte[] getCompressedData(String inFileName){
try{

File file = new File(inFileName);
ByteArrayOutputStream bos = new ByteArrayOutputStream();
GZIPOutputStream gzos = new GZIPOutputStream(bos);
FileInputStream fin = new FileInputStream(file);
BufferedInputStream in = new BufferedInputStream(fin);

byte[] buffer = new byte[1024];
int i;
while ((i = in.read(buffer)) >= 0){
gzos.write(buffer,0,i);
}
in.close();
gzos.close();
return bos.toByteArray();

}catch(Exception e){e.printStackTrace(); return null;}


}

}