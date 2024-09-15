/** Return the max depth of a binary tree */
public class Solution { // leetcode 104
    // dfs-division
    public int maxDepth(TreeNode root) { // T: O(N), S: O(1).
        // edge case
        if (root == null) return 0;
        // return
        return dfs(root);
    }
    private int dfs(TreeNode node) {
        // base case
        if (node == null)
            return 0;
        // division
        int maxLeft = dfs(node.left);
        int maxRight = dfs(node.right);
        // post-order
        return 1 + Math.max(maxLeft, maxRight);
    }
}


/** Return the max depth of a binary tree */
public class Solution { // leetocde 104
    // field
    private int curDepth = 0;
    private int maxDepth = 0;
    // dfs-traverse
    public int maxDepth(TreeNode root) { // T: O(N), S: O(1).
        // edge case
        if (root == null) return 0;
        // dfs
        dfs(root);
        // return
        return maxDepth;
    }
    private void dfs(TreeNode node) {
        // base case
        if (node == null)
            return;
        // pre-order
        ++curDepth;
        if (node.left == null && node.right == null) // node is leaf node
            maxDepth = Math.max(maxDepth, curDepth);
        // traverse
        dfs(node.left);
        dfs(node.right);
        // post-order
        --curDepth;
    }
}
