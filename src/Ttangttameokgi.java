import java.util.*;

public class Ttangttameokgi {
    public static int solution(int[][] land) {
        int answer = 0;
        int prev=0;  // 이전 열 저장
        for(int i=0;i<land.length;i++){
            int max=0;
            int maxCol=0;
            System.out.println(i+" i");
            for(int j=0;j<land[i].length;j++){
                System.out.println(prev);
                if(prev==j)
                    continue;
                if(max<=land[i][j]){
                    max=land[i][j];
                    maxCol=j;
                }
            }
            prev=maxCol;
            answer+=max;
        }

        return answer;
    }
    public static int solution2(int[][] land) {
        int answer = 0;
        int prev=-1;  // 이전 열 저장
        int max=0;
        //int[] arr=new int[land.length*land[0].length];
        List<Integer> list=new ArrayList<>();
        int index=0;
        // 1차원 배열로 변경
        for(int[] tmp:land){
            for(int t:tmp){
                //arr[index++]=t;
                list.add(t);
            }
        }
        // 최댓값 찾기 (다음 요소와 이전 인덱스 차이가 4이상이면 Ok, 그렇지 않으면 값을 0으로 변경하고 건너뛰기)
//        for(int i=0;i<land.length;i++){
//            if(prev==-1){
//                max=Collections.max(list);
//                answer+=max;
//                prev=list.indexOf(max);
//            }
//            else{
//                max=Collections.max(list);
//            }
//        }
        return answer;
    }

    // DP (동적계획법)
    public static int solution3(int[][] land) {
        int answer = 0;
        for(int i=1;i<land.length;i++){
            land[i][0]+=Math.max(land[i-1][1],Math.max(land[i-1][2],land[i-1][3]));
            land[i][1]+=Math.max(land[i-1][0],Math.max(land[i-1][2],land[i-1][3]));
            land[i][2]+=Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][3]));
            land[i][3]+=Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][2]));
        }
        for(int i=0;i<4;i++){
            answer=Math.max(answer,land[land.length-1][i]);
        }

        return answer;
    }
    public static void main(String[] args) {
        int[][] land={{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        solution(land);

    }
}
