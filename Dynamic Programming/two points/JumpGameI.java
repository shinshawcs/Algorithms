public class Solution {
    public boolean canJump(int[] A) {
        if(A==null||A.length==0) return true;
	      int n=A.length;
		    if(n<=1) return true;
		    int max=A[0];
		    for(int i=0;i<n;i++){
		      if(max<=i&&A[i]==0){
		        return false;
		      }
		      if(A[i]+i>max) max=A[i]+i;
		      if(max>=n-1) return true;
		  }
		  return false;
    }
}
