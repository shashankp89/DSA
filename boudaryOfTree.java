/*Given a root of Binary Tree, perform the boundary traversal of the tree. 



The boundary traversal is the process of visiting the boundary nodes of the binary tree in the anticlockwise direction, starting from the root.



The boundary of a binary tree is the concatenation of the root, the left boundary, the leaves ordered from left-to-right, and the reverse order of the right boundary.

The left boundary is the set of nodes defined by the following:



The root node's left child is in the left boundary. If the root does not have a left child, then the left boundary is empty.


If a node in the left boundary and has a left child, then the left child is in the left boundary.


If a node is in the left boundary, has no left child, but has a right child, then the right child is in the left boundary.


The leftmost leaf is not in the left boundary.


The right boundary is similar to the left boundary, except it is the right side of the root's right subtree. Again, the leaf is not part of the right boundary, and the right boundary is empty if the root does not have a right child.


Example 1

Input : root = [1, 2, 3, 4, 5, 6, 7, null, null, 8, 9]

Output : [1, 2, 4, 8, 9, 6, 7, 3]

Explanation :



Example 2

Input : root = [1, 2, null, 4, 9, 6, 5, 3, null, null, null, null, null, 7, 8]

Output : [1, 2, 4, 6, 5, 7, 8]

Explanation :



 
Constraints

0 <= Number of Nodes <= 104
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
    
    public void left(TreeNode root, List<Integer> ans) {
        TreeNode curr = root;
        while (curr != null) {
             
            if (curr.left == null && curr.right == null) {
                break; 
            }
            
            ans.add(curr.data);  
            
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return;
    }
    
    public void leaf(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans.add(root.data);
            return;
        }
        
        leaf(root.left, ans);
        leaf(root.right, ans);
        return;
    }
    
    public void right(TreeNode root, List<Integer> ans) {
        TreeNode curr = root;
        List<Integer> temp = new ArrayList<>();
        
        while (curr != null) {
            
            if (curr.left == null && curr.right == null) {
                break;
            }
            
            temp.add(curr.data);
            
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        
         
        for (int i = temp.size() - 1; i >= 0; i--) {
            ans.add(temp.get(i));
        }
        return;
    }
    
    public List<Integer> boundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }
        
        
        if (root.left == null && root.right == null) {
            ans.add(root.data);
            return ans;
        }
        ans.add(root.data);
        
        left(root.left, ans);
        
        leaf(root, ans);  
         
        right(root.right, ans);

        return ans;
    }
}
