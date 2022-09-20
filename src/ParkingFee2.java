import java.util.*;

class Fee2 {
    public static int basicTime;
    public static int basicFee;
    public static int unitTime;
    public static int unitFee;
}

class ParkingTime2 {
    private String carNum;
    private int inTime;
    private int outTime;
    private int totalTime;
    private boolean outCheck;

    public ParkingTime2(String carNum){
        this.carNum=carNum;
    }

    public ParkingTime2(String carNum, int inTime){
        this.carNum=carNum;
        this.inTime=inTime;
    }

    public void setInTime(int inTime) {
        this.inTime = inTime;
    }

    public void setOutTime(int outTime) {
        this.outTime = outTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public void setOutCheck(boolean outCheck) {
        this.outCheck = outCheck;
    }

    public int getInTime() {
        return inTime;
    }

    public int getOutTime() {
        return outTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public String getCarNum() {
        return carNum;
    }

    public boolean isOutCheck() {
        return outCheck;
    }

    @Override
    public boolean equals(Object o){
        return this.carNum .equals(((ParkingTime2) o).getCarNum());
    }
    @Override
    public String toString(){
        return "["+inTime+", "+outTime+", "+carNum+","+totalTime+"]";
    }
}

class ParkingFee2 {
    // 시각 -> 분
    private static int timeToMin(String time){
        String[] arr=time.split(":");
        return Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]);
    }
    public static int[] solution(int[] fees, String[] records) {
        Fee2.basicTime=fees[0];
        Fee2.basicFee=fees[1];
        Fee2.unitTime=fees[2];
        Fee2.unitFee=fees[3];
        // hashMap에 차 번호, 총시간
        List<ParkingTime2> list=new ArrayList<>();
        for(String record:records){
            String[] r=record.split(" ");
            ParkingTime2 t=new ParkingTime2(r[1]);
            if(r[2].equals("IN")){
                if(list.contains(t)){
                    ParkingTime2 tmp=list.get(list.indexOf(t));
                    tmp.setInTime(timeToMin(r[0]));
                    tmp.setOutCheck(false);
                    list.set(list.indexOf(t),tmp);
                }
                else{
                    t.setInTime(timeToMin(r[0]));
                    t.setOutCheck(false);
                    list.add(t);
                }
            }
            else{
                ParkingTime2 tmp=list.get(list.indexOf(t));
                tmp.setOutTime(timeToMin(r[0]));
                tmp.setTotalTime(tmp.getTotalTime()+tmp.getOutTime()- tmp.getInTime());  // 총 주차 시간 계산
                // 입, 출차 시간 초기화
                tmp.setInTime(0);
                tmp.setOutTime(0);
                tmp.setOutCheck(true);
                list.set(list.indexOf(t), tmp);
            }
            System.out.println(list);
        }
        for(ParkingTime2 t:list){
            if(!t.isOutCheck()){
                ParkingTime2 tmp=list.get(list.indexOf(t));
                tmp.setOutTime(timeToMin("23:59"));
                tmp.setTotalTime(tmp.getTotalTime()+tmp.getOutTime()- t.getInTime());  // 총 주차 시간 계산
                list.set(list.indexOf(t), tmp);
            }
        }

        // 정렬 및 요금 계산
        int[] answer=new int[list.size()];
        Collections.sort(list, new Comparator<ParkingTime2>() {
            @Override
            public int compare(ParkingTime2 o1, ParkingTime2 o2) {
                return Integer.parseInt(o1.getCarNum())-Integer.parseInt(o2.getCarNum());
            }
        });
        for(int i=0;i<answer.length;i++){
            if(list.get(i).getTotalTime()> Fee2.basicTime)
                answer[i]=(int) (Fee2.basicFee+Math.ceil((float)(list.get(i).getTotalTime()- Fee2.basicTime)/ Fee2.unitTime)* Fee2.unitFee);
            else
                answer[i]= Fee2.basicFee;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] fees={1, 461, 1, 10};
        String[] records={"00:00 1234 IN"};
        solution(fees,records);
    }

}

class Solution {

    public int timeToInt(String time) {
        String temp[] = time.split(":");
        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
    }
    public int[] solution(int[] fees, String[] records) {

        TreeMap<String, Integer> map = new TreeMap<>();

        for(String record : records) {
            String temp[] = record.split(" ");
            int time = temp[2].equals("IN") ? -1 : 1;
            time *= timeToInt(temp[0]);
            map.put(temp[1], map.getOrDefault(temp[1], 0) + time);
        }
        int idx = 0, ans[] = new int[map.size()];
        for(int time : map.values()) {
            if(time < 1) time += 1439;
            time -= fees[0];
            int cost = fees[1];
            if(time > 0)
                cost += (time%fees[2] == 0 ? time/fees[2] : time/fees[2]+1)*fees[3];

            ans[idx++] = cost;
        }
        return ans;
    }
}

