import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Solo {
    static boolean[] visited;
    static List<Integer> list=new ArrayList<>();
    public int solution(int[] cards) {
        int answer = 0;
        visited=new boolean[cards.length];
        int index=0;
        for(int i=0;i<cards.length;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(cards, cards[i]-1, 1);
            }

        }

        list.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });
        if(list.size()>=2)
            answer=list.get(0)*list.get(1);
        return answer;
    }

    private void dfs(int[] cards, int c, int count){
        if(!visited[c]){
            visited[c]=true;
            dfs(cards, cards[c]-1, count+1);
        }
        else{
            list.add(count);
            return;
        }
    }
}