package hiho.game;

import java.util.Scanner;

/**
 * @author zhuangqf
 * @date 2019/6/16
 */
public class Main103_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for(int i=0;i<n;i++) {
            String line = scanner.next();
            for(int j=0;j<m;j++) {
                char c = line.charAt(j);
                if(c == 'B') {
                    matrix[i][j] = -1;
                }else {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(matrix[i][j] == -1) {
                    // 上
                    for(int k=i-1;k>=0;k--) {
                        if(matrix[k][j] == -1) {
                            break;
                        }else {
                            matrix[k][j]++;
                        }
                    }
                    // 下
                    for(int k=i+1;k<n;k++) {
                        if(matrix[k][j] == -1) {
                            break;
                        }else {
                            matrix[k][j]++;
                        }
                    }
                    // 左
                    for(int k=j-1;k>=0;k--) {
                        if(matrix[i][k] == -1) {
                            break;
                        }else {
                            matrix[i][k]++;
                        }
                    }
                    //右
                    for(int k=j+1;k<n;k++) {
                        if(matrix[i][k] == -1) {
                            break;
                        }else {
                            matrix[i][k]++;
                        }
                    }
                }
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(matrix[i][j] == -1) {
                    System.out.print('B');
                }else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
    }

}
