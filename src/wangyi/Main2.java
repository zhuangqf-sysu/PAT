package wangyi;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>(n);
        boolean hasA = false;
        boolean hasB = false;
        for(int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            list.add(a);
            if(a % 2 == 0) {
                hasA = true;
            } else {
                hasB = true;
            }
        }
        if(hasA && hasB) {
            Collections.sort(list);
        }
        for(int a:list) {
            System.out.print(a + " ");
        }
    }
}
