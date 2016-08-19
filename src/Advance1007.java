import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhuangqf on 8/19/16.
 */
public class Advance1007 {

    private static List<Integer>myList;

    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        myList = new ArrayList<Integer>();

        int n = scanner.nextInt();
        for(int i=0;i<n;i++)
            myList.add(scanner.nextInt());

        //answer
        int ans = -1;
        int begin = -1;
        int end = -1;

        int sum = 0;
        int from = 0;
        boolean isAllNeg = true;
        for(int i=0;i<n;i++){
            int a = myList.get(i);

            if(a>=0) isAllNeg = false;

            sum+=a;
            if(sum<a){
                sum = a;
                from = i;
            }

            if(sum>ans){
                begin = from;
                end = i;
                ans = sum;
            }
        }

        if(isAllNeg) System.out.println(0+" "+myList.get(0)+" "+myList.get(n-1));
        else System.out.println(ans+" "+myList.get(begin)+" "+myList.get(end));
    }

}
