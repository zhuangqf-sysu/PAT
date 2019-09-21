package other;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int m = scanner.nextInt();

        long sum = 0;
        int[] h = new int[n];

        for(int i=0;i<n;i++) {
            h[i] = scanner.nextInt();
            sum += h[i];
        }
        if(t<n) {
            System.out.println(-1);
        }else if(t>=sum) {
            System.out.println(0);
        }else {
            int x = (int) ((sum - t)/m + 1);
            if((sum-t)%m > 0) {
                x++;
            }
            PriorityQueue<Node> queue = new PriorityQueue<>(n);
            for(int i=0;i<n;i++) {
                queue.add(new Node(h[i]));
            }
            while (m >0) {
                Node node = queue.poll();
                node.other -= x;
                node.time++;
                if(node.other > 0) {
                    queue.add(node);
                    sum-=x;
                }else{
                    sum-=(node.other + x);
                }
                m--;
            }
            if(sum <= t - m) {
                System.out.println(x);
                return;
            }
            for(int i=1;;i++) {
                long temp = sum;
                for(Node node:queue) {
                    temp -= Math.min(node.other,node.time*i);
                }
                if(temp <= t-m) {
                    System.out.println(x + i);
                    return;
                }
            }
        }
    }

    private static class Node implements Comparable<Node>{
        int value;
        int time;
        int other;

        public Node(int value) {
            this.value = value;
            this.other = value;
            this.time = 0;
        }

        @Override
        public int compareTo(Node o) {
            return o.other - this.other;
        }
    }

}