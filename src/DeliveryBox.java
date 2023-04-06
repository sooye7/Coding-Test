import java.util.Deque;
import java.util.ArrayDeque;

class DeliveryBox {
    public int solution(int[] order) {
        int answer = 0;
        Deque<Integer> st=new ArrayDeque<>();
        int num=0;
        for(int i=0;i<order.length;i++){
            if(st.isEmpty()){
                while(num<order[i]){
                    num++;
                    st.offerLast(num);

                }

            }

            while(st.peekLast()<order[i]){
                num++;
                st.offerLast(num);
            }

            if(st.peekLast()==order[i]){
                st.pollLast();
                answer++;
            }

            else if(st.peekLast()>order[i])
                break;


        }


        return answer;
    }
}