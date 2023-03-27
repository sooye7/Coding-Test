import java.util.LinkedList;
import java.util.Queue;

public class TransformingNumber {

    public int solution(int x, int y, int n) {
        int answer = -1;
        Queue<Number> q=new LinkedList<>();
        q.offer(new Number(x, 0));
        while(!q.isEmpty()){
            Number tmp=q.poll();
            if(tmp.num==y){
                return answer;
            }
            if(tmp.num>y){
                continue;
            }
            q.offer(new Number(tmp.num+n, tmp.count+1));
            q.offer(new Number(tmp.num*2, tmp.count+1));
            q.offer(new Number(tmp.num*3, tmp.count+1));
        }


        return answer;
    }
}

class Number{
    int num;
    int count;

    public Number(int num, int count){
        this.num=num;
        this.count=count;
    }
}
