package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> scoreMap = new HashMap<>();
        List<String> oldFriend = new ArrayList<>();

        oldFriend = getOldFriend(user, friends);

        return answer;
    }

    private static List<String> getOldFriend(String user, List<List<String>> friends) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (friends.get(i).get(j) == user) {
                    list.add(friends.get(i).get(1-j));
                    break;
                }
            }
        }
    }
}
