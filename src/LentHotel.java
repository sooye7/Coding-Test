import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class LentHotel {
    public int solution(String[][] book_time) {
        int answer = 0;
        List<Time> list=new ArrayList<>();
        // 종료시간 기준 정렬
        Arrays.sort(book_time, new Comparator<String[]>(){
            @Override
            public int compare(String[] s1, String[] s2){
                return s1[1].compareTo(s2[1]);
            }
        });

        for(int i=0;i<book_time.length;i++){
            String[] start=book_time[i][0].split(":");
            int startH=Integer.parseInt(start[0]);
            int startM=Integer.parseInt(start[1]);
            String[] end=book_time[i][1].split(":");
            int endH=Integer.parseInt(end[0]);
            int endM=Integer.parseInt(end[1]);
            //System.out.println(list);
            if(list.isEmpty()){
                if(endM+10>=60)
                    list.add(new Time((endH+1)%24, (endM+10)%60));
                else
                    list.add(new Time(endM, endM+10));
            }
            else{
                Collections.sort(list, new Comparator<Time>(){
                    @Override
                    public int compare(Time o1, Time o2){
                        if(o1.hour==o2.hour)
                            return o1.minute-o2.minute;
                        return o1.hour-o2.hour;
                    }
                });
                boolean check=false;
                for(int j=0;j<list.size();j++){
                    if(startH>list.get(j).hour||
                            startH==list.get(j).hour&&startM>=list.get(j).minute){
                        // 종료 시간 교체
                        if(endM+10>=60)
                            list.set(j,new Time((endH+1)%24, (endM+10)%60));
                        else
                            list.set(j,new Time(endM, endM+10));
                        check=true;
                        break;
                    }
                    if(!check){
                        if(endM+10>=60)
                            list.add(new Time((endH+1)%24, (endM+10)%60));
                        else
                            list.add(new Time(endM, endM+10));
                    }
                }
            }
        }

        answer=list.size();
        return answer;
    }
}

class Time{
    int hour;
    int minute;

    public Time(int hour, int minute){
        this.hour=hour;
        this.minute=minute;
    }

    @Override
    public String toString(){
        return hour+":"+minute;
    }
}