package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String,ArrayList<String>> friends_map = new HashMap<>();
        for(List<String> friend : friends){
            String f1 = friend.get(0);
            String f2 = friend.get(1);
            if(friends_map.containsKey(f1)){
                friends_map.get(f1).add(f2);
            }else{
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(f2);
                friends_map.put(f1,tmp);
            }
            if(friends_map.containsKey(f2)){
                friends_map.get(f2).add(f1);
            }else{
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(f1);
                friends_map.put(f2,tmp);
            }
        }
        ArrayList<String> user_friends = friends_map.get(user);
        friends_map.remove(user);
        for(String user_friend : user_friends){
            friends_map.remove(user_friend);
        }
        Map<String,Integer> points = new TreeMap<>();
        for(String name : friends_map.keySet()){
            int point = 0;
            for(String f : friends_map.get(name)){
                if(user_friends.contains(f)) point += 10;
            }
            points.put(name,point);
        }
        for(String visitor : visitors) {
            if (!user_friends.contains(visitor)) {
                if (points.containsKey(visitor)) {
                    int p = points.get(visitor);
                    points.put(visitor, p + 1);
                } else {
                    points.put(visitor, 1);
                }
            }
        }
        List<Map.Entry<String,Integer>> entryList = new LinkedList<>(points.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for(Map.Entry<String,Integer> entry : entryList){
            if(entry.getValue() != 0) answer.add(entry.getKey());
        }
        return answer;
    }
}
