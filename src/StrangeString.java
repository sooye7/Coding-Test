
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

    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }
}
