import java.util.Scanner;

/**
 * @author zhuangqf
 * @date 2019/4/3
 */
public class Main2 {

    private static int v[] = new int[10001];
    private static int w[] = new int[10001];
    private static int A[] = new int[10001];
    private static int n,m,x,y,z;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            init(scanner);

            int sum = 0;
            for(int i=0; i<n; i++) {
                A[i] = 0;
                int a = Integer.MAX_VALUE, b = 0, index = 0;

                // 冲咖啡
                for (int j = 0; j < m; j++) {
                    b = v[j] + w[j];
                    if (b < a) {
                        a = b;
                        index = j;
                    }
                }
                w[index] += v[index];
                A[i] = a;
            }

            int c = Integer.MAX_VALUE;
            for(int i=n-1;i>=0;i--) {
                int ans = 0;
                if(x > y || (A[i]+x) > c) {
                    ans = A[i] + y;
                } else {
                    ans = A[i] + x;
                    c = A[i];
                }

                sum = sum > ans ? sum : ans;
            }

            System.out.println(sum);

            t--;
        }


    }

    private static void init(Scanner scanner) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        z = 0;

        for(int i=0; i<m; i++) {
            v[i] = scanner.nextInt();
            w[i] = 0;
        }
    }
}
