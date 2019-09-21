package pat;

import java.util.Scanner;

/**
 * Created by zhuangqf on 8/19/16.
 */
public class Advance1008 {

    public static void main(String []arg){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int from = 0;
        int to = 0;
        int ans = 0;

        for(int i=0;i<n;i++){
            to = scanner.nextInt();
            if(to>from) ans+=(to-from)*6+5;
            else ans+=(from-to)*4+5;
            from = to;
        }
        System.out.println(ans);
    }
}
