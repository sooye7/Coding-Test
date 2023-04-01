import java.util.Deque;
import java.util.LinkedList;

class FindBigNum2 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> d=new LinkedList<>();
        d.offerLast(0);
        for(int i=0;i<numbers.length;i++){
            while(!d.isEmpty()&&numbers[d.peekLast()]<numbers[i]){
                answer[d.pollLast()]=numbers[i];
            }
            d.offer(i);
        }
        while(!d.isEmpty()){
            answer[d.pollLast()]=-1;
        }
        return answer;
    }
}