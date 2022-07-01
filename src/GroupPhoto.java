public class GroupPhoto {
    private int answer = 0;
    private String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

    // 완전탐색
    public int solution(int n, String[] data) {
        boolean[] isVisited=new boolean[8];
        dfs("",isVisited,data);
        return answer;
    }

    private void dfs(String names, boolean[] isvisited, String[] data){
        if(names.length()==7){
            if(check(names, data)){
                answer++;
            }
        }
        for(int i=0;i<8;i++){
            if(!isvisited[i]){
                isvisited[i]=true;
                String name=names+friends[i];
                dfs(name, isvisited, data);
                isvisited[i]=false;
            }
        }
    }

    private boolean check(String names, String[] data){
        for(String d:data){
            int pos1=names.indexOf(d.charAt(0));  // 프렌즈 1
            int pos2=names.indexOf(d.charAt(2));  // 프렌즈 2
            char op=d.charAt(3);
            int index=d.charAt(4)-'0';  // 간격
            if(op=='=') {
                if (!(Math.abs(pos1 - pos2) == index + 1)) return false;
            }
            else if(op=='>') {
                if (!(Math.abs(pos1 - pos2) > index + 1)) return false;
            }
            else if(op=='<'){
                if(!(Math.abs(pos1-pos2)<index+1)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
