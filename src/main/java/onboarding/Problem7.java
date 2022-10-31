package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static class User {
        String name;
        int point;

        public static User createUser(String name) {
            User user = new User();
            user.name = name;
            user.point = 0;
            return user;
        }

        @Override
        public String toString() {
            return this.getName() + ": " + this.getPoint();
        }

        public int getPoint() {
            return point;
        }

        public String getName() {
            return name;
        }

        public void onePointUp() {
            this.point++;
        }

        public void tenPointUp() {
            this.point+=10;
        }
    }

    private final static ArrayList<User> list = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        validateUserNameLength(user);
        validateFriendsSize(friends);
        validateVisitorSize(visitors);

        List<String> except = getExcept(user, friends);
        except.add(user);

        putVisitor(list, visitors, except);
        putFriends(list, friends, except);

        removeElementsFromMap(list, except);

        countVisitPoint(list, visitors);
        countNotFriendPoint(list, friends);
        System.out.println(list);

        return getAnswer(list);
    }

    private static List<String> getAnswer(List<User> list) {

        int cnt = 0;
        for (User user : list) {
            if (user.getPoint() == 0) {
                cnt++;
            }
        }

        if (cnt == list.size()) {
            return Collections.emptyList();
        }
        else {
            return list.stream()
                .filter(it -> it.getPoint() != 0)
                .sorted(
                    Comparator.comparing(User::getPoint).reversed()
                        .thenComparing(User::getName)
                )
                .map(User::getName)
                .distinct()
                .limit(5)
                .collect(Collectors.toList());
        }
    }

    private static void countNotFriendPoint(List<User> list, List<List<String>> friends) {
        for (List<String> friend : friends) {
            for (String name : friend) {
                for (User user : list) {
                    if (user.getName().equals(name)) {
                        user.tenPointUp();
                    }
                }
            }
        }
    }

    private static void countVisitPoint(List<User> list, List<String> visitors) {
        for (User user : list) {
            if (visitors.contains(user.getName())) {
                user.onePointUp();
            }
        }
    }

    private static void putFriends(List<User> list, List<List<String>> friends, List<String> bf) {
        for (List<String> friend : friends) {
            for (String name : friend) {
                if (!bf.contains(name)) {
                    list.add(User.createUser(name));
                }
            }
        }
    }

    private static void putVisitor(List<User> list, List<String> visitors, List<String> bf) {
        for (String visitor : visitors) {
            if (!bf.contains(visitor)) {
                list.add(User.createUser(visitor));
            }
        }
    }

    private static void removeElementsFromMap(List<User> list, List<String> elements) {
        for (String ele : elements) {
            while(list.contains(ele)) {
                list.remove(ele);
            }
        }
    }

    private static List<String> getExcept(String user, List<List<String>> friends) {

        List<String> bestFriend = new ArrayList<>();

        for (List<String> friend: friends) {
            if (friend.contains(user)) {

                for (String name : friend) {
                    if (!name.equals(user)) {

                        bestFriend.add(name);
                    }
                }
            }
        }

        return bestFriend;
    }

    private static void validateUserNameLength(String user) {
        int length = user.length();
        boolean isCorrectNameLength = 1 <= length && length <= 30;

        if (!isCorrectNameLength) {
            throw new IllegalArgumentException("유저 이름 크기는 1 이상 30이하 여야 합니다.");
        }
    }

    private static void validateFriendsSize(List<List<String>> friends) {
        int size = friends.size();
        boolean isCorrectListSize = 1 <= size && size <= 10_000;

        if (!isCorrectListSize) {
            throw new IllegalArgumentException("friends는 길이가 1 이상 10,000 이하 이어야 합니다.");
        }

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).size() != 2) {
                throw new IllegalArgumentException("friends의 각 원소는 길이가 2 이어야 한다.");
            }
        }
    }

    private static void validateVisitorSize(List<String> list) {
        int size = list.size();
        boolean isCorrectListSize = 1 <= size && size <= 10_000;

        if (!isCorrectListSize) {
            throw new IllegalArgumentException("길이가 1 이상 10,000 이하 여야 합니다.");
        }
    }
}
