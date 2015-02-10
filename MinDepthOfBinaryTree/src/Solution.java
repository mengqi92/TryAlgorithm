/**
 * Created by Mengqi on 15/2/10.
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        //叶子结点
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftMinDepth = Integer.MAX_VALUE, rightMinDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            leftMinDepth = minDepth(root.left);
        }
        if (root.right != null) {
            rightMinDepth = minDepth(root.right);
        }
        return leftMinDepth < rightMinDepth ? leftMinDepth+1 : rightMinDepth+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);

        root.left = node2; root.right = node3;
        node2.left = node4;
        node3.left = node5; node3.right = node6;
        node4.left = node7; node4.right = node8;
        node6.right = node9;

        System.out.println(solution.minDepth(root));
//        System.out.println(solution.hasPathSum(null, 5));
    }
}
