import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortNum {
    public static long solution(long n) {
        long answer = 0;
        char[] chars=String.valueOf(n).toCharArray();
        Arrays.sort(chars);
        StringBuilder sb=new StringBuilder(String.valueOf(chars));
        answer=Long.parseLong(String.valueOf(sb.reverse()));

        return answer;
    }
    public static void main(String[] args) {
        solution(12888920);
    }
}
