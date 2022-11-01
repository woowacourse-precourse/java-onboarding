package onboarding;

import java.util.*;
import java.util.stream.Stream;

public class Problem7 {
    public static final int FRIEND_SCORE = 10;
    public static final int VISIT_SCORE = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> score = new HashMap<>();
        HashMap<String, List<String>> friendsMap = getFriendsMap(friends);
        HashMap<String, Integer> visitorCount = getVisitorCount(visitors);
        List<String> userFriends = friendsMap.get(user);
        for (String userFriend: userFriends){
            for (String friend: friendsMap.get(userFriend)){
                if (friend == user){
                    continue;
                }
                score.put(friend, score.getOrDefault(friend, 0) + FRIEND_SCORE);
            }
        }

        for(String visitor: visitorCount.keySet()) {
            if (userFriends.contains(visitor)){
                continue;
            }
            score.put(visitor, score.getOrDefault(visitor, 0) + visitorCount.get(visitor) * VISIT_SCORE);
        }

        List<String> answer = new ArrayList<>(score.keySet());
        Collections.sort(answer);
        Collections.sort(answer, (o1, o2) -> (score.get(o2).compareTo(score.get(o1))));

        if (answer.size() > 5) {
            answer = answer.subList(0, 5);
        }
        return answer;
    }

    public static HashMap<String, List<String>> getFriendsMap(List<List<String>> friends) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (List<String> f: friends ) {
            hashMap.computeIfAbsent(f.get(0), s -> new ArrayList<>()).add(f.get(1));
            hashMap.computeIfAbsent(f.get(1), s -> new ArrayList<>()).add(f.get(0));
        }
        return hashMap;
    }

    public static HashMap<String, Integer> getVisitorCount(List<String> visitors) {
        HashMap <String, Integer> hashMap = new HashMap<>();
        for (String v : visitors) {
            hashMap.computeIfAbsent(v, s -> 0);
            hashMap.put(v, hashMap.get(v) + 1);
        }
        return hashMap;
    }

}
