public class TwoNTile {
    private static int comb(int n, int r){
        if(r==0 || r==n)
            return 1;
        else
            return comb(n-1, r-1) + comb(n-1, r);
    }

    private static int fibonacci(int N) {
        if(N == 0 || N == 1) return 1;
        return fibonacci(N - 1) + fibonacci(N - 2);
    }

    public static int solution(int n) {
        int answer = 0;
        for(int i=n;i>=0;i--){
            if(i%2==0){
                answer+=comb(n-i+i/2,n-i);
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static int solution2(int n) {
        int answer = fibonacci(n);
        System.out.println(answer);
        return answer;
    }

    public static int solution3(int n){
        int answer = 0;

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < n; i++) {
            int num = arr[i - 1] + arr[i - 2];
            arr[i] = num % 1000000007;
        }

        return arr[n-1];
    }
    public static void main(String[] args) {
        solution3(4);
    }
}
