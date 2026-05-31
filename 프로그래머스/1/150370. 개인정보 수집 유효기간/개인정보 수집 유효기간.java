import java.util.*;

class Date {
    int year;
    int month;
    int day;
    Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}

class Term {
    char alp;
    int month;
    Term (char alp, int month) {
        this.alp = alp;
        this.month = month;
    }
}

class Privacies {
    int idx;
    Date date;
    char alp;
    
    Privacies (int idx, Date date, char alp) {
        this.idx = idx;
        this.date = date;
        this.alp = alp;
    }
}

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        // today
        String[] todayArr = today.split("\\.");
        Date todayDate = new Date(Integer.parseInt(todayArr[0]),Integer.parseInt(todayArr[1]),Integer.parseInt(todayArr[2]));
        
        // term
        Map<Character, Integer> termMap = new HashMap<>();
        for (int i=0; i<terms.length; i++) {
            String[] arr = terms[i].split(" ");
            
            char alp = arr[0].charAt(0);
            int month = Integer.parseInt(arr[1]);
            termMap.put(alp, month);
        }
        
        // privacies
        Privacies[] privaciesArr = new Privacies[privacies.length];
        for (int i=0; i<privaciesArr.length; i++) {
            String[] arr = privacies[i].split(" ");
            String fullDate = arr[0];
            char alp = arr[1].charAt(0);
            
            String[] dateArr = fullDate.split("\\.");
            
            privaciesArr[i] = new Privacies(i+1,
                new Date(Integer.parseInt(dateArr[0]), Integer.parseInt(dateArr[1]), Integer.parseInt(dateArr[2])), alp);
        }
        
        // logic
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<privaciesArr.length; i++) {
            int curIdx = privaciesArr[i].idx;
            Date curDate = privaciesArr[i].date;
            char alp = privaciesArr[i].alp;
            
            int termMonth = termMap.get(alp);
            
            int year = (-curDate.year + todayDate.year) * 12 * 28;
            int month = (-curDate.month + todayDate.month) * 28;
            int day = -curDate.day + todayDate.day;
            
            if (year + month + day >= termMonth * 28) {
                list.add(curIdx);
            }
        }
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}