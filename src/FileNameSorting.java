import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class FileName implements Comparable<FileName>{
    String head;
    String number;
    String tail;

    public FileName(String head, String number, String tail){
        this.head=head;
        this.number=number;
        this.tail=tail;
    }

    @Override
    public String toString(){
        return head+number+tail;
    }

    @Override
    public int compareTo(FileName o) {
        if(head.equalsIgnoreCase(o.head))
            return Integer.parseInt(number, 10)-Integer.parseInt(o.number, 10);
        return head.toLowerCase().compareTo(o.head.toLowerCase());
    }
}

public class FileNameSorting {
    public static String[] solution(String[] files) {
        String[] answer = {};
        PriorityQueue<FileName> pq=new PriorityQueue<>();

        for(int i=0;i< files.length;i++){
            int index1=0, index2=0;
            for(int j=0;j<files[i].length();j++){
                if(Character.isDigit(files[i].charAt(j))){
                    index1=j;
                    break;
                }
            }
            String head=files[i].substring(0, index1);
            index2=index1;
            while(Character.isDigit(files[i].charAt(index2))){
                index2++;
                if(index2>=files[i].length())
                    break;
            }
            String number=files[i].substring(index1,index2);
            String tail="";
            if(index2<files[i].length())
                tail=files[i].substring(index2);

            System.out.println(head+" "+number+" "+tail);

            pq.offer(new FileName(head, number, tail));

            System.out.println(pq);
        }
        System.out.println(pq);
        return answer;
    }

    public static String[] solution2(String[] files) {
        String[] answer = new String[files.length];
        FileName[] fn=new FileName[files.length];
        for(int i=0;i<files.length;i++){
            int index1=0, index2=0;
            // head, name, tail 쪼개기
            for(int j=0;j<files[i].length();j++){
                if(Character.isDigit(files[i].charAt(j))){
                    index1=j;
                    break;
                }
            }
            String head=files[i].substring(0, index1);
            index2=index1;
            while(Character.isDigit(files[i].charAt(index2))){
                index2++;
                if(index2>=files[i].length())
                    break;
            }
            String number=files[i].substring(index1,index2);
            String tail="";
            if(index2<files[i].length())
                tail=files[i].substring(index2);
            fn[i]=new FileName(head, number, tail);
        }
        Arrays.sort(fn, new Comparator<FileName>() {
            @Override
            public int compare(FileName o1, FileName o2) {
                if(o1.head.equalsIgnoreCase(o2.head))
                    return Integer.parseInt(o1.number, 10)-Integer.parseInt(o2.number, 10);
                return o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
            }
        });
        for(int i=0;i< answer.length;i++){
            answer[i]=fn[i].toString();
        }
        return answer;
    }


    public static void main(String[] args) {
        String[] files={"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        solution(files);

    }
}
