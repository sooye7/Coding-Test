import java.util.Queue;
import java.util.LinkedList;

class MinDist {
    int[] x = {0, 1, 0, -1};
    int[] y = {-1, 0, 1, 0};
    boolean[][] visited;
    int answer;
    public int solution(int[][] maps) {
        visited=new boolean[maps.length][maps[0].length];

        return bfs(maps);
    }


    private int bfs(int[][] maps){
        Queue<Point5> q=new LinkedList<>();
        q.offer(new Point5(0,0,1));
        visited[0][0]=true;

        while(!q.isEmpty()){
            Point5 p=q.poll();
            if(p.px==maps.length-1&&p.py==maps[0].length-1){
                return p.dist;
            }
            for(int i=0;i<4;i++){
                int mx=p.px+x[i];
                int my=p.py+y[i];
                if(mx>=maps.length||mx<0||my>=maps[0].length||my<0)
                    continue;
                else{
                    if(maps[mx][my]==1&&!visited[mx][my]){
                        visited[mx][my]=true;
                        q.offer(new Point5(mx, my, p.dist+1));
                    }
                }
            }
        }
        return -1;
    }
}

class Point5{
    int px;
    int py;
    int dist;

    public Point5(int px, int py, int dist){
        this.px=px;
        this.py=py;
        this.dist=dist;
    }
}