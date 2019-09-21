package hiho.game;

import com.sun.org.apache.bcel.internal.generic.BIPUSH;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author zhuangqf
 * @date 2019/9/1
 */
public class Main107_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        if(!isValid(num)) {
            System.out.println(0);
            return;
        }
        int n = num.length();
        int[] count = new int[n];
        for(int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if(c == '0' || c == '2') {
                count[i] = 1;
            } else {
                count[i] = 2;
            }
        }
        BigInteger res = BigInteger.ONE;
        boolean first = false;
        for(int i = 0; i < n; i++) {
            if(count[i] == 2) {
                if(!first) {
                    first = true;
                } else {
                    res = res.multiply(BigInteger.valueOf(2));
                }
            }
        }
        System.out.println(res);
    }
    private static boolean isValid(String num) {
        for(char c:num.toCharArray()) {
            if(c != '0' && c != '1' && c != '2') {
                return false;
            }
        }
        return true;
    }
}
