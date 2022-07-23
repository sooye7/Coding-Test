import java.util.ArrayList;
import java.util.List;

public class WordChainGame {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] turn=new int[n];
        List<String> list=new ArrayList<>();
        int idx=0;
        for(int i=0;i<words.length;i++){
            turn[i%n]++;
            // 이어지는지 체크
            // 중복 확인
            if((i>0&&words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0))||list.contains(words[i])) {
                idx=i%n;
                break;
            }
            else
                list.add(words[i]);
        }
        if(list.size()!=words.length) {
            answer[0]=idx+1;
            answer[1]=turn[idx];
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] words={"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        int n=5;
        solution(n, words);
    }
}
