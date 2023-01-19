import java.util.HashSet;
import java.util.Set;

public class Phonecketmon {

    public int solution(int[] nums){
        int len=nums.length;
        Set<Integer> hs=new HashSet<>();
        for(int n:nums)
            hs.add(n);
        int result= Math.min(hs.size(), nums.length / 2);
        return result;
    }
    public static void main(String[] args) {

    }
}
