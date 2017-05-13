public class DropEggII {
	 public int dropEggs2(int m, int n){
		 int[][] dp=new int[m+1][n+1];
		 for(int i=1;i<m;i++){
			 dp[i][1]=1;
			 dp[i][0]=0;
		 }
		 for(int i=1;i<n;i++){
			 dp[1][i]=i;
		 }
		 for(int i=2;i<=m;i++){
			 for(int j=2;j<=n;j++){
				 dp[i][j]=Integer.MAX_VALUE;
				 for(int k=1;k<=j;k++){
					 int cur=1+Math.max(dp[i-1][k-1], dp[i][j-k]);
					 if(dp[i][j]>cur) dp[i][j]=cur;
				 }
			 }
		 }
		 return dp[m][n];
	 }
}
