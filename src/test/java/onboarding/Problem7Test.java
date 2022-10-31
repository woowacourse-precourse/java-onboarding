package onboarding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class Problem7Test {

    String user;
    List<List<String>> friends;
    List<String> visitors;

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
            List<Person> userFriends = Problem7.getUserFriends(new Person(user), friends);
            assertThat(userFriends).containsExactly(new Person("donut"), new Person("shakevan"));
        }

        @Test
        @DisplayName("사용자와 함께 아는 친구를 찾는다.")
        void getMutualFriendsTest() {
            List<Person> userFriends = Problem7.getUserFriends(new Person(user), friends);
            assertThat(userFriends).containsExactly(new Person("donut"), new Person("shakevan"));

            List<Person> mutualFriends = Problem7.findMutualFriends(user, userFriends, friends);
            assertThat(mutualFriends).contains(new Person("jun"), new Person("andole"));
        }
    }
}