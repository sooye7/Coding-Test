import java.util.*;

class LentHotel2 {
    public static int solution(String[][] book_time) {
        int answer = 0;
        Queue<Integer> pq=new PriorityQueue<>();

        Arrays.sort(book_time, new Comparator<String[]>(){
            @Override
            public int compare(String[] s1, String[] s2){
                if(s1[0].compareTo(s2[0])==0)
                    return s1[1].compareTo(s2[1]);
                return s1[0].compareTo(s2[0]);
            }
        });

        //pq.offer(afterTenMinute(book_time[0][1]));
        for(int i=0;i<book_time.length;i++){
            //System.out.println(pq);
            int start=toMinute(book_time[i][0]);
            int end=toMinute(book_time[i][1]);
            if(pq.isEmpty()){
                pq.offer(end+10);
                continue;
            }
            if(pq.peek()<=start){
                pq.poll();
                pq.offer(end+10);
            }
            else{
                pq.offer(end+10);
            }
        }
        answer=pq.size();
        return answer;
    }

    private static String afterTenMinute(String end){
        StringBuffer sb=new StringBuffer(end);
        int endH=Integer.parseInt(end.substring(0,2));
        int endM=Integer.parseInt(end.substring(3,5));
        if(endM+10>=60){
            sb.replace(3,5,String.valueOf((endM+10)%60));
            sb.insert(3, "0");
            sb.replace(0,2,String.valueOf((endH+1)%24));
            if((endH+1)%24<10)
                sb.insert(0, "0");
        }
        else{
            sb.replace(3,5,String.valueOf(endM+10));
        }
        return String.valueOf(sb);
    }

    private static int toMinute(String time){
        String[] t=time.split(":");
        return Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
    }

    public static void main(String[] args) {
        String[][] book_time={{"00:00", "00:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        solution(book_time);

        System.out.println("00:59".compareTo("01:09"));
    }
}
