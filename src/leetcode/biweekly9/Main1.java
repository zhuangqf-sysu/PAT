package leetcode.biweekly9;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * https://leetcode-cn.com/contest/biweekly-contest-9
 * @author zhuangqf
 * @date 2019/9/21
 */
public class Main1 {

    public static void main(String[] args) {

    }

    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 5000;
        for(int i=0;i<arr.length;i++) {
            if(sum >= arr[i]) {
                sum -= arr[i];
            }else {
                return i+1;
            }
        }
        return arr.length;
    }

}
