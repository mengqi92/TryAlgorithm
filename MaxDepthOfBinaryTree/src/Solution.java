/**
 * Created by Mengqi on 15/2/10.
 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
//256 ms
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return leftDepth > rightDepth ? leftDepth+1 : rightDepth+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);
//        TreeNode node8 = new TreeNode(2);
//        TreeNode node9 = new TreeNode(1);

//        root.left = node2; root.right = node3;
//        node2.left = node4; node2.right = node5;
//        node4.left = node6; node4.right = node7;
//        node4.left = node7; node4.right = node8;
//        node6.right = node9;

        System.out.println(solution.maxDepth(root));
    }
}
