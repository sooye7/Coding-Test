import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

class CCTV {
    public static int solution(int[][] routes) {
        int answer = 0;
        Set<Integer> set=new HashSet<>();

        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0]==o2[0])
                    return o2[1]-o1[1];
                return o1[0]-o2[0];
            }
        });
        int in=routes[0][0];  // 진입
        int out=routes[0][1];  // 진출
        set.add(out);
        for(int[] r:routes){
            if(r[0]>out){
                out=r[1];
                set.add(out);
            }
            in=r[0];
        }
        System.out.println(set);
        answer=set.size();
        return answer;
    }

    public static void main(String[] args) {
        int[][] routes={{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        solution(routes);
    }
}