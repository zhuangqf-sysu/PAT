package test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zhuangqf
 * @date 2019/1/16
 */
public class MyLinkedQueue<T> implements MyQueue<T> {

    private AtomicReference<Node<T>> head;
    private AtomicReference<Node<T>> tail;

    @Override
    public void product(T item) {

    }

    @Override
    public T consume() {
        return null;
    }

    public class Node<T> {

        Node<T> next;

        T value;
    }

}
