import java.util.Arrays;
import java.util.Comparator;

public class MultipleMin {
    public int solution(int []A, int []B) {
        int answer=0;
        int len=A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<len;i++){
            answer+=A[i]*B[len-1-i];
        }

        return answer;
    }
    public static void main(String[] args) {

    }
}
