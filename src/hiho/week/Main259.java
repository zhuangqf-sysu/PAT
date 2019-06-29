package hiho.week;

import java.util.Scanner;

/**
 * @author zhuangqf
 * @date 2019/6/15
 */
public class Main259 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = 'A' - 'a';
        while (n > 0) {
            String s = scanner.next();
            boolean before = false;
            for(char c : s.toCharArray()) {
                if(c >= 'A' && c <= 'Z') {
                    System.out.print("_" + (char)(c - d));
                    before = false;
                }else if(before) {
                    System.out.print((char) (c + d));
                    before = false;
                }else if(c == '_') {
                    before = true;
                }else {
                    System.out.print(c);
                    before = false;
                }
            }
            System.out.println();
            n--;
        }
    }
}
