public class Friends4Block {
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        // char 배열로 변경
        char[][] charArr=new char[m][n];
        boolean[][] check=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                charArr[i][j]=board[i].charAt(j);
            }
        }

        while(true){
            if(!findBlock(m,n, charArr, check))
                break;
            downBlock(m,n,charArr,check);
        }
        answer+=countCheck(check);
        return answer;
    }

    // 2x2 만족 블록 찾기
    private static boolean findBlock(int m, int n, char[][] charArr, boolean[][] check){
        boolean findState=false;
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
                if(charArr[i][j]!='0'&&charArr[i][j]==charArr[i+1][j]&&charArr[i][j]==charArr[i][j+1]&&charArr[i][j]==charArr[i+1][j+1]){
                    check[i][j]=true;
                    check[i+1][j]=true;
                    check[i][j+1]=true;
                    check[i+1][j+1]=true;
                    findState=true;
                }
            }
        }
        replaceToZero(m,n,check,charArr);
        return findState;
    }

    // '0' 처리
    private static void replaceToZero(int m, int n, boolean[][] check, char[][] charArr){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(check[i][j])
                    charArr[i][j]='0';
            }
        }
    }

    // 블록 아래로 내리기
    private static void downBlock(int m, int n, char[][] charArr, boolean[][] check){
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(charArr[i][j]=='0'){
                    int k=i;
                    while(k>0&&charArr[k][j]=='0')
                        k--;
                    if(k>=0&&charArr[k][j]!='0'){
                        charArr[i][j]=charArr[k][j];
                        charArr[k][j]='0';
                        check[i][j]=check[k][j];
                        check[k][j]=true;
                    }
                }
            }
        }

    }

    // 제거된 블록의 수 세기
    private static int countCheck(boolean[][] check){
        int count=0;
        for(boolean[] checkArr:check)
            for(boolean c:checkArr)
                if(c)
                    count++;
        return count;
    }

    public static void main(String[] args) {
        String[] board={"CCBDE", "AAADE", "AAABF", "CCBBF"};
        solution(4,5,board);


    }
}
