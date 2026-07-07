/*Given root of binary tree, return the bottom view of the binary tree.



The bottom view of a binary tree is the set of nodes visible when the tree is viewed from the bottom. Return nodes from the leftmost node to the rightmost node. Also if 2 nodes are outside the shadow of the tree and are at the same position then consider the node that appears later in level traversal.


Example 1

Input : root = [20, 8, 22, 5, 3, null, 25, null, null, 10 ,14]

Output : [5, 10, 3, 14, 25]

Explanation : From left to right the path is as follows :

First we encounter node with value 5.

Then we have nodes 8 , 10 but from bottom only 10 will be visible.

Next we have 20 , 3 but from bottom only 3 will be visible.

Next we have 14 , 22 but from bottom only 14 will be visible.

Then we encounter node with value 25.





Example 2

Input : root = [20, 8, 22, 5, 3, 4, 25, null, null, 10 ,14]

Output : [5, 10, 4, 14, 25]

Explanation : From left to right the path is as follows :

First we encounter node with value 5.

Then we have nodes 8 , 10 but from bottom only 10 will be visible.

Next we have 20 , 3 and 4. The 3 and 4 will be nodes visible from bottom but as the node 4 appears later from left to right , so only node 4 will be considered visible.

Next we have 14 , 22 but from bottom only 14 will be visible.

Then we encounter node with value 25.





Now your turn!

Input: root = [10, 20, 30, 40, 60]





Output:

Pick your answer


[40, 20, 30, 60]

[40, 20, 60, 30]

[60, 20, 40, 30]

[60, 30, 40, 20]
Constraints

1 <= Number of Nodes <= 104
-103 <= Node.val <= 103
 */

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
    
    public List<Integer> bottomView(TreeNode root) {
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
            
            // CRITICAL DIFFERENCE FROM TOP VIEW:
            // We ALWAYS overwrite the value for this horizontal distance.
            // Because we are doing BFS (level-by-level), the last value we put in 
            // the map for a specific HD will be the bottom-most node.
            map.put(hd, currNode.data); // Use currNode.val if on LeetCode
            
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