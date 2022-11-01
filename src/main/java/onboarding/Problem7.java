package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();

        Map<String, Set<String>> friendsMap = makeFriendsMap(friends);
        Map<String, Integer> recommendedScoreMap = makeRecommendedScoreMap(friendsMap);

        giveTenPointsToNearFriends(user, friendsMap, recommendedScoreMap);
        giveOnePointToVisitors(user, visitors, friendsMap, recommendedScoreMap);

        List<Map.Entry<String, Integer>> recommendLists = makeSortedRecommendList(recommendedScoreMap);

        int maxRecommendSize = (recommendLists.size() > 5)? 5 : recommendLists.size();

        for(int i=0; i<maxRecommendSize; i++) {

            Map.Entry<String, Integer> recommended = recommendLists.get(i);
            String recommendedFriend = recommended.getKey();
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

    public static void giveOnePointToVisitors(String user, List<String> visitors, Map<String, Set<String>> friendsMap, Map<String, Integer> recommendedScoreMap) {

        for(String visitor : visitors) {
            updateRecommendScoreOfVisitor(user, visitor, friendsMap, recommendedScoreMap);
        }
    }

    public static void updateRecommendScoreOfVisitor(String user, String visitor, Map<String, Set<String>> friendsMap, Map<String, Integer> recommendedScoreMap) {


        if(!validVisitor(visitor, user, friendsMap)) return;

        if(recommendedScoreMap.containsKey(visitor)) {
            int recommendedScore = recommendedScoreMap.get(visitor);

            recommendedScoreMap.put(visitor, recommendedScore + 1);
            return;
        }

        recommendedScoreMap.put(visitor, 1);
    }

    public static boolean validVisitor(String visitor, String user, Map<String, Set<String>> friendsMap) {

        Set<String> realFriendSet = friendsMap.get(user);
        if(realFriendSet.contains(visitor))
            return false;

        if(visitor.equals(user))
            return false;

        return true;
    }

    public static List<Map.Entry<String, Integer>> makeSortedRecommendList(Map<String, Integer> recommendedScoreMap) {

        List<Map.Entry<String, Integer>> recommendList = new LinkedList<>();

        for(Map.Entry<String, Integer> recommended : recommendedScoreMap.entrySet()) {
            if(recommended.getValue() > 0)
                recommendList.add(recommended);
        }
        recommendList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        return recommendList;
    }
}
