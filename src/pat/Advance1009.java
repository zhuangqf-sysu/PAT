package pat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhuangqf on 8/23/16.
 */
public class Advance1009 {

    private static Scanner scanner;
    private static List<Double>answer;

    public static void main(String[] arg){
        scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Polynamial polynamial1 = new Polynamial(n);
        readPolynamial(n,polynamial1);

        n = scanner.nextInt();
        Polynamial polynamial2 = new Polynamial(n);
        readPolynamial(n,polynamial2);

        productPolynamial(polynamial1,polynamial2);

        printPolynomial();

    }

    private static void printPolynomial() {

        StringBuffer answerString = new StringBuffer();
        int count = 0;

        for(int i=answer.size()-1;i>=0;i--){
            double a = answer.get(i);

            if(a>=-0.00005&&a<=0.00005)
                continue;

            count++;
            answerString.append(" ").append(i).append(" ").append(String.format("%.1f",a));
        }

        answerString.insert(0,count);

        System.out.println(answerString);
    }

    private static void productPolynamial(Polynamial polynamial1, Polynamial polynamial2) {
        answer = new ArrayList<Double>();
        for(int i=0;i<2010;i++)
            answer.add(0.0);
        for(int i=0;i<polynamial1.getSize();i++){

            int index1 = polynamial1.getIndex(i);
            double value1 = polynamial1.getValue(i);

            for(int j=0;j<polynamial2.getSize();j++){
                int index2 = polynamial2.getIndex(j);
                double value2 = polynamial2.getValue(j);
                answer.set(index1+index2,
                        answer.get(index1+index2)+value1*value2);
            }
        }
    }

    private static void readPolynamial(int n, Polynamial polynamial1) {
        for(int i=0;i<n;i++){
            int a = scanner.nextInt();
            double b = scanner.nextDouble();
            polynamial1.addPolynamial(a,b);
        }
    }


    private static class Polynamial{

        private int size;
        private List<Integer>indexArray;
        private List<Double> valueArray;

        public Polynamial(int n){
            this.size = n;
            indexArray = new ArrayList<Integer>(n);
            valueArray = new ArrayList<Double>(n);
        }

        public int getSize(){
            return size;
        }

        public void addPolynamial(int index,double value){
            indexArray.add(index);
            valueArray.add(value);
        }

        public int getIndex(int index){
            return indexArray.get(index);
        }

        public double getValue(int index){
            return valueArray.get(index);
        }

    }

}
