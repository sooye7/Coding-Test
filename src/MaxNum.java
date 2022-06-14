import java.util.Arrays;
import java.util.Comparator;

public class MaxNum {

    public static String solution(int[] numbers) {
        String answer = "";
        String[] str=new String[numbers.length];

        for(int i=0;i<numbers.length;i++){
            str[i]=Integer.toString(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        for(String s:str)
            answer+=s;

        return answer;
    }
    public static void main(String[] args) {

    }

}
