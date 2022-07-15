import java.util.Arrays;

public class HIndex {

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int hIndex=0;
        int index=0;
        for(int i=0;i<=citations[citations.length-1];i++){
            if(citations[index]<i)
                index++;
            if(citations.length-index>=i&&i>=index+1)
                hIndex=Math.max(i,hIndex);
        }
        return hIndex;
    }


    public static void main(String[] args) {
        int[] citations={3, 0, 6, 1, 5};
        solution(citations);
    }

}
