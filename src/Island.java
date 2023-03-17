import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Island {
    static int[] x={1,0,-1,0};
    static int[] y={0,1,0,-1};
    static boolean[][] visited;
    static List<Integer> list=new ArrayList<>();
    public static int[] solution(String[] maps) {
        int[] answer;
        char[][] map=new char[maps.length][maps[0].length()];
        visited=new boolean[map.length][map[0].length];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                map[i][j]=maps[i].charAt(j);
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }


        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(!visited[i][j]&&map[i][j]!='X')
                    bfs(i, j, map);
            }
        }

        Collections.sort(list);
        if(list.size()==0){
            answer=new int[1];
            answer[0]=-1;
        }
        else{
            answer = new int[list.size()];
            for(int i=0;i<list.size();i++)
                answer[i]=list.get(i);
        }
        return answer;
    }

    private static void bfs(int nx, int ny, char[][] map){
        Queue<Point11> q=new LinkedList<>();
        visited[nx][ny]=true;
        q.offer(new Point11((int)map[nx][ny]-'0', nx, ny));
        int sum=0;
        while(!q.isEmpty()){
            Point11 p=q.poll();
            sum+=p.n;
            System.out.println(q);
            for(int i=0;i<4;i++){
                int px=x[i]+p.px;
                int py=y[i]+p.py;
                if(px>=map.length||px<0||py>=map[0].length||py<0)
                    continue;
                else{
                    if(!visited[px][py]&&map[px][py]!='X'){
                        visited[px][py]=true;
                        q.offer(new Point11((int)map[px][py]-'0', px, py));
                        //sum+=(int)map[nx][ny]-'0';
                    }
                }
            }
        }
        if(sum!=0)
            list.add(sum);
    }


    public static void main(String[] args) {
        String[] maps={"X591X","X1X5X","X231X", "1XXX1"};
        solution(maps);
    }
}

class Point11{
    int n;
    int px;
    int py;
    public Point11(int n, int px, int py){
        this.n=n;
        this.px=px;
        this.py=py;
    }

    @Override
    public String toString(){
        return n+" "+px+" "+py;
    }
}