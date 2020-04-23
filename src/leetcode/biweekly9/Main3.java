package leetcode.biweekly9;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.PriorityQueue;

/**
 * @author zhuangqf
 * @date 2019/9/21
 */
public class Main3 {

    public static void main(String[] args) {
        int[][] mat = new int[10][10];
        for(int i=0;i<10;i++) {
            for(int j=0;j<10;j++) {
                mat[i][j] = i+j;
            }
        }
        System.out.println(mat);
    }

    public int smallestCommonElement(int[][] mat) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int max = -1;
        for(int i=0;i<mat.length;i++) {
            queue.add(new Node(i,mat[i][0]));
            if(mat[i][0] > max) {
                max = mat[i][0];
            }
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.value == max) {
                return max;
            }
            node.i++;
            if(node.i >= mat[node.index].length) {
                return  -1;
            }else {
                node.value = mat[node.index][node.i];
                if(node.value > max) {
                    max = node.value;
                }
            }
            queue.add(node);
        }
        return -1;
    }

    public static class Node implements Comparable<Node>{
        int index;
        int value;
        int i;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
            this.i = 0;
        }

        @Override
        public int compareTo(Node o) {
            if(this.value == o.value){
                return this.index > o.index ? 1 : -1;
            }
            return this.value > o.value ? 1 : -1;
        }
    }
}
