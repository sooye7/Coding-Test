import java.util.ArrayList;
import java.util.List;

public class HateSameNum {
    public static int[] solution(int []arr) {
        List<Integer> list=new ArrayList<>();
        int num=-1;
        for(int i=0;i<arr.length;i++){
            if(num!=arr[i])
                list.add(arr[i]);
            num=arr[i];
        }
        int[] answer=new int[list.size()];
        for(int i=0;i<answer.length;i++)
            answer[i]=list.get(i);
        return answer;
    }

    public static void main(String[] args) {

    }
}
