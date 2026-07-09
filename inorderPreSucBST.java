/*Given the root node of a binary search tree (BST) and an integer key. Return the Inorder predecessor and successor of the given key from the provided BST.



Note: key will always present in given BST.



If predecessor or successor is missing then return -1.


Example 1

Input : root = [5, 2, 10, 1, 4, 7, 12] , key = 10

Output : [7, 12]

Explanation :



Example 2

Input : root = [5, 2, 10, 1, 4, 7, 12] , key = 12

Output : [10, -1]

Explanation :



Now your turn!

Input : root = [5, 2, 10, 1, 4, 7, 12] , key = 1

Output:

Pick your answer


[-1, 2]

[1, 2]

[4, 7]

[2, -1]
Constraints

1 <= Number of Nodes <= 104
1 <= Node.val <= 105
All the values Node.val are unique. */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

 

class Solution {
    List<Integer> succPredBST(TreeNode root, int key) {
        int predecessor = -1;
        int successor = -1;
        
        
        TreeNode curr = root;
        while (curr != null) {
            if (curr.data < key) {
                 
                predecessor = curr.data;
                curr = curr.right;
            } else {
                 
                curr = curr.left;
            }
        }
        
        // 2. Find Successor
        curr = root;
        while (curr != null) {
            if (curr.data > key) {
                // Potential successor found, go left to find a smaller one
                successor = curr.data;
                curr = curr.left;
            } else {
                // Current node is too small (or equal), go right
                curr = curr.right;
            }
        }
        
        return Arrays.asList(predecessor, successor);
    }
}