import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CandidateKey3 {
    public static int solution(String[][] relation){
        List<Integer> candidateKey=new ArrayList<>();

        int rowLen=relation.length;
        int colLen=relation[0].length;

        // 비트마스킹으로 모든 경우의 조합
        /*
        1. 모든 열(속성)의 조합을 구함
        2. 만들어진 조합이 이전에 만들어진 후보키를 포함하는지 확인
            2-1. 포함된다면 다음 조합으로 넘어감
            2-2. 포함되지 않는다면 유일성을 체크하여 후보키 여부 판단
        3. 후보키의 개수 반환
         */
        for(int set=1;set<(1<<colLen);set++){  // 1을 열의 길이만큼 왼쪽 쉬프트 연산을 하면 만들 수 있는 최대 이진수의 다음 수가 나옴
            // 최소성 검사
            if(!isMinimal(set,candidateKey))
                continue;
            // 유일성 검사
            if(isUnique(set,rowLen,colLen,candidateKey,relation))
                candidateKey.add(set);
        }
        return candidateKey.size();
    }

    private static boolean isUnique(int set, int rowLen, int colLen, List<Integer> candidateKey, String[][] relation){
        HashMap<String, String> map=new HashMap<>();

        // 자릿수 구하기
        for(int row=0;row<rowLen;++row){
            String dateByKeySet="";

            for(int th=0;th<colLen;++th){
                // set과 같다면 dateByKeySet에 추가
                if((set&(1<<th))!=0){
                    dateByKeySet+=relation[row][th];
                }
            }
            // 이미 있으면 유일성 깨기
            if(map.containsKey(dateByKeySet))
                return false;
            else
                map.put(dateByKeySet,dateByKeySet);
        }
        return true;
    }

    private static boolean isMinimal(int set, List<Integer> candidateKey){
        // 후보키에 선정된 조합이 있다면 최소성 깨기
        for(int key:candidateKey)
            // 포함관계
            if((key&set)==key)
                return false;
        return true;
    }
    public static void main(String[] args) {
        String[][] relation={{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        solution(relation);
    }
}
