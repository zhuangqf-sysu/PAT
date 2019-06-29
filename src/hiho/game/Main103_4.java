package hiho.game;

import java.util.Scanner;

/**
 * @author zhuangqf
 * @date 2019/6/16
 */
public class Main103_4 {

    private static boolean[][] matrix = new boolean[1001][1001];
    private static boolean[][] done = new boolean[1001][1001];
    private static int[][][] dp = new int[1001][1001][11];
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int k = scanner.nextInt();
        for(int i=0;i<n;i++) {
            String s = scanner.next();
            for(int j=0;j<n;j++) {
                matrix[i][j] = s.charAt(j) == '#';
            }
        }
        int ans = dfs(0,0,k);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static int dfs(int i, int j, int k) {
        if(dp[i][j][k]!=0) {
            return dp[i][j][k];
        }
        if(matrix[i][j]) {
            if(k <=0 ) {
                return Integer.MAX_VALUE;
            }else {
                k--;
            }
        }

        if(i==n-1 && j==n-1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        done[i][j] = true;
        if(i-1>0 && !done[i-1][j]) {
            min = Math.min(min,dfs(i-1,j,k));
        }

        if(i+1<n && !done[i+1][j]) {
            min = Math.min(min,dfs(i+1,j,k));
        }

        if(j-1>0 && !done[i][j-1]) {
            min = Math.min(min,dfs(i,j-1,k));
        }

        if(j+1<n && !done[i][j+1]) {
            min = Math.min(min,dfs(i,j+1,k));
        }
        done[i][j] = false;
        dp[i][j][k] = min == Integer.MAX_VALUE ? min : min+1;
        return dp[i][j][k];
    }
}
