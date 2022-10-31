package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> userFriendList = new ArrayList<>();
        Map<String, Integer> recommendScore = new HashMap<>();
        for (List<String> relation : friends) {
            if (relation.contains(user)) {
                addUserFriend(user, userFriendList, relation);
            }
        }
        return answer;
    }

    private static void addUserFriend(String user, List<String> userFriendList, List<String> relation) {
        for (String friend : relation) {
            if(friend != user){
                userFriendList.add(friend);
                break;
            }
        }
    }

}