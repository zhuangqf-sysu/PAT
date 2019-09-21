package hiho.game;

import java.util.Scanner;

/**
 * @author zhuangqf
 * @date 2019/9/1
 */
public class Main107_2 {

    private static long[][][] value = new long[102][102][5];
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                value[i][j][0] = scanner.nextLong();
            }
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                // 横
                value[i][j][1] = value[i][j][0] + getValue(i-1,j,1);
                // 竖
                value[i][j][2] = value[i][j][0] + getValue(i,j-1,2);
                // 左下
                value[i][j][3] = value[i][j][0] + getValue(i-1,j-1,3);
                //右下
                value[i][j][4] = value[i][j][0] + getValue(i-1,j+1,4);
            }
        }
        for(int k=0;k<5;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    System.out.print(value[i][j][k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        int result = n * n;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                for(int k=2;k+i<=n&&k+j<=n;k++) {
                    long v = value[i+k][j+k][3] - value[i][j][3];
                    boolean is = (v != (value[i + k][j + 1][4] - value[i][j + k + 1][4]));
                    for(int p=j+1;p<=k;p++) {
                        is = is && (v != (value[i+k][p][1] - value[i][p][1]));
                    }
                    for(int p=i+1;p<=k;p++) {
                        is = is && (v != (value[p][j+k][2] - value[p][j][2]));
                    }
                    if(is) {
                        System.out.println(i+" " +j+" " +k);
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static long getValue(int x,int y,int k) {
        if(x<0 || x > n) {
            return 0;
        }
        if(y<0 || y > n) {
            return 0;
        }
        return value[x][y][k];
    }

}
