package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String,List<String>> friendmake(List<List<String>> friends){
        Map<String,List<String>> friendList = new HashMap<>(); //TreeMap과 HashMap중 고민했음 하지만 마지막에만 정렬해주면 되기에 전체적인 시간을 고려해 HashMap
        for (int i = 0 ;i<friends.size();i++){
            final String name1 = friends.get(i).get(0);
            final String name2 = friends.get(i).get(1);
            if (friendList.containsKey(name1)) { //name1의 친구리스트가 형성되어있는 경우
                friendList.get(name1).add(name2);
            }else{
                List<String> templist = new ArrayList<>(); //되어있지 않다면 name2를 넣은 arrayList형성후 삽입
                templist.add(name2);
                friendList.put(name1,templist);
            }
            if (friendList.containsKey(name2)) { //동일
                friendList.get(name2).add(name1);
            }else{
                List<String> templist = new ArrayList<>();
                templist.add(name1);
                friendList.put(name2,templist);
            }
        }
        return friendList;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String,List<String>> friendMap =friendmake(friends);
    }
}
