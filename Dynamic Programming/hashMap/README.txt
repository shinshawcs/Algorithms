Frog Jump:

A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. 
The frog can jump on a stone, but it must not jump into the water.
Given a list of stones' positions (in units) in sorted ascending order, 
determine if the frog is able to cross the river by landing on the last stone. 
Initially, the frog is on the first stone and assume the first jump must be 1 unit.
If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. 
Note that the frog can only jump in the forward direction.

dp 400ms O(n2)

public class Solution {
    public boolean canCross(int[] stones) {
        int len = stones.length;
        if (len == 2 && stones[1] - stones[0] > 1) {
            return false;
        }
        Set[] lastPos = new Set[len + 1];
        for (int i = 1; i < len; i ++) {
            lastPos[i] = new HashSet<>();
        }
        lastPos[1].add(1);
        for (int i = 2; i < len; i ++) {
            for (int j = 1; j < i; j ++) {
                if (lastPos[j].size() > 0) {
                    int dist = stones[i] - stones[j];
                    if (lastPos[j].contains(dist) || lastPos[j].contains(dist - 1) || lastPos[j].contains(dist + 1)) {
                        lastPos[i].add(dist);
                    }
                }
            }
        }
        return lastPos[len - 1].size() > 0;
    }
}

HashMap 90ms 
