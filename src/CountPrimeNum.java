import java.util.ArrayList;
import java.util.List;

public class CountPrimeNum {
    public static int solution(int n, int k) {
        int answer = 0;
        String nk=Integer.toString(n,k);
        String[] temp=nk.split("0");
        List<String> list=new ArrayList<>();
        for(String t:temp){
            if(!t.equals(""))
                list.add(t);
        }
        for(String str:list){
            long num=Long.parseLong(str);
            System.out.println(num);
            // 소수인지 판별 후 소수이면 answer++;
            if(isPrime(num))
                answer++;
        }
        return answer;
    }
    // 제곱근 이용
    private static boolean isPrime(long n){
        if(n==1)
            return false;
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        solution(437674,3);
    }
}
