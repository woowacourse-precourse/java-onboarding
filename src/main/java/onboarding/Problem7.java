package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Comparator;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> user_friends = findUserFriends(user, friends);
        HashMap<String, Integer> not_user_friends = findNotUserFriends(user, friends, user_friends);
        not_user_friends = addVisitor(not_user_friends, user_friends, visitors);
        answer = sortFiveValueAndName(not_user_friends);
        return answer;
    }
    private static Set<String> findUserFriends(String user, List<List<String>> friends) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++)
                if (friends.get(i).get(j) == user) {
                    result.add(friends.get(i).get(1 - j));
                }
        }
        return result;
    }
    private static HashMap<String, Integer> findNotUserFriends(String user, List<List<String>> friends, Set<String> user_friends) {
        HashMap<String, Integer> result = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            String first = friends.get(i).get(0);
            String second = friends.get(i).get(1);
            if (first == user || second == user || user_friends.isEmpty())
                continue;
            if (!user_friends.contains(first) && !user_friends.contains(second))
                continue;
            if(!user_friends.contains(first))
                result.put(first, result.getOrDefault(first, 0) + 10);
            if(!user_friends.contains(second))
                result.put(second, result.getOrDefault(second, 0) + 10);
        }
        return result;
    }
    private static HashMap<String, Integer> addVisitor(HashMap<String, Integer> notFriendMap, Set<String> friends, List<String> visitors) {
        for (int i = 0; i < visitors.size(); i++) {
            String friend_key = visitors.get(i);
            if (friends.contains(friend_key))
                continue;
            notFriendMap.put(friend_key, notFriendMap.getOrDefault(friend_key, 0) + 1);
        }
        return notFriendMap;
    }
    public static List<String> sortFiveValueAndName(HashMap<String,Integer> map){
        List<String> result = new ArrayList<>();
        List<Map.Entry<String,Integer>> map_entryList = new ArrayList<Entry<String, Integer>>(map.entrySet());
        Collections.sort(map_entryList, new Comparator<Entry<String,Integer>>(){
            @Override
            public int compare(Entry<String,Integer> ob1, Entry<String,Integer>ob2){
                if(ob1.getValue() > ob2.getValue())
                    return -1;
                if(ob1.getValue() < ob2.getValue())
                    return 1;
                if(ob1.getKey().compareTo(ob2.getKey()) <= 0)
                    return -1;
                return 1;
            }
        });
        for(int j = 0, i = 0; (j < 5)&&(i < map_entryList.size()); i++, j++){
            result.add(map_entryList.get(i).getKey());
        }
        return result;
    }
}
