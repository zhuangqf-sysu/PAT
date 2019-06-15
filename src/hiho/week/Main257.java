package hiho.week;

import java.util.Scanner;

/**
 * 题目链接：http://hihocoder.com/contest/hiho257/problem/1
 * @author zhuangqf
 * @date 2019/6/8
 */
public class Main257 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A[] = new int[n];
        int B[] = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++) {
            A[i] = scanner.nextInt();
            B[i] = scanner.nextInt();
            sum += A[i];
            sum += B[i];
        }

        int avg = sum / (2*n);
        long action = 0;
        for(int i=0;i<n;i++) {
            A[i] -= avg;
            B[i] -= avg;
            int a = 0,b = 0;
            if(A[i] > 0) {
                if(B[i] < 0) {
                    if(A[i] + B[i] > 0) {
                        // 给B[i] b个硬币
                        action += Math.abs(B[i]);
                        a = A[i] + B[i];
                    }else {
                        // 给B a个硬币
                        action += Math.abs(A[i]);
                        b = A[i] + B[i];
                    }
                }else {
                    a = A[i];
                    b = B[i];
                }
            }else {
                if(B[i] > 0) {
                    if(A[i] + B[i] > 0) {
                        // 给A a个硬币
                        action += Math.abs(A[i]);
                        b = A[i] + B[i];
                    }else {
                        // 给A b个硬币
                        action += Math.abs(B[i]);
                        a = A[i] + B[i];
                    }
                }else{
                    a = A[i];
                    b = B[i];
                }
            }
            if(i<n-1) {
                A[i+1] += a;
                B[i+1] += b;
            }
            action += Math.abs(a);
            action += Math.abs(b);
        }
        System.out.println(action);
    }
}
