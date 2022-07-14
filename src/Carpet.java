public class Carpet {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int height=0;
        int width=0;
        for(int i=1;i<=yellow;i++){
            if(yellow%i==0){
                height=Math.min(yellow/i,i);
                width=Math.max(yellow/i,i);
                if(height+width<=(brown-4)/2)
                    break;
            }
        }
        answer[0]=width+2;
        answer[1]=height+2;

        for(int a:answer)
            System.out.println(a);

        return answer;
    }

    public static void main(String[] args) {
        solution(24,24);

    }
}
