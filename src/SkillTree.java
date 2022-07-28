public class SkillTree {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int index=-1;
        String[] skillArr = skill.split("");
        for(String st:skill_trees){
            //System.out.println(st);
            for(String s:skillArr){
//                System.out.println(s);
                System.out.println(st+" "+s +" "+st.contains(s));
                if(st.contains(s)){
                    // 뒤의 skill이 앞에 있으면 불가능한 스킬트리이므로 break
                   // System.out.println(st.indexOf(s));
                    if(index>st.indexOf(s))
                        break;
                    index=st.indexOf(s);
                   // System.out.println(st+" "+index);
                }
                if(s.equals(skillArr[skillArr.length-1])) {
                    answer++;
                    System.out.println(st);
                }
            }

        }
        return answer;
    }
    public static void main(String[] args) {
        String[] skill_trees={"BACDE", "CBADF", "AECB", "BDA"};
        String skill="CBD";
        System.out.println(solution(skill,skill_trees));
    }
}
