package test;

import java.util.Scanner;

/**
 * @author zhuangqf
 * @date 2019/4/7
 */
public class Tx1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            long answer = 0;
            int k = 0;
            for(int i=0;i<n;i++) {
                int a = scanner.nextInt();
                answer += Math.abs(k);
                k += a;
            }
            System.out.println(answer);
        }

    }
}
