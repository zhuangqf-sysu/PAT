package leetcode.biweekly9;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

/**
 * @author zhuangqf
 * @date 2019/9/21
 */
public class Main2 {

    private static final int[] arrX = new int[] {2,2,1,1,-1,-1,-2,-2};
    private static final int[] arrY = new int[] {1,-1,2,-2,2,-2,1,-1};

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        System.out.println(main2.minKnightMoves(5,5));
    }

    public int minKnightMoves(int x, int y) {
        HashMap<Long, Integer> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0,0,0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.x == x && node.y == y) {
                return node.t;
            }
            for(int i=0;i<arrX.length;i++) {
                Node next = new Node(node.x + arrX[i], node.y + arrY[i], node.t+1);
                long code = next.x * 1000 + next.y;
                if(!map.containsKey(code)) {
                    map.put(code,next.t);
                    queue.add(next);
                }
            }
        }
        return -1;
    }

    public static class Node {
        int x;
        int y;
        int t;

        public Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }


}
