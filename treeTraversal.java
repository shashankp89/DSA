/*Given a binary tree with root node. Return the In-order,Pre-order and Post-order traversal of the binary tree.


Example 1

Input : root = [1, 3, 4, 5, 2, 7, 6 ]

Output : [ [5, 3, 2, 1, 7, 4, 6] , [1, 3, 5, 2, 4, 7, 6] , [5, 2, 3, 7, 6, 4, 1] ]

Explanation : The In-order traversal is [5, 3, 2, 1, 7, 4, 6].

The Pre-order traversal is [1, 3, 5, 2, 4, 7, 6].

The Post-order traversal is [5, 2, 3, 7, 6, 4, 1].

Constraints

1 <= Number of Nodes <= 105
0 <= Node.val <= 10^5 */

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
    public void inorder(TreeNode root, List<Integer>in){
        if(root==null){
            return;
        }
        inorder(root.left,in);
        in.add(root.data);
        inorder(root.right,in);

        return;
    }
    public void preorder(TreeNode root, List<Integer>pre){
        if(root==null){
            return;
        }
        pre.add(root.data);
        preorder(root.left,pre);
        preorder(root.right,pre);

        return;
    }
    public void postorder(TreeNode root, List<Integer>post){
        if(root==null){
            return;
        }
        postorder(root.left,post);
        postorder(root.right,post);
        post.add(root.data);

        return;
    }
    List<List<Integer>> treeTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        inorder(root, in);
        preorder(root, pre);
        postorder(root, post);

        ans.add(in);
        ans.add(pre);
        ans.add(post);

        return ans;

    }
}




// this approach didn't click while solving the problem but it is a good approach to solve the problem. 

class Solution {
    
    // Single helper method to handle all three traversals at once
    public void traverse(TreeNode root, List<Integer> in, List<Integer> pre, List<Integer> post) {
        if (root == null) {
            return;
        }
        
        // 1. Pre-order: Process node before visiting children
        pre.add(root.data);
        
        // Visit Left
        traverse(root.left, in, pre, post);
        
        // 2. In-order: Process node after visiting left child, before right
        in.add(root.data);
        
        // Visit Right
        traverse(root.right, in, pre, post);
        
        // 3. Post-order: Process node after visiting both children
        post.add(root.data);
    }
    
    List<List<Integer>> treeTraversal(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        // Call the single-pass method
        traverse(root, in, pre, post);
        
        ans.add(in);
        ans.add(pre);
        ans.add(post);
        
        return ans;
    }
}