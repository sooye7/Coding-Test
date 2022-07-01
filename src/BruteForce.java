public class BruteForce {
    static int[] arr={1,2,3,4,5,6};
    static int M;
    static int pCnt=0, cCnt=0, ppCnt=0, ccCnt=0;

    static int[] numbers;
    static boolean[] check;  // 방문 여부
    static int n;  // 전체 n개

    // 순열
    // cnt : 뽑으려는 개수, selected: 선택된 수, visited : 배열 방문
    static void perm(int cnt, int[] selected, boolean[] visited){
        if(cnt==M){
            pCnt++;
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i]=true;
                selected[cnt]=arr[i];
                perm(cnt+1,selected, visited);
                visited[i]=false;
            }
        }
    }

    // 중복순열
    // 중복 가능하므로 방문 관리 필요 X
    static void pperm(int cnt,int[] selected){
        if(cnt==M){
            ppCnt++;
            return;
        }
        for(int i=0;i<arr.length;i++){
            selected[cnt]=arr[i];
            pperm(cnt+1,selected);
        }
    }

    // 조합
    static void comb(int cnt, int[] selected, int startIdx){
        if(cnt==M){
            cCnt++;
            return;
        }
        for(int i=startIdx;i<arr.length;i++){
            selected[cnt]=arr[i];
            comb(cnt+1,selected,i+1);
        }
    }

    // 중복조합
    static void ccomb(int cnt, int[] selected, int startIdx){
        if(cnt==M){
            ccCnt++;
            return;
        }
        for(int i=startIdx;i<arr.length;i++){
            selected[cnt]=arr[i];
            ccomb(cnt+1,selected,i);
        }
    }

    // 부분집합
    public static void subset(int cnt){
        if(cnt==n){
            for(int i=0;i<check.length;i++){
                if(check[i]){
                    // subset으로 하고싶은 연산
                }

            }
            return;
        }
        // 해당 원소 포함하는 경우
        check[cnt]=true;
        subset(cnt+1);

        // 해당 원소는 포함하지 않는 경우
        check[cnt]=false;
        subset(cnt+1);

    }

    public static void main(String[] args) {

    }



}
