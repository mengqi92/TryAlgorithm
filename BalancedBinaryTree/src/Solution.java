/**
 * Created by Mengqi on 15/2/10.
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getDepthAndJudgeBalanced(root).balanced;
    }

    public depthAndBalanced getDepthAndJudgeBalanced(TreeNode root) {
        //叶子结点一定平衡
        if (root.left == null && root.right == null)
            return new depthAndBalanced(1, true);
        //左树空，存在右子树，则右子树必须为叶子节点
        if(root.left == null)
            if (root.right.left == null && root.right.right == null) {
                return new depthAndBalanced(2, true);
            } else {
                return new depthAndBalanced(-1, false);
            }
        //右树空，存在左子树，则左子树必须为叶子节点
        if(root.right == null)
            if (root.left.left == null && root.left.right == null) {
                return new depthAndBalanced(2, true);
            } else {
                return new depthAndBalanced(-1, false);
            }
        //左右子树均非空，则两子树必须平衡
        depthAndBalanced left = getDepthAndJudgeBalanced(root.left);
        depthAndBalanced right = getDepthAndJudgeBalanced(root.right);
        if(left.balanced && right.balanced)
            if (Math.abs(left.depth - right.depth) <= 1) {
                int maxDepth = left.depth > right.depth ? left.depth : right.depth;
                return new depthAndBalanced(maxDepth+1, true);
            } else
                return new depthAndBalanced(-1, false);
        else
            return new depthAndBalanced(-1, false);
    }

    class depthAndBalanced {
        public depthAndBalanced(int depth, boolean balanced) {
            this.depth = depth;
            this.balanced = balanced;
        }

        int depth;
        boolean balanced;
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

        root.left = node2; root.right = node3;
        node2.left = node4; node2.right = node5;
        node4.left = node6; node4.right = node7;
//        node4.left = node7; node4.right = node8;
//        node6.right = node9;

        System.out.println(solution.isBalanced(root));
    }
}
