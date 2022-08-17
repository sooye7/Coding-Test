public class JadenCaseString {
    public static String solution(String s) {
        String answer = "";
        int head=0, charIndex=0;
        StringBuilder sb=new StringBuilder(" "+s);

        while(true){
            if(sb.indexOf(" ")==-1)
                break;
            charIndex=sb.substring(head).indexOf(" ")+1;
            if(Character.isAlphabetic(sb.charAt(charIndex)))
                sb.setCharAt(charIndex,Character.toUpperCase(sb.charAt(charIndex)));

            head=charIndex;
        }
        System.out.println(sb);

        return answer;
    }

    public static String solution2(String s) {
        String answer="";

        String[] str=s.split(" ");

        for(String st:str){
            if(st.isEmpty()) {
                answer+=" ";
                continue;
            }
            StringBuilder sb=new StringBuilder(st.toLowerCase());
            if(Character.isAlphabetic(sb.charAt(0)))
                sb.setCharAt(0,Character.toUpperCase(sb.charAt(0)));
            answer+=String.valueOf(sb)+" ";
        }
        if(s.charAt(s.length()-1)!=' ')
            answer=answer.substring(0,answer.length()-1);
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        String s="3people unFollowed me";
        solution2(s);

    }
}
