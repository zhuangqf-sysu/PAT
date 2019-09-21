import com.sun.corba.se.impl.protocol.INSServerRequestDispatcher;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.io.*;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author zhuangqf
 * @date 2019/9/11
 */
public class Test {

    private static final int n = 10000;
    private static final String[] data = new String[n];

    static {
        for(int i=0;i<n;i++) {
            data[i] = UUID.randomUUID().toString();
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("./out/test.zip");
        if(!file.exists()) {
            file.createNewFile();
        }
        Instant begin = Instant.now();
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            ZipOutputStream outputStream = new ZipOutputStream(fileOutputStream)) {
            outputStream.putNextEntry(new ZipEntry("text.txt"));
            PrintWriter writer = new PrintWriter(outputStream);
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    writer.println(data[j]);
                }
            }
        }
        Instant end = Instant.now();
        System.out.println("共耗时"+(end.getEpochSecond() - begin.getEpochSecond())+"s");
    }

}
