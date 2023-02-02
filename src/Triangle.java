class Triangle {
    static int[][] dp;
    public int solution(int[][] triangle) {
        int answer = 0;
        int n=triangle.length;
        dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=triangle[i-1].length;j++){
                dp[i][j]=triangle[i-1][j-1];
            }
        }


        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=Math.max(dp[i][j]+dp[i-1][j-1], dp[i][j]+dp[i-1][j]);
            }
        }

        for(int i=0;i<=n;i++)
            answer=Math.max(answer, dp[n][i]);
        return answer;
    }
}