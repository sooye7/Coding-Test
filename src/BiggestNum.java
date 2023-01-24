import java.util.Arrays;
import java.util.Comparator;

public class BiggestNum {

    public String solution(int[] numbers) {
        String[] nums=new String[numbers.length];

        for(int i=0;i<numbers.length;i++)
            nums[i]=String.valueOf(numbers[i]);
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o2.charAt(0)==o1.charAt(0)) {
                    for (int i = 0; i < Math.max(o1.length(), o2.length()); i++) {
                        if (i > o1.length()) {
                            if (o2.charAt(i) != o1.charAt(o1.length() - 1))
                                return o2.charAt(i) - o1.charAt(o1.length() - 1);
                        }
                        else if (i > o2.length()) {
                            if (o2.charAt(o2.length() - 1) != o1.charAt(i))
                                return o2.charAt(o2.length() - 1) - o1.charAt(i);
                        }
                        else if (o2.charAt(i) != o1.charAt(i))
                            return o2.charAt(i) - o1.charAt(i);
                    }
                }
                return o2.charAt(0)-o1.charAt(0);
            }
        });
        StringBuilder sb=new StringBuilder();
        for(String n:nums)
            sb.append(n);

        return String.valueOf(sb);
    }
}
