import java.util.Set;
import java.util.HashSet;

class TransformingNumber2 {
    public int solution(int x, int y, int n) {
        int answer = 0;

        Set<Integer> hs=new HashSet<>(), next=null;
        int num=x;
        hs.add(num);
        while(!hs.isEmpty()){
            if(hs.contains(y))
                return answer;
            next=new HashSet<>();
            for(int s:hs){
                int n1=s+n;
                int n2=s*2;
                int n3=s*3;
                if(n1<=y)
                    next.add(n1);
                if(n2<=y)
                    next.add(n2);
                if(n3<=y)
                    next.add(n3);
            }
            hs=next;
            answer++;
        }

        return -1;
    }
}