package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> friendsMap = makeFriendsGraph(friends);
        Map<String, Integer> scoreMap = new HashMap<>();


        getScoreSameFriends(friendsMap, user, scoreMap);
        getVisitScore(visitors, scoreMap);
        alreadyFriendRemoveScore(friendsMap, scoreMap, user);
        makeRecommendFriend(scoreMap);

        answer = makeRecommendFriend(scoreMap);
        return answer;
    }

    private static void alreadyFriendRemoveScore(Map<String, List<String>> friendsMap, Map<String, Integer> scoreMap, String user){
        List<String> alreadyFriends = friendsMap.get(user);
        for (String friend : alreadyFriends){
            scoreMap.remove(friend);
        }
    }

    private static List<String> makeRecommendFriend(Map<String, Integer> scoreMap){
        List<String> ret = new ArrayList<>();

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(scoreMap.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().compareTo(o2.getValue()) == 0){
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return -1*o1.getValue().compareTo(o2.getValue());
                }
            }
        });

        for (int i = 0; i < Math.min(5, entries.size()); i++) {
            ret.add(entries.get(i).getKey());
        }


        return ret;
    }

    private static void getVisitScore(List<String> visitors, Map<String, Integer> scoreMap){
        for (String visitor: visitors){
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
        }
    }

    private static void getScoreSameFriends(Map<String, List<String>> friendsMap, String target, Map<String, Integer> scoreMap){
        List<String> targetFriends = friendsMap.get(target);

        for(Map.Entry<String, List<String>> entry : friendsMap.entrySet()){
            if (entry.getKey().equals(target)){
                continue;
            }

            List<String> friendFriendShip = entry.getValue();
            ArrayList<String> intersect = new ArrayList<>(targetFriends);
            intersect.retainAll(friendFriendShip);
            scoreMap.put(entry.getKey(), 10 * intersect.size());
        }
    }

    private static Map<String, List<String>> makeFriendsGraph(List<List<String>> friends){
        Map<String, List<String>> friendsMap = new HashMap<>();

        for (List<String> relation : friends){
            List<String> relationship = friendsMap.getOrDefault(relation.get(0), new ArrayList<>());
            relationship.add(relation.get(1));
            friendsMap.put(relation.get(0),relationship);
            relationship = friendsMap.getOrDefault(relation.get(1), new ArrayList<>());
            relationship.add(relation.get(0));
            friendsMap.put(relation.get(1),relationship);
        }

        return friendsMap;
    }
}
