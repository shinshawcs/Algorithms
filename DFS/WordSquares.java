public class Solution {
    HashMap<String, List<String>> map=new HashMap<>();
    List<List<String>> res=new ArrayList<>();
    List<String> squares=new ArrayList<>();
    int wordLen=0;
    public List<List<String>> wordSquares(String[] words) {
        if(words==null||words.length==0) return res;
        wordLen=words[0].length();
        initPrefix(words);
        dfs(0);
        return res;
    }
    public void initPrefix(String[] words){
        for(String word:words){
            if(!map.containsKey("")){
                map.put("",new ArrayList<String>());
            }
            map.get("").add(word);
            for(int i=0;i<word.length();i++){
                String sub=word.substring(0,i+1);
                if(!map.containsKey(sub)){
                    map.put(sub,new ArrayList<String>());
                }
                map.get(sub).add(word);
            }
        }
    }
    public void dfs(int l){
        if(l==wordLen){
            res.add(new ArrayList<String>(squares)); return;
        }
        String pre="";
        for(int i=0;i<l;i++){
            pre+=squares.get(i).charAt(l);
        }
        List<String> w=map.get(pre);
        for(int i=0;i<w.size();i++){
            if(!checkPrefix(l,w.get(i))) continue;
            squares.add(w.get(i));
            dfs(l+1);
            squares.remove(squares.size()-1);
        }
    }
    public boolean checkPrefix(int l,String nextWord){
        for(int i=l+1;i<wordLen;i++){
            String pre="";
            for(int j=0;j<l;j++){
                pre+=squares.get(j).charAt(i);
            }
            pre+=nextWord.charAt(i);
            if(!map.containsKey(pre)){
                return false;
            }
        }
        return true;
    }
}
