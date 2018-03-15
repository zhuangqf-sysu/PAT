import java.util.Scanner;
/**
 * @author zhuangqf
 * @date 2018/1/29
 */
public class Advance1013 {

    private static boolean[] done = new boolean[1001];
    private static boolean[][] road = new boolean[1001][1001];
    private static int n,m,k;

    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        for(int i=0;i<1001;i++){
            done[i] = false;
            for(int j=0;j<=n;j++){
                road[i][j] = false;
            }
        }
        for(int i=0;i<m;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            road[a][b] = true;
            road[b][a] = true;
        }
        for(int i=0;i<k;i++){
            for(int j=1;j<=n;j++) {
                done[i] = false;
            }
            int a = scanner.nextInt();
            done[a] = true;
            System.out.println(getAns(a));
        }
    }

    private static int getAns(int a) {
        int ans = 0;
        for(int i=1;i<=n;i++){
            if(!done[i]){
                dfs(i);
                ans++;
            }
        }
        return ans - 1;
    }

    private static void dfs(int i) {
        done[i] = true;
        for(int j=1;j<n;j++){
            if(!done[j]&&road[i][j]) {
                dfs(j);
            }
        }
    }

}
