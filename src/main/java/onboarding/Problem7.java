package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static List<String> getAlreadyFriendWithUserListFromFriends(String user, List<List<String>> friends) {

        List<String> alreadyFriendList = new ArrayList<>();

        for (List<String> friend : friends) {

            if (friend.contains(user)) {
                List<String> temp = friend.stream()
                        .filter((name) -> !name.equals(user))
                        .collect(Collectors.toList());

                alreadyFriendList.addAll(temp);
            }
        }

        return alreadyFriendList;
    }
}
