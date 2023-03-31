import java.util.Queue;
import java.util.LinkedList;

class EscapeMaze {
    static int[] x={1,0,-1,0};
    static int[] y={0,1,0,-1};
    static int startX,startY,leverX, leverY, exitX, exitY;
    static boolean[][] visited;
    static boolean check1, check2;
    static int answer;

    public int solution(String[] maps) {

        char[][] map=new char[maps.length][maps[0].length()];
        visited=new boolean[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                map[i][j]=maps[i].charAt(j);
            }
        }

        // 레버 위치, 도착 위치 찾기
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(map[i][j]=='S'){
                    startX=i;
                    startY=j;
                }
                else if(map[i][j]=='L'){
                    leverX=i;
                    leverY=j;
                }
                else if(map[i][j]=='E'){
                    exitX=i;
                    exitY=j;
                }
            }
        }

        bfs(map);
        if(!check1||!check2)
            answer=-1;
        return answer;
    }

    private void bfs(char[][] map){
        Queue<Point19> q=new LinkedList<>();

        // 시작->레버
        q.offer(new Point19(startX, startY, 0));
        visited[startX][startY]=true;
        System.out.println(q);
        while(!q.isEmpty()){
            //System.out.println(q);
            Point19 p=q.poll();

            if(!check1&&map[p.px][p.py]=='L'){
                answer+=p.cost;
                check1=true;
                visited=new boolean[map.length][map[0].length];
                q.clear();
                q.offer(new Point19(p.px,p.py,0));
                continue;
            }
            else if(check1&&map[p.px][p.py]=='E'){
                answer+=p.cost;
                check2=true;
                break;
            }
            for(int i=0;i<4;i++){
                int nx=p.px+x[i];
                int ny=p.py+y[i];

                if(nx>=map.length||nx<0||ny>=map[0].length||ny<0)
                    continue;
                else{
                    if(map[nx][ny]!='X'&&!visited[nx][ny]){
                        q.offer(new Point19(nx, ny, p.cost+1));
                        visited[nx][ny]=true;
                    }
                }
            }

        }

    }

}

class Point19{
    int px;
    int py;
    int cost;

    public Point19(int px, int py, int cost){
        this.px=px;
        this.py=py;
        this.cost=cost;
    }
    @Override
    public String toString(){
        return px+" "+py+" "+cost;
    }
}