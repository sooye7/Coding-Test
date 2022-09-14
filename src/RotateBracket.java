import java.util.*;

public class RotateBracket {
    public static int solution(String s) {
        int answer = 0;
        // 문자열 문자 -> Queue에
        Queue<Character> queue=new LinkedList<>();
        for(int i=0;i<s.length();i++)
            queue.offer(s.charAt(i));
        for(int i=0;i<queue.size();i++){
            System.out.println(queue);
            if(isCorrect2(queue))
                answer++;
            char c=queue.poll();
            queue.offer(c);

        }
        System.out.println(answer);

        return answer;
    }

    // 올바른 괄호인지 확인
    private static boolean isCorrect(Queue<Character> queue){
        List<Character> list=new ArrayList<>();
        Queue<Character> temp=new LinkedList<>();
        for(char c:queue)
            temp.offer(c);
        boolean check=true;
        for(int i=0;i<temp.size();i++){
            char c=temp.poll();
            temp.offer(c);
            if(c==']'){
                if(!list.contains('[')){
                    check=false;
                    break;
                }
                else
                    list.remove((Character)'[');
            }
            else if(c==')'){
                if(!list.contains('(')){
                    check=false;
                    break;
                }
                else
                    list.remove((Character)'(');
            }
            else if(c=='}'){
                if(!list.contains('{')) {
                    check = false;
                    break;
                }
                else
                    list.remove((Character)'{');
            }
            else{
                list.add(c);
            }
        }

        if(!list.isEmpty())
            check=false;
        return check;
    }

    private static boolean isCorrect2(Queue<Character> queue){
        List<Character> list=new ArrayList<>();
        Deque<Character> deque=new ArrayDeque<>();
        Queue<Character> temp=new LinkedList<>();
        for(char c:queue)
            temp.offer(c);
        boolean check=true;
        for(int i=0;i<temp.size();i++){
            char c=temp.poll();
            temp.offer(c);
            if(c=='('||c=='['||c=='{'){
                deque.offer(c);
            }
            else {
                if(c==')'){
                    if(!deque.isEmpty()&&deque.peekLast()=='(')
                        deque.pollLast();
                    else{
                        check=false;
                        break;
                    }
                }
                else if(c==']'){
                    if(!deque.isEmpty()&&deque.peekLast()=='[')
                        deque.pollLast();
                    else{
                        check=false;
                        break;
                    }
                }
                else if(c=='}'){
                    if(!deque.isEmpty()&&deque.peekLast()=='{')
                        deque.pollLast();
                    else{
                        check=false;
                        break;
                    }
                }

            }

        }
        if(!deque.isEmpty())
            check=false;
        return check;
    }


    public static void main(String[] args) {
        solution("}]()[{");

    }
}
