public class ExpressionOfNumbers {
    public static int solution(int n) {
        int answer = 0;
        for(int i=1;i<=n/2;i++){
            int sum=0;
            for(int j=i;j<=n/2+1;j++){
                sum+=j;
                if(sum==n){
                    answer++;
                    break;
                }
                else if(sum>n)
                    break;
            }
        }
        answer++;  // 자기 자신
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}
