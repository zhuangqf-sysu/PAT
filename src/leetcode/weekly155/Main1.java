package leetcode.weekly155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 *
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * @author zhuangqf
 * @date 2019/9/22
 */
public class Main1 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++) {
            int d = arr[i+1] - arr[i];
            if(d < min) {
                result.clear();
                result.add(Arrays.asList(arr[i],arr[i+1]));
                min = d;
            }else if(d == min) {
                result.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }

        return result;
    }

}
