import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line {
    private static int[] answer;
    private static boolean[] visited;

    public static int[] solution(int n, long k) {
        answer=new int[n];
        visited=new boolean[n];
        dfs(n,k,0);
        for(int a:answer)
            System.out.println(a);
        return answer;
    }
    private static void dfs(int n, long k, int depth){
        if(depth==n){
            System.out.println(Arrays.toString(answer));
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                answer[depth]=i+1;
                dfs(n,k,depth+1);
                visited[i]=false;
            }
        }
    }

    public int[] solution2(int n, long k){
        int[] answer=new int[n];
        List<Integer> numbers=new ArrayList<>();
        long factorial=1;
        int index=0;

        for(int i=1;i<=n;i++){
            factorial*=i;
            numbers.add(i);
        }

        k--;
        while(n>0){
            factorial/=n;
            int value=(int)(k/factorial);
            answer[index++]=numbers.get(value);
            numbers.remove(value);

            k%=factorial;
            n--;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n=3;
        long k=5;
        solution(n,k);
    }
}
