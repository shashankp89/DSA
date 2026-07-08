/*Given a root of binary search tree and a key(node) value, find the floor and ceil value for that particular key value.



Floor Value Node: Node with the greatest data lesser than or equal to the key value. 


Ceil Value Node: Node with the smallest data larger than or equal to the key value.


If a particular floor or ceil value is not present then output -1.


Example 1

Input : root = [8, 4, 12, 2, 6, 10, 14] , key = 11

Output : [10, 12]

Explanation :



Example 2

Input : root = [8, 4, 12, 2, 6, 10, 14] , key = 15

Output : [14, -1]

Explanation :



Now your turn!

Input : root = [8, 4, 12, 2, 6, 10, 14] , key = 1

Output:

Pick your answer


[2, 4]

[-1, 2]

[-1, 14]

[4, 6]
Constraints

1 <= Number of Nodes <= 5000
1 <= Node.val <= 107
1 <= key <= 107 */

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
    public void floor(TreeNode root, int key, List<Integer> ans) {
        if (root == null) {
            return;
        } 
        if (root.data == key) {
            ans.set(0, key);
            return;
        }
        if (root.data > key) {
            floor(root.left, key, ans);
        } else {
            ans.set(0, root.data);  
            floor(root.right, key, ans);
        }
    }

    public void ciel(TreeNode root, int key, List<Integer> ans) {
        if (root == null) {
            return;
        } 
        if (root.data == key) {
            ans.set(1, key);
            return;
        }
        if (root.data > key) {
            ans.set(1, root.data);  
            ciel(root.left, key, ans);  
        } else {
            ciel(root.right, key, ans);  
        }
    }

    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        List<Integer> ans = new ArrayList<>();
        ans.add(-1);
        ans.add(-1);

        floor(root, key, ans);
        ciel(root, key, ans);

        return ans;
    }
}