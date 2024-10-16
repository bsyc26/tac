/** Return the max depth of a binary tree */

// leetcode 104
// dfs-division
// T: O(N)
// S: O(1)

public class Solution {
    // core method
    public int maxDepth(TreeNode root) {
        // edge case
        if (root == null) return 0;
        // return
        return dfs(root);
    }

    // support method
    private int dfs(TreeNode node) {
        // base case
        if (node == null)
            return 0;
        // division
        int maxLeft = dfs(node.left);
        int maxRight = dfs(node.right);
        // return
        return 1 + Math.max(maxLeft, maxRight);
    }
}
