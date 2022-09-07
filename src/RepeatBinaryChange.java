public class RepeatBinaryChange {
    public static int[] solution(String s) {
        int[] answer = new int[2];
        int count=0;  // 이진 변환의 횟수
        int zeroNum=0;  // 0의 개수
        while(true){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0')
                    zeroNum++;
            }
            // 0 없애기
            s=s.replaceAll("0","");
            s=Integer.toBinaryString(s.length());
            count++;
            if(s.equals("1"))
                break;
        }

        System.out.println(count);
        System.out.println(zeroNum);

        answer[0]=count;
        answer[1]=zeroNum;

        return answer;
    }


    public static void main(String[] args) {
        solution("110010101001");
    }
}
