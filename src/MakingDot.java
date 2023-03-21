public class MakingDot {
    public long solution(int k, int d) {
        long answer = 0;
        answer+=(d+1)*2;
        long triangle=(long)Math.sqrt((double)Math.pow(d,2)/2);
        int count=0;
        System.out.println(triangle);
        for(int row=1;row<=triangle;row++){
            for(int col=row;col<=triangle;col++){
                if(row%k!=0||col%k!=0)
                    continue;
                count++;
            }
        }
        answer+=(count*2)-triangle;


        return answer;
    }
    public static void main(String[] args) {

    }
}
