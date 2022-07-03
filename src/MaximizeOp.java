import java.util.ArrayList;
import java.util.List;

public class MaximizeOp {
    static String[] op={"+","*","-"};
    //static List<String> opPerm=new ArrayList<>();  // 연산자 순열
    static String[] opPerm={"+*-","+-*","-+*","-*+","*-+","*+-"};
    static boolean[] visited=new boolean[3];

    public static long solution(String expression) {
        long answer = 0;
        List<Long> num=new ArrayList<>();
        List<String> opList=new ArrayList<>();
        long max=0;

        // 1. 연산자 순열
//        for(int i=0;i<op.length;i++){
//            dfs(op, i,"");
//        }

        // 1. expression을 숫자와 연산자 list로 분리
        for(int i=0;i<expression.length();i++){
            // 연산자 list
            if(!Character.isDigit(expression.charAt(i)))
                opList.add(expression.substring(i,i+1));
        }
        // 숫자 list
        expression = expression.replaceAll("\\*", " ");
        expression = expression.replaceAll("-", " ");
        expression = expression.replaceAll("\\+", " ");
        String[] temp=expression.split(" ");
        for(String t:temp)
            num.add(Long.parseLong(t));

        // 3. 최대값 구하기
        for(String opStr:opPerm){
            List<Long> numTmp=new ArrayList<>(num);
            List<String> opTmp=new ArrayList<>(opList);
            for(int i=0;i<opStr.length();i++){
                if(opTmp.contains(opStr.substring(i,i+1))){
                    while(opTmp.contains(opStr.substring(i,i+1))){
                        int index=opTmp.indexOf(opStr.substring(i,i+1));
                        long result=calculate(numTmp.get(index),numTmp.get(index+1),opStr.substring(i,i+1));
                        numTmp.remove(index);
                        numTmp.remove(index);
                        opTmp.remove(index);
                        numTmp.add(index,result);
                    }
                }
            }

            max=Math.max(max,Math.abs(numTmp.get(0)));
        }
        answer=max;
        System.out.println(max);
        return answer;
    }

    public static long calculate(long a, long b, String op){
        if(op.equals("*"))
            return a*b;
        else if(op.equals("-"))
            return a-b;
        else if(op.equals("+"))
            return a+b;
        else
            return 0;
    }

    public static void dfs(String[] op, int startOp, String orderOp){
        visited[startOp]=true;
        if (orderOp.length()==3) {
            //opPerm.add(orderOp);
        }

        for(int i=0;i<op.length;i++){
            if(!visited[i]){
                orderOp+=op[i];
                System.out.println(orderOp);
                dfs(op,startOp,orderOp);
                visited[i]=false;
            }
        }
    }
    public static void main(String[] args) {
        String expression="100-200*300-500+20";
        solution(expression);

    }
}
