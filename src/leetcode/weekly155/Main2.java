package leetcode.weekly155;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 请你帮忙设计一个程序，用来找出第 n 个丑数。
 *
 * 丑数是可以被 a 或 b 或 c 整除的正整数。
 * @author zhuangqf
 * @date 2019/9/22
 */
public class Main2 {


    public int nthUglyNumber(int n, int a, int b, int c) {
        long at = a;
        long bt = b;
        long ct = c;
        Set<Long> set = new HashSet<>();
        set.add(at);
        set.add(bt);
        set.add(ct);
        while (n>1) {
            long min = Math.min(at,Math.min(bt,ct));
            if(at == min) {
                do {
                    at = at + a;
                }while (set.contains(at));
                set.add(at);
            }else if(bt == min) {
                do {
                    bt = bt + b;
                }while (set.contains(bt));
                set.add(bt);
            }else {
                do {
                    ct = ct + c;
                }while (set.contains(ct));
                set.add(ct);
            }
            n--;
        }
        return (int) Math.min(at,Math.min(bt,ct));
    }
}
