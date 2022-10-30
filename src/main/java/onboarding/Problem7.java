package onboarding;

import java.util.*;

public class Problem7 {

    private static Set<String> friendList = new HashSet<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        return answer;
    }

    public static void findFriend(String user, List<List<String>> friends) {
        for (List<String> friendData : friends) {
            if(user.equals(friendData.get(0)) == true) {
                friendList.add(friendData.get(1));
            }
            if(user.equals(friendData.get(1)) == true) {
                friendList.add(friendData.get(0));
            }
        }
    }

}
