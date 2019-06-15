package test;

import java.util.Scanner;

/**
 * @author zhuangqf
 * @date 2019/4/7
 */
public class Tx2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int answer = 0;
            while (k>0 && n>1) {
                n = (n/2) + (n%2);
                k--;
                answer++;
            }

            answer += n;
            System.out.println(answer);
        }

    }

}
