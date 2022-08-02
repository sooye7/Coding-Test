import java.util.*;

class MovePos{
    int x;
    int y;
    boolean left;
    boolean right;
    boolean up;
    boolean down;
    public MovePos(int x, int y){
        this.x=x;
        this.y=y;
    }

    public MovePos(MovePos movePos){
        this.x=movePos.x;
        this.y=movePos.y;
        if(movePos.right)
            this.left=true;
        if(movePos.left)
            this.right=true;
        if(movePos.up)
            this.down=true;
        if(movePos.down)
            this.up=true;
    }
    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(Object o){
        MovePos mp=(MovePos)o;
        return mp.x==this.x&&mp.y==this.y;
    }

    @Override
    public String toString(){
        return "("+x+", "+y+")";
    }
}

class Move{

    public void moveRight(MovePos pos){
        pos.x++;
    }
    public void moveLeft(MovePos pos){
        pos.x--;
    }
    public void moveUp(MovePos pos){
        pos.y++;
    }
    public void moveDown(MovePos pos){
        pos.y--;
    }

}

public class VisitLen {
    public static int solution(String dirs) {
        int answer = 0;
        char[] chars=dirs.toCharArray();
        MovePos pos=new MovePos(0,0);
        Move move=new Move();
        List<MovePos> list=new ArrayList<>();
        //list.add(new MovePos(pos));
        for(char c:chars){
            MovePos mp =null;
            switch (c){
                case 'L':
                    if(pos.x>-5) {
                        pos.left=true;
                        move.moveLeft(pos);
                        mp=new MovePos(pos);
                        if(!list.contains(mp)||list.contains(mp)&&!mp.right)
                            list.add(mp);
                        System.out.println(mp+" mp "+mp.right+" right");
                    }
                    System.out.println(mp);
                    break;
                case 'R':
                    if(pos.x<5) {
                        pos.right=true;
                        move.moveRight(pos);
                        mp=new MovePos(pos);
                        if(!list.contains(mp)||list.contains(mp)&&!mp.left)
                            list.add(mp);
                    }
                    System.out.println(mp);
                    break;
                case 'U':
                    if(pos.y<5) {
                        pos.up=true;
                        move.moveUp(pos);
                        mp=new MovePos(pos);
                        if(!list.contains(mp)||list.contains(mp)&&!mp.down)
                            list.add(mp);
                    }
                    System.out.println(mp);
                    break;
                case 'D':
                    if(pos.y>-5) {
                        pos.down=true;
                        move.moveDown(pos);
                        mp=new MovePos(pos);
                        if(!list.contains(mp)||list.contains(mp)&&!mp.up)
                            list.add(mp);
                    }
                    System.out.println(mp);
                    break;
            }
        }
        answer=list.size();
        System.out.println(list);
        return answer;
    }


    public static void main(String[] args) {
        String dirs="ULURRDLLU";
        solution(dirs);
    }
}
