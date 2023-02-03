class GoingToSchool {
    static int[][] dp;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dp=new int[n][m];
        dp[0][0]=1;
        for(int i=0;i<puddles.length;i++){  // 웅덩이 표시
            dp[puddles[i][1]-1][puddles[i][0]-1]=-1;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]==-1)
                    continue;
                int dist=dp[i][j];
                // 현재 점에서 왼쪽이 웅덩이가 아닌 경우
                if(j!=0&&dp[i][j-1]!=-1)
                    dist+=dp[i][j-1];
                // 현재 점에서 위쪽이 웅덩이가 아닌 경우
                if(i!=0&&dp[i-1][j]!=-1)
                    dist+=dp[i-1][j];
                dp[i][j]=dist%1000000007;
            }
        }

        answer=dp[n-1][m-1];
        return answer;
    }
}