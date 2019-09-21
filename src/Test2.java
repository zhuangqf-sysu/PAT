

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhuangqf
 * @date 2019/9/11
 */
public class Test2 {

    private static final int n = 10000;
    private static final int size = UUID.randomUUID().toString().getBytes().length + 1;
    private static final String[] data = new String[n];

    static {
        for(int i=0;i<n;i++) {
            data[i] = UUID.randomUUID().toString() + '\n';
        }
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        RandomAccessFile file = new RandomAccessFile("test","rw");
        FileChannel fileChannel = file.getChannel();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        AtomicInteger counter = new AtomicInteger();
        List<Future<Integer>> list = new ArrayList<>();
        for(int i=0;i<10;i++) {
            list.add(executorService.submit(new WriteTask(counter,fileChannel)));
        }
        ByteBuffer buffer = ByteBuffer.allocate(size);
        int i =0;
        while (i < n) {
            buffer.clear();
            fileChannel.read(buffer);
            System.out.print(i+" "+new String(buffer.array()));
            i++;
        }

        int sum = 0;
        for(Future<Integer> future : list) {
            Integer count = future.get();
            System.out.println(count);
            sum+=count;
        }
        executorService.shutdown();
        fileChannel.force(true);
        System.out.println("sum:"+sum);
    }

    public static class WriteTask implements Callable<Integer> {

        private AtomicInteger counter;
        private FileChannel fileChannel;
        private ByteBuffer buffer;

        public WriteTask(AtomicInteger counter, FileChannel fileChannel) {
            this.counter = counter;
            this.fileChannel = fileChannel;
            this.buffer = ByteBuffer.allocate(size);
        }

        @Override
        public Integer call() throws Exception {
            int i;
            int count = 0;
            while ((i=counter.getAndIncrement()) < n) {
                buffer.clear();
                buffer.put(data[i].getBytes());
                buffer.flip();
                fileChannel.write(buffer,i*size);
                count++;
            }
            return count;
        }
    }

}
