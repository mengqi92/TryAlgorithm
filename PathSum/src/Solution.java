/**
 * Created by Mengqi on 15/2/10.
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
       5
      / \
     4   8
    /   / \
   11  13  4
  /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
//262ms
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        //左右子树都不存在，为叶子节点
        if (root.left == null && root.right == null) {
            return root.val == sum ? true : false;
        }
//        if (root.val < sum) {
            //存在左子树，则到左子树找
            if (root.left != null) {
                if (hasPathSum(root.left, sum - root.val)) {
                    return true;
                } else {
                    //存在右子树，则到右子树找
                    if (root.right != null)
                        return hasPathSum(root.right, sum - root.val);
                    else
                        return false;
                }
            } else { //不存在左子树，则一定存在右子树
                return hasPathSum(root.right, sum - root.val);
            }
//        }
//        return false;
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

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.left = node5; node3.right = node6;
        node4.left = node7; node4.right = node8;
        node6.right = node9;

        System.out.println(solution.hasPathSum(root, 23));
//        System.out.println(solution.hasPathSum(null, 5));
    }
}
