import java.util.*;

class Pair{
    private int location;
    private int priority;

    public Pair(int location, int priority){
       this.location=location;
       this.priority=priority;
    }

    public int getLocation(){return location;}
    public int getPriority(){return priority;}

}

public class Printer {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pair> q=new LinkedList<>();
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<priorities.length;i++) {
            q.offer(new Pair(i,priorities[i]));
            list.add(priorities[i]);
        }

        while(!q.isEmpty()){
            int maxPriority = Collections.max(list);
            Pair qp=q.poll();
            if(qp.getPriority()==maxPriority) {
                answer++;
                list.remove(Integer.valueOf(maxPriority));
               if(qp.getLocation()==location){
                   break;
               }
            }
            else
                q.offer(qp);
        }
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        int[] priorities={1, 1, 9, 1, 1, 1};
        int location=0;
        solution(priorities,location);

    }
}
