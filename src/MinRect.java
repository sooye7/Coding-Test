import java.util.Arrays;
import java.util.Comparator;

public class MinRect {
    public static int solution(int[][] sizes) {
        int answer = 0;
        int maxWeight=0;
        int maxHeight=0;

        for(int[] s:sizes) {
            Arrays.sort(s);
            if(maxWeight<s[0])
                maxWeight=s[0];
            if(maxHeight<s[1])
                maxHeight=s[1];
        }

        answer=maxHeight*maxWeight;
        return answer;
    }

    public static int solution2(int[][] sizes) {
        int length = 0, height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr={{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(arr));
    }
}
