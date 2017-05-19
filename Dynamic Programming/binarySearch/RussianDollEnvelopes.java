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
		int len=0;
		for(int[] e:envelopes){
			int idx=Arrays.binarySearch(dp,0,len,e[1]);
			if(idx<0) idx=-idx-1;
			//System.out.println(idx);
			dp[idx]=e[1];
			if(idx==len) len++;
		}
		return len;
	}
