Jump I && II

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

dp solution --- time limited exceeded
int[] dp=new int[n];
dp[i]=Math.min(dp[j]+1,dp[i]) if(dp[j]!=Integer.MAX_VALUE&&j+A[j]>=i); (j<i)

Three Points solution:
We use "last" to keep track of the maximum distance that has been reached
by using the minimum steps "res", whereas "cur" is the maximum distance
that can be reached by using "ret+1" steps. Thus,
cur = max(i+A[i]) where 0 <= i <= last.
int cur,last,minstep=0;
