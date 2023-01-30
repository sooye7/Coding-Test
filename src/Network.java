import java.util.Queue;
import java.util.LinkedList;

class Network{
    boolean[][] visited;
    int[] x={1, 0, -1, 0};
    int[] y={0, 1, 0, -1};
    int answer;
    public int solution(int n, int[][] computers) {
        visited=new boolean[n][n];
        for(int i=0;i<n;i++)
            bfs(n,i,i,computers);

        return answer;
    }

    private void bfs(int n, int nx, int ny, int[][] computers){
        Queue<Point> q=new LinkedList<>();
        q.offer(new Point(nx, ny));
        int count=0;
        if(!visited[nx][ny])
            count++;
        while(!q.isEmpty()){
            Point p=q.poll();

            for(int i=0;i<4;i++){
                int mx=p.px+x[i];
                int my=p.py+y[i];

                if(mx>=n||mx<0||my>=n||my<0)
                    continue;
                else{
                    if(computers[mx][my]==1&&!visited[mx][my]){
                        visited[mx][my]=true;
                        q.offer(new Point(mx, my));
                        count++;
                    }
                }
            }
        }
        if(count!=0)
            answer++;

    }
}

class Point{
    int px;
    int py;

    public Point(int px, int py){
        this.px=px;
        this.py=py;
    }
}