package ali;

import java.util.Scanner;

/**
 * @author zhuangqf
 * @date 2019/4/12
 */
public class Main {

    private static final int MOD = 10000;

    private static int f(int k, int m) {
        int result = 0;
        // 第一个碗放i个丸子
        for(int i=1;i*k<=m; i++) {
            result += f(k-1,m-i*k);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int result = 0;
        for(int i=1;i<K;i++) {
            result += f(i,M) * f(K-i,N);
            result %= 10000;
        }
        System.out.println(result);
    }

}
