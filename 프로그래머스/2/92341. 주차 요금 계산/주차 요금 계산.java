import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        boolean[] visited = new boolean[records.length];
        int[] time = new int[10000];
        
        for (int i=0; i<records.length; i++) {
            if (!visited[i]) {
                String num = records[i].substring(6,10);
                visited[i] = true;
                boolean check = false;

                for (int j=i+1; j<records.length; j++) {
                    if (num.equals(records[j].substring(6,10)) && records[j].substring(11,14).equals("OUT")) {
                        time[Integer.parseInt(records[j].substring(6,10))] += calTime(records[i], records[j]);
                        visited[j] = true;
                        check = true;
                        break;
                    }
                }
                
                if (!check) {
                    time[Integer.parseInt(records[i].substring(6,10))] += calTime(records[i], "23:59");
                }
            }
        }
        
        int cnt = 0;
        for (int i=0; i<10000; i++) {
            if (time[i] != 0) cnt++;
        }
        
        int[] result = new int[cnt];
        int idx = 0;
        
        for (int i=0; i<10000; i++) {
            if (time[i] != 0) {
                int cost = 0;
                if (time[i] <= fees[0]) {
                    cost = fees[1];
                } else {
                    cost = fees[1];
                    
                    if ((time[i]-fees[0]) % fees[2] > 0) {
                        cost += (((time[i]-fees[0]) / fees[2]) + 1) * fees[3];
                    } else {
                        cost += ((time[i]-fees[0]) / fees[2]) * fees[3];
                    }
                }
                
                result[idx++] = cost;
            }
        }
        
        
        return result;
    }
    
    public int calTime(String str1, String str2) {
        int time1 = Integer.parseInt(str1.substring(0,2)) * 60 + Integer.parseInt(str1.substring(3,5));
        int time2 = Integer.parseInt(str2.substring(0,2)) * 60 + Integer.parseInt(str2.substring(3,5));
        
        return time2 - time1;
    }
}