import java.util.Queue;
import java.util.LinkedList;

class Volt {
    static int[][] map;
    static int min=Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        map=new int[n+1][n+1];
        for(int i=0;i<wires.length;i++){
            int v1=wires[i][0];
            int v2=wires[i][1];

            map[v1][v2]=1;
            map[v2][v1]=1;
        }

        for(int i=0;i<wires.length;i++){
            int v1=wires[i][0];
            int v2=wires[i][1];

            // 전선 끊기
            map[v1][v2]=0;
            map[v2][v1]=0;

            // bfs
            bfs(n, i+1);

            map[v1][v2]=1;
            map[v2][v1]=1;
        }


        return min;
    }

    private void bfs(int n, int start){
        // 큐
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[n+1];
        int count=0;
        queue.offer(start);
        while(!queue.isEmpty()){
            int q=queue.poll();
            for(int i=1;i<n+1;i++){
                if(map[q][i]==1&&!visited[i]){
                    visited[i]=true;
                    count++;
                    queue.offer(i);
                }
            }
        }
        min=Math.min(min, Math.abs(n-2*count));
    }
}