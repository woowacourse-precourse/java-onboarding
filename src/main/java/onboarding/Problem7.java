package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> usersFriend = getFriends(user, friends);
        HashMap<String, Integer> FriendCountHash = getFriendCountHash(usersFriend, friends, user);
        HashMap<String, Integer> RecommendPointHash = calcRecommendPoint(visitors, FriendCountHash, usersFriend);
        System.out.println(RecommendPointHash);
        return answer;
    }
    static List<String> getFriends(String user, List<List<String>> friends) {
        List<String> usersFriend = new ArrayList<>();
        for (List<String> friend: friends) {
            if (user.equals(friend.get(0))) {
                usersFriend.add(friend.get(1));
            } else if (user.equals(friend.get(1))) {
                usersFriend.add(friend.get(0));
            }
        }
        return usersFriend;
    }
    static HashMap<String, Integer> getFriendCountHash(List<String> usersFriend, List<List<String>> friends, String user) {
        HashMap<String, Integer> FriendCountHash = new HashMap<>();
        for (String OneDepthFriend: usersFriend) {
            List<String> TwoDepthFriends = getFriends(OneDepthFriend, friends);
            for (String TwoDepthFriend: TwoDepthFriends) {
                if (TwoDepthFriend.equals(user)){
                    //pass
                } else if (FriendCountHash.containsKey(TwoDepthFriend)) {
                    FriendCountHash.put(TwoDepthFriend , FriendCountHash.get(TwoDepthFriend)+1);
                } else {
                    FriendCountHash.put(TwoDepthFriend, 1);
                }
            }
        }
        return FriendCountHash;
    }
    static HashMap<String, Integer> calcRecommendPoint(List<String> visitors, HashMap<String, Integer> FriendCountHash, List<String> usersFriend) {
        HashMap<String, Integer> RecommendPointHash = new HashMap<>();
        for (String visitor:visitors) {
            if (usersFriend.contains(visitor)){
                //pass
            } else if (RecommendPointHash.containsKey(visitor)) {
                RecommendPointHash.put(visitor , RecommendPointHash.get(visitor)+1);
            } else {
                RecommendPointHash.put(visitor, 1);
            }
        }
        for (String TwoDepthFriend:FriendCountHash.keySet()) {
            if (usersFriend.contains(TwoDepthFriend)){
                //pass
            } else if (RecommendPointHash.containsKey(TwoDepthFriend)) {
                RecommendPointHash.put(TwoDepthFriend , RecommendPointHash.get(TwoDepthFriend)+10);
            } else {
                RecommendPointHash.put(TwoDepthFriend, 10);
            }
        }
        return RecommendPointHash;
    }
}
