package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();

        Map<String, Set<String>> friendsMap = makeFriendsMap(friends);

        Map<String, Integer> recommendedScoreMap = new HashMap<>();
        for(String friend : friendsMap.keySet()) {
            recommendedScoreMap.put(friend, 0);
        }

        String[] realFriends = friendsMap.get(user).toArray(new String[0]);
        for(String friend : realFriends) {
            for(String nearFriend : friendsMap.get(friend)) {
                if (nearFriend.equals(user))
                    recommendedScoreMap.put(nearFriend, recommendedScoreMap.get(nearFriend) + 10);
            }
        }

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
}
