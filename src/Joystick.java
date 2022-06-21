import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Joystick {
    // 40점 풀이
    public static int solution(String name) {
        int answer = 0;
        int cnt=0,reverseCnt=0;
        List<String> list=new ArrayList<>(Arrays.asList(new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}));
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<name.length();i++){
            sb1.append("A");
            sb2.append("A");
        }

        while(!sb1.toString().equals(name)&&!sb2.toString().equals(name)){
            // 오른쪽으로 이동
            for(int i=0;i<name.length();i++){
                if(list.indexOf(name.substring(i,i+1))+1>list.size()/2)
                    cnt+=list.size()-list.indexOf(name.substring(i,i+1));  // 아래로 이동
                else
                    cnt+=list.indexOf(name.substring(i,i+1));  // 위로 이동
                if(!(i==name.length()-1&&name.charAt(i)=='A'))
                    cnt++;  // 다음 알파벳으로 이동
                sb1.setCharAt(i,name.charAt(i));
            }
            // 왼쪽으로 이동
            if(list.indexOf(name.substring(0,1))+1>list.size()/2)
                reverseCnt=list.size()-list.indexOf(name.substring(0,1));  // 아래로 이동
            else
                reverseCnt=list.indexOf(name.substring(0,1));  // 위로 이동
            sb2.setCharAt(0,name.charAt(0));
            for(int i=name.length()-1;i>0;i--){
                if(list.indexOf(name.substring(i,i+1))+1>list.size()/2)
                    reverseCnt+=list.size()-list.indexOf(name.substring(i,i+1));  // 아래로 이동
                else
                    reverseCnt+=list.indexOf(name.substring(i,i+1));  // 위로 이동
                if(!(i==1&&name.charAt(i)=='A'))
                    reverseCnt++;  // 다음 알파벳으로 이동
                sb2.setCharAt(i,name.charAt(i));
            }
        }
        answer=Math.min(cnt,reverseCnt);
        return answer;
    }

    // 알파벳 개수 26개
    public static int solution2(String name) {
        int answer = 0;
        int move = name.length() - 1; // 오른쪽으로 쭉 간 횟수

        for(int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A')); //상,하 알파벳 맞추기
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int endA = i + 1;
                while(endA < name.length() && name.charAt(endA) == 'A')
                    endA++;
                move = Math.min(move, i * 2 + (name.length() - endA));// 오른쪽으로 갔다 다시 왼쪽으로 (오른쪽으로 갔다가 왼쪽으로 가야하므로 처음부터 A를 만날 때까지 i의 2배 + 마지막 A와 끝까지 길이)
                move = Math.min(move, i + (name.length() - endA) * 2);// 왼쪽으로 갔다 다시 오른쪽으로
            }
        }
        return answer + move;
    }



    public static void main(String[] args) {
        String name="JEROEN";
        int answer=solution(name);
        System.out.println(answer);
        solution2("J");
    }
}
