import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SameSumOfQueue {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long total=0, half=0;  // 총합, 절반
        long sum1=0, sum2=0;
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        for(int q:queue1) {
            q1.offer(q);
            total+=q;
            sum1+=q;
        }
        for(int q:queue2) {
            q2.offer(q);
            total+=q;
            sum2+=0;
        }
        if(total%2==0) {
            half=total/2;
            while (!q1.isEmpty() && !q2.isEmpty()) {
                if (sum1>half){
                    int num=q1.poll();
                    sum1-=num;
                    q2.offer(num);
                    sum2+=num;
                }
                else if(sum1<half){
                    int num=q2.poll();
                    sum1+=num;
                    q1.offer(num);
                    sum2-=num;
                }
                if(sum1==half)
                    break;
            }
        }
        return answer;
    }


    public static int solution2(int[] queue1, int[] queue2) {
        int answer = 0;
        long total=0, half=0;
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> ansList=new ArrayList<>();
        for(int q:queue1) {
            total += q;
            list.add(q);
        }
        for(int q:queue2) {
            total += q;
            list.add(q);
        }
        int len=list.size();
        System.out.println(list);
        if(total%2==0){
            half=total/2;
            for(int i=0;i<len;i++){
                int sum=0;
                List<Integer> temp=new ArrayList<>();
                System.out.println(list);
                for(int j=0;j<len&&sum<=half;j++){
                    sum+=list.get(j);
                    temp.add(list.get(j));

                    System.out.println(sum);
                    if(sum==half){
                        if(!ansList.contains(temp)) {
                            answer++;
                            ansList.add(temp);
                            List<Integer> temp2 = new ArrayList<>();
                            for (int k = j + 1; k < len; k++)
                                temp2.add(list.get(k));
                            ansList.add(temp2);
                        }
                        break;
                    }
                }

                int num=list.get(0);
                list.remove(0);
                list.add(num);

                System.out.println(ansList);
            }
        }
        if(total%2!=0||answer==0)
            answer=-1;

        return answer;
    }
    public static void main(String[] args) {
        int[] queue1={1,2,1,2};
        int[] queue2={1,10,1,2};

        System.out.println(solution2(queue1,queue2));
    }
}
