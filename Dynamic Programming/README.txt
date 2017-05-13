Two Google Interview questions:

1.Guess Number Higher or Lower II:

We are playing the Guess Game. The game is as follows:
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

dp[n][n] 
State:dp[i][j]: money you need to guarantee a win between i and j
Function: dp[i][j]= min(k+1 + max(dp[i][k-1], dp[k+1][j])) //dp[i][k-1]:num is lower; dp[k+1][j]:num is greater.
Intialize: dp[i][i]=0; dp[i][i+1]=i+1;
Answer: dp[0][n]



2.Drop Eggs
There is a building of n floors. If an egg drops from the k th floor or above, it will break. If it's dropped from any floor below, it will not break.
You're given m eggs, Find k while minimize the number of drops for the worst case. Return the number of drops in the worst case.

dp[n+1][m+1]
State: dp[i][j] times you need to decide the floor at i floors and j eggs
Function: dp[i][j]=min(1+max(dp[k-1][j-1],dp[i-k,j]))// dp[k-1][j-1]:egg is broken; dp[i-k,j]: egg is not broken.
Intialize: dp[i][1]=i; dp[1][j]=1;
Answer: dp[n][m]
