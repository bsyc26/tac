/** Return the len of diameter of tree
  * diameter: len of longest path between two nodes in tree (not necessary pass root) */

// leetcode 543
// dfs-division
// T: O(N)
// S: O(1)

public class Solution {
    // state
    private int maxDiam;

    // core method
    public int diameterOfBinaryTree(TreeNode root) {
        // field
        this.maxDiam = 0;
        // edge case
        if (root == null) return 0;
        // dfs
        dfs(root);
        // return field
        return this.maxDiam;
    }

    // support method
    private int dfs(TreeNode node) {
        // base case
        if (node == null)
            return 0;
        // division
        int maxLeft = dfs(node.left);
        int maxRight = dfs(node.right);
        // post-order
        int curDiam = maxLeft + maxRight;
        this.maxDiam = Math.max(this.maxDiam, curDiam); // update state
        // return
        return 1 + Math.max(maxLeft, maxRight);
    }
}
