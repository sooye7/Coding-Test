import java.util.Queue;
import java.util.LinkedList;

class PickItem {
    int[][] map=new int[101][101];
    boolean[][] visited=new boolean[101][101];
    int[] x={1, 0, -1, 0};
    int[] y={0, 1, 0, -1};
    int answer;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int i=0;i<rectangle.length;i++){
            int x1=rectangle[i][0]*2;
            int y1=rectangle[i][1]*2;
            int x2=rectangle[i][2]*2;
            int y2=rectangle[i][3]*2;
            for(int k=x1;k<=x2;k++){
                for(int j=y1;j<=y2;j++){
                    if(k==x1||k==x2||j==y1||j==y2){  // 테두리
                        if(map[k][j]!=2)
                            map[k][j]=1;
                    }
                    else  // 내부
                        map[k][j]=2;
                }
            }



        }
        bfs(characterX*2, characterY*2, itemX*2, itemY*2);

        return answer/2;
    }

    private void bfs(int characterX, int characterY, int itemX, int itemY){
        Queue<Point6> q=new LinkedList<>();
        q.offer(new Point6(characterX, characterY, 0));
        visited[characterX][characterY]=true;

        while(!q.isEmpty()){
            Point6 p=q.poll();
            if(p.px==itemX&&p.py==itemY){
                answer=p.cost;
                break;
            }
            for(int i=0;i<4;i++){
                int nx=p.px+x[i];
                int ny=p.py+y[i];

                if(nx>=map.length||nx<0||ny>=map[0].length||ny<0)
                    continue;

                if(!visited[nx][ny]&&map[nx][ny]==1){
                    visited[nx][ny]=true;
                    q.offer(new Point6(nx, ny, p.cost+1));
                }
            }
        }

    }
}

class Point6{
    int px;
    int py;
    int cost;

    public Point6(int px, int py, int cost){
        this.px=px;
        this.py=py;
        this.cost=cost;
    }
}