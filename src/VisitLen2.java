import java.util.HashSet;
import java.util.Set;

class MovePosition{
    int x;
    int y;

    public MovePosition(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString(){
        return "("+x+","+y+")";
    }
}

public class VisitLen2 {

    public static int solution(String dirs) {
        int answer = 0;
        MovePosition pos=new MovePosition(0,0);
        Set<String> set=new HashSet<>();
        for(char c:dirs.toCharArray()){
            if(c == 'U' && pos.y < 5) {
                pos.y++;
                String str = pos.x + "," + (pos.y - 0.5); // 이동한 길 저장
                set.add(str);
            } else if(c == 'D' && pos.y > -5) {
                pos.y--;
                String str = pos.x + "," + (pos.y + 0.5);
                set.add(str);
            } else if(c == 'R' && pos.x < 5) {
                pos.x++;
                String str = (pos.x - 0.5) + "," + pos.y;
                set.add(str);
            } else if(c == 'L' && pos.x > -5) {
                pos.x--;
                String str = (pos.x + 0.5) + "," + pos.y;
                set.add(str);
            }
        }
        answer=set.size();
        return answer;
    }
    public static void main(String[] args) {
        String dirs="UDU";
        solution(dirs);
    }
}
