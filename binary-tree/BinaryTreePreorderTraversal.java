/** Return the preorder traversal of binary tree's node's values */

// leetcode 144
// dfs-traverse
// T: O(N)
// S: O(1)

import java.util.List;
import java.util.LinkedList;

public class Solution {
    // state
    private List<Integer> preOrder;

    // core method
    public List<Integer> preorderTraversal(TreeNode root) {
        // field
        this.preOrder = new LinkedList<>();
        // edge case
        if (root == null) return new LinkedList<Integer>();
        // dfs
        dfs(root);
        // return
        return this.preOrder;
    }

    // support method
    private void dfs(TreeNode node) {
        // base case
        if (node == null)
            return;
        // pre-order
        this.preOrder.add(node.val);
        // traverse
        dfs(node.left);
        dfs(node.right);
    }
}
