public class LongJump {
    public long solution(int n) {
        long answer = 0;
        long[] arr = new long[2001];
        arr[1]=1;
        arr[2]=2;
        for(int i=3;i<arr.length;i++)
            arr[i]=(arr[i-1]+arr[i-2])%1234567;
        answer=arr[n];
        return answer;
    }
    public static void main(String[] args) {

    }

}
