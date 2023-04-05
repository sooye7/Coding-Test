import java.util.List;
import java.util.ArrayList;

class Minerals {
    static int[][] fatigue={{1,1,1},{5,1,1},{25,5,1}};
    static int[] arr;
    static boolean[] visited;
    static int answer=Integer.MAX_VALUE;
    static List<Integer> pickList=new ArrayList<>();
    public int solution(int[] picks, String[] minerals) {
        int num=0;

        for(int p:picks){
            for(int i=0;i<p;i++){
                pickList.add(num);
            }
            num++;
        }

        arr=new int[pickList.size()];
        visited=new boolean[pickList.size()];

        dfs(0, minerals);

        return answer;
    }

    private void dfs(int depth, String[] minerals){

        if(depth==pickList.size()){
            int total=0;
            int count=0;
            int n=0;
            for(int k=0;k<minerals.length;k++){
                int index=0;
                if(minerals[k].equals("diamond"))
                    index=0;
                else if(minerals[k].equals("iron"))
                    index=1;
                else
                    index=2;
                total+=fatigue[arr[n]][index];
                System.out.println("f"+fatigue[arr[n]][index]);
                System.out.println(total);
                count++;
                if(count>5){
                    n++;
                    count=0;
                }
            }
            answer=Math.min(total, answer);
            //System.out.println(answer);
            return;
        }

        for(int i=0;i<pickList.size();i++){
            if(!visited[i]){
                visited[i]=true;
                arr[depth]=pickList.get(i);
                dfs(depth+1, minerals);
                visited[i]=false;
            }
        }
    }
}