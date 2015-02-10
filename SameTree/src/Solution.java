/**
 * Created by Mengqi on 15/2/10.
 Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            if(q == null)//p、q均空
                return true;
            else//p空q非空
                return false;
        }
        if(q == null)//p非空q空
            return false;

        //p、q均非空
        if (p.val == q.val) {
            if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
                return true;
            return false;
        } else
            return false;
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

        root.left = node2; root.right = node3;
        node2.left = node4; node2.right = node5;
        node4.left = node6; node4.right = node7;

        TreeNode aroot = new TreeNode(1);
        TreeNode anode2 = new TreeNode(2);
        TreeNode anode3 = new TreeNode(2);
        TreeNode anode4 = new TreeNode(3);
        TreeNode anode5 = new TreeNode(3);
        TreeNode anode6 = new TreeNode(4);
        TreeNode anode7 = new TreeNode(4);

        aroot.left = anode2; aroot.right = anode3;
        anode2.left = anode4; anode2.right = anode5;
        anode4.left = anode6; anode4.right = anode7;

        System.out.println(solution.isSameTree(root, aroot));
    }
}
