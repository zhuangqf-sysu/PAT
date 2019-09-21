package xz1;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Node> list = new ArrayList<>();

        for(int i=0;i<n;i++) {
            Node node = new Node(i,scanner.nextInt());
            list.add(node);
        }
        for(int i=0;i<m;i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            list.get(a).out.add(b);
            list.get(b).in++;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for(Node node : list) {
            if(node.in == 0) {
                queue.add(node);
            }
        }

        List<Integer> result = new ArrayList<>(n);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node.no);

            for(Integer index : node.out) {
                Node next = list.get(index);
                next.in--;
                if(next.in == 0) {
                    queue.add(next);
                }
            }
        }
        for(int i=0;i<n;i++) {
            System.out.print(result.get(i)+" ");
        }
        System.out.println();
    }

    private static class Node implements Comparable<Node>{
        int no;
        int p = 0;
        int in = 0;
        List<Integer> out = new LinkedList<>();

        public Node(int no, int p) {
            this.no = no + 1;
            this.p = p;
        }

        @Override
        public int compareTo(Node o) {
            if(this.p == o.p) {
                return this.no - o.no;
            }
            return this.p - o.p;
        }
    }

}
