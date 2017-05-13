public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n][n];
        for(int i=0;i<n-1;i++){
            dp[i][i+1]=i+1;
        }
        for(int len=2;len<n;len++){
            for(int i=0;i+len<n;i++){
                int j=i+len;
                for(int k=i+1;k<j;k++){
                    int cur=k+1+Math.max(dp[i][k-1],dp[k+1][j]);
                    if(dp[i][j]==0||dp[i][j]>cur){
                        dp[i][j]=cur;
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
