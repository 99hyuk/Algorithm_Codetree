import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] arr = s.split(" ");
        int[] iArr = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            iArr[i] = Integer.parseInt(arr[i]);
        }
        
        Arrays.sort(iArr);
        
        StringBuilder sb = new StringBuilder();
        int min = iArr[0];
        int max = iArr[arr.length-1];
        sb.append(min).append(" ").append(max);
        
        String answer = sb.toString();
        return answer;
    }
}