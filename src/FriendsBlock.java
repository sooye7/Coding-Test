import java.util.LinkedList;
import java.util.Queue;

class Pos{
    int xPos;
    int yPos;
    public Pos(int xPos, int yPos){
        this.xPos=xPos;
        this.yPos=yPos;
    }
}

public class FriendsBlock {
    static int[] xArr={1, 0, -1, 0};
    static int[] yArr={0, 1, 0, -1};
    static int answer=0;
    static boolean check=true;

    public static int solution(int m, int n, String[] board) {
        //int answer = 0;
        boolean checkFin=true;
        while(checkFin){
            boolean[][] visited=new boolean[board.length][board[0].length()];
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length();j++){
                    bfs(i, j, board, visited);
                }
            }
        }
        return answer;
    }

    private static void bfs(int x, int y, String[] board, boolean[][] visited){
        Queue<Pos> queue=new LinkedList<>();
        if(visited[x][y]) return;
        else{
            queue.offer(new Pos(x,y));
            while(!queue.isEmpty()){
                Pos p=queue.poll();

                for(int i=0;i<4;i++){
                    int nx=p.xPos+xArr[i];
                    int ny=p.yPos+yArr[i];
                    if(!visited[nx][ny]&&nx>0||nx<board[p.xPos].length()||ny>0||ny<board.length&&board[nx].charAt(ny)==board[p.xPos].charAt(p.yPos)){
                        queue.offer(new Pos(nx,ny));
                    }
                }
            }


        }


    }
    public static void main(String[] args) {

    }
}
