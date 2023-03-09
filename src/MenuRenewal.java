
import java.util.*;

public class MenuRenewal {
    // 최대 조건 만족 X
    public static String[] solution(String[] orders, int[] course) {
        //String[] answer={};
        List<String> list=new ArrayList<>();
        List<Integer> len=new ArrayList<>();
        //Map<String, Integer> map=new HashMap<>();
        for(int i:course)
            len.add(i);

        for(int i=0;i<orders.length;i++){
            for(int j=i+1;j<orders.length;j++){
                StringBuilder str=new StringBuilder();
                for(int k=0;k<orders[j].length();k++){
                    if(orders[i].contains(orders[j].substring(k,k+1))) {
                        str.append(orders[j].charAt(k));
                    }
                }
                if(!list.contains(str.toString()))
                    list.add(str.toString());
            }
        }

        list.removeIf(str -> !len.contains(str.length()));

        String[] answer=new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        Arrays.sort(answer);
        for(String a:answer)
            System.out.println(a);
        return answer;
    }

    public static void main(String[] args) {
        String[] orders={"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course={2,3,4};
    }
}
