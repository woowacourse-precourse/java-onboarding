package onboarding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

/**
 * - 사용자와 함께 아는 친구를 찾아, 해당 친구의 점수를 10점 더한다.
 * - 사용자의 타임라인에 방문한 친구를 찾아, 해당 친구의 점수를 1점 더한다.
 * - 친구들의 점수가 큰 순서대로 최대 5개까지 구하고, 그들의 이름을 결과값으로 반환한다.
 * - 만약 점수가 0이라면 결과값에 포함시키지 않는다.
 * - 만약 두 친구의 점수가 같다면 이름 순서대로 결과값에 포함시킨다.
 */
class Problem7Test {
    public static final int ONE_POINT = 1;
    public static final int TEN_POINT = 10;
    public static final int RECOMMEND_MAX_CNT = 5;

    String user;
    List<List<String>> friends;
    List<String> visitors;

    static class Person {


        private String name;
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

    @BeforeEach
    void init() {
        user = "mrko";
        friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
    }

    @Nested
    class FindFriends {

        @Test
        @DisplayName("사용자의 친구를 찾는다.")
        void getUserFriendsTest() {
            List<Person> userFriends = getUserFriends(new Person(user), friends);
            assertThat(userFriends).containsExactly(new Person("donut"), new Person("shakevan"));
        }

        @Test
        @DisplayName("사용자와 함께 아는 친구를 찾는다.")
        void getMutualFriendsTest() {
            List<Person> userFriends = getUserFriends(new Person(user), friends);
            assertThat(userFriends).containsExactly(new Person("donut"), new Person("shakevan"));

            List<Person> mutualFriends = handleMutualFriends(user, userFriends, friends);
            assertThat(mutualFriends).contains(new Person("jun"), new Person("andole"));
        }

        @Test
        void scoreTest() {
            List<String> answer = new ArrayList<>();
            List<Person> userFriends = getUserFriends(new Person(user), friends); // 사용자의 친구

            List<Person> targetList = handleMutualFriends(user, userFriends, friends); // 사용자와 함께 아는 친구 처리
            handleVisitors(visitors, userFriends, targetList); // 방문자 처리

            sort(targetList); // point를 기준으로 내림차순 정렬

            for (Person p : targetList) {
                isValid(answer, p); // 최대 5개, point != 0, point가 같다면 이름으로 정렬
            }
            assertThat(answer).isEqualTo(List.of("andole", "jun", "bedi"));
        }
    }

    private List<Person> getUserFriends(Person user, List<List<String>> friends) {
        List<Person> list = new ArrayList<>();
        for (List<String> friend : friends) {
            Person a = new Person(friend.get(0)), b = new Person(friend.get(1));
            if (a.equals(user)) list.add(b);
            else if (b.equals(user)) list.add(a);
        }
        return list;
    }

    private List<Person> handleMutualFriends(String user, List<Person> userFriends, List<List<String>> friends) {
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

    private void handleVisitors(List<String> visitors, List<Person> userFriends, List<Person> targetList) {
        for (String friend : visitors) {
            Person p = new Person(friend, ONE_POINT);
            if (targetList.contains(p)) {
                targetList.get(targetList.indexOf(p)).plusOnePoint();
            } else if (!userFriends.contains(p)) {
                targetList.add(p);
            }
        }
    }

    private void sort(List<Person> targetList) {
        Collections.sort(targetList, (a, b) -> {
            if (a.getPoint() == b.getPoint()) return a.getName().compareTo(b.getName());
            return Integer.compare(b.point, a.point);
        });
    }

    private void isValid(List<String> answer, Person p) {
        if (p.getPoint() != 0 && answer.size() < RECOMMEND_MAX_CNT) {
            answer.add(p.getName());
        }
    }
}