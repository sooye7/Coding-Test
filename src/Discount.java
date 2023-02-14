import java.util.Map;
import java.util.HashMap;

public class Discount {

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i=0;i<discount.length;i++){
            Map<String, Integer> map=new HashMap<>();
            if(i+10<=discount.length){
                for(int j=i;j<i+10;j++)
                    map.put(discount[j], map.getOrDefault(discount[j],0)+1);
            }
            else{
                for(int j=i;j<discount.length;j++)
                    map.put(discount[j], map.getOrDefault(discount[j],0)+1);
            }
            answer++;
            for(int j=0;j<want.length;j++){
                if(!map.containsKey(want[j])){
                    answer--;
                    break;
                }
                else{
                    if(map.get(want[j])<number[j]){
                        answer--;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] want={"banana", "apple", "rice", "pork", "pot"};
        int[] number={3, 2, 2, 2, 1};
        String[] discount={"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        solution(want, number, discount);
    }
}
