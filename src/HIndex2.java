import java.util.Arrays;

public class HIndex2 {

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int right=citations.length-1;
        int left=0;
        int h=0;
        while(true){
            h=(right+left)/2;
            if(citations[h]>citations.length-h)
                right=h+1;
            else
                break;
//            else
//                left=h;
        }
        while(true){
            if(citations[h]> citations.length-h)
                break;
            h++;
        }
        h--;
        return citations[h];
    }

    public static void main(String[] args) {
        int[] citations={3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }
}
