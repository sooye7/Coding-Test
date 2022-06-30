import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NewsClustering {
    public static int solution(String str1, String str2) {
        int answer = 0;
        Map<String,Integer> map1=new HashMap<>();  //str1 (자른 문자열, 해당 문자열 등장 횟수)
        Map<String,Integer> map2=new HashMap<>();  //str2
        int unionCnt=0;  // 합집합 원소 개수
        int intersectionCnt=0;  // 교집합 원소 개수

        // 모두 대문자로 변경
        str1=str1.toUpperCase();
        str2=str2.toUpperCase();

        // 1. 두 문자열 2개씩 자르기 (같은 문자열은 +1)
        for(int i=0;i<str1.length()-1;i++)
            if(Character.isAlphabetic(str1.charAt(i))&&Character.isAlphabetic(str1.charAt(i+1)))
                map1.put(str1.substring(i,i+2), map1.getOrDefault(str1.substring(i,i+2),0)+1);

        for(int i=0;i<str2.length()-1;i++)
            if(Character.isAlphabetic(str2.charAt(i))&&Character.isAlphabetic(str2.charAt(i+1)))
                map2.put(str2.substring(i,i+2),map2.getOrDefault(str2.substring(i,i+2),0)+1);

        // 2. 교집합/합집합 개수
        if(map1.isEmpty()&&map2.isEmpty())
            answer=65536;
        else{
            Iterator<String> it=map1.keySet().iterator();
            Iterator<String> it2=map2.keySet().iterator();
            while(it.hasNext()){
                String key=it.next();
                if(map2.containsKey(key)){
                    intersectionCnt+=Math.min(map1.get(key),map2.get(key));
                    unionCnt+=Math.max(map1.get(key),map2.get(key));
                }
                else{
                    unionCnt+=map1.get(key);
                }
            }

            while(it2.hasNext()){
                String key=it2.next();
                if(!map1.containsKey(key))
                    unionCnt+=map2.get(key);
            }

            answer= (int) ((double)intersectionCnt/unionCnt*65536);

        }
        return answer;
    }

    public static void main(String[] args) {
        String str1="aaaaaa";
        String str2="aaaaaaaa";
        int answer=solution(str1,str2);
        System.out.println(answer);
    }
}
