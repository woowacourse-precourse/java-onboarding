package onboarding;

import java.util.*;

public class Problem7 {
    public static final int ONE_POINT = 1;
    public static final int TEN_POINT = 10;
    public static final int RECOMMEND_MAX_CNT = 5;

    static class Person {

        private final String name;
        private int point = 0;

        public Person(String name) {
            this.name = name;
        }

        public Person(String name, int point) {
            this(name);
            this.point = point;
        }

        public void plusOnePoint() {
            this.point += ONE_POINT;
        }

        public int getPoint() {
            return point;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<Person> userFriends = getUserFriends(new Person(user), friends); // 사용자의 친구

        List<Person> targetList = handleMutualFriends(user, userFriends, friends); // 사용자와 함께 아는 친구 처리
        handleVisitors(visitors, userFriends, targetList); // 방문자 처리

        sort(targetList); // point를 기준으로 내림차순 정렬

        for (Person p : targetList) {
            isValid(answer, p); // 최대 5개, point != 0, point가 같다면 이름으로 정렬
        }

        return answer;
    }

    private static List<Person> getUserFriends(Person user, List<List<String>> friends) {
        List<Person> list = new ArrayList<>();
        for (List<String> friend : friends) {
            Person a = new Person(friend.get(0)), b = new Person(friend.get(1));
            if (a.equals(user)) list.add(b);
            else if (b.equals(user)) list.add(a);
        }
        return list;
    }

    private static List<Person> handleMutualFriends(String user, List<Person> userFriends, List<List<String>> friends) {
        Set<Person> set = new HashSet<>();
        for (List<String> friend : friends) {
            if (!friend.contains(user)) {
                Person a = new Person(friend.get(0), TEN_POINT), b = new Person(friend.get(1), TEN_POINT); // 10점씩 기본 셋팅
                if (userFriends.contains(a)) set.add(b);
                else if (userFriends.contains(b)) set.add(a);
            }
        }
        return new ArrayList<>(set);
    }

    private static void handleVisitors(List<String> visitors, List<Person> userFriends, List<Person> targetList) {
        for (String friend : visitors) {
            Person p = new Person(friend, ONE_POINT);
            if (targetList.contains(p)) {
                targetList.get(targetList.indexOf(p)).plusOnePoint();
            } else if (!userFriends.contains(p)) {
                targetList.add(p);
            }
        }
    }

    private static void sort(List<Person> targetList) {
        Collections.sort(targetList, (a, b) -> {
            if (a.getPoint() == b.getPoint()) return a.getName().compareTo(b.getName());
            return Integer.compare(b.point, a.point);
        });
    }

    private static void isValid(List<String> answer, Person p) {
        if (p.getPoint() != 0 && answer.size() < RECOMMEND_MAX_CNT) {
            answer.add(p.getName());
        }
    }
}
