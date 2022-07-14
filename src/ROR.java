import java.util.LinkedList;
import java.util.Queue;

class Point2{
    private int x;
    private int y;
    public Point2(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class ROR {
    static int[] xPos={0,1,0,-1};
    static int[] yPos={1,0,-1,0};
    static int answer;

    public static int solution(int[][] maps) {
        // 테두리 0으로
        int[][] mapTmp=new int[maps.length+2][maps[0].length+2];
        for(int i=1;i<mapTmp.length-1;i++){
            for(int j=1;j<mapTmp[i].length-1;j++){
                mapTmp[i][j]=maps[i-1][j-1];
            }
        }
        return  bfs(mapTmp,1 , 1);
    }

    public static int bfs(int[][] maps, int x, int y){
        boolean[][] visited=new boolean[maps.length][maps[0].length];
        visited[x][y]=true;
        Queue<Point2> queue=new LinkedList<>();
        queue.offer(new Point2(x,y));
        int goalX=maps.length-2;
        int goalY=maps[0].length-2;

        // (n, m)에 도달할 수 없는 경우
        if(maps[goalX+xPos[2]][goalY+yPos[2]]==0&&maps[goalX+xPos[3]][goalY+yPos[3]]==0)
            return -1;
        else{
            while(!queue.isEmpty()){
                Point2 p=queue.poll();
                for(int i=0;i<4;i++){
                    // 인접 확인
                    if(maps[p.getX()+xPos[i]][p.getY()+yPos[i]]==1&&!visited[p.getX()+xPos[i]][p.getY()+yPos[i]]){
                        // 도착점에 도달한 경우
                        if(p.getX()+xPos[i]==goalX&&p.getY()+yPos[i]==goalY)
                            return answer;
                        else{
                            visited[p.getX()+xPos[i]][p.getY()+yPos[i]]=true;
                            queue.offer(new Point2(p.getX()+xPos[i],p.getY()+yPos[i]));
                        }
                    }
                }
                answer++;
            }
            return answer;
        }
    }

    public static int bfs2(int[][] maps, int x, int y){
        boolean[][] visited=new boolean[maps.length][maps[0].length];
        visited[x][y]=true;
        Queue<Point2> queue=new LinkedList<>();
        queue.offer(new Point2(x,y));
        int goalX=maps.length-2;
        int goalY=maps[0].length-2;

        // (n, m)에 도달할 수 없는 경우
        if(maps[goalX+xPos[2]][goalY+yPos[2]]==0&&maps[goalX+xPos[3]][goalY+yPos[3]]==0)
            return -1;
        else{
            while(!queue.isEmpty()){
                Point2 p=queue.poll();
                for(int i=0;i<4;i++){
                    // 인접 확인
                    if(maps[p.getX()+xPos[i]][p.getY()+yPos[i]]==1&&!visited[p.getX()+xPos[i]][p.getY()+yPos[i]]){
                        // 도착점에 도달한 경우
                        if(p.getX()+xPos[i]==goalX&&p.getY()+yPos[i]==goalY)
                            return answer;
                        else{
                            visited[p.getX()+xPos[i]][p.getY()+yPos[i]]=true;
                            queue.offer(new Point2(p.getX()+xPos[i],p.getY()+yPos[i]));
                        }
                    }
                }
                answer++;
            }
            return answer;
        }
    }



    public static void main(String[] args) {
        int[][] maps={{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        solution(maps);
    }
}
