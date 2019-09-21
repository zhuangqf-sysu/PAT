package wangyi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            System.out.print((n+1-a) + " ");
        }
    }
}
