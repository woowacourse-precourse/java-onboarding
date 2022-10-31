package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        List<String> friendList = findUserFriend(user, friends);


        return answer;
    }

    public static List<String> findUserFriend(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();

        for (List<String> target : friends) {
            if (target.get(0) == user) {
                friendList.add(target.get(1));
            }
            if (target.get(1) == user) {
                friendList.add(target.get(0));
            }
        }

        return friendList;
    }
}
