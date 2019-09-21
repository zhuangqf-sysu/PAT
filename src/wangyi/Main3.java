package wangyi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n > 0) {
            String s = scanner.next();
            String t = scanner.next();
            List<String> list = new LinkedList<>();
            while(s.length() > 0) {
                list.add(s);
                s = rev(s);
            }
            if(dfs(t, list)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            n--;
        }
    }

    private static boolean dfs(String t, List<String> list) {
        if(t.length() == 0) {
            return true;
        }
        for(String s: list) {
            if(s.length() > 0 && t.indexOf(s)==0) {
                boolean res = dfs(t.substring(s.length()), list);
                if(res) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String rev(String s) {
        boolean one = false;
        StringBuilder builder = new StringBuilder();
        for(char c:s.toCharArray()) {
            if(c == '1' && one) {
                builder.append('0');
            } else if(c == '0'){
                one = true;
                builder.append('1');
            }
        }
        return builder.toString();
    }
}
