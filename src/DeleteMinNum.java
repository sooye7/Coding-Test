import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeleteMinNum {
    public static int[] solution(int[] arr) {
        int[] answer;
        List<Integer> list=new ArrayList<>();
        for(int a:arr)
            list.add(a);
        int min=Collections.min(list);
        list.remove(Integer.valueOf(min));
        if(list.size()==0) {
            answer = new int[1];
            answer[0]=-1;
        }
        else {
            answer = new int[list.size()];
            for (int i = 0; i < answer.length; i++)
                answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr={10};
        int[] answer=solution(arr);
        for(int i=0;i<answer.length;i++)
            System.out.println(answer[i]);
    }
}
