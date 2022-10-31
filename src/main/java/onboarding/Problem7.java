package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /**
     * @param user    : 문자열(기준이되는 user이름)
     * @param friends : 문자열 리스트(친구 관계 정보)
     * @return user와 친구인 사람과 친구인 user를 문자열 리스트형으로 반환
     */
    private static List<String> getFriendOfFriends(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();
        List<String> userFriends = getFriends(user, friends);
        for (String userFriend : userFriends) {
            result.addAll(getFriends(userFriend, friends));
            if (result.contains(user)) {
                result.remove(user);
            }
        }
        return result;
    }

    /**
     * @param user    : 문자열(기준이되는 user이름)
     * @param friends : 문자열 리스트(친구 관계 정보)
     * @return 친구관계에서 user와 직접적으로 친구인 문자열 리스트 반환
     */
    private static List<String> getFriends(String user, List<List<String>> friends) {
        List<List<String>> userFriends = friends.stream().filter(friend -> friend.contains(user)).collect(Collectors.toList());
        List<String> result = userFriends.stream().flatMap(Collection::stream).distinct().collect(Collectors.toList());
        result.remove(user);

        return result;
    }
}
