import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;
import java.util.Comparator;

class TicketRouting {
    static boolean[] visited;
    public static String[] solution(String[][] tickets) {
        List<String> route=new ArrayList<>();
        int num=tickets.length;
        visited=new boolean[num];
        Queue<Ticket> q=new LinkedList<>();
        List<Ticket> sameDeparture=new ArrayList<>();
        for(int i=0;i<num;i++){
            if(tickets[i][0].equals("ICN")){
                sameDeparture.add(new Ticket(tickets[i][0],tickets[i][1], i));
            }
        }

        Collections.sort(sameDeparture, new Comparator<Ticket>(){
            @Override
            public int compare(Ticket o1, Ticket o2){
                return o1.destination.compareTo(o2.destination);
            }
        });

        q.add(sameDeparture.get(0));
        visited[sameDeparture.get(0).index]=true;
        route.add(sameDeparture.get(0).departure);
        System.out.println(sameDeparture);
        while(!q.isEmpty()){
            sameDeparture=new ArrayList<>();
            Ticket t=q.poll();
            route.add(t.destination);
            for(int i=0;i<num;i++){
                if(t.destination.equals(tickets[i][0])&&!visited[i])
                    sameDeparture.add(new Ticket(tickets[i][0], tickets[i][1], i));
            }
            System.out.println(sameDeparture);
            System.out.println(route);
            Collections.sort(sameDeparture, new Comparator<Ticket>(){
                @Override
                public int compare(Ticket o1, Ticket o2){
                    return o1.destination.compareTo(o2.destination);
                }
            });

            q.add(sameDeparture.get(0));
            visited[sameDeparture.get(0).index]=true;

        }
        String[] answer = new String[route.size()];
        for(int i=0;i<route.size();i++)
            answer[i]=route.get(i);

        return answer;
    }

    public static void main(String[] args) {
        String[][] tickets={{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        solution(tickets);
    }
}

class Ticket{
    String departure;
    String destination;
    int index;

    public Ticket(String departure, String destination, int index){
        this.departure=departure;
        this.destination=destination;
        this.index=index;
    }

    @Override
    public String toString(){
        return departure+" "+destination+" "+index;
    }
}