import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FuncDev {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] temp=new int[progresses.length];
        Queue<Integer> q=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        int firstFuncIdx=0;
        int count=0;
        int j=1;
        boolean check=true;
        while(check) {
            for (int i = 0; i < progresses.length; i++) {
                temp[i] = progresses[i] + speeds[i];
                if (temp[i] >= 100 && i == firstFuncIdx) {
                    //System.out.println(i);
                    count++;
                    while (!q.isEmpty() && q.peek() == i + j) {
                        q.poll();
                        count++;
                        j++;
                    }
                    firstFuncIdx++;
                    list.add(count);
                    q.clear();
                    j = 1;
                    count = 0;
                } else if (temp[i] >= 10 && i != firstFuncIdx)
                    q.add(i);
            }
            if(list.stream().mapToInt(Integer::intValue).sum()==progresses.length)
                check=false;
        }
        int[] answer=new int[list.size()];
        for(int i=0;i<answer.length;i++)
            answer[i]=list.get(i);

        return answer;
    }

    public static int[] solution2(int[] progresses, int[] speeds) {
        int[] temp=new int[progresses.length];
        Queue<Integer> q=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        int progIdx=0, count=0, prevFunc=0;

        for(int i=0;i<progresses.length;i++)
            q.add(i);

        while(!q.isEmpty()){
            count=0;
            for(int i=0;i<progresses.length;i++)
                progresses[i]=progresses[i]+speeds[i];

            System.out.println(q);
            progIdx=q.poll();
            //temp[progIdx]=progresses[progIdx]+speeds[progIdx];

            if(progIdx==prevFunc&&progresses[progIdx]>=100){
                count++;
                while(!q.isEmpty()&&temp[q.poll()]>=100)
                    count++;
                list.add(count);
                prevFunc+=count;
            }
            else
                q.add(progIdx);
        }
        int[] answer=new int[list.size()];
        for(int i=0;i<answer.length;i++)
            answer[i]=list.get(i);

        return answer;
    }
    public static int[] solution3(int[] progresses, int[] speeds) {
        Queue<Integer> q=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        int count=0, prevFunc=0;
        int tmp=0;
        int len=0;
        for(int p:progresses) {
            q.add(p);
        }
        while(!q.isEmpty()){
            count=0;
            len=q.size();
            for(int i=0;i<len;i++){
                q.add(q.poll()+speeds[prevFunc+i]);
            }
            System.out.println(q);
            if(!q.isEmpty()&&q.peek()>=100){
                while(!q.isEmpty()&&q.peek()>=100){
                    q.poll();
                    count++;
                }
                prevFunc+=count;
                list.add(count);
            }
        }
        int[] answer=new int[list.size()];
        for(int i=0;i<answer.length;i++)
            answer[i]=list.get(i);

        return answer;
    }


    public static void main(String[] args) {
        int[] progresses={95,90,99,99,80,99};
        int[] speeds={1,1,1,1,1,1};
        int[] answer=solution3(progresses,speeds);
        for(int a:answer)
            System.out.println(a);
    }
}
