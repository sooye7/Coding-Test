import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {

    // 시간 초과 풀이
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i=0;i<phone_book.length;i++){
            for(int j=i+1;j<phone_book.length;j++){
                if(phone_book[i].length()>phone_book[j].length()){
                    if(phone_book[j].equals(phone_book[i].substring(0,phone_book[j].length()))){
                        answer=false;
                    }
                }
                else{
                    if(phone_book[i].equals(phone_book[j].substring(0,phone_book[i].length()))){
                        answer=false;
                    }
                }
            }
        }

        return answer;
    }

    // 해시
    public static boolean solution2(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map=new HashMap<>();

        for(int i=0;i<phone_book.length;i++){
            map.put(phone_book[i],i);
        }

        for(int i=0;i<phone_book.length;i++)
            for(int j=0;j<phone_book[i].length();j++)
                if(map.containsKey(phone_book[i].substring(0,j)))
                    answer=false;

        return answer;
    }

    public static boolean solution3(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map=new HashMap<>();

        for(int i=0;i<phone_book.length;i++){
            map.put(phone_book[i],i);
        }

        for(int i=0;i<phone_book.length;i++)
            for(int j=0;j<phone_book[i].length();j++)
                if(map.containsKey(phone_book[i].substring(0,j)))
                    answer=false;

        return answer;
    }

    public static void main(String[] args) {

    }
}
