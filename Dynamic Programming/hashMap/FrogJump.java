public class Solution {
    public boolean canCross(int[] stones) {
        if(stones==null||stones.length==0) return true;
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],new HashSet<Integer>());
        }
        map.get(0).add(0);
        for(int i=0;i<stones.length-1;i++){
            int stone=stones[i];
            for(int k:map.get(stone)){
                if(k-1>0&&map.containsKey(stone+k-1)){
                    map.get(stone+k-1).add(k-1);
                }
                if(map.containsKey(stone+k)){
                    map.get(stone+k).add(k);
                }
                if(map.containsKey(stone+k+1)){
                    map.get(stone+k+1).add(k+1);
                }
            }
        }
        return !map.get(stones[stones.length-1]).isEmpty();
    }
}
