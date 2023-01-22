import java.util.*;

public class DiskController {

    public static int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<DiskTime> pq=new PriorityQueue<>(new Comparator<DiskTime>() {
            @Override
            public int compare(DiskTime o1, DiskTime o2) {
                return DiskTime.totalTime+o1.processTime-o1.requestTime-(DiskTime.totalTime+o2.processTime-o2.requestTime);
            }
        });

        for(int i=0;i<jobs.length;i++){
            pq.offer(new DiskTime(jobs[i][0],jobs[i][1]));
        }

        int totalTmp=0;
        for(DiskTime dt:pq){
            totalTmp+=dt.processTime;
            answer+=totalTmp-dt.requestTime;
        }
//        for(int i=0;i<jobs.length;i++){
//            dt.add(new DiskTime(jobs[i][0],jobs[i][1]));
//
//        }
//        Collections.sort(dt, new Comparator<DiskTime>() {
//            @Override
//            public int compare(DiskTime o1, DiskTime o2) {
//                if(o1.processTime==o2.processTime)
//                    return o1.start-o2.start;
//                return o1.processTime-o2.processTime;
//            }
//        });
//        System.out.println(dt);
//        int total=0;
//        for(DiskTime t:dt){
//            total+=t.processTime;
//            answer+=total-t.start;
//        }
        answer/=3;
        return answer;
    }

    public static void main(String[] args) {
        int[][] jobs={{0,3},{1,9},{2,6}};
        System.out.println(solution(jobs));
    }
}

class DiskTime {
    static int totalTime;
    int requestTime;
    int processTime;

    public DiskTime(int requestTime, int processTime){
        this.requestTime=requestTime;
        this.processTime=processTime;
    }

    @Override
    public String toString(){
        return requestTime+" "+processTime;
    }
}

