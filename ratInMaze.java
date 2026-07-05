/*Given a grid of dimensions n x n. A rat is placed at coordinates (0, 0) and wants to reach at coordinates (n-1, n-1).



Find all possible paths that rat can take to travel from (0, 0) to (n-1, n-1). The directions in which rat can move are 'U' (up) , 'D' (down) , 'L' (left) , 'R' (right).



The value 0 in grid denotes that the cell is blocked and rat cannot use that cell for travelling, whereas value 1 represents that rat can travel through the cell. If the cell (0, 0) has 0 value, then mouse cannot move to any other cell.



Note :

In a path no cell can be visited more than once.
If there is no possible path then return empty vector.

Example 1

Input : n = 4 , grid = [ [1, 0, 0, 0] , [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1] ]

Output : [ "DDRDRR" , "DRDDRR" ]

Explanation : The rat has two different path to reach (3, 3).

The first path is (0, 0) => (1, 0) => (2, 0) => (2, 1) => (3, 1) => (3, 2) => (3, 3).

The second path is (0,0) => (1,0) => (1,1) => (2,1) => (3,1) => (3,2) => (3,3).

Example 2

Input : n = 2 , grid = [ [1, 0] , [1, 0] ]

Output : -1

Explanation : There is no path that rat can choose to travel from (0,0) to (1,1).

 
Constraints

2 <= n <= 5
0 <= grid[i][j] <= 1 */




import java.util.ArrayList;

class Solution {
    public void DFS(ArrayList<String> ans, StringBuilder temp, int[][] nums, int i, int j) {
        int n = nums.length;
        
         
        if (i == n - 1 && j == n - 1) {
            ans.add(temp.toString());
            return;
        }
        
        
        if (i < 0 || i > n - 1 || j < 0 || j > n - 1 || nums[i][j] == 0) {
            return;
        }
        
         
        nums[i][j] = 0; 
        
         
        temp.append('D');
        DFS(ans, temp, nums, i + 1, j);
        temp.deleteCharAt(temp.length() - 1);
        
        
        temp.append('L');
        DFS(ans, temp, nums, i, j - 1);
        temp.deleteCharAt(temp.length() - 1);
        
         
        temp.append('R');
        DFS(ans, temp, nums, i, j + 1);
        temp.deleteCharAt(temp.length() - 1);
        
         
        temp.append('U');
        DFS(ans, temp, nums, i - 1, j);
        temp.deleteCharAt(temp.length() - 1);
        
         
        nums[i][j] = 1; 
    }
    
    public ArrayList<String> findPath(int[][] m) {
        ArrayList<String> ans = new ArrayList<>();
        int n = m.length;
         
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0) {
            return ans;
        }
        
        DFS(ans, new StringBuilder(), m, 0, 0);
        return ans;
    }
}