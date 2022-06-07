import java.util.PriorityQueue;
import java.util.Queue;

public class MoreSpicy {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pq=new PriorityQueue<>();
        boolean check=true;
        int sum=0;
        int firstScov, secondScov, newScov;
        for(int s:scoville) {
            pq.offer(s);
            sum+=s;
        }
        if(sum==0)
            answer=-1;
        else{
            while(check){
                firstScov=pq.poll();
                secondScov= pq.poll();
                newScov=firstScov+2*secondScov;
                pq.offer(newScov);
                answer++;
                if(pq.peek()>=K)
                    check=false;
                else if(pq.size()==1&&pq.peek()<K){
                    answer=-1;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] scovile={1, 2, 3, 9, 10, 12};
        System.out.println(solution(scovile,7));

    }
}
