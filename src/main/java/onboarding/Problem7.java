package onboarding;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static HashMap<String,List<String>> getFriends(List<List<String>> friends) {
        HashMap<String,List<String>> map = new HashMap<>();

        for (int i = 0; i < friends.size(); i++){
            String friend1 = friends.get(i).get(0);
            String friend2 = friends.get(i).get(1);

            List<String> list1 = map.getOrDefault(friend1, new ArrayList<>());
            List<String> list2 = map.getOrDefault(friend2, new ArrayList<>());
            list1.add(friend2);
            list2.add(friend1);

            map.put(friend1, list1);
            map.put(friend2, list2);
        }

        return map;
    }

    public static HashMap<String, Integer> getScore(String user, HashMap<String,List<String>> map, List<String> visitors){
        HashMap<String, Integer> scores = new HashMap<>();
        List<String> userfriends = map.getOrDefault(user, new ArrayList<>());

        for (String visitor : visitors) {
            scores.put(visitor, scores.getOrDefault(visitor, 1) + 1);
        }

        for (String friend : userfriends) {
            List<String> tempfriends = map.getOrDefault(friend, new ArrayList<>());

            for (int i = 0; i < tempfriends.size(); i++){
                scores.put(tempfriends.get(i), scores.getOrDefault(tempfriends.get(i), 10) + 10);
            }
        }

        scores.remove(user);
        return scores;
    }

    public static HashMap<String, Integer> removeFriend(HashMap<String, Integer> scores, List<String> friends) {
        for(String friend : friends) {
            scores.remove(friend);
        }
        return scores;
    }

    public static List<String> getTop5(HashMap<String, Integer> scores) {
        List<String> top5 = new ArrayList<String>();
        List<String> finalTop = top5;
        scores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> finalTop.add(entry.getKey()));

        if (top5.size() > 5) {
            top5 = top5.subList(0, 5);
        }

        return top5;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String,List<String>> friendmap = getFriends(friends);
        HashMap<String, Integer> scores = getScore(user, friendmap, visitors);
        scores = removeFriend(scores, friendmap.get(user));
        List<String> answer = getTop5(scores);
        return answer;
    }
}
