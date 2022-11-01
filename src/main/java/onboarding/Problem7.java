package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = makeUserFriends(user, friends);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    //user의 친구들의 리스트를 반환
    public static List<String> makeUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            //user와 친구인 경우
            if (friend.get(0).equals(user)) {
                userFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                userFriends.add(friend.get(0));
            }
        }

        return userFriends;
    }
}
