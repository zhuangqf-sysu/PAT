import java.util.*;

public class Main {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()) {
            String s = scanner.next();
            if(s.trim().length() == 0) {
                continue;
            }
            if(s.trim().equals(".")){
                break;
            }
            if(s.charAt(s.length()-1) == '.') {
                if(builder.length() != 0) {
                    builder.insert(0, " ");
                }
                builder.insert(0, s.substring(0,s.length()-1));
                break;
            }
            if(builder.length() != 0) {
                builder.insert(0, " ");
            }
            builder.insert(0,s);
        }
        System.out.println(builder.toString()+".");
    }

}
