import java.util.*;

public class FailureRate {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] arr=new int[N+1];
        Map<Integer,Double> map= new HashMap<>();

        int len=stages.length;
        for(int s:stages)
            if(s!=N+1)
                arr[s]++;

        for(int i=1;i<arr.length;i++){
            if(len==0){
                map.put(i,0.0);
            }
            else{
                map.put(i,(double)arr[i]/len);
                len-=arr[i];
            }
        }
        List<Map.Entry<Integer,Double>> entryList=new LinkedList<>(map.entrySet());  // Collections.sort() 이용 위함

        entryList.sort(new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for(int i=0;i<entryList.size();i++){
            answer[i]=entryList.get(i).getKey();
            System.out.println(answer[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] stages={2, 1, 2, 6, 2, 4, 3, 3};
        int N=5;
        solution(N,stages);
    }
}
