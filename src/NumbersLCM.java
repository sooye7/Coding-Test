import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NumbersLCM {
    public static int solution(int[] arr) {
        int answer = 1;
        // 소수와 소수 개수 따로 HashMap에 저장
        Map<Integer,Integer> map=new HashMap<>();  // 소수, 소수 개수

        // 1~num 까지 소수인지 판별해서 소수라면 while %==0 일 동안 나눠지는 수 개수 구해서 map에 있는 개수랑 비교하여 MAX 값을 hashmap에 넣기
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=arr[i];j++){
                int num=arr[i];
                if(isPrime(j)&&arr[i]%j==0){
                    int count=0;
                    while(num%j==0){
                        count++;
                        num/=j;
                    }
                    map.put(j,Math.max(count,map.getOrDefault(j,0)));
                }
            }
        }
        System.out.println(map);
        Iterator<Integer> it=map.keySet().iterator();
        while(it.hasNext()){
            int key=it.next();
            answer*=Math.pow(key,map.get(key));
        }
        //System.out.println(answer);
        return answer;
    }

    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n % 2 == 0)
            return n == 2;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr={2,6,8,14};
        solution(arr);

    }
}
