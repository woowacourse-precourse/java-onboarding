package onboarding;

import java.util.*;

import DTO.FriendCandidate;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> userFriendListMap = getUserFriendListMap(friends);
        Map<String, FriendCandidate> friendCandidateIdInfoMap = initFriendCandidateIdInfoMap(user, userFriendListMap);
        List<FriendCandidate> friendCandidateList = calcRecommendScore(friendCandidateIdInfoMap, userFriendListMap, visitors);
        answer = getRecommendationList(friendCandidateList);

        return answer;
    }

    public static Map<String, List<String>> getUserFriendListMap(List<List<String>> friends){
        Map<String, List<String>> userFriendListMap = new HashMap<>();

        for(List<String> friend : friends){
            String user1 = friend.get(0);
            String user2 = friend.get(1);
            List<String> friendList1 = userFriendListMap.getOrDefault(user1, new ArrayList<>());
            List<String> friendList2 = userFriendListMap.getOrDefault(user2, new ArrayList<>());

            friendList1.add(user2);
            friendList2.add(user1);

            userFriendListMap.put(user1, friendList1);
            userFriendListMap.put(user2, friendList2);
        }

        return userFriendListMap;
    }

    public static Map<String, FriendCandidate> initFriendCandidateIdInfoMap(String user, Map<String, List<String>> userFriendListMap){
        Map<String, FriendCandidate> friendCandidateIdInfoMap = new HashMap<>();

        return friendCandidateIdInfoMap;
    }

    public static List<FriendCandidate> calcRecommendScore(Map<String, FriendCandidate> friendCadidateIdInfoMap, Map<String, List<String>> userFriendListMap, List<String> visitors){
        List<FriendCandidate> friendCandidateList = new ArrayList<>();

        return friendCandidateList;
    }

    public static List<String> getRecommendationList(List<FriendCandidate> friendCandidateList){
        List<String> recommendationList = new ArrayList<>();

        return recommendationList;
    }
}
