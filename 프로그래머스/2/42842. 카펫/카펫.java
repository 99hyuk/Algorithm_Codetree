import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int garo;
        int sero;
        
        for (int i=1; i*i<=yellow; i++) {
            if (yellow % i == 0) {
                sero = i;
                garo = yellow / i;
                
                if (garo*2 + sero*2 + 4 == brown) {
                    return new int[]{garo+2, sero+2};
                }
            }
        }
        return new int[2];
    }
}