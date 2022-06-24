public class MatrixRotate {
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr=new int[rows][columns];
        int num=1;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=num;
                num++;
            }
        }
        int k=0;
        // 행렬 회전
        for (int[] query : queries) {
            int x1 = query[0]-1;
            int x2 = query[2]-1;
            int y1 = query[1]-1;
            int y2 = query[3]-1;

            int temp=arr[x1][y1];
            int minNum=temp;
            // 왼쪽 세로
            for(int i=x1+1;i<=x2;i++) {
                arr[i - 1][y1] = arr[i][y1];
                minNum=Math.min(arr[i - 1][y1],minNum);
            }
            // 아래 가로
            for(int i=y1+1;i<=y2;i++) {
                arr[x2][i - 1] = arr[x2][i];
                minNum=Math.min(arr[x2][i - 1],minNum);
            }
            // 오른쪽 세로
            for(int i=x2;i>x1;i--) {
                arr[i][y2] = arr[i - 1][y2];
                minNum=Math.min(arr[i][y2],minNum);
            }
            // 위 가로
            for(int i=y2;i>y1;i--) {
                arr[x1][i] = arr[x1][i - 1];
                minNum=Math.min(arr[x1][i],minNum);
            }
            arr[x1][y1+1]=temp;

            answer[k]=minNum;
            k++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] queries={{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        solution(6,6,queries);

    }
}
