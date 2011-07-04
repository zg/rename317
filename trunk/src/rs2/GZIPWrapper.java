package rs2;

import java.util.zip.GZIPInputStream;
import java.io.*;
import java.util.zip.GZIPOutputStream;

public class GZIPWrapper {

    public static byte[] decompress(byte[] data) {
        try {
            if (data == null)
                return null;
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] compress(byte[] data) {
        try {
            if (data == null)
                return null;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gos = new GZIPOutputStream(bos);
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            byte[] buf = new byte[1024];
            int len;
            while ((len = bis.read(buf)) > 0) {
                gos.write(buf, 0, len);
            }
            gos.close();
            bos.flush();
            bos.close();
            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
} 