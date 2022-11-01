package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> scoreMap = new HashMap<>();

        scoreMap = friendsListMap(user, friends, visitors);

        answer = sortValue(5, scoreMap);

        return answer;
    }

    private static HashMap<String, Integer> friendsListMap(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scoreMap = new HashMap<>();
        HashSet<String> friend = new HashSet<>();

        // friends
        for (List<String> withFriend : friends) {
            String friendName = withFriend.get(1);
            friend.add(withFriend.get(0));

            if (friendName == user)
                continue;
            if (scoreMap.containsKey(friendName)) {
                scoreMap.put(friendName, scoreMap.get(friendName) + 10);
                continue;
            }
            scoreMap.put(friendName, 10);
        }

        // visitors
        for (String friendName : visitors) {
            if (friend.contains(friendName)) {
                continue;
            }
            if (scoreMap.containsKey(friendName)) {
                scoreMap.put(friendName, scoreMap.get(friendName) + 1);
                continue;
            }
            scoreMap.put(friendName, 1);
        }

        return scoreMap;
    }

    private static List<String> sortValue(int n, HashMap<String, Integer> scoreMap) {
        List<String> recommendedFriend = new ArrayList<>();

        List<String> keySetList = new ArrayList<>(scoreMap.keySet());
        Collections.sort(keySetList, ((o1, o2) -> (scoreMap.get(o2).compareTo(scoreMap.get(o1)))));

        for (int k = 0; k < keySetList.size(); k++) {
            if (recommendedFriend.size() == n)
                break;
            recommendedFriend.add(keySetList.get(k));
        }

        return recommendedFriend;
    }
}