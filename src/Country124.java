public class Country124 {
    public static String solution(int n) {
        String[] number={"4","1","2"};
        String answer = "";
        int num=n;
        while(num>0){
            answer=number[num%3]+answer;
            if(num%3==0)
                num--;
            num=num/3;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6));

    }
}
