import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Deque<Character> stack = new ArrayDeque<>();
        boolean answer = true;
        
        for (int i=0; i<s.length(); i++) {
            char current = s.charAt(i);
            
            if (stack.isEmpty()) {
                stack.push(current);
                continue;
            }
            
            char prev = stack.peek();
            
            if (prev == '(') {
                if (current == '(') {
                    stack.push(current);
                } else {
                    stack.pop();
                }
            } else {
                if (current == '(') {
                    answer = false;
                    break;
                } 
            }
        }
        
        if (!stack.isEmpty()) answer = false;
        
        return answer;
    }
}