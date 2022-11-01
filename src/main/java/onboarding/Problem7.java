package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;

public class Problem7 {
    public static Comparator<HashMap.Entry<String, Integer>> comparator = new Comparator<>() {
        @Override
        public int compare(HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2) {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        }
    };

    private static HashMap<String, List<String>> createFriendMap(List<List<String>> friends) {
        HashMap<String, List<String>> friendMap = new HashMap<>();
        List<String> friendList;

        for (List<String> friend : friends) {
            friendList = new ArrayList<>();
            if (friendMap.containsKey(friend.get(0))) {
                friendList = friendMap.get(friend.get(0));
                friendList.add(friend.get(1));
            } else {
                friendList.add(friend.get(1));
            }
            friendMap.put(friend.get(0), friendList);

            friendList = new ArrayList<>();
            if (friendMap.containsKey(friend.get(1))) {
                friendList = friendMap.get(friend.get(1));
                friendList.add(friend.get(0));
            } else {
                friendList.add(friend.get(0));
            }
            friendMap.put(friend.get(1), friendList);
        }

        return friendMap;
    }

    private static HashMap<String, Integer> scoreFriendsOfFriends(String user, HashMap<String, List<String>> friendMap) {
        HashMap<String, Integer> scoreMap = new HashMap<>();
        List<String> userFriendList = friendMap.get(user);
        List<String> friendOfFriendList;

        for (String userFriend : userFriendList) {
            friendOfFriendList = friendMap.get(userFriend);

            for (String friendOfFriend : friendOfFriendList) {
                scoreMap.put(friendOfFriend, scoreMap.getOrDefault(friendOfFriend, 0) + 10);
            }
        }

        return scoreMap;
    }

    private static HashMap<String, Integer> scoreVisitors(HashMap<String, Integer> scoreMap, List<String> visitors) {
        for (String visitor : visitors) {
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
        }

        return scoreMap;
    }

    private static HashMap<String, Integer> removeUserAndFriend(HashMap<String, Integer> scoreMap, HashMap<String, List<String>> friendMap, String user) {
        List<String> userFriendList = friendMap.get(user);

        for (String userFriend : userFriendList) {
            scoreMap.remove(userFriend);
        }

        if (scoreMap.containsKey(user)) {
            scoreMap.remove(user);
        }

        return scoreMap;
    }

    private static List<String> recommend(List<String> answer, HashMap<String, Integer> scoreMap) {
        List<HashMap.Entry<String, Integer>> scoreList = new ArrayList<>(scoreMap.entrySet());

        scoreList.sort(comparator);

        int count = 0;

        for (HashMap.Entry<String, Integer> list : scoreList) {
            answer.add(list.getKey());
            count++;
            if (count == 5) {
                break;
            }
        }

        return answer;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> friendMap;
        HashMap<String, Integer> scoreMap;

        friendMap = createFriendMap(friends);

        scoreMap = scoreFriendsOfFriends(user, friendMap);

        scoreMap = scoreVisitors(scoreMap, visitors);

        scoreMap = removeUserAndFriend(scoreMap, friendMap, user);

        answer = recommend(answer, scoreMap);

        return answer;
    }
}
