package pat;

import java.util.*;

/**
 * Created by zq on 2016/8/17.
 */
public class Advance1101  {

    private static int[] myList;
    private static boolean[] isPivot;
    private static List<Integer> answer;

    private static final int MAX_NUMBER = 100001;

    public static void main(String[] arg){

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        myList = new int[n];
        isPivot = new boolean[n];
        answer = new ArrayList<Integer>();

        for(int i=0;i<n;i++) {
            myList[i] = scanner.nextInt();
            isPivot[i] = true;
        }

        int leftMaxValue = myList[0];
        for(int i=0;i<n;i++){
            int a = myList[i];
            if(a>=leftMaxValue) leftMaxValue = a;
            else isPivot[i] = false;
        }

        int rightMinValue = myList[n-1];
        for(int i=n-2;i>=0;i--){
            int a = myList[i];
            if(a<=rightMinValue) rightMinValue = a;
            else isPivot[i] = false;
        }

        for(int i=0;i<n;i++)
            if(isPivot[i])
                answer.add(myList[i]);

        Collections.sort(answer);

        System.out.println(answer.size());

        if(!answer.isEmpty()) System.out.print(answer.get(0));
        for(int i=1;i<answer.size();i++)
            System.out.print(" "+answer.get(i));
        System.out.println();

    }
}
