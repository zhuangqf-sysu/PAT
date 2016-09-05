
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringJoiner;

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

        long a = allToTen(n1,radix);
        if(a==-1L){
            System.out.println("Impossible");
            return;
        }

        long b = 0L;

        int i = 2;
        for(;i<=50;i++){
            b = allToTen(n2,i);
            if(b==-1L) continue;
            if(b==a) break;
        }

        if(i<=50) {
            System.out.println(i);
            return;
        }

        if(a<=50){
            System.out.println("Impossible");
            return;
        }

        BigInteger minRadix = new BigInteger("2");
        BigInteger maxRadix = new BigInteger("50");
        BigInteger MaxRadix = new BigInteger("-1");
        BigInteger maybeAns = new BigInteger("-1");

        BigInteger stopValue = new BigInteger("20");
        BigInteger multValue = new BigInteger("2");
        BigInteger A = new BigInteger(String.valueOf(a));
        BigInteger B;
        while(maxRadix.compareTo(minRadix.add(stopValue))>0) {
            B = allToTen(n2,maxRadix);
           // System.out.println(A+" "+B+" "+minRadix+" "+maxRadix+" "+MaxRadix+" "+maybeAns);
            if(A.compareTo(B)>0){
                minRadix = maxRadix;
                if(MaxRadix.compareTo(BigInteger.ZERO)>0) maxRadix = MaxRadix;
                else maxRadix = maxRadix.multiply(multValue);
            }else{
                MaxRadix = maxRadix;
                maxRadix = maxRadix.add(minRadix).divide(multValue).add(multValue);
                if(A.compareTo(B)==0&&
                        (maybeAns.compareTo(BigInteger.ZERO)<0
                                ||maybeAns.compareTo(maxRadix)>0))
                    maybeAns = maxRadix;
            }
        }
        for(;MaxRadix.compareTo(minRadix)>=0;
            MaxRadix = MaxRadix.subtract(BigInteger.ONE)){
            B = allToTen(n2,MaxRadix);
            if(A.equals(B)) maybeAns = MaxRadix;
        }

        if(maybeAns.compareTo(BigInteger.ZERO)<0) System.out.println("Impossible");
        else System.out.println(maybeAns);
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

    private static BigInteger allToTen(String n1, BigInteger radix) {
        BigInteger num = new BigInteger("0");
        for(int i=0;i<n1.length();i++){
            char c = n1.charAt(i);
            int a;
            if(c<='z'&&c>='a') a = c - 'a' + 10;
            else a = c - '0';
            num = num.multiply(radix).add(new BigInteger(String.valueOf(a)));
        }
        return num;
    }

}
