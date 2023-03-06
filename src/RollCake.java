import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class RollCake {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> num=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int t:topping)
            num.put(t, num.getOrDefault(t, 0)+1);
        for(int i=0;i<topping.length;i++){
            num.put(topping[i], num.get(topping[i])-1);
            set.add(topping[i]);
            if(num.get(topping[i])==0)
                num.remove(topping[i]);
            if(set.size()==num.size())
                answer++;

        }

        return answer;
    }
}