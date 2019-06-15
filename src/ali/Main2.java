package ali;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        if(K == 2) {
            System.out.println(1);
            return;
        }
        int[][][] dp = new int[M+1][N+1][K+1];
        for(int k = 0; k <= K; k++) {
            dp[0][0][k] = 1;
            dp[1][0][k] = 1;
            dp[0][1][k] = 1;
        }
        for(int m = 0; m <= M; m++) {
            dp[m][0][1] = 1;
        }
        for(int n = 0; n <= N; n++) {
            dp[0][n][1] = 1;
        }
        for(int m = 2; m <= M; m++) {
            for(int k = 2; k <= K; k++) {
                dp[m][0][k] = dp[m][0][k-1] + dp[m-k][0][k];
            }
        }
        for(int n = 2; n <= N; n++) {
            for(int k = 2; k <= K; k++) {
                dp[0][n][k] = dp[0][n][k-1] + dp[0][n-k][k];
            }
        }

        for(int m = 0; m <= M; m++) {
            for (int n = 0; n <= N; n++) {
                dp[m][n][2] = 1;
            }
        }
        for(int m = 1; m <= M; m++) {
            for(int n = 1; n <= N; n++) {
                for(int k = 3; k <= K; k++) {
                    if(k > (m + n)) {
                        dp[m][n][k] = dp[m][n][k - 1];
                    } else {
                        dp[m][n][k] = dp[m][n][k - 1];
                        for(int i = 1; i <= Math.min(k-1,m); i++) {
                            int j = k - i;
                            dp[m][n][k] += dp[m-i][0][i] * dp[0][n-j][j];
                        }
                    }
                }
            }
        }

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++){
                for(int k=0;k<K;k++){
                    System.out.print(dp[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }

        int res = dp[M][N][K];
        System.out.println(res);
    }
}
