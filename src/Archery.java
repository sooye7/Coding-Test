import java.util.ArrayList;
import java.util.List;

public class Archery {
    public static int[] solution(int n, int[] info) {
        int[] answer;
        boolean check=true;
        // info 어피치 점수 계산
        int max=0;
        int plus=0;
        int minIdx=0, min=0, listIdx=0;  // 가장 낮은 점수 많이 맞춘 캐릭터 구하기
        List<int[]> list=new ArrayList<>();
        while(check){
            int apeachScore=0, ryanScore=0;
            int total=n;
            int index=plus;
            int score=0;
            int[] tmp=new int[info.length];
            while(total>0){
                System.out.println(total);
                if(index==info.length-1){
                    if(total>=info[index]+1)
                        tmp[index]=info[index]+1;
                    total-=(info[index]+1);
                    check=false;
                    break;
                }
                if(total-(info[index]+1)<0) {
                    index++;
                    continue;
                }
                else{
                    total-=(info[index]+1);
                    tmp[index]=info[index]+1;
                }
                index++;
            }

            // 라이언과 어피치의 점수 계산
            for(int i=0;i<info.length;i++){
                if(info[i]<tmp[i])
                    ryanScore+=10-i;
                else{
                    if(info[i]!=0)
                        apeachScore+=10-i;
                }
            }

            System.out.println(ryanScore+"ryan");
            System.out.println(apeachScore+"apeach");
            // 두 캐릭터의 점수의 차 비교 후 max 갱신
            if(ryanScore>apeachScore) {
                if(ryanScore-apeachScore>max){
                    max = ryanScore-apeachScore;
                    list.clear();
                    list.add(tmp);
                }
                else if(ryanScore-apeachScore==max)
                    list.add(tmp);
            }
            plus++;
        }
        System.out.println(list);

        if(list.size()==0){
            answer=new int[1];
            answer[0]=-1;
        }
        else{
            answer=new int[info.length];
            for(int j=0;j<list.size();j++){
                for(int i=list.get(j).length-1;i>=0;i--){
                    if(list.get(j)[i]!=0){
                        if(i>minIdx){
                            minIdx=i;
                            min=list.get(j)[i];
                            listIdx=j;
                        }
                        else if(i==minIdx){
                            if(min<list.get(j)[i]) {
                                min = list.get(j)[i];
                                listIdx=j;
                            }
                        }
                    }
                }
            }
            answer=list.get(listIdx);
        }
        for(int a:answer)
            System.out.println(a);
        return answer;
    }
    public static void main(String[] args) {
        int n=9;
        int[] info={0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        solution(n,info);
    }
}
