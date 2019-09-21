package xz1;

import java.util.*;

/**
 * @author zhuangqf
 * @date 2019/4/2
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<String> list = new LinkedList<>();
        for(int i=0;i<n;i++) {
            list.add(scanner.next());
        }
        System.out.println(isHuan(list));
    }

    private static final Map<Character,List<String>>map = new HashMap<>();

    private static boolean isHuan(List<String> list) {
        if(list == null || list.isEmpty()) {
            return true;
        }
        for(String item : list) {
            List<String> subList = map.get(item.charAt(0));
            if(subList == null) {
                subList = new LinkedList<>();
            }
            subList.add(item);
            map.put(item.charAt(0),subList);
        }
        int size = dfs(list.get(0));
        return size == list.size();
    }

    private static int dfs(String s) {
        int size = 0;
        Character last = s.charAt(s.length() - 1);
        List<String> list = map.get(last);
        if(list == null) {
            return 0;
        }
        List<String> temp = new LinkedList<>(list);
        for(int i=0;i<list.size();i++) {
            String next = list.get(i);
            temp.remove(i);
            map.put(last,temp);
            int newSize = dfs(next) + 1;
            size = newSize > size ? newSize : size;
            temp.add(i,next);
        }
        return size;
    }
}
