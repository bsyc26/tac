import java.util.List;
import java.util.ArrayList;
/** Return the preorder traversal of binary tree's node's values */
public class Solution { // leetcode 144
    // fields
    private List<Integer> listPreVal = new ArrayList<>();
    // dfs-traverse
    public List<Integer> preorderTraversal(TreeNode root) { // T: O(N), S: O(1).
        // edge case
        if (root == null) return new ArrayList<Integer>();
        // dfs
        dfs(root);
        // return
        return listPreVal;
    }
    private void dfs(TreeNode node) {
        // base case
        if (node == null)
            return;
        // pre-order
        listPreVal.add(node.val);
        // traverse
        dfs(node.left);
        dfs(node.right);
    }
}

import java.util.List;
import java.util.LinkedList;
/** Return the preorder traversal of binary tree's node's values */
public class Solution { // leetcode 144
    // dfs-division
    public List preorderTraversal(TreeNode root) { // T: O(N), S: O(1).
        // edge case
        if (root == null) return new LinkedList<Integer>();
        // return
        return dfs(root);
    }
    private List<Integer> dfs(TreeNode node) {
        // var
        List<Integer> ListPreVal = new LinkedList<>();
        // base case
        if (node == null)
            return ListPreVal;
        // pre-order
        ListPreVal.add(node.val);
        // division
        ListPreVal.addAll(dfs(node.left)); // addAll() is T: O(N), can be implemented into T: O(1).
        ListPreVal.addAll(dfs(node.right));
        // post-order
        return ListPreVal;
    }
}
