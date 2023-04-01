import java.util.List;
import java.util.ArrayList;

class FindBigNum {
    public int[] solution(int[] numbers) {
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<numbers.length-1;i++){
            int num=-1;
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]<numbers[j]){
                    num=numbers[j];
                    break;
                }
            }
            list.add(num);
        }

        list.add(-1);
        int[] answer = new int[list.size()];

        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }

        return answer;
    }
}