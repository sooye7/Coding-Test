public class BiggestRect {
    public int solution(int [][]board) {
        int answer = 0;
        int height = board.length; // 세로길이
        int width = board[0].length; // 가로길이
        int[][] map = new int[height + 1][width + 1]; // 원본에 0 패딩할 배열

        // 배열 복사
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i + 1][j + 1] = board[i][j];
            }
        }

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (map[i][j] != 0) { // 0이 아닌 경우에 한해서, 최소를 찾는다
                    map[i][j] = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]) + 1;
                    answer = Math.max(answer, map[i][j]); // 최대값 갱신
                }
            }
        }

        return answer * answer;
    }

    public static void main(String[] args) {

    }
}
