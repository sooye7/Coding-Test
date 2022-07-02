import java.util.LinkedList;
import java.util.Queue;

class Position{
    private int x;
    private int y;

    public Position(int x, int y){
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

public class Distance {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0;i<places.length;i++){
            String[] temp=places[i];
            int result=1;
            boolean check=true;
            for(int x=0;x<5&&check;x++){
                for(int y=0;y<5&&check;y++){
                    if(temp[x].charAt(y)=='P'){
                        if(bfs(x,y,temp)==0){
                           result=0;
                            check=false;
                        }

                    }
                }
            }
            answer[i]=result;
        }
        return answer;
    }



    static int moveX[] = {-1,0,1,0};
    static int moveY[] = {0,1,0,-1};

    private static int bfs(int x, int y,String[] place){
    Queue<Position> q=new LinkedList<>();

    q.add(new Position(x,y));

    while(!q.isEmpty()){
        Position temp=q.poll();
        for(int i=0;i<4;i++){
            int nextX=temp.getX()+moveY[i];
            int nextY=temp.getY()+moveX[i];

            if(nextY<0||nextX<0||nextY>=5||nextX>=5||(nextY == y && nextX == x))
                continue;
            int dist=Math.abs(nextX-x)+Math.abs(nextY-y);
            if(place[nextX].charAt(nextY)=='P'&&dist<=2)
                return 0;
            else if(place[nextX].charAt(nextY)=='O'&&dist<2)
                q.offer(new Position(nextX,nextY));
        }
    }
        return 1;
}

    public static void main(String[] args) {

    }
}
