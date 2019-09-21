package other;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 0;
        long ans = 0;
        for (int i=0;i<n;i++) {
            long a = scanner.nextLong();
            sum += a;
            if(sum * a > ans) {
                ans = sum * a;
            }
            if(a * a > ans) {
                ans = a * a;
            }
        }
        System.out.println(ans);
    }
}
