public class ListOfMatches {
    public static int solution(int n, int a, int b) {
        int answer = 1;
        int mid=n/2;

        while(true){
            answer++;
            // mid를 중심으로 왼쪽 오른쪽 각각 다른 영역에 있는 경우
            if(a<=mid&&b>mid||a>mid&&b<=mid){
                n/=2;
                if(n==2)
                    break;
            }
            // mid를 중심으로 같은 영역에 있는 경우
            else{
                if(Math.abs(a-b)==1){
                    answer=1;
                    break;
                }
                // 왼쪽
                else if(a<=mid&&b<=mid){
                    mid/=2;
                }
                // 오른쪽
                else if(a>mid&&b>mid){
                    mid+=mid/2;
                }
            }
        }
        return answer;
    }

    public static int solution2(int n, int a, int b) {
        int answer = 0;
        while(true){
            a=a/2+a%2;
            b=b/2+b%2;
            answer++;
            if(a==b)
                break;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution2(8,4,7));

    }
}
