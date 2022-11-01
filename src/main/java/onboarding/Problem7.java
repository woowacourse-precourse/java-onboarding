package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String,Integer> recommendedFriendScores =new HashMap<>();
    private static List<String> userFriendList =new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        return answer;
    }

    private static String findUserFriendId(List<String> friend, String userId) {
        String friendId1=friend.get(0);
        String friendId2=friend.get(1);

        if(friendId1.equals(userId)){
            return friendId2;
        }
        if(friendId2.equals(userId)){
            return friendId1;
        }
        return "";
    }

    private static void addFriendScore(List<String> friend){
        friend.stream()
                .forEach(friendId -> recommendedFriendScores.put(friendId, recommendedFriendScores.getOrDefault(friendId,0)+10));
    }


}
