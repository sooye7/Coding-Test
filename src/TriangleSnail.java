public class TriangleSnail {
    public static int[] solution(int n) {
        // 전체 개수 n(n+1)/2
        int[] answer = new int[n * (n + 1) / 2];
        int[][] arr = new int[n][n];
        int x = -1, y = 0;
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                // 아래쪽 방향
                if (i % 3 == 0) {
                    x++;
                }
                // 오른쪽 방향
                else if (i % 3 == 1) {
                    y++;
                }
                // 대각선 방향
                else {
                    x--;
                    y--;
                }
                arr[x][y] = num;
                num++;
            }
        }
        int idx = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
                if (arr[i][j] != 0) {
                    answer[idx] = arr[i][j];
                    idx++;
                }
            }
            System.out.println();
         }

        return answer;
    }
    public static void main(String[] args) {
        int[] answer=solution(4);
        for(int a:answer)
            System.out.println(a);
    }
}
