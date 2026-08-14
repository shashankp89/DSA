import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
         
        boolean[] cols = new boolean[n];
        boolean[] posDiag = new boolean[2 * n];
        boolean[] negDiag = new boolean[2 * n];
        
        backtrack(0, n, board, res, cols, posDiag, negDiag);
        return res;
    }
    
    private void backtrack(int row, int n, char[][] board, List<List<String>> res, 
                           boolean[] cols, boolean[] posDiag, boolean[] negDiag) {
        
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            
            if (cols[col] || posDiag[row + col] || negDiag[row - col + n]) {
                continue;
            }
            
             
            board[row][col] = 'Q';
            cols[col] = true;
            posDiag[row + col] = true;
            negDiag[row - col + n] = true;
            
             
            backtrack(row + 1, n, board, res, cols, posDiag, negDiag);
            
            
            board[row][col] = '.';
            cols[col] = false;
            posDiag[row + col] = false;
            negDiag[row - col + n] = false;
        }
    }
}