
import java.util.Scanner;

/**
 * Created by zhuangqf on 8/25/16.
 */
public class Advance1010 {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        String n1 = scanner.next();
        String n2 = scanner.next();
        int tag = scanner.nextInt();
        int radix = scanner.nextInt();

        if(tag==2){
            String n = n1;
            n1 = n2;
            n2 = n;
        }

        Long a = allToTen(n1,radix);
        if(a.equals(-1L)){
            System.out.println("Impossible");
            return;
        }

        Long b = 0L;

        int i = 2;
        for(;i<=50;i++){
            b = allToTen(n2,i);
            if(b.equals(-1L)) continue;
            if(b.equals(a)) break;
        }

        if(i<=50) System.out.println(i);
        else System.out.println("Impossible");
    }

    private static Long allToTen(String n1, int radix) {
        Long num = 0L;
        for(int i=0;i<n1.length();i++){
            char c = n1.charAt(i);
            int a;
            if(c<='z'&&c>='a') a = c - 'a' + 10;
            else a = c - '0';
            if(a>=radix) return -1L;

            num = num * radix + a;
        }
        return num;
    }

}
