public class JumpAndTeleport {
    public int solution(int n) {
        int ans = 0;
        while(n>0){
            if(n%2!=0){
                ans++;
                n--;
            }
            n/=2;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
