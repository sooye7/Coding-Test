import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class MenuRenewal2 {
    static char[] charArr;
    static List<String> list=new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        for(int c:course){
            charArr=new char[c];
            dfs(orders, c, 0, 0);
        }

        return answer;
    }

    private void dfs(String[] orders, int c, int r, int depth){

        if(depth==c){
            int count=0;
            for(String order:orders){
                boolean check=true;
                for(char ca:charArr){
                    if(!order.contains(String.valueOf(ca)))
                        check=false;
                }
                if(check)
                    count++;
            }
            if(count>=2){
                Arrays.sort(charArr);
                list.add(String.valueOf(charArr));
            }
        }


        for(String order:orders){
            for(int i=r;i<order.length()&&order.length()>=c;i++){
                charArr[depth]=order.charAt(i);
                dfs(orders, c, i+1, depth+1);
            }
        }
    }
}