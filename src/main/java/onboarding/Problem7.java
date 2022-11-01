package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> findFriend(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                result.add(friends.get(i).get(1));
            }else if (friends.get(i).get(1).equals(user)) {
                result.add(friends.get(i).get(0));
            }
        }

        return result;
    }


}
