package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Set<String> friendList = generateFriendList(friends);
        List<String> relatedUserList = generateRelatedUser(friends, user);
        List<String> unknownVisitors = exceptFriend(visitors, friendList);
//        Map<String,Integer> scoreMap = generateScoreMap();
//        List<Map.Entry<String,Integer>> sortedScoreMap = sortScoreMap();
//        answer = generateRecommedList();

        return answer;
    }

    private static Set<String> generateFriendList(List<List<String>> friends) {
        Set<String> friendList = new HashSet<>();
        for (List<String> friend : friends) {
            friendList.add(friend.get(0));
        }
        return friendList;
    }

    private static List<String> generateRelatedUser(List<List<String>> friends, String user) {
        List<String> relatedUserList = new ArrayList<>();
        for (List<String> friend : friends) {
            String userName = friend.get(1);
            if (!userName.equals(user)) {
                relatedUserList.add(userName);
            }
        }
        return relatedUserList;
    }

    private static List<String> exceptFriend(List<String> visitors, Set<String> friendList) {
        for (String friend : friendList) {
            visitors = visitors.stream()
                    .filter(v -> !v.equals(friend))
                    .collect(Collectors.toList());
        }
        return visitors;
    }

//    private static Map<String,Integer> generateScoreMap(){
//        
//    }
}
