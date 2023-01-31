import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;
import java.util.Comparator;

class TicketRouting2 {
    static boolean[] visited;
    public static String[] solution(String[][] tickets) {
        List<String> route=new ArrayList<>();
        int num=tickets.length;
        visited=new boolean[num];
        Queue<Ticket> q=new LinkedList<>();
        List<Ticket> sameDeparture=new ArrayList<>();
        String firstDest="ZZZ";
        int idx=0;
        for(int i=0;i<num;i++){
            if(tickets[i][0].equals("ICN")){
                System.out.println(firstDest);
                System.out.println(tickets[i][1]);
                System.out.println(firstDest.compareTo(tickets[i][1])<0);
                if(firstDest.compareTo(tickets[i][1])>0){
                    firstDest = tickets[i][1];
                    idx = i;
                }
            }
        }

        q.add(new Ticket("ICN",firstDest,idx));
        visited[idx]=true;
        route.add("ICN");
        System.out.println(firstDest);
        while(!q.isEmpty()){
            sameDeparture=new ArrayList<>();
            firstDest="ZZZ";
            idx=0;
            Ticket t=q.poll();
            route.add(t.destination);
            System.out.println(t);
            System.out.println(route);
            for(int i=0;i<num;i++){
                if(t.destination.equals(tickets[i][0])&&!visited[i]){
                    if(firstDest.compareTo(tickets[i][1])>0){
                        firstDest = tickets[i][1];
                        idx = i;
                    }
                }

            }
            if(firstDest.equals("ZZZ"))
                break;

            q.add(new Ticket(t.destination,firstDest,idx));
            visited[idx]=true;

        }
        String[] answer = new String[route.size()];
        for(int i=0;i<route.size();i++)
            answer[i]=route.get(i);

        return answer;
    }

    public static void main(String[] args) {
        String[][] tickets={{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        solution(tickets);
    }
}

class Ticket2{
    String departure;
    String destination;
    int index;

    public Ticket2(String departure, String destination, int index){
        this.departure=departure;
        this.destination=destination;
        this.index=index;
    }

    public String toString(){
        return departure+" "+destination+" "+index;
    }
}