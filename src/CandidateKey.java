import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CandidateKey {
    static int answer = 0;

    public static int solution(String[][] relation) {
        boolean[] check=new boolean[relation[0].length];  // 속성의 길이 (PK 제외하기 위해)
        int cnt=0;
        for(int i=1;i<=relation[0].length;i++){
            List<List<String>> list=new ArrayList<>();
            subset(relation, list, 0, i, check);
            System.out.println(list);
            for(boolean c:check) {
                if (c)
                    cnt++;
            }
            if(answer>cnt)
                break;
        }
        System.out.println(answer);
        return answer;
    }

    public static void subset(String[][] relation, List<List<String>> list, int start, int r, boolean[] check){

        if(list.size()==relation.length&&list.get(0).size()==r) {
            answer++;
            if(r==1)
               check[start-1]=true;  // PK
            return;
        }

        for(int i=start;i<relation[0].length;i++){
            if(check[i])  // PK 확인
                continue;
            for(int j=0;j<relation.length;j++){
                if(r==1){
                    List<String> temp=new ArrayList<>();
                    temp.add(relation[j][i]);
                    if(!list.contains(temp))
                        list.add(temp);
                }
                else {
                    if (i == start) {
                        List<String> temp = new ArrayList<>();
                        temp.add(relation[j][i]);
                        list.add(temp);
                    } else if (list.get(j).size() == r - 1) {  // 오류
                        if (!list.contains(list.get(j))) {
                            list.get(j).add(relation[j][i]);
                        }
                    } else
                        list.get(j).add(relation[j][i]);
                }
            }
            subset(relation, list, i+1, r, check);
        }
    }
    public static void main(String[] args) {
        String[][] relation={{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        solution(relation);
    }
}
