import java.util.Deque;
import java.util.LinkedList;

public class DeleteStr {

    // 시간 초과
    public static int solution(String s) {
        int answer = -1;
        StringBuilder sb=new StringBuilder(s);
        boolean check=true;
        while(check){
            for(int i=0;i<sb.length()-1;i++){
                if(sb.isEmpty()){
                    answer=1;
                    check=false;
                }
                else if(sb.charAt(i)==sb.charAt(i+1)){
                    sb.delete(i,i+2);
                    break;
                }
                else if(i==sb.length()-2&&sb.charAt(i)!=sb.charAt(i+1)){
                    answer=0;
                    check=false;
                }
            }
        }
        return answer;
    }

    public static int solution2(String s) {
        int answer = -1;
        Deque<Character> stack=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            System.out.println(stack);
            if(stack.isEmpty())
                stack.addFirst(s.charAt(i));
            else{
                if(stack.peekFirst()==s.charAt(i))
                    stack.pollFirst();
                else
                    stack.addFirst(s.charAt(i));
            }
        }
        if(stack.isEmpty())
            answer=1;
        else
            answer=0;
        System.out.println(answer);
        return answer;
    }


    public static void main(String[] args) {
        String s="cdcd";
        solution2(s);
    }
}
