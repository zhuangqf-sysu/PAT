package pat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zq on 2016/8/16.
 */
public class Advance1005 {

    private static Map<Character,String> dictionary;

    private static void initMap(){
        dictionary = new HashMap<Character,String>();
        dictionary.put('0',"zero");
        dictionary.put('1',"one");
        dictionary.put('2',"two");
        dictionary.put('3',"three");
        dictionary.put('4',"four");
        dictionary.put('5',"five");
        dictionary.put('6',"six");
        dictionary.put('7',"seven");
        dictionary.put('8',"eight");
        dictionary.put('9',"nine");
    }

    public static void main(String[] arg){

        initMap();

        Scanner scanner = new Scanner(System.in);
        Long integer = scanner.nextLong();
        Long sum = Long.valueOf(0);
        while(integer>0){
            sum += integer%10;
            integer /= 10;
        }
        String string = String.valueOf(sum);
        for(int i=0;i<string.length();i++){
            System.out.print(dictionary.get(string.charAt(i)));
            if(i!=string.length()-1) System.out.print(" ");
            else System.out.print("\n");
        }
    }
}
