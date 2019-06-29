package hiho.train;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目链接：http://hihocoder.com/problemset/problem/1970
 * @author zhuangqf
 * @date 2019/6/8
 */
public class Main_1970 {

    private static TreeSet<Long> X = new TreeSet<>();
    private static TreeSet<Long> Y = new TreeSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i=0;i<n;i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            X.add((x<<32)+y);
            Y.add((y<<32)+x);
        }
        long ans = 0;
        for(int i=0;i<m;i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            long d = scanner.nextLong();
            d = Math.abs(d);
            ans += delete(X,Y,x,y-d,y+d);
            ans += delete(Y,X,y,x-d,x+d);
        }
        System.out.println(ans);
    }

    private static long delete(TreeSet<Long> setX, TreeSet<Long> setY, long x, long y1, long y2) {
        if(setX == null || setX.size() == 0) {
            return 0;
        }
        Set<Long> subSet = setX.subSet((x<<32)+y1,true,(x<<32)+y2,true);
        if(subSet.size() == 0) {
            return 0;
        }
        Set<Long> temp = subSet.stream().map(l -> (l<<32)|(l>>>32)).collect(Collectors.toSet());
        setY.removeAll(temp);
        setX.removeAll(subSet);
        return temp.size();
    }
}
