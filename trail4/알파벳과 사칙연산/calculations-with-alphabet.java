import java.util.*;

public class Main {

    static int[] alp;
    static char[] alpIdx;
    static String input;

    static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        input = sc.next();
        alp = new int[150];
        alpIdx = new char[6];

        for (int i=0; i<6; i++) {
            alpIdx[i] = (char)('a' + i);
        }

        recursive(0);
        System.out.print(maxResult);
    }

    static void recursive(int idx) {
        if (idx == 6) {
            simulation();
            return;
        }
        
        for (int i=1; i<=4; i++) {
            alp[alpIdx[idx]] = i;
            recursive(idx+1);
        }
    }

    static void simulation() {
        char curStr = input.charAt(0);
        int curNum = alp[curStr];

        int sum = curNum;

        for (int i=2; i<input.length(); i+=2) {
            char cul = input.charAt(i-1);
            curStr = input.charAt(i);
            curNum = alp[curStr];

            if (cul == '+') {
                sum += curNum;
            } else if (cul == '-') {
                sum -= curNum;
            } else if (cul == '*') {
                sum *= curNum;
            }
        }

        maxResult = Math.max(maxResult, sum);
    }
}