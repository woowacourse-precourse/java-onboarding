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
 * 4. 점수 별 정렬 기능
 * */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> recFriends = calRecFriends(user, friends, visitors);
        Map<String, Integer> sortedRecFriends = sortMapByValue(recFriends);

        return new ArrayList<>(sortedRecFriends.keySet());
    }

    private static Map<String, Integer> calRecFriends(
            String user,
            List<List<String>> friends,
            List<String> visitors)
    {
        Map<String, Integer> nonFriendAndScore = new HashMap<>();
        Set<String> myFriends = getMyFriends(user, friends);
        Map<String, Set<String>> nonFriends = getNonFriendsAndFriendList(user, friends, visitors);

        nonFriends.forEach((key, values) -> {
            int associatedScore = calAssociatedScore(values, myFriends);
            int visitorsScore = catVisitorsScore(key, visitors);
            nonFriendAndScore.computeIfAbsent(key, v -> associatedScore + visitorsScore);
        });

        return nonFriendAndScore;
    }

    private static Set<String> getMyFriends(String user, List<List<String>> friends) {
        return friends.stream()
                .filter(list -> list.contains(user))
                .map(list -> list.toArray(String[]::new))
                .flatMap(Arrays::stream)
                .filter(s -> !s.equals(user))
                .collect(Collectors.toSet());
    }

    private static Map<String, Set<String>> getNonFriendsAndFriendList(
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

    private static Set<String> getNonFriends(
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

    private static int catVisitorsScore(String nonFriend, List<String> visitors) {
        return (int) visitors.stream().filter(v -> v.equals(nonFriend)).count();
    }

    private static int calAssociatedScore(Set<String> friendsOfNonFriend, Set<String> myFriends) {
        return (int) friendsOfNonFriend.stream().filter(myFriends::contains).count() * 10;
    }

    private static Map<String, Integer> sortMapByValue(Map<String, Integer> target) {
        List<Map.Entry<String, Integer>> sortedEntryList = target.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toList());

        HashMap<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : sortedEntryList) {
            result.putIfAbsent(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
