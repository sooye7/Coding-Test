public class MinRectangle {

    public int solution(int[][] sizes) {
        int answer = 0;
        int weight=0;
        int height=Math.min(sizes[0][0],sizes[0][1]);

        for(int[] s:sizes){
            weight=Math.max(weight, Math.max(s[0], s[1]));
            height=Math.max(height, Math.min(s[0], s[1]));
        }
        answer=weight*height;
        return answer;
    }
}
