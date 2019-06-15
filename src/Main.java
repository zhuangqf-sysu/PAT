import java.util.*;

/**
 * @author zhuangqf
 * @date 2019/4/2
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 完成任务需要的时间
        int w[] = new int[n];
        for(int i=0;i<n;i++) {
            w[i] = scanner.nextInt();
        }

        // 任务的入度
        int in[] = new int[n];
        // 任务的出度
        List<List<Integer>> out = new ArrayList<>(n);
        for(int i=0;i<n;i++) {
            in[i] = 0;
            out.add(new LinkedList<>());
        }

        int m = scanner.nextInt();
        for(int i=0;i<m;i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            in[e]++;
            out.get(s).add(e);
        }

        // 完成任务实际花费的时间
        int f[] = new int[n];

        // 拓扑排序一般用队列实现，先进先出
        Queue<Integer> queue = new ArrayDeque<>();
        // 将所有入度为0的节点放进来，先完成这些任务
        for(int i=0;i<n;i++) {
            if(in[i] == 0) {
                queue.add(i);
            }
        }

        // while 循环，不断地干活，直到任务都完成了
        while (!queue.isEmpty()) {
            // 取出头节点
            int index = queue.poll();
            //完成这个任务
            f[index] += w[index];
            // 依赖它的任务入度-1
            for(Integer after : out.get(index)) {
                in[after]--;
                // 判断是否等待这个任务完成
                if(f[after] < f[index]) {
                    f[after] = f[index];
                }
                //判断这个任务是否可以执行了
                if(in[after] == 0) {
                    queue.add(after);
                }
            }
        }
        int max = 0;
        for(int i=0;i<n;i++) {
            max = Math.max(f[i],max);
        }
        System.out.println(max);
    }

}
