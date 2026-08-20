import java.util.*;

class Sorting implements Comparable<Sorting> {
    int num;
    
    Sorting(int num) {
        this.num = num;
    }
    
    @Override
    public int compareTo(Sorting o) {
        String s1 = String.valueOf(this.num) + String.valueOf(o.num);
        String s2 = String.valueOf(o.num) + String.valueOf(this.num);
        
        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);
        
        return Integer.compare(num2, num1);
    }
}

class Solution {
    public String solution(int[] numbers) {
        List<Sorting> list = new ArrayList<>();
        for (int i=0; i<numbers.length; i++) {
            list.add(new Sorting(numbers[i]));
        }
        
        Collections.sort(list);
        
        String answer = "";
        for (Sorting s : list) {
            int num = s.num;
            answer += num;            
        }
        
        if (answer.charAt(0) == '0') {
            answer = "0";
        }
        
        return answer;
    }
}
