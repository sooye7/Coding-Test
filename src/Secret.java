public class Secret {
    public static String solution(String s, String skip, int index) {
        StringBuilder sb=new StringBuilder();
        char[] chars=s.toCharArray();

        for(char c:chars){
            int count=0;
            char tmp=c;
            for(int i=1;i<=index;i++){
                tmp=(char)(tmp+1);
                if(!Character.isAlphabetic(tmp))
                    tmp='a';
                if(skip.contains(String.valueOf(tmp)))
                    i--;
            }
            sb.append(tmp);
        }

        return String.valueOf(sb);
    }
    public static void main(String[] args) {
        String s="aukks";
        String skip="wbqd";
        int index=5;
        System.out.println(solution(s,skip,index));
    }
}
