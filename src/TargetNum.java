public class TargetNum {
    static int count=0;

    public static int solution(int[] numbers, int target) {
        int answer=0;
        dfs(numbers,0,target,0);
        answer=count;
        return answer;
    }

    public static void dfs(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){ // 마지막 노드 까지 탐색한 경우
            if(target == sum) count++;
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]); // 해당 노드의 값을 더하고 다음 깊이 탐색
            dfs(numbers, depth + 1, target, sum - numbers[depth]); // 해당 노드의 값을 빼고 다음 깊이 탐색
        }
    }

    public static void main(String[] args) {
        int[] numbers={4, 1, 2, 1};
        solution(numbers,4);
    }
}
