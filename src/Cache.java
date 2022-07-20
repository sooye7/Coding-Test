import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cache {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String, Integer> cache=new HashMap<>();

        for(int i=0;i<cities.length;i++){
            if(cache.size()<cacheSize){
                if(cache.containsKey(cities[i])){
                    answer++;
                    cache.remove(cities[i]);
                    if(!cache.isEmpty()){
                        Iterator<String> key=cache.keySet().iterator();
                        // 사용시간 1씩 증가
                        while(!key.hasNext()){
                            String k= key.next();
                            cache.put(k,cache.get(k)+1);
                        }
                    }
                }
                cache.put(cities[i],0);
            }
            else{
                if(cache.containsKey(cities[i])){
                    answer++;
                    cache.remove(cities[i]);
                    if(!cache.isEmpty()){
                        Iterator<String> key=cache.keySet().iterator();
                        // 사용시간 1씩 증가
                        while(!key.hasNext()){
                            String k= key.next();
                            cache.put(k,cache.get(k)+1);
                        }
                    }
                }
                // 페이지 교체
                else{
                    answer+=5;
                    Iterator<String> key=cache.keySet().iterator();
                    cache.remove(key.next());
                    if(!cache.isEmpty()){
                        Iterator<String> key2=cache.keySet().iterator();
                        // 사용시간 1씩 증가
                        while(!key2.hasNext()){
                            String k= key2.next();
                            cache.put(k,cache.get(k)+1);
                        }
                    }
                    cache.put(cities[i],0);
                }
            }
        }

        return answer;
    }

    public static int solution2(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String, Integer> cache=new HashMap<>();
        for(int i=0;i<cities.length;i++){
            String city=cities[i].toUpperCase();
            if(cacheSize==0){
                answer+=5;
                continue;
            }
            addExeTime(cache);
            if(!cache.isEmpty()){
                if(cache.containsKey(city)){
                    answer++;
                    cache.put(city,0);
                }
                else{
                    answer+=5;
                    if(cache.size()<cacheSize)
                        cache.put(city,0);
                    else
                        replacePage(cache, city);
                }
            }
            else {
                answer+=5;
                cache.put(city, 0);
            }
        }
        return answer;
    }

    private static void addExeTime(Map<String, Integer> cache){
        Iterator<String> key=cache.keySet().iterator();
        while(key.hasNext()){
            String k=key.next();
            cache.put(k,cache.get(k)+1);
        }
    }

    private static void replacePage(Map<String, Integer> cache, String city){
        Iterator<String> key=cache.keySet().iterator();
        int max=0;
        StringBuilder maxKey=new StringBuilder();
        while(key.hasNext()){
            String k=key.next();
            if(max<cache.get(k)) {
                maxKey.replace(0, maxKey.length(), k);
                max=cache.get(k);
            }
        }
        cache.remove(maxKey.toString());
        cache.put(city, 0);
    }

    public static void main(String[] args) {
        String[] cities={"Jeju", "Pangyo", "NewYork", "newyork"};
        System.out.println(solution2(3, cities));
    }
}
