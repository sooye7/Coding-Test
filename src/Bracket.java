import java.util.ArrayDeque;
import java.util.Deque;

public class Bracket {
    public static String solution(String p) {
        String answer = "";
        answer+=recursion(p);
        return answer;
    }

    public static String recursion(String p){
        Deque<String> stack=new ArrayDeque<>();
        int index=0;
        String answer="";
        if(p.equals(""))
            return "";

        // 1. u, v로 쪼개기 (균형잡힌 괄호 -> '('의 수와 ')'의 수가 일치하는 시점에서 끊음)
        for(int i=0;i<p.length();i++){
            if(stack.isEmpty())
                stack.offer(p.substring(i,i+1));
            else{
                if(stack.peekLast().equals(p.substring(i,i+1)))
                    stack.add(p.substring(i,i+1));
                else{
                    stack.poll();
                    if(stack.isEmpty()){
                        index=i;
                        break;
                    }
                }
            }
        }

        String u=p.substring(0,index+1);
        String v=p.substring(index+1);


        // 2. 올바른 괄호 문자열 여부
        if(u.charAt(0)==')'){  // 올바르지 않은 문자열
            StringBuilder sb=new StringBuilder(u.substring(1,u.length()-1));
            for(int i=0;i<sb.length();i++){
                if(sb.substring(i,i+1).equals("("))
                    sb.replace(i,i+1,")");
                else
                    sb.replace(i,i+1,"(");
            }

            u=sb.toString();
            return  "("+recursion(v)+")"+u;
        }
        else{  // 올바른 문자열
            return  u+recursion(v);
        }
    }

    public static void main(String[] args) {
        String p="))()((";
        solution(p);

    }
}
