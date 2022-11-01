package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    /**
     * user와 친구인 친구를 찾아 set에 저장한 후 set을 리턴한다.
     *
     * @param user    친구관계의 주인
     * @param friends 여러 친구관계를 담은 배열
     * @return user와 친구인 사람들의 set
     */
    public static Set<String> findFriends(String user, List<List<String>> friends) {
        Set<String> friendsOfUser = new HashSet<>();

        for (List<String> li : friends) {
            if (li.contains(user)) {
                Optional<String> friend = li.stream()
                        .filter(x -> !x.equals(user))
                        .findFirst();

                friend.ifPresent(friendsOfUser::add);
            }
        }
        return friendsOfUser;
    }

    /**
     * map을 value와 알파벳 순에 따라 정렬한 list를 리턴합니다.
     *
     * @param map 정렬시킬 map
     * @return 값에 따라 정렬된 list
     */
    public static List<String> getResultByValue(Map<String, Integer> map) {
        return map.keySet().stream()
                .sorted(Comparator
                        .comparing(x -> map.get(x))
                        .reversed())
                .collect(Collectors.toList());
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> friendsOfUser = findFriends(user, friends);

        Map<String, Integer> pointUser = new HashMap<>();

        for (String friend : friendsOfUser) {
            for (List<String> li : friends) {
                Optional<String> first = li.stream()
                        .filter(x -> !x.equals(user) &&
                                !x.equals(friend) &&
                                !friendsOfUser.contains(x) &&
                                li.contains(friend))
                        .findFirst();

                first.ifPresent(s -> pointUser.put(s, pointUser.getOrDefault(s, 0) + 10));
            }
        }

        Set<String> visitorSet = visitors.stream()
                .filter(x -> !friendsOfUser.contains(x) && !x.equals(user))
                .collect(Collectors.toSet());

        for (String member : visitorSet) {
            pointUser.put(member, pointUser.getOrDefault(member, 0) + 1);
        }

        return getResultByValue(pointUser);
    }
}
