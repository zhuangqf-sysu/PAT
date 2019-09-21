package leetcode;

/**
 * @author zhuangqf
 * @date 2019/6/29
 */
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"val\":")
                .append(val);
        sb.append(",\"left\":")
                .append(left);
        sb.append(",\"right\":")
                .append(right);
        sb.append('}');
        return sb.toString();
    }
}
