import java.util.*;

public class BestAlbum {

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int max=0;
        String mostPlayGenre="";
        int number = 0;
        Map<String,Map<Integer,Integer>> map=new HashMap<>();

        for(int i=0;i<genres.length;i++){
            Map<Integer, Integer> temp=new HashMap<>();
            temp.put(i, plays[i]);
            map.put(genres[i], map.getOrDefault(genres[i], temp));
        }

        return answer;
    }
}
