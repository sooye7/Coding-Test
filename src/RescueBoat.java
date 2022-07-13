import java.util.*;

public class RescueBoat {
    // 오답 풀이, 시간 초과
    public static int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> peopleList=new ArrayList<>();
        for(int p:people)
            peopleList.add(p);

        // 1. 내림차순 정렬
        peopleList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        // 2. 구명보트의 개수를 최소로 하여 구출
        // 구출한 사람은 -1로 변경
        for(int i=0;i<peopleList.size();i++){
            for(int j=i+1;j<peopleList.size();j++){
                if(peopleList.get(i)!=-1){
                    if(peopleList.get(i)+peopleList.get(j)<=limit) {
                        peopleList.set(j, -1);
                    }
                    peopleList.set(i,-1);
                    answer++;
                    break;
                }
            }
        }
        if(peopleList.get(peopleList.size()-1)!=-1)
            answer++;
        return answer;
    }

    // 오답 풀이, 시간 초과
    public static int solution2(int[] people, int limit) {
        int answer=0;

        // 1. 오름차순 정렬
        Arrays.sort(people);

        // 2. 한 요소 잡고 다른 요소들과 비교할 때 끝에서부터 비교
        // 구출한 사람은 -1로 변경
        for(int i=0;i< people.length-1;i++){
            for(int j=people.length-1;j>i;j--){
                if(people[j]!=-1&&people[i]+people[j]<=limit){
                    people[j]=-1;
                    answer++;
                    break;
                }
                else if(people[i]!=-1&&j==i+1&&people[i]+people[j]>=limit)
                    answer++;
            }
        }
        if(people[people.length-1]!=-1)
            answer++;

        return answer;
    }

    // 정답 풀이
    public static int solution3(int[] people, int limit) {
        int answer=0;

        // 1. 오름차순 정렬 후 Deque에 넣기
        Arrays.sort(people);
        Deque<Integer> deque=new ArrayDeque<>();
        for(int p:people)
            deque.offer(p);

        // 2. deque의 맨앞과 맨뒤를 비교하여 삭제
        while(!deque.isEmpty()){
            int min=deque.getFirst();
            if(deque.size()==1){
                deque.pollLast();
            }
            else{
                if(min+deque.getLast()>limit){
                    deque.pollLast();
                }
                else{
                    deque.pollLast();
                    deque.pollFirst();
                }
            }
            answer++;
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] people={70, 50, 80, 50};
        System.out.println(solution3(people,100));

    }
}
