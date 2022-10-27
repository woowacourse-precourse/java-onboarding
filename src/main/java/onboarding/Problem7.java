package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        final int COUNT = 5;
        Map<String, Set<String>> friendsList = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            makeConnections(friendsList, friends.get(i).get(0), friends.get(i).get(1));
        }

        Set<String> usersFriendsSet = makeUsersFriendsList(user, friendsList);

        Map<String, Integer> scores = getFriendScore(user, usersFriendsSet, friendsList);

        addVisitScore(visitors, scores);

        ArrayList<Map.Entry<String, Integer>> forSort = new ArrayList(scores.entrySet());

        forSort.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() - o2.getValue() == 0){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        return getResult(forSort, COUNT);
    }

    static void makeConnections(Map<String, Set<String>> map, String name1, String name2){
        if (map.containsKey(name1)){
            map.get(name1).add(name2);
        } else {
            map.put(name1, Set.of(name2));
        }
    }

    static Set<String> makeUsersFriendsList(String user, Map<String, Set<String>> map){
        Set<String> result = new HashSet<>();

        Set<String> keySet = map.keySet();

        for(String str : keySet){
            if (map.get(user).contains(str)){
                result.add(str);
            }
        }
        return result;
    }

    static Map<String, Integer> getFriendScore(String user, Set<String> set, Map<String, Set<String>> map) {
        Map<String, Integer> result = new HashMap<>();

        for (String str : set) {
            Iterator<String> it = map.get(str).iterator();
            if (!str.equals(user) && it.hasNext()) {
                result.put(str, result.getOrDefault(str, 0) + 10);
            }
        }
        return result;
    }


    static void addVisitScore(List<String> list, Map<String, Integer> scores){
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String visitor = it.next();
            scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
        }
    }

    static List<String> getResult(List<Map.Entry<String, Integer>> entry, int count){
        List result = new ArrayList();
        Iterator<Map.Entry<String, Integer>> it = entry.iterator();

        while( it.hasNext() && count-- > 0){
            result.add(it.next().getKey());
        }
        return result;
    }
}
