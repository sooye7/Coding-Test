import java.util.Arrays;
import java.util.Comparator;

class ConnectingIsland {
    static int[] parents;
    public static int solution(int n, int[][] costs) {
        // 크루스칼 알고리즘
        int cost=0;
        parents=new int[n];
        for(int i=0;i<n;i++)
            parents[i]=i;
        // costs 비용 기준 오름차순 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
            for(int i=0;i<costs.length;i++){
                int p=costs[i][0];  //parent
                int c=costs[i][1];  //child
                int cnt=costs[i][2];  // cost

                int fromParent=find(p);
                int toParent=find(c);

                if(fromParent==toParent)  // 사이클 형성 여부
                    continue;
                parents[toParent]=fromParent;
                cost+=cnt;
        }

        System.out.println(cost);
        return cost;
    }

    private static int find(int n){
        if(parents[n]==n) return n;
        return parents[n]=find(parents[n]);
    }

    public static void main(String[] args) {
        int n=4;
        int[][] costs={{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        solution(n, costs);
    }
}