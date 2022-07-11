import java.util.*;

public class Camouflage {
    static int answer=0;
    static int result=1;

    public static int solution(String[][] clothes) {
        int answer = 1;

        // 1. 의상의 종류 별로 분류하여 Map에 <의상의 종류, 의상의 개수> 삽입
        Map<String, Integer> map=new HashMap<>();
        List<String> type=new ArrayList<>();
        for(String[] c:clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
            type.add(c[1]);
        }
        System.out.println(map);

        // 2. 각 종류 별 옷 조합 경우의 수
        Iterator<Integer> it=map.values().iterator();
        while(it.hasNext())
            answer*=it.next().intValue()+1;

        // 3. 아무 종류의 옷도 입지 않은 경우 제외
        answer--;

        return answer;
    }


    static void subset(Map<String,Integer> map, boolean[] visited, List<String> type, int start, int r){
        if(start==r) {
            answer += result;
            result=1;
        }
        for(int i=start;i<map.size();i++){
            if(!visited[i]){
                visited[i]=true;
                result*=map.get(type.get(i));
                subset(map,visited,type, start+1,r);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        String[][] clothes={{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));

    }
}
