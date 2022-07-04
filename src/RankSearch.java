import java.util.*;

public class RankSearch {
    static Map<String,List<Integer>> map=new HashMap<>();
    static int[] answer;

    // 시간 초과 풀이
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // 1. info에서 점수만 뽑아 리스트
        List<Integer> score=new ArrayList<>();
        for(String i:info){
            int index=0;
            for(int j=0;j<i.length();j++){
                if(Character.isDigit(i.charAt(j))){
                    index=j;
                    break;
                }
            }
            score.add(Integer.parseInt(i.substring(index)));
        }

        // 2. query split해서 리스트
        List<List<String>> querySplit=new ArrayList<>();
        for(String q:query){
            String[] temp=q.split(" ");
            List<String> tmp=new ArrayList<>();
            for(String t:temp){
                if(!t.equals("and"))
                    tmp.add(t);
            }
            querySplit.add(tmp);
        }

        // 3. query 돌면서 info와 비교, count
        for(int k=0;k<querySplit.size();k++){
            int sum=0;
            for(int i=0;i<info.length;i++){
                int count=1;
                for(int j=0;j< querySplit.get(k).size()-1;j++){

                    if(!querySplit.get(k).get(j).equals("-")) {
                        if (!info[i].contains(querySplit.get(k).get(j)) || score.get(i) < Integer.parseInt(querySplit.get(k).get(querySplit.get(k).size() - 1))) {
                            count = 0;
                            break;
                        }
                    }

                    if(score.get(i) < Integer.parseInt(querySplit.get(k).get(querySplit.get(k).size() - 1))){
                        count=0;
                        break;
                    }

                }
                sum+=count;
            }
            answer[k]=sum;
        }

        return answer;
    }

    // 다른 사람 풀이
    public static int[] solution2(String[] info, String[] query) {
        answer = new int[query.length];
        setInfo(info);
        countQ(query);

        return answer;
    }

    static void dfs(String str, int depth, String[] info){
        if(depth==4){
            if(map.containsKey(str)==false){
                List<Integer> list=new ArrayList<>();
                list.add(Integer.parseInt(info[4]));
                map.put(str,list);
            }
            else{
                map.get(str).add(Integer.parseInt(info[4]));
            }
            return;
        }
        dfs(str+"-",depth+1,info);
        dfs(str+info[depth],depth+1,info);
    }

    static void setInfo(String[] info){
        for(int i=0;i<info.length;i++){
            dfs("",0,info[i].split(" "));
        }
        for(String key:map.keySet()){
            Collections.sort(map.get(key));
        }
    }

static void countQ(String[] query){
        for(int i=0;i< query.length;i++){
            String[] sql=query[i].split(" and ");
            String q="";
            for(int j=0;j<sql.length;j++){
                q+=sql[j];
            }
            String[] qArr=q.split(" ");
            String key=qArr[0];
            int score=Integer.parseInt(qArr[1]);
            int count=0;
            if(map.containsKey(key)){
                List<Integer> list=map.get(key);

                int start=0;
                int end=list.size()-1;
                int mid=0;

                while(start<=end){
                    mid=(start+end)/2;

                    if(list.get(mid)>=score){
                        end=mid-1;
                    }
                    else{
                        start=mid+1;
                    }
                }
                count=list.size()-start;
            }
            answer[i]=count;
        }
}


    public static void main(String[] args) {
        String[] info={"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150",
                "cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query={"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250",
                "- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        solution2(info, query);

    }
}
