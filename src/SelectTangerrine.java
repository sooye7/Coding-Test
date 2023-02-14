import java.util.*;

public class SelectTangerrine {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map=new HashMap<>();
        for(int t:tangerine)
            map.put(t, map.getOrDefault(t,0)+1);

        List<Integer> key=new ArrayList<>(map.keySet());

        Collections.sort(key, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });


            for(int ky:key){
                k-=map.get(ky);
                answer++;
                if(k<=0)
                    break;
            }

        return answer;
    }

    public static void main(String[] args) {

    }
}
