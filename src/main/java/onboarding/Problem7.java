package onboarding;

import java.util.*;

import DTO.FriendCandidate;

public class Problem7 {
    static final int FRIEND_OF_FRIEND_SCORE = 10;
    static final int VISITOR_SCORE = 1;
    static final int RECOMMEND_MAX_SIZE = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;

        Map<String, List<String>> userFriendListMap = getUserFriendListMap(friends);
        List<FriendCandidate> friendCandidateList = getFriendCandidateList(user, userFriendListMap, visitors);
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

    public static List<FriendCandidate> getFriendCandidateList(String user, Map<String, List<String>> userFriendListMap, List<String> visitors){
        Map<String, FriendCandidate> friendCandidateIdInfoMap = new HashMap<>();

        List<String> friendList = userFriendListMap.get(user);
        for(String friend : friendList){
            List<String> friendOfFriendList = userFriendListMap.get(friend);
            for(String friendOfFriend : friendOfFriendList){
                if(friendOfFriend.equals(user)) continue;
                FriendCandidate friendCandidate = friendCandidateIdInfoMap.getOrDefault(friendOfFriend, new FriendCandidate(friendOfFriend));
                friendCandidate.setScore(friendCandidate.getScore()+FRIEND_OF_FRIEND_SCORE);
                friendCandidateIdInfoMap.put(friendOfFriend, friendCandidate);
            }
        }

        for(String visitor : visitors){
            if(friendList.contains(visitor)) continue;
            FriendCandidate friendCandidate = friendCandidateIdInfoMap.getOrDefault(visitor, new FriendCandidate(visitor));
            friendCandidate.setScore(friendCandidate.getScore()+VISITOR_SCORE);
            friendCandidateIdInfoMap.put(visitor, friendCandidate);
        }

        List<FriendCandidate> friendCandidateList = new ArrayList<>(friendCandidateIdInfoMap.values());
        Collections.sort(friendCandidateList);

        return friendCandidateList;
    }

    public static List<String> getRecommendationList(List<FriendCandidate> friendCandidateList){
        List<String> recommendationList = new ArrayList<>();

        for(FriendCandidate friendCandidate : friendCandidateList){
            if(friendCandidate.getScore() > 0 && recommendationList.size()<RECOMMEND_MAX_SIZE){
                recommendationList.add(friendCandidate.getId());
            }
        }
        return recommendationList;
    }
}
