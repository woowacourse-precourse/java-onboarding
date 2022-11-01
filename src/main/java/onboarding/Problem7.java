package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Set<String>> friendsMap = makeFriendsMap(friends);

        Map<String, Integer> recommendedScoreMap = makeRecommendedScoreMap(friendsMap);

        giveTenPointsToNearFriends(user, friendsMap, recommendedScoreMap);

        for(String visitor : visitors) {
            if(visitor.equals(user) || friendsMap.get(user).contains(visitor))
                continue;

            if(recommendedScoreMap.containsKey(visitor))
                recommendedScoreMap.put(visitor, recommendedScoreMap.get(visitor) + 1);
            else {
                recommendedScoreMap.put(visitor, 1);

            }
        }

        List<Map.Entry<String, Integer>> recommendList = new LinkedList<>(recommendedScoreMap.entrySet());
        recommendList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));


        List<String> answer = new ArrayList<>();

        for(int i=0; i<recommendList.size(); i++) {
            if(i == 5) break;
            String recommendedFriend = recommendList.get(i).getKey();
            if(recommendList.get(i).getValue() == 0) break;
            answer.add(recommendedFriend);
        }

        return answer;
    }

    public static HashMap<String, Set<String>> makeFriendsMap(List<List<String>> friends) {

        HashMap<String, Set<String>> friendsMap = new HashMap<>();

        for(List<String> friend : friends) {
            String friendOne = friend.get(0);
            String friendTwo = friend.get(1);

            addFriendIntoFriendsMap(friendOne, friendTwo, friendsMap);
            addFriendIntoFriendsMap(friendTwo, friendOne, friendsMap);
        }

        return friendsMap;
    }

    public static void addFriendIntoFriendsMap(String friendOne, String friendTwo, HashMap<String, Set<String>> friendsMap) {

        if(friendsMap.containsKey(friendOne)) {
            makeConnectionBetweenFriends(friendOne, friendTwo, friendsMap);
            return;
        }

        friendsMap.put(friendOne, new HashSet<>());
        makeConnectionBetweenFriends(friendOne, friendTwo, friendsMap);
    }

    public static void makeConnectionBetweenFriends(String friendOne, String friendTwo, HashMap<String, Set<String>> friendsMap) {
        Set<String> friendsSet = friendsMap.get(friendOne);
        friendsSet.add(friendTwo);
    }

    public static Map<String, Integer> makeRecommendedScoreMap(Map<String, Set<String>> friendsMap) {

        Map<String, Integer> recommendedScoreMap = new HashMap<>();

        for(String friend : friendsMap.keySet()) {
            recommendedScoreMap.put(friend, 0);
        }

        return recommendedScoreMap;
    }

    public static void giveTenPointsToNearFriends(String user, Map<String, Set<String>> friendsMap, Map<String, Integer> recommendedScoreMap) {

        Set<String> realFriendSet = friendsMap.get(user);
        String[] realFriendsList = realFriendSet.toArray(new String[0]);

        for(String realFriend : realFriendsList) {
            Set<String> nearFriendSet = friendsMap.get(realFriend);

            updateRecommendScoreOfNearFriend(user, nearFriendSet, recommendedScoreMap);
        }
    }

    public static void updateRecommendScoreOfNearFriend(String user, Set<String> nearFriendSet, Map<String, Integer> recommendedScoreMap) {

        for(String nearFriend : nearFriendSet)
            scoreIfNearFriend(user, nearFriend, recommendedScoreMap);
    }

    public static void scoreIfNearFriend(String user, String nearFriend, Map<String, Integer> recommendedScoreMap) {

        if (!nearFriend.equals(user)) {
            int recommendedScore = recommendedScoreMap.get(nearFriend);

            recommendedScoreMap.put(nearFriend, recommendedScore + 10);
        }
    }
}
