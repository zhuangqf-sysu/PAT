
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zq on 2016/8/16.
 */
public class Advance1002 {

    private static List<Double> arr = new ArrayList<Double>();
    private static Scanner scanner;

    public static void main(String[] arg){

        init();
        readPolynomial();
        readPolynomial();
        printPolynomial();
    }

    private static void init(){
        arr.clear();
        for(int i=0;i<11;i++)
            arr.add(i,0.0);
        scanner = new Scanner(System.in);
    }

    private static void readPolynomial(){
        int n = scanner.nextInt();
        for(int i=0;i<n;i++){
            int a = scanner.nextInt();
            double b = scanner.nextDouble();
            arr.set(a, b+arr.get(a) );
        }
    }

    private static void printPolynomial() {

        StringBuffer answer = new StringBuffer();
        int count = 0;

        for(int i=arr.size()-1;i>=0;i--){
            double a = arr.get(i);

            if(a>=-0.00005&&a<=0.00005)
                continue;

            count++;
            answer.append(" ").append(i).append(" ").append(String.format("%.1f",a));
        }

        answer.insert(0,count);

        System.out.println(answer);
    }
}

