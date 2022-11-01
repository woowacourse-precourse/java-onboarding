package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static final Map<String, List<String>> friendMap = new HashMap<String, List<String>>();
    private static Map<String, Integer> scoreMap = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        createFriendsList(friends);
        createScoreMap(user);
        scoringFriends(user,friendMap);
        scoringVisits(visitors);
        removeOriginalFriends(user,friendMap);
        List<String> answer = getRecommandFriends();
        return answer;
    }

    private static void createFriendsList(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);
            if (!friendMap.containsKey(user1)) {
                friendMap.put(user1, new ArrayList<>());
                friendMap.get(user1).add(user2);
            }else{
                friendMap.get(user1).add(user2);
            }
            if (!friendMap.containsKey(user2)) {
                friendMap.put(user2, new ArrayList<>());
                friendMap.get(user2).add(user1);
            }else{
                friendMap.get(user2).add(user1);
            }
        }
    }

    private static void createScoreMap(String user) {
        for( String friendkey : friendMap.keySet() ){
            if(!friendkey.equals(user))
                scoreMap.put(friendkey, 0);
        }
    }

    private static void scoringFriends(String user, Map<String, List<String>> friendList) {
        List<String> userFriends = friendList.get(user);
        for (String userFriend : userFriends) {
            List<String> tartgetfFriends = friendList.get(userFriend);
            for (String friend : tartgetfFriends) {
                if(!user.equals(friend)){
                    scoreMap.put(friend , scoreMap.get(friend) + 10);
                }
            }
        }
    }

    private static void scoringVisits(List<String> visitors) {
        for (String visitor : visitors) {
            //없으면 추가
            if (!scoreMap.containsKey(visitor)) {
                scoreMap.put(visitor, 0);
            }
            scoreMap.put(visitor , scoreMap.get(visitor) + 1);
        }
    }

    private static void removeOriginalFriends(String user,Map<String, List<String>> friendList) {
        List<String> userFriends = friendList.get(user);
        for (String userFriend : userFriends) {
            scoreMap.remove(userFriend);
        }
    }

    private static List<String> getRecommandFriends() {
        return scoreMap.entrySet().stream()
                .filter(sc -> sc.getValue() >0)
                .limit(5)
                .sorted(Comparator.comparing(Map.Entry<String, Integer>::getKey)
                        .thenComparing(Comparator.comparing(Map.Entry<String, Integer>::getValue)).reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
