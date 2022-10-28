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

    String user;
    List<List<String>> friends;
    List<String> visitors;

    static class Person {
        String name;
        int point;

        public Person(String name) {
            this.name = name;
        }

        public Person(String name, int point) {
            this(name);
            this.point = point;
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

            Set<Person> mutualFriends = getMutualFriends(user, userFriends, friends);
            assertThat(mutualFriends).contains(new Person("jun"), new Person("andole"));
        }
    }

    @Test
    void scoreTest() {
//        assertThat(getScore(user, friends, visitors)).isEqualTo(List.of("andole", "jun", "bedi"));
    }

   /* private List<String> getScore(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> map = new HashMap<>();
        List<String> userFriends = getUserFriends(user, friends);
        Set<String> mutualFriends = getMutualFriends(user, userFriends, friends);
        for (String friend : mutualFriends) {
            map.put(friend, 10);
        }
        for (String friend : visitors) {
            map.put(friend, map.getOrDefault(friend, 0) + 1);
        }

        return null;
    }*/


    private List<Person> getUserFriends(Person user, List<List<String>> friends) {
        List<Person> list = new ArrayList<>();
        for (List<String> friend : friends) {
            Person a = new Person(friend.get(0)), b = new Person(friend.get(1));
            if (a.equals(user)) list.add(b);
            else if (b.equals(user)) list.add(a);
        }
        return list;
    }

    private Set<Person> getMutualFriends(String user, List<Person> userFriends, List<List<String>> friends) {
        Set<Person> set = new HashSet<>();
        for (List<String> friend : friends) {
            if (!friend.contains(user)) {
                Person a = new Person(friend.get(0)), b = new Person(friend.get(1));
                if (userFriends.contains(a)) set.add(b);
                else if (userFriends.contains(b)) set.add(a);
            }
        }
        return set;
    }
}