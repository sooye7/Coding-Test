public class NextBigNum {
    public static int solution(int n) {
        int answer = 0;
        // 1. n을 2진수로 변경
        String binaryN=Integer.toString(n,2);
        // 2. 1의 개수 세기
        int count=countOneNum(binaryN);
        System.out.println(count);
        // 3. 다음 큰 수 구하기
        int num=n+1;
        while(count!=countOneNum(Integer.toString(num++,2)));
        answer=num-1;
        return answer;
    }

    private static int countOneNum(String bin){
        //bin=bin.replaceAll("0","");
        int count=0;
        for(int i=0;i<bin.length();i++)
            if(bin.charAt(i)=='1')
                count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(78));
    }
}
