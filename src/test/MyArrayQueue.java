package test;

import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhuangqf
 * @date 2019/1/16
 */
public class MyArrayQueue<T> {

    private static final Integer MAX_SIZE = Integer.MAX_VALUE;

    /** 容量 **/
    private final int capital;
    private final ArrayList<T> values;

    private AtomicInteger tail;
    private AtomicInteger head;

    public MyArrayQueue(int capital) throws Exception {

        if(capital > MAX_SIZE) {
            throw new Exception("容量太大");
        }

        this.capital = capital;
        this.values = new ArrayList<>(capital);
        this.head = new AtomicInteger(0);
        this.tail = new AtomicInteger(0);
    }

    public void product(T item) {
        int index = getIndex(head,tail);
        this.values.set(index,item);
    }

    public T comsume() {
        int index = getIndex(tail,head);
        T item = this.values.get(index);
        this.values.set(index,null);
        return item;
    }

    private int getIndex(AtomicInteger source,AtomicInteger target) {
        while (true) {
            int index = source.get();
            int update = (index + 1) % capital;

            // 队列已满
            if(update == target.get()) {
                continue;
            }
            // CAS
            if(source.compareAndSet(index,update)) {
                return index;
            }
        }
    }
}
