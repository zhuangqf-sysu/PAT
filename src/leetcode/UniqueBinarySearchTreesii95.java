package leetcode;

import java.util.*;

/**
 * @author zhuangqf
 * @date 2019/6/29
 */
public class UniqueBinarySearchTreesii95 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UniqueBinarySearchTreesii95 temp = new UniqueBinarySearchTreesii95();
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(temp.generateTrees(n));
        }
    }

    public ArrayList<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }
    ArrayList<TreeNode> dfs(int begin, int end) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if(begin == end) {
            list.add(new TreeNode(begin));
            return list;
        }else if(begin > end) {
            return list;
        }
        for(int i=begin;i<=end;i++) {
            ArrayList<TreeNode> leftList = dfs(begin,i-1);
            ArrayList<TreeNode> rightList = dfs(i+1,end);

            if(leftList.isEmpty()) {
                for(TreeNode right : rightList) {
                    TreeNode node = new TreeNode(i);
                    node.right = right;
                    list.add(node);
                }
            }else if(rightList.isEmpty()) {
                for(TreeNode left : leftList) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    list.add(node);
                }
            }else {
                for (TreeNode left : leftList) {
                    for (TreeNode right : rightList) {
                        TreeNode node = new TreeNode(i);
                        node.left = left;
                        node.right = right;
                        list.add(node);
                    }
                }
            }
        }
        return list;
    }


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

}
