public class Test1 {
    public long solution(long n) {
        long answer = 0;
        long sqrtNum=(long)Math.sqrt(n);
        if(n%sqrtNum!=0)
            answer=-1;
        else
            answer=(long) Math.pow(n+1,2);

        return answer;
    }

    public static String solution(String new_id) {
        StringBuilder sb=new StringBuilder(new_id.toLowerCase());
        for(int i=0;i<sb.length();i++){
            if(Character.isDigit(sb.charAt(i))||Character.isAlphabetic(sb.charAt(i))||sb.charAt(i)=='-'||sb.charAt(i)=='.'||sb.charAt(i)=='_')
                continue;
            else{
                sb.delete(i,i+1);
                i--;
            }
        }
        String str=sb.toString();

        while(str.contains("..")){
            str=str.replaceAll("\\.\\.","\\.");
        }

        if(!str.isEmpty()&&str.length()!=1){
            if(str.charAt(0)=='.')
                str=str.substring(1);
            if(str.charAt(str.length()-1)=='.')
                str=str.substring(0,str.length()-1);
        }
        else if(!str.isEmpty()&&str.length()==1){
            if(str.charAt(0)=='.')
                str="";
        }


        if(str.isEmpty())
            str+="a";

        if(str.length()>=16)
            str=str.substring(0,15);

        if(str.charAt(str.length()-1)=='.')
            str=str.substring(0,str.length()-1);

        if(str.length()<=2)
            while(str.length()<3)
                str=str.concat(str.substring(str.length()-1));

        return str;
    }

    public static void main(String[] args) {
        solution("=.=");

    }

}
