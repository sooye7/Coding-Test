import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MusicInfo{
    String title;
    String music;
    int time;
    public MusicInfo(String title, String music, int time){
        this.title=title;
        this.music=music;
        this.time=time;
    }
}

public class Song {
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        // 음 배열에 넣기
        List<String> tone=new ArrayList<>(Arrays.asList("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"));
        List<MusicInfo> musicInfoList=new ArrayList<>();
        StringBuilder musicIdx=new StringBuilder();

        // m을 인덱스로 표현
        for(int i=0;i<m.length()-1;i++){
            if(m.charAt(i+1)=='#') {
                musicIdx.append(tone.indexOf(m.substring(i, i + 2)) + ",");
                i++;
            }
            else
                musicIdx.append(tone.indexOf(m.substring(i, i + 1))+",");
        }
        if(m.charAt(m.length()-1)!='#')
            musicIdx.append(tone.indexOf(m.substring(m.length()-1)));
        System.out.println(musicIdx);
        for(int i=0;i<musicinfos.length;i++){
            String[] arr=musicinfos[i].split(",");
            String[] prev=arr[0].split(":");
            String[] after=arr[1].split(":");
            int time=(Integer.parseInt(after[0])-Integer.parseInt(prev[0]))*60+Integer.parseInt(after[1])-Integer.parseInt(prev[1]);  // 재생 시간
            MusicInfo mi=new MusicInfo(arr[2],arr[3],time);
            int index=0;
            StringBuilder musicSheet=new StringBuilder();
            StringBuilder musicSheetIdx=new StringBuilder();
            for(int j=0;j<time/mi.music.length();j++)
                musicSheet.append(mi.music);
            for(int j=0;j<time%mi.music.length();j++){
                if(index>=mi.music.length())
                    index=0;
                if(index!=mi.music.length()-1&&mi.music.charAt(index+1)=='#') {
                    musicSheet.append(mi.music.substring(index, index + 2));
                    index+=2;
                }
                else{
                    musicSheet.append(mi.music.substring(index, index + 1));
                    index++;
                }
            }
            System.out.println(musicSheet);
            // musicSheet를 인덱스로 표현
            for(int j=0;j<musicSheet.length()-1;j++){
                if(musicSheet.charAt(j+1)=='#') {
                    musicSheetIdx.append(tone.indexOf(musicSheet.substring(j, j + 2)) + ",");
                    j++;
                }
                else
                    musicSheetIdx.append(tone.indexOf(musicSheet.substring(j, j + 1))+",");
            }
            if(musicSheet.charAt(musicSheet.length()-1)!='#')
                musicSheetIdx.append(tone.indexOf(musicSheet.substring(musicSheet.length()-1)));
            System.out.println(musicSheetIdx);
            if(musicSheetIdx.toString().contains(musicIdx.toString()))
                musicInfoList.add(mi);
        }

        // answer
        if(musicInfoList.size()==1)
            answer+=musicInfoList.get(0).title;
        else if(musicInfoList.size()==0)
            answer+="None";
        else{
            MusicInfo musicInfo=musicInfoList.get(0);
            for(MusicInfo mi:musicInfoList){
                if(musicInfo.time<mi.time)
                    musicInfo=mi;
            }
            answer+= musicInfo.title;
        }
        System.out.println(answer);
        return answer;
    }

    public static String solution2(String m, String[] musicinfos) {
        String answer = "";
        List<MusicInfo> musicInfoList=new ArrayList<>();

        for(int i=0;i<musicinfos.length;i++){
            String[] arr=musicinfos[i].split(",");
            String[] prev=arr[0].split(":");
            String[] after=arr[1].split(":");
            int time=(Integer.parseInt(after[0],10)-Integer.parseInt(prev[0],10))*60+Integer.parseInt(after[1],10)-Integer.parseInt(prev[1],10);  // 재생 시간
            MusicInfo mi=new MusicInfo(arr[2],arr[3],time);
            int index=0;
            StringBuilder musicSheet=new StringBuilder();
            for(int j=0;j<time/mi.music.length();j++)
                musicSheet.append(mi.music);
            for(int j=0;j<time%mi.music.length();j++){
                if(index>=mi.music.length())
                    index=0;
                if(index!=mi.music.length()-1&&mi.music.charAt(index+1)=='#') {
                    musicSheet.append(mi.music.substring(index, index + 2));
                    index+=2;
                }
                else{
                    musicSheet.append(mi.music.substring(index, index + 1));
                    index++;
                }
            }
            musicSheet= new StringBuilder(musicSheet.toString().replaceAll(m + "#", " "));
            if(m.length()>musicSheet.length())
                continue;
            System.out.println(musicSheet);
            if(musicSheet.toString().contains(m))
                musicInfoList.add(mi);
        }
        // answer
        if(musicInfoList.size()==1)
            answer+=musicInfoList.get(0).title;
        else if(musicInfoList.size()==0)
            answer+="(None)";
        else{
            MusicInfo musicInfo=musicInfoList.get(0);
            for(MusicInfo mi:musicInfoList){
                if(musicInfo.time<mi.time)
                    musicInfo=mi;
            }
            answer+= musicInfo.title;
        }
        System.out.println(answer);
        return answer;
    }

    public static String solution3(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxtime = 0;
        for(int i = 0; i<m.length();i++){
            m = m.replace("A#","a");
            m = m.replace("C#","c");
            m = m.replace("D#","d");
            m = m.replace("F#","f");
            m = m.replace("G#","g");
            m = m.replace("E#","e");
        }

        for(int i = 0; i< musicinfos.length;i++) {
            String[] tmp = musicinfos[i].split(",");
            tmp[3] = tmp[3].replace("A#","a");
            tmp[3] = tmp[3].replace("C#","c");
            tmp[3] = tmp[3].replace("D#","d");
            tmp[3] = tmp[3].replace("F#","f");
            tmp[3] = tmp[3].replace("G#","g");
            tmp[3] = tmp[3].replace("E#","e");


            String[] starttime = tmp[0].split(":");
            String[] endtime = tmp[1].split(":");

            int hour = Integer.parseInt(endtime[0]) - Integer.parseInt(starttime[0]);
            int min = Integer.parseInt(endtime[1]) - Integer.parseInt(starttime[1]) + (hour * 60);

            String meltmp = "";
            for(int j = 0; j<min;j++){
                meltmp += tmp[3].charAt(j%tmp[3].length());
            }
            //System.out.println(meltmp); 노래가 진행되는 동안의 음들
            if(meltmp.contains(m)){
                if(maxtime < meltmp.length()){
                    maxtime = meltmp.length();
                    answer = tmp[2];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String m="ABC";
        String[] musicInfos={"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        solution2(m,musicInfos);
    }
}
