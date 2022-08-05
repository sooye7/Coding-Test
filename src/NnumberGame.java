import java.util.LinkedList;
import java.util.Queue;

public class NnumberGame {
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        Queue<Character> queue=new LinkedList<>();
        int num=0;
        StringBuilder sb=new StringBuilder();
        while(queue.size()<t*m){
            String str=Integer.toString(num,n);
            for(int i=0;i<str.length()&&queue.size()<t*m;i++)
                queue.offer(str.charAt(i));
            num++;
        }
        int qLen=queue.size();
        for(int i=1;i<=qLen&&!queue.isEmpty();i++){
            char c=queue.poll();
            if(p%m==0) {
                if (i % m == 0)
                    sb.append(c);
            }
            else {
                    if (i % m == p)
                        sb.append(c);
                }
        }
        answer=String.valueOf(sb).toUpperCase();
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(16,16,2,1));
    }
}
