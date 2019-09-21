package ali;

import java.math.BigInteger;
import java.util.concurrent.*;


public class Main {

    private final static int PARALLELISM = 64;

    public BigInteger sum(int[] array) throws ExecutionException, InterruptedException {
        Long begin = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool(PARALLELISM);
        Future<BigInteger> future = pool.submit(new SumTask(array,0,array.length));
        BigInteger result = future.get();
        Long end = System.currentTimeMillis();
        System.out.println("总耗时："+ (end - begin) + "ms");
        return result;
    }

    private static class SumTask extends RecursiveTask<BigInteger> {

        // 每个"小任务"最多只累加5000个数,暂定可调
        private static final int MAX = 5000;
        private int arr[];
        private int begin;
        private int end;

        public SumTask(int arr[], int begin, int end) {
            this.arr = arr;
            this.begin = begin;
            this.end = end;
        }

        @Override
        protected BigInteger compute() {

            if(this.end - this.begin > MAX)  {
                // 任务分解
                int medium = (begin + end) /2;
                SumTask left = new SumTask(arr,begin,medium);
                SumTask right = new SumTask(arr,medium,end);
                left.fork();
                right.fork();
                return left.join().add(right.join());
            }else {
                BigInteger sum = BigInteger.ZERO;
                for(int i=begin;i<end;i++) {
                    sum.add(BigInteger.valueOf(arr[i]));
                }
                return sum;
            }
        }
    }
}