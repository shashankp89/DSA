import java.util.*;

class Solution {
    private int index = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> resultSet = parseExpression(expression);
        List<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }
    
    private Set<String> parseExpression(String s) {
        Set<String> currentSet = new HashSet<>();
        Set<String> groupSet = new HashSet<>();
        groupSet.add("");
        
        while (index < s.length()) {
            char c = s.charAt(index);
            
            if (c == '{') {
                index++;
                Set<String> subSet = parseExpression(s);
                groupSet = combine(groupSet, subSet);
            } else if (c == '}') {
                index++;
                currentSet.addAll(groupSet);
                return currentSet;
            } else if (c == ',') {
                index++;
                currentSet.addAll(groupSet);
                groupSet = new HashSet<>();
                groupSet.add("");
            } else {
                Set<String> charSet = new HashSet<>();
                charSet.add(String.valueOf(c));
                groupSet = combine(groupSet, charSet);
                index++;
            }
        }
        
        currentSet.addAll(groupSet);
        return currentSet;
    }
    
    private Set<String> combine(Set<String> set1, Set<String> set2) {
        Set<String> result = new HashSet<>();
        for (String s1 : set1) {
            for (String s2 : set2) {
                result.add(s1 + s2);
            }
        }
        return result;
    }
}