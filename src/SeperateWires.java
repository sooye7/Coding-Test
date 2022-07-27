import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SeperateWires {
    public static int solution(int n, int[][] wires) {
        int answer = n;
        // 인접 리스트로 wires 표현
        List<Integer>[] list=new List[n+1];
        for(int i=0;i<n+1;i++)
            list[i]=new ArrayList<>();
        for(int[] w:wires){
            list[w[0]].add(w[1]);
            list[w[1]].add(w[0]);
        }

        for(int i=1;i<list.length;i++){
            for(int j=0;j<list[i].size();j++){
                boolean[] visited=new boolean[n+1];
                int v=list[i].get(j);
                visited[v]=true;  // 연결관계 끊기, 방문하지 못하도록
                int count=bfs(i, list, visited);
                int diff=Math.abs(n-2*count);
                answer=Math.min(answer, diff);
            }
        }

        return answer;
    }

    private static int bfs(int v, List<Integer>[] list, boolean[] visited){
        Queue<Integer> queue =new LinkedList<>();
        queue.offer(v);
        visited[v]=true;
        int count=0;
        while(!queue.isEmpty()){
            int temp=queue.poll();
            count++;
            for(int i=0;i<list[temp].size();i++){
                if(!visited[list[temp].get(i)]){
                    visited[list[temp].get(i)]=true;
                    queue.offer(list[temp].get(i));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] wires ={{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(9,wires));
    }

}
