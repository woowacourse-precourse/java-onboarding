package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> friend_list = createFrined_List(user, friends);
        HashMap<String, Integer> strange_map = createStranger_List(friends, visitors, friend_list);
        modifyScore(friends, visitors, friend_list, strange_map);

        return answer;
    }

    public static List<String> createFrined_List(String user, List<List<String>> friends) {
        List<String> friend_list = new ArrayList<>();

        friend_list.add(user);
        for(List<String> f : friends) {
            if(user.equals(f.get(0))) friend_list.add(f.get(1));
            if(user.equals(f.get(1))) friend_list.add(f.get(0));
        }

        return friend_list;
    }

    public static HashMap<String, Integer> createStranger_List(List<List<String>> friends,List<String> visitors, List<String> friend_list) {
        HashMap<String, Integer> strange_map = new HashMap<>();

        for(List<String> f : friends) {
            if(!friend_list.contains(f.get(0))) strange_map.put(f.get(0), 0);
            if(!friend_list.contains(f.get(1))) strange_map.put(f.get(1), 0);
        }
        for(String v : visitors) {
            if(!friend_list.contains(v) && !strange_map.containsKey(v)) strange_map.put(v, 0);
        }

        return strange_map;
    }

    public static void modifyScore(List<List<String>> friends, List<String> visitors, List<String> friend_list, HashMap<String, Integer> strange_map) {
        for(List<String> f : friends) {
            if(friend_list.contains(f.get(0)) && strange_map.containsKey(f.get(1))) {
                strange_map.put(f.get(1), strange_map.get(f.get(1)) + 10);
            }
            if(friend_list.contains(f.get(1)) && strange_map.containsKey(f.get(0))) {
                strange_map.put(f.get(0), strange_map.get(f.get(0)) + 10);
            }
        }
        for(String v : visitors) {
            if(!friend_list.contains(v) && strange_map.containsKey(v)) {
                strange_map.put(v, strange_map.get(v) + 1);
            }
        }
    }
}
