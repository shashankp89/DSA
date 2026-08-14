import java.util.*;
 
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        
        q.offer(0); 
        
        while (!q.isEmpty()) {
            int start = q.poll();
             
            if (start == s.length()) {
                return true;
            }
             
            if (!visited[start]) {
                for (int end = start + 1; end <= s.length(); end++) {
                     
                    if (wordSet.contains(s.substring(start, end))) {
                        q.offer(end);
                    }
                }
                visited[start] = true;  
            }
        }
        
        return false;
    }
}