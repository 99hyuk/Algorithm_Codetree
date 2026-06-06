import java.util.*;

class Solution {
    
    public String[] solution(String[] record) {
        
        List<String> id = new ArrayList<>();
        Map<String, String> nickname = new HashMap<>();
        List<String> cmd = new ArrayList<>();
        
        for (int i=0; i<record.length; i++) {
            String[] arr = record[i].split(" ");
            if (arr[0].equals("Enter")) {
                cmd.add(arr[0]);
                id.add(arr[1]);
                nickname.put(arr[1], arr[2]);
            } else if (arr[0].equals("Leave")) {
                cmd.add(arr[0]);
                id.add(arr[1]);
            } else {
                nickname.put(arr[1], arr[2]);
            }
        }
        
        String[] answer = new String[id.size()];
        for (int i=0; i<id.size(); i++) {
            if (cmd.get(i).equals("Enter")) {
                answer[i] = nickname.get(id.get(i)) + "님이 들어왔습니다.";
            } else if (cmd.get(i).equals("Leave")) {
                answer[i] = nickname.get(id.get(i)) + "님이 나갔습니다.";
            }
        }
        
        
        return answer;
    }
}