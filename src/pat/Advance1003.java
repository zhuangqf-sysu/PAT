package pat;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

/**
 * Created by zq on 2016/8/18.
 */
public class Advance1003 {

    private static int cityNum;
    private static int loadNum;
    private static int srcCity;
    private static int dstCity;

    private static int price[][];
    private static int value[];

    private static int cast[];
    private static int get[];
    private static boolean done[];
    private static int pathNum[];

    private static Scanner scanner;

    public static void main(String[] arg){
        scanner = new Scanner(System.in);

        cityNum = scanner.nextInt();
        loadNum = scanner.nextInt();
        srcCity = scanner.nextInt();
        dstCity = scanner.nextInt();

        myInit();
        inputValue();
        inputPrive();

        bfs();

        //printAll();
        System.out.println(pathNum[dstCity]+" "+get[dstCity]);
    }

    private static void bfs() {
        get[srcCity] = value[srcCity];
        cast[srcCity] = 0;
        done[srcCity] = true;
        pathNum[srcCity] = 1;
        int currentCity = srcCity;

        while(currentCity!=dstCity&&currentCity!=-1){
            done[currentCity] = true;
            for(int i=0;i<cityNum;i++){
                if(done[i]) continue;
                if(price[currentCity][i]==Integer.MAX_VALUE) continue;

                int newCast = price[currentCity][i]+cast[currentCity];
                int newGet = value[i]+get[currentCity];

                if(newCast<cast[i]){
                    cast[i] = newCast;
                    get[i] = newGet;
                    pathNum[i] = pathNum[currentCity];
                }else if(newCast==cast[i]){
                    if(get[i]<newGet) get[i] = newGet;
                    pathNum[i] = pathNum[i]+pathNum[currentCity];
                }
//                System.out.println("new cast:"+currentCity+" to "+
//                        i+" cast "+ cast[i]+" get "+get[i]+" pathNum "+pathNum[i]);
            }

            int minIndex = -1;
            int minCast = Integer.MAX_VALUE;
            for(int i=0;i<cityNum;i++){
                if(done[i]) continue;
                if(cast[i]<minCast){
                    minCast = cast[i];
                    minIndex = i;
                }
            }
            currentCity = minIndex;
        }
    }

    private static void printAll() {
        for(int i=0;i<cityNum;i++){
            System.out.println(cast[i]+" "+get[i]+" "+done[i]+" "+pathNum[i]);
        }
    }

    private static void inputValue() {
        for(int i=0;i<cityNum;i++)
            value[i] = scanner.nextInt();
    }

    private static void inputPrive() {
        int src,dst,pri;
        for(int i=0;i<loadNum;i++){
            src = scanner.nextInt();
            dst = scanner.nextInt();
            pri = scanner.nextInt();
            price[src][dst] = pri;
            price[dst][src] = pri;
        }
    }

    private static void myInit() {
        price = new int[cityNum][cityNum];
        value = new int[cityNum];
        cast  = new int[cityNum];
        get   = new int[cityNum];
        done  = new boolean[cityNum];
        pathNum = new int[cityNum];

        for(int i=0;i<cityNum;i++){

            cast[i] = Integer.MAX_VALUE;
            get [i] = 0;
            done[i] = false;
            pathNum[i] = 0;

            for(int j=0;j<cityNum;j++)
                price[i][j] = Integer.MAX_VALUE;
        }
    }

}
