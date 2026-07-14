import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        for (int i=0; i<phone_book.length-1; i++) {
            String s1 = phone_book[i];
            String s2 = phone_book[i+1];
            
            if (s1.startsWith(s2) || s2.startsWith(s1)) {
                return false;
            }
        }
            
        
//         for (int i=0; i<phone_book.length; i++) {
//             String s1 = phone_book[i];
//             int l1 = s1.length();
//             for (int j=i+1; j<phone_book.length; j++) {
                
//                 String s2 = phone_book[j];
//                 int l2 = s2.length();   
                
//                 boolean isPoss = true;
                
//                 if (l1 < l2) {
//                     for (int c=0; c<l1; c++) {
//                         if (s1.charAt(c) != s2.charAt(c)) {
//                             isPoss = false;
//                             break;
//                         }
//                     }
//                 } else {
//                     for (int c=0; c<l2; c++) {
//                         if (s1.charAt(c) != s2.charAt(c)) {
//                             isPoss = false;
//                             break;
//                         }
//                     }
//                 }
                
//                 if (isPoss) {
//                     return false;
//                 }
//             }
//         }
        
        return true;
    }
}