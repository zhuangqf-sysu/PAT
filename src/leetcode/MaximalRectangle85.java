package leetcode;

/**
 * @author zhuangqf
 * @date 2018/3/15
 */

/**
 * 让我们先看看题目：给定一个01矩阵，找出其中最大的全1子矩阵
 *
 * 我们先尝试着将一个大的矩阵(n,m)分成小的子矩阵：
 * 对于矩阵中的某一点为(i,j)，我们可以得到一个子矩阵：（0,0）->(x,j)
 * 设product[i][j]为原点到m[i][j]的最大全1矩阵
 * 则有 product[n][m] = max(p[i][j]) i=(0->n),j=(0-m)
 *
 *
 *
 * 当m[i][j]==0时，p[i][j] = 0;
 * 当m[i][j]==1时，
 *
 * 接下来，我们看一个j简单的例子：[0 1, 1, 1]
 * 当 i=0,j=0时, m[0][0]=0, p[0][0]=0
 * 当 i=0,j=1时，m[0][1]=0,p[0][1]=1
 *
 * */


public class MaximalRectangle85 {

    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n==0) { return 0; }
        int m  = matrix[0].length;
        int f[][] = new int[n][m];
        int g[][] = new int[n][m];
        int max = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(matrix[i][j] == '0'){
                    f[i][j] = 0;
                    g[i][j] = 0;
                    continue;
                }
                f[i][j] = (i==0)?1:f[i-1][j]+1;
                g[i][j] = (j==0)?1:g[i][j-1]+1;
                int minY = g[i][j];
                for(int k=0;k<=i;k++) {
                    minY = minY < g[i-k][j] ? minY : g[i-k][j];
                    int product = (k+1) * minY;
                    max = (max>product)?max:product;
                }
            }
        }
        /***调试用，提交时请删除***/
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                System.out.print(f[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                System.out.print(g[i][j]);
            }
            System.out.println();
        }
        /***调试用，提交时请删除***/

        return max;
    }

    public static void main(String[] arg) {
        char matrix[][] = {"01101".toCharArray(),
                "11010".toCharArray(),
                "01110".toCharArray(),
                "11110".toCharArray(),
                "11111".toCharArray(),
                "00000".toCharArray()
        };
        System.out.println(maximalRectangle(matrix));
    }

}
