package pat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Created by zq on 2016/9/5.
 */
public class Advance1011 {
    public static void main(String[] arg){
        Double oddOfWin,oddOfTie,oddOfLose;
        Double oddOfMax;
        Scanner scanner = new Scanner(System.in);

        Double ans = new Double(1.0);
        for(int i=0;i<3;i++){
            oddOfWin = scanner.nextDouble();
            oddOfTie = scanner.nextDouble();
            oddOfLose = scanner.nextDouble();

            oddOfMax = oddOfWin;
            if(oddOfMax<oddOfTie) oddOfMax = oddOfTie;
            if(oddOfMax<oddOfLose) oddOfMax = oddOfLose;

            if(oddOfMax.equals(oddOfWin)) System.out.print("W ");
            else if(oddOfMax.equals(oddOfTie)) System.out.print("T ");
            else if(oddOfMax.equals(oddOfLose)) System.out.print("L ");
            ans = ans*oddOfMax;
        }
        ans = (ans*0.65-1)*2;
        System.out.println(new BigDecimal(ans).setScale(2, RoundingMode.HALF_UP));
    }
}
