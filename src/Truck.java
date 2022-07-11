import java.util.*;

public class Truck {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int timeSec = 0;
        int bridge_total=0;  // 현재 다리에 있는 트럭 전체 무게

        // turck_weights의 길이만큼 돌면서 큐에 삽입과 삭제를 통한 시간 계산
        Queue<Integer> queue=new LinkedList<>();
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<truck_weights.length;i++){
            if(queue.isEmpty()){
                queue.offer(truck_weights[i]);
                timeSec++;
                bridge_total+=truck_weights[i];
                for(int j=0;j<=i;j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                    if(map.get(j)==bridge_length)
                        queue.poll();
                }
            }
            else{
                if(bridge_total+truck_weights[i]<=weight&&queue.size()<bridge_length){
                    queue.offer(truck_weights[i]);
                    bridge_total+=truck_weights[i];
                    timeSec++;
                    for(int j=0;j<=i;j++) {
                        map.put(j, map.getOrDefault(j, 0) + 1);
                        if(map.get(j)==bridge_length)
                            queue.poll();
                    }
                }
                else{
                    timeSec++;
                    for(int j=0;j<i;j++) {
                        map.put(j, map.getOrDefault(j, 0) + 1);
                        if (map.get(j) == bridge_length)
                            queue.poll();
                    }
                    i--;
                }
            }
        }
        while(!queue.isEmpty()){
            timeSec++;
            queue.poll();
        }

        return timeSec;
    }

    public static int solution2(int bridge_length, int weight, int[] truck_weights) {
        int time_sec = 0;
        int bridge_total = 0;  // 현재 다리에 있는 트럭 전체 무게

        // turck_weights의 길이만큼 돌면서 큐에 삽입과 삭제를 통한 시간 계산
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> truck_queue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        for(int t:truck_weights)
            truck_queue.offer(t);

        while(!truck_queue.isEmpty()||!queue.isEmpty()){
            // 다리 건너기 (다리 길이만큼의 시간이 걸림)
            time_sec++;
            if(!queue.isEmpty()){
                int len=list.size();
                for(int i=0;i<len;i++){
                    list.set(i,list.get(i)+1);
                    if(list.get(i)==bridge_length) {
                        bridge_total -= queue.poll();
                    }
                }
            }
            // 조건에 따라 다리(queue)에 트럭 집어 넣기
            if(!truck_queue.isEmpty()&&queue.size()<bridge_length&&bridge_total+truck_queue.peek()<=weight){
                bridge_total+=truck_queue.peek();
                queue.offer(truck_queue.poll());
                list.add(0);
            }
        }

//        // 마지막 트럭
//        while(!queue.isEmpty()){
//            time_sec++;
//            int len=list.size();
//            for(int i=0;i<len;i++){
//                list.set(i,list.get(i)+1);
//                if(list.get(i)==bridge_length) {
//                    bridge_total -= queue.poll();
//                }
//            }
//        }
        return time_sec;

    }
        public static void main(String[] args) {
        int[] truck_weight={7,4,5,6};
        System.out.println(solution2(2, 10, truck_weight));

    }
}
