import java.util.List;
import java.util.ArrayList;

class Test {
    static int[] first={1,2,3,4,5};
    static int[] second={2,1,2,3,2,4,2,5};
    static int[] third={3,3,1,1,2,2,4,4,5,5};

    public int[] solution(int[] answers) {
        int[] count=new int[3];

        for(int i=0;i<answers.length;i++){
            if(answers[i]==first[i%first.length])
                count[0]++;
            if(answers[i]==second[i%second.length])
                count[1]++;
            if(answers[i]==third[i%third.length])
                count[2]++;
        }

        int max=Math.max(count[0], Math.max(count[1], count[2]));
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<3;i++){
            if(count[i]==max)
                list.add(i+1);
        }
        int[] answer=new int[list.size()];
        for(int i=0;i<answer.length;i++)
            answer[i]=list.get(i);

        return answer;
    }
}