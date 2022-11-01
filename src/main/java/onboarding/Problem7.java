package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> recommendedFriendList = new ArrayList<>();
        HashSet<String> socialNetwork = new HashSet<>(); // 전체 사용자들
        HashMap<String, HashSet<String>> friendsOfFriendOfUserMap = new HashMap<>(); // 친구의 친구들 저장
        HashMap<String, Integer> scoreInfo = new HashMap<>(); // 사용자들의 추천 점수 저장

        // 전체 사용자들을 나타내는 social network와 친구의 친구 정보를 설정
        generateSocialNetworkInfo(user, friends, socialNetwork, friendsOfFriendOfUserMap);

        // 사용자와 함께 아는 친구의 수만큼 10점을 반복해서 더해줌
        plusAcquaintanceScore(user, socialNetwork, friendsOfFriendOfUserMap, scoreInfo);

        // 사용자의 타임 라인에 방문한 횟수만큼 1점을 반복해서 더해줌
        setVisitorScore(user, friendsOfFriendOfUserMap, scoreInfo, visitors);

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

    public static void plusAcquaintanceScore(String user, HashSet<String> socialNetwork, HashMap<String, HashSet<String>> friendsOfFriendOfUserMap, HashMap<String, Integer> scoreInfo) {
        for (String name : socialNetwork) {
            if (name.equals(user)) {
                continue; // 자기 자신은 스킵
            }
            if (friendsOfFriendOfUserMap.get(user).contains(name)) {
                continue; // 이미 친구라면 스킵
            }

            friendsOfFriendOfUserMap.get(name).retainAll(friendsOfFriendOfUserMap.get(user));
            if (friendsOfFriendOfUserMap.get(name).size() > 0) {
                scoreInfo.put(name, friendsOfFriendOfUserMap.get(name).size() * 10);
            }
        }
    }

    public static void setVisitorScore(String user, HashMap<String, HashSet<String>> friendsOfFriendOfUserMap, HashMap<String, Integer> scoreInfo, List<String> visitors) {
        for (String visitor : visitors) {
            if (friendsOfFriendOfUserMap.get(user).contains(visitor)) {
                continue; // 이미 친구라면 스킵
            }
            // 없으면 0점으로 세팅 후 저장
            if (scoreInfo.containsKey(visitor) == false) {
                scoreInfo.put(visitor, 0);
            }
            scoreInfo.replace(visitor, scoreInfo.get(visitor) + 1);
        }
    }
}
