import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Fee{
    public static int basicTime;
    public static int basicFee;
    public static int unitTime;
    public static int unitFee;
}

class ParkingInfo{
    private int inTime;  // 입차 시각
    private int outTime;  // 출차 시각
    private String carNum;  // 차 번호
    private int fee;  // 주차 요금

    public ParkingInfo( String carNum){
        this.carNum=carNum;
    }
    public ParkingInfo(int inTime, String carNum){
        this.inTime=inTime;
        this.carNum=carNum;
    }

    @Override
    public boolean equals(Object o){
        return this.carNum .equals(((ParkingInfo) o).getCarNum());
    }
    @Override
    public String toString(){
        return "["+inTime+", "+outTime+", "+carNum+", "+fee+"]";
    }

    public void setOutTime(int outTime) {
        this.outTime = outTime;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getInTime() {
        return inTime;
    }
    public int getOutTime() {
        return outTime;
    }
    public String getCarNum() {
        return carNum;
    }
}

public class ParkingFee {
    // 시각 -> 분
    private static int timeToMin(String time){
        String[] arr=time.split(":");
        return Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]);
    }

    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Fee.basicFee=fees[0];
        Fee.basicTime=fees[1];
        Fee.unitTime=fees[2];
        Fee.unitFee=fees[3];
        List<ParkingInfo> list = new ArrayList<>();
        for(String r:records){
            System.out.println(list);
            String[] record=r.split(" ");
            if(record[2].equals("IN")){
                list.add(new ParkingInfo(timeToMin(record[0]),record[1]));
            }
            // OUT
            else{
                ParkingInfo pi=new ParkingInfo(record[1]);
                System.out.println(pi);
                if(list.contains(pi)){
                    ParkingInfo tmp=list.get(list.indexOf(pi));
                    tmp.setOutTime(timeToMin(record[0]));
                    list.set(list.indexOf(pi),tmp);
                }
            }
        }
        for(ParkingInfo pi:list){
            if(pi.getOutTime()==0){
                pi.setOutTime(timeToMin("23:59"));
                list.set(list.indexOf(pi),pi);
            }
        }

        // 요금 계산
        for(ParkingInfo pi:list){
            int diff=pi.getOutTime()-pi.getInTime();
            if(diff>Fee.basicTime){
                pi.setFee((int) (Fee.basicFee+Math.ceil((float)(diff-Fee.basicTime)/Fee.unitTime)*Fee.basicFee));
            }
            else{
                pi.setFee(Fee.basicFee);
            }
            list.set(list.indexOf(pi),pi);
        }

        // 차 번호 작은 것부터 정렬
        Collections.sort(list, new Comparator<ParkingInfo>() {
            @Override
            public int compare(ParkingInfo o1, ParkingInfo o2) {
                return Integer.parseInt(o1.getCarNum())-Integer.parseInt(o2.getCarNum());
            }
        });

        System.out.println(list);

        return answer;
    }
    public static void main(String[] args) {
        int[] fees={180, 5000, 10, 600};
        String[] records={"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        solution(fees,records);

    }
}
