public class Fibonacci {
    public static int solution(int n) {
        return fibonacci2(n);
    }

    public static int fibonacci(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return solution(n-1)+solution(n-2);
    }

    public static int fibonacci2(int n){
       int one=1;
       int two=1;
       int result=-1;
       if(n==1)
           return one;
       else if(n==2)
           return two;
       else{
           for(int i=2;i<n;i++){
               result=(one+two)%1234567;
               one=two;
               two=result;
           }
           return result;
       }
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}
