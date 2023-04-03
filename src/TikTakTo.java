class TikTakTo {
    public int solution(String[] board) {
        int count=0;
        int len=3;
        int oCnt=0, xCnt=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(board[i].charAt(j)=='O')
                    oCnt++;
                else if(board[i].charAt(j)=='X')
                    xCnt++;
            }
        }

        if(oCnt==xCnt||oCnt==xCnt+1);
        else return 0;

        for(int i=0;i<len;i++){
            if(board[i].charAt(0)=='O'&&board[i].charAt(1)=='O'
                    &&board[i].charAt(2)=='O'&&oCnt==xCnt
                    ||board[0].charAt(i)=='O'&&board[1].charAt(i)=='O'
                    &&board[2].charAt(i)=='O'&&oCnt==xCnt
                    ||board[i].charAt(0)=='X'&&board[i].charAt(1)=='X'
                    &&board[i].charAt(2)=='X'&&oCnt!=xCnt
                    ||board[0].charAt(i)=='X'&&board[1].charAt(i)=='X'
                    &&board[2].charAt(i)=='X'&&oCnt!=xCnt)
                return 0;
        }
        if(board[0].charAt(0)=='O'&&board[1].charAt(1)=='O'
                &&board[2].charAt(2)=='O'&&oCnt==xCnt
                ||board[2].charAt(0)=='O'&&board[1].charAt(1)=='O'
                &&board[0].charAt(2)=='O'&&oCnt==xCnt
                ||board[0].charAt(0)=='X'&&board[1].charAt(1)=='X'
                &&board[2].charAt(2)=='X'&&oCnt!=xCnt
                ||board[2].charAt(0)=='X'&&board[1].charAt(1)=='X'
                &&board[0].charAt(2)=='X'&&oCnt!=xCnt)
            return 0;
        return 1;
    }
}