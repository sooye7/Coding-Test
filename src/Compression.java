import java.util.ArrayList;
import java.util.List;

public class Compression {
    public static int[] solution(String msg) {
        int[] answer=new int[msg.length()];
        List<String> list=new ArrayList<>();
        // list에 알파벳 추가
        for(int i=0;i<26;i++)
            list.add(Character.toString('A'+i));
        System.out.println(list);
        for(int i=0;i<msg.length()-1;i++){
            int index=i;
            for(int j=i;j<index;j++);
            if(list.contains(msg.substring(i,i+1))){
                index++;
                while(list.contains(msg.substring(i,index)))
                    index++;
                answer[i]=list.indexOf(msg.substring(i,index-1))+1;
                list.add(msg.substring(i,index));
            }
        }
        answer[msg.length()-1]=list.indexOf(msg.substring(msg.length()-1))+1;

        for(int i:answer)
            System.out.println(i);
        return answer;
    }

    public static int[] solution2(String msg) {

        List<String> list=new ArrayList<>();
        List<Integer> ansList=new ArrayList<>();
        // list에 알파벳 추가
        for(int i=0;i<26;i++)
            list.add(Character.toString('A'+i));
        //System.out.println(list);
        int headIdx=0, endIdx=1;
        while(headIdx<msg.length()-1){
            headIdx=endIdx-1;
            if(headIdx>=msg.length()-1)
                break;
            while(list.contains(msg.substring(headIdx,endIdx))){
                endIdx++;
                if(endIdx>msg.length())
                    break;
            }
            if(endIdx>msg.length()) {
                ansList.add(list.indexOf(msg.substring(headIdx))+1);
                list.add(msg.substring(headIdx));
            }
            else{
                ansList.add(list.indexOf(msg.substring(headIdx,endIdx-1))+1);
                list.add(msg.substring(headIdx,endIdx));
            }
            System.out.println(list);
        }
        if(endIdx==msg.length())
            ansList.add(list.indexOf(msg.substring(msg.length()-1))+1);
        //System.out.println(ansList);
        int[] answer=new int[ansList.size()];
        for(int i=0;i<answer.length;i++)
            answer[i]=ansList.get(i);
        return answer;
    }

    public static void main(String[] args) {
        String msg=	"TOBEORNOTTOBEORTOBEORNOT";
        solution2(msg);
    }
}
