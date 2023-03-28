import java.util.Arrays;
import java.util.Collections;

class NumberCard {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        Arrays.sort(arrayA);
        int g1=Integer.MAX_VALUE;
        if(arrayA.length==1)
            g1=arrayA[0];
        for(int i=0;i<arrayA.length-1;i++){
            g1=Math.min(g1, gcd(arrayA[i+1], arrayA[i]));
        }
        for(int i=0;i<arrayB.length;i++){
            if(arrayB[i]%g1==0){
                g1=0;
                break;
            }
        }

        Arrays.sort(arrayB);
        int g2=Integer.MAX_VALUE;
        if(arrayB.length==1)
            g2=arrayB[0];
        for(int i=0;i<arrayB.length-1;i++){
            g2=Math.min(g2, gcd(arrayB[i+1], arrayB[i]));
        }
        for(int i=0;i<arrayA.length;i++){
            if(arrayA[i]%g2==0){
                g2=0;
                break;
            }
        }
        answer=Math.max(g1, g2);

        return answer;
    }

    private int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
}