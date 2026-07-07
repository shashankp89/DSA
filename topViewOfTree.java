/*Given the root of a binary tree, return the top view of the binary tree.



The top view of a binary tree consists of the set of nodes visible when the tree is observed from above.



Return the values of these nodes ordered from the leftmost to the rightmost position.



If multiple nodes share the same horizontal distance from the root, only the node that appears first when traversing from left to right (i.e., the leftmost node) should be included in the result.


Example 1

Input : root = [1, 2, 3, 4, 5, 6, 7]

Output : [4, 2, 1, 3, 7]

Explanation :



Example 2

Input : root = [10, 20, 30, 40, 60, 90, 100]

Output : [40, 20, 10, 30, 100]

Explanation :



Now your turn!

Input : root = [5, 1, 2, 8, null, 4, 5, null, 6]

Output:

Pick your answer


[8, 1, 5, 5, 2]

[8, 1, 5, 2, 5]

[8, 5, 1, 2, 5]

[8, 5, 1, 5, 2]
Constraints

1 <= Number of Nodes <= 104
-103 <= Node.val <= 103 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/
 
import java.util.*;
class Solution {
    // Helper class to pair a node with its Horizontal Distance (HD)
    static class Pair {
        TreeNode node;
        int hd;
        
        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    
    public List<Integer> topView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }
        
        // TreeMap keeps the horizontal distances (keys) automatically sorted from negative to positive
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        
        // Start with the root at horizontal distance 0
        queue.add(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            TreeNode currNode = curr.node;
            int hd = curr.hd;
            
            // If we have NEVER seen this horizontal distance before, 
            // add it to the map. Because this is BFS, the first node we see 
            // at this HD is guaranteed to be the topmost one!
            if (!map.containsKey(hd)) {
                map.put(hd, currNode.data);
            }
            
            // Go left: Horizontal Distance decreases by 1
            if (currNode.left != null) {
                queue.add(new Pair(currNode.left, hd - 1));
            }
            
            // Go right: Horizontal Distance increases by 1
            if (currNode.right != null) {
                queue.add(new Pair(currNode.right, hd + 1));
            }
        }
        
        // Extract the values from the TreeMap (which are already sorted left-to-right)
        for (int value : map.values()) {
            ans.add(value);
        }
        
        return ans;
    }
}
