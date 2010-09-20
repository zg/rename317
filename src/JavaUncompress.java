 import java.util.zip.GZIPInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.*;
import java.io.IOException;

public class JavaUncompress{

public static byte[] decompress(byte[] data)
{
try{
GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(data));
ByteArrayOutputStream bos = new ByteArrayOutputStream();
byte[] buf = new byte[1024];
        int len;
        while ((len = gzipInputStream.read(buf)) > 0) {
          bos.write(buf, 0, len);
        }
        gzipInputStream.close();
        bos.close();
return bos.toByteArray();
}catch(Exception e){e.printStackTrace(); return null;}
}

} 