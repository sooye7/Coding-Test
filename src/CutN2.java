public class CutN2 {
    public static int[] solution(int n, long left, long right) {
        int[] answer=new int[(int)(right-left+1)];
        int col=0,row=0;

        for(int i=0;i<answer.length;i++){
            col=(int)((i+left)%n)+1;
            row=(int)((i+left)/n)+1;
            answer[i]=Math.max(row, col);
        }

        return answer;
    }

    public static int[] solution2(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];

        for(int i = 0; i < answer.length; i++){
            int row = (int)((i + left) / n) + 1;
            int col = (int)((i + left) % n) + 1;
            answer[i] = Math.max(row, col);
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(4, 7, 14);

    }
}
