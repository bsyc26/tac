import java.util.Queue;
import java.util.LinkedList;
/** Return the min depth of leaf */
public class Solution { // leetcode 111
    // bfs
    public int minDepth(TreeNode root) { // T: O(N), S: O(N).
        // base case
        if (root == null) return 0;
        // data struct
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // var
        int depth = 1; // root has depth 1
        // bfs
        while (!q.isEmpty()) {
            // cnt level
            int sz = q.size();
            // loop level
            for (int i = 0; i < sz; i++) {
                // poll
                TreeNode curNode = q.poll();
                // manage states
                if (curNode.left == null && curNode.right == null) // is leaf node
                    return depth;
                // offer
                if (curNode.left != null)
                    q.offer(curNode.left);
                if (curNode.right != null)
                    q.offer(curNode.right);
            }
            // step level
            ++depth;
        }
        // return
        return depth;
    }
}
