package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static final int ONE_POINT = 1;
    public static final int TEN_POINT = 10;
    public static final int RECOMMEND_MAX_CNT = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<Person> userFriends = getUserFriends(new Person(user), friends); // 사용자의 친구
        List<Person> targetList = findMutualFriends(user, userFriends, friends); // 사용자와 함께 아는 친구를 뽑아냄
        handleVisitors(visitors, userFriends, targetList); // 방문자 처리
        sort(targetList); // point를 기준으로 내림차순 정렬
        return getValidAnswer(targetList);
    }

    protected static List<Person> getUserFriends(Person user, List<List<String>> friends) {
        List<Person> list = new ArrayList<>();
        for (List<String> friend : friends) {
            addUserFriend(list, user, friend);
        }
        return list;
    }

    private static void addUserFriend(List<Person> list, Person user, List<String> friend) {
        Person a = new Person(friend.get(0)), b = new Person(friend.get(1));
        if (a.equals(user)) list.add(b);
        else if (b.equals(user)) list.add(a);
    }

    protected static List<Person> findMutualFriends(String user, List<Person> userFriends, List<List<String>> friends) {
        Set<Person> set = new HashSet<>();
        for (List<String> friend : friends) {
            if (friend.contains(user)) continue;
            getMutualFriend(set, userFriends, friend);
        }
        return new ArrayList<>(set);
    }

    private static void getMutualFriend(Set<Person> set, List<Person> userFriends, List<String> friend) {
        Person a = new Person(friend.get(0), TEN_POINT), b = new Person(friend.get(1), TEN_POINT); // 10점씩 기본 셋팅
        if (userFriends.contains(a)) set.add(b);
        else if (userFriends.contains(b)) set.add(a);
    }

    protected static void handleVisitors(List<String> visitors, List<Person> userFriends, List<Person> targetList) {
        for (String friend : visitors) {
            addVisitors(targetList, userFriends, new Person(friend, ONE_POINT));
        }
    }

    private static void addVisitors(List<Person> targetList, List<Person> userFriends, Person visitor) {
        if (targetList.contains(visitor)) {
            targetList.get(targetList.indexOf(visitor)).plusOnePoint();
        } else if (!userFriends.contains(visitor)) {
            targetList.add(visitor);
        }
    }

    private static void sort(List<Person> targetList) {
        Collections.sort(targetList, (a, b) -> {
            if (a.getPoint() == b.getPoint()) return a.getName().compareTo(b.getName());
            return Integer.compare(b.getPoint(), a.getPoint());
        });
    }

    private static List<String> getValidAnswer(List<Person> people) {
        return people.stream()
                .filter(p -> p.getPoint() != 0)
                .map(Person::getName)
                .limit(RECOMMEND_MAX_CNT)
                .collect(Collectors.toList());
    }
}
