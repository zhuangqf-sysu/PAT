package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuangqf
 * @date 2018/12/2
 */
public class OfferOne {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Node {

        TreeNode node;
        int sum;
        Node parent;

        public Node(TreeNode node, Node parent) {
            this.node = node;
            this.parent = parent;
            this.sum = this.parent.sum + node.val;
        }

        public Node(TreeNode node) {
            this.node = node;
            this.parent = null;
            this.sum = node.val;
        }

        boolean isLeaf() {
            return this.node.left == null && this.node.right == null;
        }

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(root == null || root.val > target) {
            return lists;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.isLeaf()) {
                if(node.sum == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(node.node.val);
                    Node parent = node.parent;
                    while (parent != null) {
                        list.add(0,parent.node.val);
                        parent = parent.parent;
                    }
                    lists.add(0,list);
                }
                continue;
            }

            if(node.sum>=target) {
                continue;
            }

            if(node.node.left != null) {
                Node left = new Node(node.node.left, node);
                queue.add(left);
            }

            if(node.node.right != null) {
                Node right = new Node(node.node.right, node);
                queue.add(right);
            }
        }
        return lists;
    }

}
