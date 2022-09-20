import java.util.ArrayDeque;
import java.util.Deque;

public class RightBracket {
    public static boolean solution(String s) {
        boolean answer = true;
        Deque<Character> deque=new ArrayDeque<>();
        char[] chars=s.toCharArray();
        for(char c:chars){
            if(c=='('){
                deque.offer(c);
            }
            else{
                if(!deque.isEmpty()&&deque.peekLast()=='(')
                    deque.poll();
                else{
                    answer=false;
                    break;
                }
            }
        }
        if(!deque.isEmpty())
            answer=false;
        return answer;
    }
    public static void main(String[] args) {
        String s="(()(";
        System.out.println(solution(s));
    }
}
