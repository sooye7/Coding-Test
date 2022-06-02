public class RectangleCnt {
    public long solution(int w, int h) {
        long answer = 0;

        // 일차함수
        for (long i = 1; i < w; i++)
            answer += Math.floor(h * i / (double) w);

        return answer * 2;

    }
}
