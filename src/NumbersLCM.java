public class NumbersLCM {
    public static int solution(int[] arr) {
        int answer = 1;
        int[] num=new int[100];
        for(int i=0;i<arr.length;i++){
            int number=arr[i];
            int count=0;
            System.out.println(number);
            for(int j=2;j<=number;j++){
                if(number%j==0){
                    System.out.println(number+"%"+j);
                    while(number%j==0&&number>1){
                        count++;
                        number/=j;
                        System.out.println(number);
                    }

                }
                num[j]=Math.max(count,num[j]);
                System.out.println(j+"num"+num[j]);
                if(number==1)
                    break;
            }
        }
        for(int n:num){
            if(n!=0){
                answer*=n;
            }
        }
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        int[] arr={2,6,8,14};
        solution(arr);

    }
}
