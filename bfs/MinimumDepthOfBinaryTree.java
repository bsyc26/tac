/** Return the min depth of leaf in a binary tree */

// leetcode 111
// bfs
// T: O(N)
// S: O(N)

import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    // core method
    public int minDepth(TreeNode root) {
        // edge case
        if (root == null) return 0;
        // DS
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // res
        int depth = 1; // root still has depth 1
        // bfs
        while (!q.isEmpty()) {
            // count level size
            int sz = q.size();
            // traverse level elems
            for (int i = 0; i < sz; i++) {
                // poll
                TreeNode curNode = q.poll();
                // update res
                if (curNode.left == null && curNode.right == null) // curNode is a leaf node
                    return depth;
                // offer
                if (curNode.left != null)
                    q.offer(curNode.left);
                if (curNode.right != null)
                    q.offer(curNode.right);
            }
            // step level
            depth++;
        }
        // return res
        return depth;
    }
}
