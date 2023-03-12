import java.util.*;

class MenuRenewal2 {
    static char[] charArr;
    static int max;
    static List<String> list=new ArrayList<>();
    static Map<Integer, Integer> map=new HashMap<>();
    public static String[] solution(String[] orders, int[] course) {
        for(String o:orders){
            for(int c:course){
                charArr=new char[c];
                dfs(orders, o, c, 0, 0);
            }
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        String[] answer=new String[list.size()];
        for(int i=0;i<list.size();i++)
            answer[i]=list.get(i);


        return answer;
    }

    private static void dfs(String[] orders, String o, int c, int r, int depth){

        if(depth==c){
            int count=0;
            for(char ch:charArr)
                System.out.print(ch+" ");
            System.out.println();
            for(String order:orders){
                boolean check=true;
                for(char ca:charArr){
                    if(!order.contains(String.valueOf(ca)))
                        check=false;
                }
                if(check)
                    count++;
            }
            System.out.println("count "+count);
            int temp=map.getOrDefault(c, 0);
            System.out.println("temp "+temp);

            if(count>=2&&temp<count){
                map.put(c,count);
                for(int i=0;i<list.size();i++){
                    if(list.get(i).length()==c){
                        list.remove(list.get(i));
                        i--;
                    }
                }
                Arrays.sort(charArr);
                System.out.println(String.valueOf(charArr));
                if(!list.contains(String.valueOf(charArr)))
                    list.add(String.valueOf(charArr));

            }
            else if(count>=2&&temp==count){
                Arrays.sort(charArr);
                if(!list.contains(String.valueOf(charArr)))
                    list.add(String.valueOf(charArr));
            }
            System.out.println(list);
            return;
        }


        for(int i=r;i<o.length()&&o.length()>=c;i++){
            charArr[depth]=o.charAt(i);
            dfs(orders, o, c, i+1, depth+1);
        }

    }
    public static void main(String[] args) {
        String[] orders={"ABCD", "ABCD", "ABCD"};
        int[] course={2,3,4};

        solution(orders, course);

    }
}