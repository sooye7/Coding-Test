import java.util.Set;
import java.util.HashSet;

class SumOfSequence {
    public int solution(int[] elements) {
        int answer = 0;
        int len=elements.length;
        Set<Integer> set=new HashSet<>();

        for(int i=1;i<=len;i++){
            for(int j=0;j<len;j++){
                int sum=0;
                for(int k=j;k<j+i;k++){
                    sum+=elements[k%len];
                }
                set.add(sum);
            }
        }

        answer=set.size();
        return answer;
    }
}