import java.util.Stack;

public class MakeBigNum {
    static int max;

    public static String solution(String number, int k) {
        String answer = "";
        for(int i=0;i<number.length();i++) {
            boolean[] visited=new boolean[number.length()];
            dfs(i, number, k, visited, "");
        }
        answer=String.valueOf(max);
        System.out.println(answer);
        return answer;
    }


    // 시간 초과 발생
    public static void dfs(int v,String number, int k, boolean[] visited, String str){
        //visited[v]=true;
        //str+=number.substring(v,v+1);
        if(str.length()==number.length()-k){
            max=Math.max(max,Integer.parseInt(str));
            System.out.println(Integer.parseInt(str));
        }
        else if(number.substring(v).length()+str.length()>=number.length()-k){
            for(int i=v;i<number.length();i++){
                if(!visited[i]){
                    visited[i]=true;
                    str+=number.substring(i,i+1);
                    System.out.println(str);
                    dfs(v,number,k,visited,str);
                    visited[i]=false;

                }
            }
        }
    }

    public static String solution2(String number, int k) {
        StringBuilder sb=new StringBuilder();
        String answer = "";
        int index=0;
        for(int i=0;i<number.length()-k;i++){
            int max=0;
            for(int j=index;j<=k+i;j++){
                if(max<number.charAt(j)-'0'){
                    max=number.charAt(j)-'0';
                    index=j+1;
                }
            }
            sb.append(max);
        }
        answer=sb.toString();
        return answer;
    }

    public String solution3(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        solution("1924",2);

    }


}
