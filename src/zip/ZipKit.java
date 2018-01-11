package zip;

import io.IOUtil;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipKit {

    static final int BUFFER = 2048;


    public static void unzip2(String zipPath) throws IOException {
        File file = new File(zipPath);//压缩文件
        ZipFile zipFile = new ZipFile(file);//实例化ZipFile，每一个zip压缩文件都可以表示为一个ZipFile
        //实例化一个Zip压缩文件的ZipInputStream对象，可以利用该类的getNextEntry()方法依次拿到每一个ZipEntry对象
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file), Charset.forName("GBK"));
        ZipEntry zipEntry = null;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            String fileName = zipEntry.getName();
            File temp = new File("temp/" + fileName);
            if (!temp.getParentFile().exists()) {
                temp.getParentFile().mkdirs();
            }
            if (temp.getName().split("\\.").length == 1) {
                temp.mkdir();
                File[] childs = temp.listFiles();
                for (File child : childs) {
                    if (child.getName().endsWith(".zip")) {
                        unzip2(child.getAbsolutePath());
                    }
                }
            } else {
                OutputStream os = new FileOutputStream(temp);
                //通过ZipFile的getInputStream方法拿到具体的ZipEntry的输入流
                InputStream is = zipFile.getInputStream(zipEntry);
                int len = 0;
                while ((len = is.read()) != -1)
                    os.write(len);
                os.close();
                is.close();
            }

        }
        zipInputStream.close();
    }


    public static void unzip(String filePath) {
        File source = new File(filePath);
        if (source.exists()) {
            ZipInputStream zis = null;
            BufferedOutputStream bos = null;
            try {
                zis = new ZipInputStream(new FileInputStream(source));
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null && !entry.isDirectory()) {
                    File target = new File(source.getParent(), entry.getName());
                    if (!target.getParentFile().exists()) {
                        target.getParentFile().mkdirs();
                    }
                    bos = new BufferedOutputStream(new FileOutputStream(target));
                    int read;
                    byte[] buffer = new byte[1024 * 10];
                    while ((read = zis.read(buffer, 0, buffer.length)) != -1) {
                        bos.write(buffer, 0, read);
                    }
                    bos.flush();
                }
                zis.closeEntry();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                IOUtil.closeQuietly(zis, bos);
            }
        }
    }

    public static void main(String... args) {

        try {
            unzip2("temp/jen.zip");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
