
Russian Doll Envelopes:

You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
One envelope can fit into another if and only if both the width and height of one envelope is 
greater than the width and height of the other envelope.
What is the maximum number of envelopes can you Russian doll? (put one inside other)

dp:slow 
public class RussianDollEnvelopes {
static class myComparator implements Comparator<int[]>{
		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if(o1[0]==o2[0]){
				return o2[1]-o1[1];
			}
			return o1[0]-o2[0];
		}		
	}
	public static int maxEnvelopes(int[][] envelopes){
		if(envelopes==null||envelopes.length==0) return 0;
		Arrays.sort(envelopes,new myComparator());
		System.out.println(Arrays.deepToString(envelopes));
		int n=envelopes.length;
		int[] dp=new int[n];
		Arrays.fill(dp, 1);
		for(int i=1;i<envelopes.length;i++){
			for(int j=0;j<i;j++){
				if(envelopes[j][0]<envelopes[i][0]&&envelopes[j][1]<envelopes[i][1]&&
						dp[j]+1>dp[i]){
					dp[i]=dp[j]+1;
				}
			}
		}
		int max=1;
		for(int i=0;i<n;i++){
			max=Math.max(max, dp[i]);
		}
		return max;
	}
  }
