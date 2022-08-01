public class SkillTree {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        String[] skillArr = skill.split("");

        // 스킬 아예 포함하지 않은 경우
        for(String st:skill_trees){
            boolean isContain=false;
            for(String s:skillArr){
                if(st.contains(s)) {
                    isContain=true;
                    break;
                }
            }
            if(!isContain)
                answer++;
        }
        for(String st:skill_trees){
            int index=0;
            boolean check=false;  // 중간 스킬이 없는 경우 다음 스킬 나오는지 체크하기 위함
            for(String s:skillArr){
                System.out.println(st+" "+s +" "+st.contains(s));
                if(st.contains(s)){
                    // 뒤의 skill이 앞에 있으면 불가능한 스킬트리, 중간 스킬이 없는데 다음 스킬이 나오면 불가능한 스킬트리이므로 break
                    if(index>st.indexOf(s)||check)
                        break;
                    index=st.indexOf(s);
                }
                //else
                    //check=true;
                else if(!st.contains(s)&&!s.equals(skillArr[skillArr.length-1])) {
                    check=true;
                    break;
                }
                if(s.equals(skillArr[skillArr.length-1]))
                    answer++;
            }
        }
        return answer;
    }

    public static int solution2(String skill, String[] skill_trees) {
        int answer = 0;

        String[] skillArr = skill.split("");

        // 스킬 아예 포함하지 않은 경우
//        for(String st:skill_trees){
//            boolean isContain=false;
//            for(String s:skillArr){
//                if(st.contains(s)) {
//                    isContain=true;
//                    break;
//                }
//            }
//            if(!isContain)
//                answer++;
//        }
        for(String st:skill_trees){
            int index=0;
            boolean check=false;  // 중간 스킬이 없는 경우 다음 스킬 나오는지 체크하기 위함
            for(String s:skillArr){
                System.out.println(st+" "+s +" "+st.contains(s));
                if(st.contains(s)){
                    // 뒤의 skill이 앞에 있으면 불가능한 스킬트리, 중간 스킬이 없는데 다음 스킬이 나오면 불가능한 스킬트리이므로 break
                    if(index>st.indexOf(s)||check)
                        break;
                    index=st.indexOf(s);
                }
                else if(!st.contains(s)&&!s.equals(skillArr[skillArr.length-1])) {
                    check=true;
                }
                if(s.equals(skillArr[skillArr.length-1]))
                    answer++;
            }
            System.out.println(answer);
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] skill_trees={"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"};
        String skill="CBDK";
        System.out.println(solution2(skill,skill_trees));
    }
}
