import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhuangqf
 * @date 2019/9/16
 */
public class Main4 {

    private static int[][] matrix = new int[10][10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<9;i++) {
            String line = scanner.next();
            for(int j=0;j<9;j++) {
                if(line.charAt(j) == 'X') {
                    matrix[i][j] = 0;
                }else{
                    matrix[i][j] = line.charAt(j) - '0';
                }
            }
        }

        if(!heng()) {
            System.out.println("false");
            return;
        }
        if(!shu()) {
            System.out.println("false");
            return;
        }
        if(!fang()) {
            System.out.println("false");
            return;
        }
        System.out.println("true");
    }

    private static boolean fang() {
        int[] num = new int[10];
        for(int i=0;i<9;i+=3) {
            for(int j=0;j<9;j+=3){
                Arrays.fill(num,0);
                for(int p=i;p<i+3;p++){
                    for(int q=j;q<j+3;q++) {
                        if(matrix[p][q]!=0) {
                            int v = matrix[p][q];
                            num[v]++;
                            if(num[v] > 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean shu() {
        int[] num = new int[10];
        for(int i=0;i<9;i++) {
            Arrays.fill(num,0);
            for(int j=0;j<9;j++) {
                if(matrix[j][i]!=0) {
                    int v = matrix[j][i];
                    num[v]++;
                    if(num[v] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean heng() {
        int[] num = new int[10];
        for(int i=0;i<9;i++) {
            Arrays.fill(num,0);
            for(int j=0;j<9;j++) {
                if(matrix[i][j]!=0) {
                    int v = matrix[i][j];
                    num[v]++;
                    if(num[v] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}
