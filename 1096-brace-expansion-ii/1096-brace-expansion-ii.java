import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        Set<String> resultSet = new HashSet<>();
        queue.offer(expression);
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            
            if (!curr.contains("{")) {
                resultSet.add(curr);
                continue;
            }
            
            int right = curr.indexOf('}');
            int left = right;
            while (curr.charAt(left) != '{') {
                left--;
            }
            
            String before = curr.substring(0, left);
            String after = curr.substring(right + 1);
            String[] parts = curr.substring(left + 1, right).split(",");
            
            for (String part : parts) {
                queue.offer(before + part + after);
            }
        }
        
        List<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }
}