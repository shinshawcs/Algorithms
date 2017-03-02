Given N jobs where every job is represented by following three elements of it.

Start Time
Finish Time
Profit or Value Associated
Find the maximum profit subset of jobs such that no two jobs in the subset overlap.

Input: Number of Jobs n = 4
       Job Details {Start Time, Finish Time, Profit}
       Job 1:  {1, 2, 50} 
       Job 2:  {3, 5, 20}
       Job 3:  {6, 19, 100}
       Job 4:  {2, 100, 200}
Output: The maximum profit is 250.
We can get the maximum profit by scheduling jobs 1 and 4.
Note that there is longer schedules possible Jobs 1, 2 and 3 
but the profit with this schedule is 20+50+100 which is less than 250.  

O(n2)
class Job{
  int start,end,profit;
  public Job(int start,int end,int profit){
    this.start=start;
    this.end=end;
    this.profit=profit;
  }
}
//dynamic programming
public static int schedule(Job jobs[]){
    if(jobs==null||jobs.length==0) return 0;
    Arrays.sort(jobs,new Comparator<Job>(){
      public int compare(Job a,Job b){
        return a.end-b.end;
      }
    });
    int n=jobs.length;
    int[] dp=new int[n];
    //initialize
    for(int i=0;i<n;i++){
      dp[i]=jobs[i].profit;
    }
    //state if(i,j no overlap) dp[i]=max(dp[i],profit[i]+dp[j])
    for(int i=1;i<n;i++){
      for(int j=0;j<i;j++){
        if(jobs[j].end<=jobs[i].start){
          dp[i]=Math.max(dp[i],jobs[i].profit+dp[j]);
          }
      }
    }
    int res=0;
		for(int i=0;i<n;i++){
			res=Math.max(dp[i], res);
		}
		return res;
}
//BinarySearch O(nlogn)
public static int schedule2(Job jobs[]){
  if(jobs==null||jobs.length==0) return 0;
		Arrays.sort(jobs,new Comparator<Job>(){
			@Override
			public int compare(Job a, Job b) {
				return a.end-b.end;
			}			
		});
    int n=jobs.length;
    int[] dp=new int[n];
		for(int i=0;i<n;i++){
			dp[i]=jobs[i].profit;
		}
    for(int i=1;i<n;i++){
      int left=binarySearch(jobs,i);
      if(left!=-1){
        dp[i]=dp[left]+jobs[i].profit;
      }
      dp[i]=Math.max(dp[i],dp[i-1]);
    }
    return dp[n-1];
}
public int binerySearch(Job[]jobs, int i){
  int l=0,r=i-1;
  while(l<=r){
    int mid=(r+l)/2;
    if(jobs[mid].end<=jobs[i].start){
      if(jobs[mid+1].end<=jobs[i].start){
          l=mid+1;
      }else{
          return mid;
      }
    }else{
      r=mid-1;
    }
  }
}
