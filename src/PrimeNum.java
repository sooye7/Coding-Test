import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PrimeNum {
    static boolean[] visited=new boolean[7];  // numbers의 몇 번째 인덱스 방문했는지 체크
    static Set<Integer> set=new HashSet<>();

    public static int solution(String numbers) {
        int answer = 0;
        for(int i=0;i<numbers.length();i++){
            dfs(numbers,"",i+1);
        }
        answer=set.size();

        return answer;
    }

    // numbers로 만들 수 있는 모든 숫자 조합
    static void dfs(String str, String temp, int m){
        if(temp.length()==m){
            int num=Integer.parseInt(temp);
            if(isPrime(num))
                set.add(num);
        }
        for(int i=0;i<str.length();i++){
            if(!visited[i]){
                visited[i]=true;
                temp+=str.charAt(i);
                dfs(str, temp, m);
                visited[i]=false;  // 백트래킹 (다음 i로 넘어가기 전에 현재 i의 방문 여부를 false로 바꿔줌)
                temp=temp.substring(0, temp.length()-1);
            }
        }
    }

    // 소수인지 판별
    static boolean isPrime(int n){
        if(n==0) return false;
        if(n==1) return false;
        for(int i=2;i*i<=n;i++)
            if(n%i==0) return false;
        return true;
    }

    public static void main(String[] args) {

    }

}
