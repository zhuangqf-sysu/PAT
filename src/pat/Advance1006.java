package pat;

import java.util.Scanner;

/**
 * Created by zq on 2016/8/16.
 */
public class Advance1006 {

    public static String firstID = null;
    public static MyTime firstTime = null;
    public static String lastID = null;
    public static MyTime lastTime = null;

    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0;i<n;i++){
            String id = scanner.next();
            String time1 = scanner.next();
            String time2 = scanner.next();
            if(firstID==null){
                firstID = id;
                firstTime  = new MyTime(time1);
            }else{
                MyTime myTime1 = new MyTime(time1);
                if(!MyTime.comp(firstTime,myTime1)){
                    firstTime = myTime1;
                    firstID = id;
                }
            }

            if(lastID==null){
                lastID = id;
                lastTime = new MyTime(time2);
            }else{
                MyTime myTime2 = new MyTime(time2);
                if(!MyTime.comp(myTime2,lastTime)){
                    lastID = id;
                    lastTime = myTime2;
                }
            }
        }
        System.out.println(firstID+" "+lastID);
    }

    private static class MyTime{
        private int hour;
        private int minute;
        private int seconds;

        public MyTime(String s){
            String a[] = s.split(":");
            hour = Integer.valueOf(a[0]);
            minute = Integer.valueOf(a[1]);
            seconds = Integer.valueOf(a[2]);
        }

        public static boolean comp(MyTime myTime1,MyTime myTime2){
            if(myTime1.hour<myTime2.hour) return true;
            if(myTime1.hour>myTime2.hour) return false;
            if(myTime1.minute<myTime2.minute) return true;
            if(myTime1.minute>myTime2.minute) return false;
            if(myTime1.seconds<myTime2.seconds) return true;
            if(myTime1.seconds>myTime2.seconds) return false;
            return false;
        }

    }
}
