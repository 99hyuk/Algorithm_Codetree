import java.util.*;

class Homework implements Comparable<Homework> {
    String subject;
    int startTime;
    int playTime;
    
    Homework (String subject, int startTime, int playTime) {
        this.subject = subject;
        this.startTime = startTime;
        this.playTime = playTime;
    }
    
    @Override
    public int compareTo(Homework o) {
        return Integer.compare(this.startTime, o.startTime);
    }
}

class Solution {
    
    List<Homework> list = new ArrayList<>();
    
    public String[] solution(String[][] plans) {
        
        for (String[] arr : plans) {
            int t = Integer.parseInt(arr[1].substring(0,2)) * 60 + Integer.parseInt(arr[1].substring(3,5));
            list.add(new Homework(arr[0], t, Integer.parseInt(arr[2])));
        }
        
        Collections.sort(list);
        
        Stack<Homework> stack = new Stack<>();
        List<String> finalArr = new ArrayList<>();
        
        int idx = 0;
        while (idx < list.size()) {
            Homework homework = list.get(idx);
            int curTime = homework.startTime;
            
            if (stack.isEmpty()) {
                stack.push(homework);
                idx++;
                
            } else if (stack.peek().startTime + stack.peek().playTime <= list.get(idx).startTime) {
                
                int time = homework.startTime - stack.peek().startTime;
                
                while (time > 0 && !stack.isEmpty()) {
                    Homework h = stack.pop();
                    
                    time -= h.playTime;
                    finalArr.add(h.subject);
                    
                    if (!stack.isEmpty() && stack.peek().playTime > time) {
                        stack.peek().playTime -= time;
                        break;
                    }
                }
                
                stack.push(homework);
                idx++;
                
            } else {
                stack.peek().playTime -= homework.startTime - stack.peek().startTime;
                stack.push(homework);
                idx++;
            }
        }
        
        while (!stack.isEmpty()) {
            Homework homework = stack.pop();
            finalArr.add(homework.subject);
        }
        
        String[] answer = new String[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = finalArr.get(i);
        }
               
        return answer;
    }
}