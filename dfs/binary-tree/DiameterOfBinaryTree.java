/** Return the len of diameter of tree
  * diameter: len of longest path between two nodes in tree (not necessary pass root) */
public class Solution { // leetcode 543
    // fields
    private int maxDiam = 0;
    // dfs-division
    public int diameterOfBinaryTree(TreeNode root) { // T: O(N), S: O(1).
        // edge case
        if (root == null) return 0;
        // dfs
        dfs(root);
        // return
        return maxDiam;
    }
    private int dfs(TreeNode node) {
        // base case
        if (node == null)
            return 0;
        // division
        int maxLeft = dfs(node.left);
        int maxRight = dfs(node.right);
        // post-order
        int curDiam = maxLeft + maxRight;
        maxDiam = Math.max(maxDiam, curDiam);
        return 1 + Math.max(maxLeft, maxRight);
    }
}
