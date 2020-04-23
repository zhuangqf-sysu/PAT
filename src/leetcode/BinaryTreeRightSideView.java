package leetcode;

    import java.util.*;

/**
 * @author zhuangqf
 * @date 2020/4/22
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int count1 = 1;
        int count2 = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                queue.add(node.left);
                count2++;
            }
            if(node.right != null) {
                queue.add(node.right);
                count2++;
            }
            count1--;
            if(count1 == 0) {
                list.add(node.val);
                count1 = count2;
                count2 = 0;
            }
        }
        return list;
    }

}
