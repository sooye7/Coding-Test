import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Queue;

class DefenceGame {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int m = n;
        int c = k;
        for (int i = 0; i < enemy.length; i++) {
            m -= enemy[i];
            pq.offer(enemy[i]);

            if (m < 0) {
                if (c > 0 && !pq.isEmpty()) {
                    m += pq.poll();
                    c--;
                } else {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }
}