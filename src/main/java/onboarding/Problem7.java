package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> network = getFriendList(friends);
        Map<String, Integer> friendScoreList = getFriendScoreList(network, user);


        return answer;
    }

    //친구 목록 생성
    public static Map<String, List<String>> getFriendList(List<List<String>> friends) {
        Map<String, List<String>> network = new HashMap<>();
        for (List<String> friend : friends) {
            String f1 = friend.get(0);
            String f2 = friend.get(1);
            if (network.containsKey(f1)) {
                network.get(f1).add(f2);
            } else {
                network.put(f1, new ArrayList<>(List.of(f2)));
            }

            if (network.containsKey(f2)) {
                network.get(f1).add(f1);
            } else {
                network.put(f1, new ArrayList<>(List.of(f1)));
            }
        }
        return network;
    }

    public static Map<String, Integer> getFriendScoreList(Map<String, List<String>> network, String user) {
        List<String> userFriendList = network.get(user);
        Map<String, Integer> getFriendScoreList = new HashMap<>();

        for (String otherUser : network.keySet()) {
            if (!otherUser.equals(user)) {
                getFriendScoreList.put(otherUser, 0);
                for (String userFriend : userFriendList) {
                    for (String otherUserFriend : network.get(otherUser)) {
                        if (userFriend.equals(otherUserFriend)) {
                            getFriendScoreList.put(otherUser, getFriendScoreList.get(otherUser) + 10);
                        }
                    }
                }
            }

        }

        return getFriendScoreList;
    }
}
