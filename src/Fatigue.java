public class Fatigue {
    static int max;

    public static int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited=new boolean[dungeons.length];
        dfs(dungeons,k, visited, 0);
        answer=max;
        return answer;
    }

    public static void dfs(int[][] dungeons, int k, boolean[] visited, int result){
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i]&&k>=dungeons[i][0]){
                visited[i]=true;
                dfs(dungeons, k-dungeons[i][1], visited, result+1);
                visited[i]=false;
            }
        }
        max=Math.max(max, result);
    }

    public static void main(String[] args) {
        int[][] dungeons={{80,20},{50,40},{30,10}};
        System.out.println(solution(80, dungeons));
    }
}
