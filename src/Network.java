import java.util.Queue;
import java.util.LinkedList;

class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i=0 ; i<n ; i++) {
            if (visited[i]) continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int current = queue.poll();
                visited[current] = true;

                for (int j=0 ; j<n ; j++)
                    if (current != j && computers[current][j] == 1 && !visited[j])
                        queue.offer(j);
            }
            answer++;
        }
        return answer;
    }
}