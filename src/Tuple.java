import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tuple {
    public static int[] solution(String s) {
        // 1. s -> list에 정리
        List<List<Integer>> list=new ArrayList<>();
        String[] splitArr=s.split("}");
        for(String str:splitArr){
            List<Integer> temp=new ArrayList<>();
            int i=0;
            // 숫자 추출
            while(i<str.length()){
                int headIdx=0;
                int tailIdx=1;
                if(Character.isDigit(str.charAt(i))){
                    headIdx=i;
                    while(i<str.length()&&Character.isDigit(str.charAt(i))){
                        i++;
                    }
                    tailIdx=i;
                    temp.add(Integer.parseInt(str.substring(headIdx,tailIdx)));
                }
                else
                    i++;
            }

            if(!temp.isEmpty())
                list.add(temp);
        }


        // 2. 개수가 작은것부터 오름차순으로 정렬
        list.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.size() - o2.size();
            }
        });

        List<Integer> result=new ArrayList<>();
        int[] answer = new int[list.size()];

        for(List<Integer> l:list){
            for(int num:l){
                if(!result.contains(num))
                    result.add(num);
            }
        }
        System.out.println(result);

        for(int i=0;i<answer.length;i++){
            answer[i]=result.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        String str="{{20,111},{111}}";
        solution(str);

    }
}
