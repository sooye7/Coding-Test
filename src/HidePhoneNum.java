public class HidePhoneNum {
    public static String solution(String phone_number) {
        String answer = "";
        StringBuilder sb=new StringBuilder(phone_number);
        for(int i=0;i<phone_number.length()-4;i++)
            sb.replace(i,i+1,"*");
        answer=sb.toString();

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("01033334444");

    }
}
