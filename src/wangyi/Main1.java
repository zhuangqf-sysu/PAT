package wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while ((t--) > 0) {
            int n = scanner.nextInt();
            if(n < 3) {
                System.out.println("NO");
                continue;
            }
            long[] a = new long[n];
            for(int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            Arrays.sort(a);
            if((a[n-3] + a[n-2]) > a[n-1]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
