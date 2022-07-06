public class IsSqrt {
    public static long solution(long n) {
        long sqrtValue = (long) Math.sqrt(n);

        if((long)Math.pow(sqrtValue,2)!=n)
            return -1;
        else
            return (long) Math.pow(sqrtValue+1,2);
    }

    public static void main(String[] args) {
        solution(3);


    }
}
