package test;

/**
 * @author zhuangqf
 * @date 2019/1/16
 */
public interface MyQueue<T> {

    /**
     * 生产
     * @param item
     */
    void product(T item);

    /**
     * 消费
     * @return
     */
    T consume();

}
