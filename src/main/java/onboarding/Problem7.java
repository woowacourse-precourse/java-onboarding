package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = getRecommendList(countScore(user, getUserFriends(user, friends), getAssociations(friends), visitors), getUserFriends(user, friends));
        return answer;
    }
    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<String>();
        List<List<String>> temp = friends.stream().filter(friend -> friend.contains(user)).collect(Collectors.toList());
        for(List users: temp) {
            for(int i = 0; i < 2; i++) {
                if(users.get(i) != user) {
                    userFriends.add((String) users.get(i));
                }
            }
        }
        return userFriends;
    }

    private static HashMap<String, List<String>> getAssociations(List<List<String>> friends) {
        HashMap<String, List<String>> associations = new HashMap<String, List<String>>();
        for(List users: friends) {
            if(!associations.containsKey(users.get(0))) {
                List<String> associationList = new ArrayList<>();
                associationList.add((String) users.get(1));
                associations.put((String) users.get(0), associationList);
            } else {
                List<String> arr = associations.get(users.get(0));
                arr.add((String) users.get(1));
                associations.put((String) users.get(0), arr);
            }
            if(!associations.containsKey(users.get(1))) {
                List<String> associationList = new ArrayList<>();
                associationList.add((String) users.get(0));
                associations.put((String) users.get(1), associationList);
            } else {
                List<String> arr = associations.get(users.get(1));
                arr.add((String) users.get(0));
                associations.put((String) users.get(1), arr);
            }
        }
        return associations;
    }
    private static HashMap<String, Integer> countScore(String user, List<String> userFriends, HashMap<String, List<String>> associations, List<String> visitors) {
        HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
        List<String> notAssociatedUsers = associations.keySet().stream().filter(key -> key != user).collect(Collectors.toList());
        for(String key: notAssociatedUsers) {
            scoreMap.put(key, 0);
            for(String userFriend: userFriends) {
                if(associations.get(key).contains(userFriend)) {
                    scoreMap.put(key, scoreMap.get(key) + 10);
                }
            }
        }
        for(String visitor: visitors) {
            if(!scoreMap.containsKey(visitor)) {
                scoreMap.put(visitor, 1);
            } else {
                scoreMap.put(visitor, scoreMap.get(visitor) + 1);
            }
        }
        return scoreMap;
    }

    private static List<String> getRecommendList(HashMap<String, Integer> scoreMap, List<String> friendList) {
        List<String> recommends = new ArrayList<String>();
        Map<String, Integer> treeMap = new TreeMap<>(scoreMap);

        List<String> keySetList = new ArrayList<>(treeMap.keySet());
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return treeMap.get(o2).compareTo(treeMap.get(o1));
            }
        });

        for(String key : keySetList) {
            if(!friendList.contains(key)) {
                recommends.add(key);
            }
        }
        return recommends;
    }
}
