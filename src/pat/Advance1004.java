package pat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by zq on 2016/8/16.
 */
public class Advance1004 {

    private static int arr[][];
    private static Queue<Integer>queue;

    public static void main(String[] arg){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        arr = new int[n+1][];

        for(int i=0;i<m;i++){
            int a = scanner.nextInt();
            int t = scanner.nextInt();
            arr[a] = new int[t];
            for(int j=0;j<t;j++)
                arr[a][j] = scanner.nextInt();
        }

        queue = new LinkedList<Integer>();

        queue.add(1);
        int count1 = 1; //本层节点数
        int count2 = 0; //下层节点数
        int count3 = 0; //本层叶子数
        while (!queue.isEmpty()){

            int a = queue.remove();
            count1--;
            if(arr[a]==null) count3++;
            else {
                for(int i=0;i<arr[a].length;i++){
                    queue.add(arr[a][i]);
                }
                count2+=arr[a].length;
            }

            if(count1==0) {
                System.out.print(count3);
                if(count2!=0) System.out.print(" ");
                count1 = count2;
                count2 = 0;
                count3 = 0;
            }
        }
        System.out.print("\n");
    }
}
