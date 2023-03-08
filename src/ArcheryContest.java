public class ArcheryContest {
    static int[] res={-1};
    static int[] lion;
    static int max=-1000;

    public int[] solution(int n, int[] info) {
        lion=new int[11];
        dfs(info, 0, n);
        return res;
    }

    private void dfs(int[] info, int depth, int n){
        if(depth==n){
            int apeachCnt=0;
            int lionCnt=0;
            for(int i=0;i<=10;i++) {
                if(info[i]!=0||lion[i]!=0){
                    if(info[i]<lion[i])
                        lionCnt+=10-i;
                    else
                        apeachCnt+=10-i;
                }
            }
            if(lionCnt>apeachCnt){
                if(lionCnt-apeachCnt>=max){
                    res=lion.clone();
                    max=lionCnt-apeachCnt;
                }
            }
            return;
        }
        for(int i=0;i<=10&&lion[i]<=info[i];i++){
            lion[i]++;
            dfs(info, depth+1, n);
            lion[i]--;
        }

    }
}
