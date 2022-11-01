package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> recommendedFriendList = new ArrayList<>();
        HashSet<String> socialNetwork = new HashSet<>(); // 전체 사용자들
        HashMap<String, HashSet<String>> friendsOfFriendOfUserMap = new HashMap<>(); // 친구의 친구들 저장

        // 전체 사용자들을 나타내는 social network와 친구의 친구 정보를 설정
        generateSocialNetworkInfo(user, friends, socialNetwork, friendsOfFriendOfUserMap);

        return recommendedFriendList;
    }

    public static void generateSocialNetworkInfo(String user, List<List<String>> friends, HashSet<String> socialNetwork, HashMap<String, HashSet<String>> friendsOfFriendOfUserMap) {
        socialNetwork.add(user);
        friendsOfFriendOfUserMap.put(user, new HashSet<String>());

        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);

            if (socialNetwork.contains(friendA) == false) {
                socialNetwork.add(friendA);
                friendsOfFriendOfUserMap.put(friendA, new HashSet<String>());
            }
            if (socialNetwork.contains(friendB) == false) {
                socialNetwork.add(friendB);
                friendsOfFriendOfUserMap.put(friendB, new HashSet<String>());
            }

            // 서로 친구로 추가
            friendsOfFriendOfUserMap.get(friendA).add(friendB);
            friendsOfFriendOfUserMap.get(friendB).add(friendA);
        }
    }
}
