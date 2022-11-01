package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, Integer> recommendedScoreMap = new HashMap<>();
        Map<String, Set<String>> userFriendsMap = new HashMap<>();

        for(List<String> friend : friends) {
            String friendOne = friend.get(0);
            String friendTwo = friend.get(1);

            if(userFriendsMap.containsKey(friendOne))
                userFriendsMap.get(friendOne).add(friendTwo);
            else {
                userFriendsMap.put(friendOne, new HashSet<>());
                userFriendsMap.get(friendOne).add(friendTwo);
            }

            if(userFriendsMap.containsKey(friendTwo))
                userFriendsMap.get(friendTwo).add(friendOne);
            else {
                userFriendsMap.put(friendTwo, new HashSet<>());
                userFriendsMap.get(friendTwo).add(friendOne);
            }

        }

        for(String friend : userFriendsMap.keySet()) {
            recommendedScoreMap.put(friend, 0);
        }

        String[] realFriends = userFriendsMap.get(user).toArray(new String[0]);
        for(String friend : realFriends) {
            for(String nearFriend : userFriendsMap.get(friend)) {
                if (nearFriend.equals(user))
                    recommendedScoreMap.put(nearFriend, recommendedScoreMap.get(nearFriend) + 10);
            }
        }

        for(String visitor : visitors) {
            if(visitor.equals(user) || userFriendsMap.get(user).contains(visitor))
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
}
