package hiho.game;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @author zhuangqf
 * @date 2019/6/16
 */
public class Main103_2 {

    private static int[] map = new int[1<<20];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++) {
            A[i] = scanner.nextInt();
        }
        int[] C = new int[m];
        for(int i=0;i<m;i++) {
            C[i] = 0;
            for(int j=0;j<n;j++) {
                int a = scanner.nextInt();
                C[i] = C[i] << 1;
                if(a >= A[i]) {
                    C[i]++;
                }
            }
        }

        int max = 0;
        for(int i=0;i<m;i++) {
            map[C[i]] = 1;
            if(C[i] > max) {
                max = C[i];
            }
        }
        for(int t=0;t<=max;t++){
            if(map[t] == 0) {
                continue;
            }
            int temp = max;
            for(int i = t+1; i<=max;i++) {
                if(map[i] == 0) {
                    continue;
                }
                int k = t | i;
                int v = map[t] + map[i];
                if(map[k] == 0 || map[k] > v) {
                    map[k] = v;
                }
                if(temp < k) {
                    temp = k;
                }
            }
            max = temp;
        }
        System.out.println(map[(1<<n)-1] == 0 ? -1 : map[(1<<n)-1]);
    }
}
