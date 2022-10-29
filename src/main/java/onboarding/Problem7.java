package onboarding;

import java.util.*;

public class Problem7 {

    static HashMap<String, ArrayList<String>> friendsMap;
    static HashMap<String, Integer> userScoreMap;
    static final int VISITOR_SCORE = 1;
    static final int WITH_FRIEND_SCORE = 10;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static void addFriendsMap(List<List<String>> friends) {

        friendsMap = new HashMap<>();

        for (List<String> friend : friends) {

            String firstFriend = friend.get(0);
            String secondFriend = friend.get(1);

            ArrayList<String> firstFriendArr = friendsMap.getOrDefault(firstFriend, new ArrayList<>());
            ArrayList<String> secondFriendArr = friendsMap.getOrDefault(secondFriend, new ArrayList<>());

            firstFriendArr.add(secondFriend);
            secondFriendArr.add(firstFriend);

            friendsMap.put(firstFriend, firstFriendArr);
            friendsMap.put(secondFriend, secondFriendArr);
        }
    }

    static void addVisitorScore(String user, List<String> visitors) {

        userScoreMap = new HashMap<>();

        for (String visitor : visitors) {
            if(!friendsMap.get(user).contains(visitor))
                userScoreMap.put(visitor, userScoreMap.getOrDefault(visitor, 0) + VISITOR_SCORE);
        }
    }

    static void addWithFriendScore(String user, ArrayList<String> userFriendsList) {

        for (String userFriend : userFriendsList) {

            ArrayList<String> withKnowFriendsList = friendsMap.getOrDefault(userFriend, new ArrayList<>());

            for (String withKnowFriend : withKnowFriendsList) {

                if(withKnowFriend != user) {
                    userScoreMap.put(withKnowFriend, userScoreMap.getOrDefault(withKnowFriend, 0) + WITH_FRIEND_SCORE);
                }
            }


        }
    }

    static List<Map.Entry<String, Integer>> getSortedEntries() {

        List<Map.Entry<String, Integer>> entries = new LinkedList<>(userScoreMap.entrySet());

        Collections.sort(entries, Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()
                .thenComparing(Map.Entry::getKey));

        return entries;
    }
}
