import java.util.*;

public class Delivery {
    // 다익스트라 알고리즘 (인접행렬)
    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map=new int[N+1][N+1];

        // 인접하지 않은 정점 초기화화
       for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i!=j)
                    map[i][j]=50001;
            }
        }
        // 인접 행렬로 나타내기
        for(int[] r:road) {
            map[r[0]][r[1]] = r[2];
            map[r[1]][r[0]] = r[2];
        }

        int[] dist=new int[N+1];  // 다른 도시까지의 거리
        for(int i=2;i<=N;i++){
            dist[i]=(dist[i]==0)?50001:map[1][i];
        }

        boolean[] visited=new boolean[N+1];
        visited[1]=true;

        for(int i=1;i<=N;i++){
            // dist 중 방문하지 않았고 가장 작은 값을 가지는 인덱스를 찾기
            int minIdx=1;
            int minValue=50001;
            for(int j=2;j<=N;j++){
                // dist[]의 값이 가장 작은 도시의 index 가져오기 - PriorityQueue/인접리스트로 구현하면 더 효율적
                if(!visited[j]&&dist[j]<minValue){
                    minValue=dist[j];
                    minIdx=j;
                }
            }
            visited[minIdx]=true;

            // 거쳐가는 것이 더 빠른지 확인
            for(int j=2;j<=N;j++){
                if(dist[j]>dist[minIdx]+map[minIdx][j]){
                    dist[j]=dist[minIdx]+map[minIdx][j];
                }
            }
        }

        // 결과
        for(int i=1;i<=N;i++){
            if(dist[i]<=K) answer++;
        }

        return answer;
    }

    // 다익스트라 알고리즘 (인접리스트)
    public static int solution2(int N, int[][] road, int K) {
        int answer = 0;

        // 해당 노드까지의 최단 거리를 담을 배열
        int[] dist=new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        // 각 노드의 인접 노드 리스트를 넣을 배열 생성
        List<Edge>[] edges=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            edges[i]=new ArrayList<Edge>();
        }
        // 거리 정보를 넣을 힙 생성
        PriorityQueue<Info> pq=new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.distance-o2.distance;
            }
        });

        for(int i=0;i<road.length;i++){
            for(int j=0;j<3;j++){
                edges[road[i][0]].add(new Edge(road[i][1],road[i][2]));
                edges[road[i][1]].add(new Edge(road[i][0],road[i][2]));
            }
        }

        // 1번 노드부터 시작
        dist[1]=0;
        pq.offer(new Info(1,dist[1]));
        while(!pq.isEmpty()){
            Info info=pq.poll();
            if(info.distance>dist[info.node]) continue;
            for(Edge adj:edges[info.node]){
                if(info.distance+adj.distance<dist[adj.v]){
                    dist[adj.v]=info.distance+adj.distance;
                    pq.offer(new Info(adj.v,dist[adj.v]));
                }
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        int[][] road={{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        solution(5,road,3);
    }
}

class Edge{
    int v;
    int distance;

    public Edge(int v, int distance){
        this.v=v;
        this.distance=distance;

    }
}

class Info{
    int node;
    int distance;
    public Info(int node, int distance){
        this.node=node;
        this.distance=distance;
    }
}