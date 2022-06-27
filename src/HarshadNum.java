public class HarshadNum {
    public boolean solution(int x) {
        boolean answer = true;
        int value=x;
        int sum=0;

        while(value!=0){
            sum+=value%10;
            value/=10;
        }
        if(x%sum==0) answer=true;
        else answer=false;

        return answer;
    }

    public static void main(String[] args) {

    }
}
