class Tired {
    static int[] order;
    static boolean[] visited;
    static int max;

    public int solution(int k, int[][] dungeons) {
        order=new int[dungeons.length];
        visited=new boolean[dungeons.length];
        dfs(0, k, dungeons);

        return max;
    }

    private void dfs(int depth, int k, int[][] dungeons){
        if(depth==dungeons.length){
            int count=0;
            for(int i=0;i<order.length;i++){
                if(k>=dungeons[order[i]][0]){
                    k-=dungeons[order[i]][1];
                    count++;
                }
            }
            max=Math.max(count, max);
            return;
        }

        for(int i=0;i<dungeons.length;i++){
            if(!visited[i]){
                visited[i]=true;
                order[depth]=i;
                dfs(depth+1, k, dungeons);
                visited[i]=false;
            }
        }
    }
}
