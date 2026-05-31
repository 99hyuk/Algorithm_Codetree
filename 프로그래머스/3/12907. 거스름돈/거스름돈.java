class Solution {
    public int solution(int n, int[] money) {
        
        int[] dp = new int[n+1];
        dp[0] = 1;
            
        for (int j=0; j<money.length; j++) {
            for (int i=money[j]; i<=n; i++) {
                dp[i] = (dp[i-money[j]] + dp[i]) % 1_000_000_007;
            }
        }
    
        int answer = dp[n] % 1_000_000_007;
        return answer;
    }
}