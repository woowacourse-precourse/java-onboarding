package onboarding;



import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        List<String> first=new ArrayList<String>();
        List<String> tmp=new ArrayList<String>();
        int a=0;
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).contains(user)){
                a=Math.abs(friends.get(i).indexOf(user)-1);
                first.add(friends.get(i).get(a));
            }
        }
        for(int i=0;i<first.size();i++){
            point(first.get(i),friends,map); //내 친구들의 친구를 포인트매김
        }
        map.remove(user);
        for(int i=0;i<visitors.size();i++){
            map.put(visitors.get(i),map.getOrDefault(visitors.get(i),0)+1);
        }
        for(int i=0;i< first.size();i++)//내 친구가 점수가 추가된경우 삭제해줌
            map.remove(first.get(i));
        List<String> namelist=new ArrayList<String>(map.keySet());
        Collections.sort(namelist,(o1,o2)->{
            return map.get(o2)!=map.get(o1) ? map.get(o2)-map.get(o1):o1.compareTo(o2);
        });
        List<String> answer =new ArrayList<String>();
        for(int i=0;i< namelist.size();i++){
            if(i>4)
                break;
            answer.add(namelist.get(i));
        }

        return answer;
    }
    public static void point(String user,List<List<String>> friends,HashMap<String,Integer> map){
        int a=0;
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).contains(user)){
                a=Math.abs(friends.get(i).indexOf(user)-1);
                map.put(friends.get(i).get(a),map.getOrDefault(friends.get(i).get(a),0)+10);
            }
        }
    }
}
