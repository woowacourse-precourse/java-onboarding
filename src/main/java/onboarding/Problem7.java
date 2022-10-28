package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 1. 사용자 친구 목록 생성 기능
 * 2. 사용자 Non-친구 목록 생성 기능
 * 3. 친구 추천 점수 계산 기능
 *  3-1. 서로 일치하는 친구 점수 계산 기능
 *  3-2. visitors 점수 계산 기능
 * */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static Map<String, Set<String>> getNonFriendsAndFriendList(
            String user,
            List<List<String>> friends,
            List<String> visitors) {
        Map<String, Set<String>> nonFriendsAndFriendList = new HashMap<>();
        Set<String> nonFriends = getNonFriends(user, friends, visitors);

        for (String nonFriend : nonFriends) {
            nonFriendsAndFriendList.putIfAbsent(nonFriend, getMyFriends(nonFriend, friends));
        }
        return nonFriendsAndFriendList;
    }

    public static Set<String> getNonFriends(
            String user,
            List<List<String>> friends,
            List<String> visitors)
    {
        Set<String> myFriends = getMyFriends(user, friends);
        Set<String> nonFriendsWithoutVisitors = friends.stream()
                .filter(list -> !list.contains(user))
                .map(list -> list.toArray(String[]::new))
                .flatMap(Arrays::stream)
                .filter(s -> !s.equals(user) && !myFriends.contains(s))
                .collect(Collectors.toSet());
        Set<String> nonFriendsInVisitors = visitors.stream().filter(v -> !myFriends.contains(v))
                .collect(Collectors.toSet());

        nonFriendsWithoutVisitors.addAll(nonFriendsInVisitors);
        return nonFriendsWithoutVisitors;
    }

    public static Set<String> getMyFriends(String user, List<List<String>> friends) {
        return friends.stream()
                .filter(list -> list.contains(user))
                .map(list -> list.toArray(String[]::new))
                .flatMap(Arrays::stream)
                .filter(s -> !s.equals(user))
                .collect(Collectors.toSet());
    }
}
