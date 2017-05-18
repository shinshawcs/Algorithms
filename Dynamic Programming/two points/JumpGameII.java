public class Solution {
    public int jump(int[] A) {
        if(A==null||A.length==0) return 0;
		 int n=A.length;
		 int cur=0;
		 int last=0;int res=0;
		 for(int i=0;i<n;i++){
		     if(i>last){
		         last=cur;
		         ++res;
		     }
		     cur=Math.max(cur,i+A[i]);
		 }
		 return res;
    }
}
