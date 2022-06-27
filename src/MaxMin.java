public class MaxMin {
    public static String solution(String s) {
        String answer = "";
        String[] arr={};

        if(s.contains("-")){
            arr=s.split("-");
            System.out.println(arr[0]);
            int min=Integer.parseInt(arr[0]);
            int max=Integer.parseInt(arr[0]);
            for(String num:arr){
                max=Math.max(max,Integer.parseInt(num));
                min=Math.min(min,Integer.parseInt(num));
            }
            answer="-"+max+"-"+min;
        }
        else{
            arr=s.split(" ");
            int min=Integer.parseInt(arr[0]);
            int max=Integer.parseInt(arr[0]);
            for(String num:arr){
                max=Math.max(max,Integer.parseInt(num));
                min=Math.min(min,Integer.parseInt(num));
            }
            answer=""+max+min;
        }
        System.out.println(answer);
        return answer;
    }

    public static String solution2(String s) {
        String answer = "";
        String[] num=s.split(" ");
        int max=Integer.parseInt(num[0]);
        int min=Integer.parseInt(num[0]);
        for(String n:num){
            max=Math.max(max,Integer.parseInt(n));
            min=Math.min(min,Integer.parseInt(n));
        }
        answer=min+" "+max;
        return answer;
    }


    public static void main(String[] args) {
        solution("-1 -2 -3 -4");

    }
}
