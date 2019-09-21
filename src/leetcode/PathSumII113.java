package leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * @author zhuangqf
 * @date 2019/6/29
 */
public class PathSumII113 {

    public static void main(String[] args) {

    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) {
            return result;
        }
        sum -= root.val;
        if(root.left == null && root.right == null) {
            if(sum == 0) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(root.val);
                result.add(list);
                return result;
            }
        }
        if(root.left != null) {
            List<List<Integer>> leftList = pathSum(root.left,sum);
            leftList.forEach(list -> list.add(0,root.val));
            result.addAll(leftList);
        }
        if(root.right != null) {
            List<List<Integer>> rightList = pathSum(root.right,sum);
            rightList.forEach(list -> list.add(0,root.val));
            result.addAll(rightList);
        }

        return result;
    }



}
