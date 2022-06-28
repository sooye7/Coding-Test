import java.util.Locale;

public class StrangeString {
    public static String solution(String s) {
        String answer = "";
       // StringBuilder sb=new StringBuilder(s);

        String[] str=s.split(" ");

        for(String word:str){
            StringBuilder sb=new StringBuilder(word);
            for(int i=0;i<word.length();i++){
                if(i%2==0)
                    sb.setCharAt(i, Character.toUpperCase(word.charAt(i)));
                else
                    sb.setCharAt(i, Character.toLowerCase(word.charAt(i)));
            }
            answer+=sb.toString()+" ";
        }
        answer=answer.substring(0,answer.length()-1);

        return answer;
    }

    public static String solution2(String s) {
        String answer = "";
        StringBuilder sb=new StringBuilder();
        String[] arr=s.trim().split(" ");
        for(String str:arr){
            String temp=str.trim();
            for(int i=0;i<str.length();i++){
                if(i%2==0)
                    sb.append(str.substring(i,i+1).toUpperCase());
                else
                    sb.append(str.substring(i,i+1).toLowerCase());

            }
            sb.append(" ");
        }

        answer=sb.toString().substring(0,sb.length()-1);

        return answer;
    }

    // 정답 풀이
    public static String solution3(String s) {
        String answer = "";
        int count=0;
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                count=0;
                sb.append(" ");
            }
            else{
                if(count%2==0)
                    sb.append(s.substring(i,i+1).toUpperCase());
                else
                    sb.append(s.substring(i,i+1).toLowerCase());
                count++;
            }
        }
        answer=sb.toString();
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution3("try hello world"));
    }
}
