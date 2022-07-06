import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortNum {
    // 정수 내림차순 배치
    public static long solution(long n) {
        long answer = 0;
        char[] chars=String.valueOf(n).toCharArray();
        Arrays.sort(chars);
        StringBuilder sb=new StringBuilder(String.valueOf(chars));
        answer=Long.parseLong(String.valueOf(sb.reverse()));

        return answer;
    }

    // 자연수 뒤집어 배열로
    public static int[] solution2(long n) {
        char[] chars=String.valueOf(n).toCharArray();
        int[] answer = new int[chars.length];
        StringBuilder sb=new StringBuilder(String.valueOf(chars));
        sb.reverse();
        for(int i=0;i<answer.length;i++){
            answer[i]=Integer.parseInt(String.valueOf(sb.charAt(i)));
        }

        return answer;
    }
    public static void main(String[] args) {
        solution(12888920);
    }
}
