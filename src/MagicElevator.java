class MagicElevator {
    public static int solution(int storey) {
        int answer = 0;
        String str=String.valueOf(storey);
        char[] chars=str.toCharArray();

        for(int i=chars.length-1;i>1;i--){
            int c=0; //carry
            if(chars[i]-'0'>5){
                answer+=10-(chars[i]-'0');
                c=1;
            }
            else{
                answer+=(chars[i]-'0');
            }
            if(chars[i-1]-'0'==9){
                c=1;
            }
            else{
                chars[i-1]=(char)((chars[i-1]-'0')+c);
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(95));
    }
}