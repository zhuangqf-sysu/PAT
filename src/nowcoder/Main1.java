package nowcoder;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;

/**
 * 迷宫寻踪
 * https://www.nowcoder.com/questionTerminal/e3fc4f8094964a589735d640424b6a47
 *
 *
 * @author zhuangqf
 * @date 2019/4/3
 */
public class Main1 {

    private static char[][] matrix;
    private static int[][][] distance;
    private static int beginX=0,beginY=0,endX=0, endY=0, n=0, m=0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        matrix = new char[n][m];
        distance = new int[n][m][1024];

        for(int i=0;i<n;i++) {
            String line = scanner.next();
            char[] temp = line.toCharArray();
            for(int j=0;j<m;j++) {
                matrix[i][j] = temp[j];
                if(matrix[i][j] == '2') {
                    beginX = i;
                    beginY = j;
                }
                if(matrix[i][j] == '3') {
                    endX = i;
                    endY = j;
                }
            }
        }

        // bfs，先把起点放入队列
        Queue<Node> queue = new ArrayDeque<>();
        Node begin = new Node(beginX,beginY);
        distance[beginX][beginX][0] = 1;
        queue.add(begin);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
//            System.out.println(node);

            int x = node.x;
            int y = node.y;
            int k = node.k;
            int d = node.d + 1;

            if(x == endX && y == endY) {
                System.out.println(node.d);
                return;
            }

            // 向四周走动，把判断的逻辑交给newNode
            // 上
            Optional<Node> optional = newNode(x-1, y, k, d);
            optional.ifPresent(queue::add);

            // 下
            optional = newNode(x+1,y,k,d);
            optional.ifPresent(queue::add);

            //左
            optional = newNode(x,y-1,k,d);
            optional.ifPresent(queue::add);

            //右
            optional = newNode(x,y+1,k,d);
            optional.ifPresent(queue::add);
        }
    }

    /**
     * 是否可生成新的节点
     * @param x
     * @param y
     * @param k
     * @param d
     * @return empty表示不能走或不用走 ifPresent() 如果有值则执行
     */
    private static Optional<Node> newNode(int x, int y, int k, int d) {
        // 不合法节点
        if(x < 0 || y < 0) {
            return Optional.empty();
        }
        if(x >= n || y >=m) {
            return Optional.empty();
        }

        // 墙
        if(matrix[x][y] == '0') {
            return Optional.empty();
        }
        // 路
        if(matrix[x][y] == '1') {
            // 如果没走过
            if(distance[x][y][k] == 0 || distance[x][y][k] > d) {
                distance[x][y][k] = d;
                return Optional.of(new Node(x,y,k,d));
            }
        }
        // 起点，其实也是路
        if(matrix[x][y] == '2') {
            if(distance[x][y][k] == 0 || distance[x][y][k] > d) {
                distance[x][y][k] = d;
                return Optional.of(new Node(x,y,k,d));
            }
        }
        // 门
        if('A' <= matrix[x][y] && matrix[x][y] <= 'Z') {
            // 有相应的钥匙
            if((k & (2 << (matrix[x][y] - 'A'))) > 0) {
                //如果没走过
                if(distance[x][y][k] == 0 || distance[x][y][k] > d) {
                    distance[x][y][k] = d;
                    return Optional.of(new Node(x,y,k,d));
                }
            }
        }
        // 钥匙
        if('a' <= matrix[x][y] && matrix[x][y] <= 'z') {
            // 用k记录拿到的钥匙，用位图法（bitmap）
            k = (k | 2 << (matrix[x][y] - 'a') );
            if(distance[x][y][k] == 0 || distance[x][y][k] > d) {
                distance[x][y][k] = d;
                return Optional.of(new Node(x,y,k,d));
            }
        }
        // 到达终点，万岁
        if(matrix[x][y] == '3') {
            return Optional.of(new Node(x,y,k,d));
        }
        return Optional.empty();
    }

    // 迷宫点
    private static class Node {
        // x坐标
        int x;
        // y坐标
        int y;
        // k表示是否持钥匙
        int k;
        //走了多少步
        int d;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.k = 0;
            this.d = 0;
        }

        Node(int x, int y, int k, int d) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.d = d;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"x\":")
                    .append(x);
            sb.append(",\"y\":")
                    .append(y);
            sb.append(",\"k\":")
                    .append(k);
            sb.append(",\"d\":")
                    .append(d);
            sb.append('}');
            return sb.toString();
        }
    }
}
