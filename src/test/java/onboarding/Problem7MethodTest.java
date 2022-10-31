package onboarding;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static onboarding.Problem7.getFriendsOfUser;
import static org.assertj.core.api.Assertions.assertThat;

class Problem7MethodTest {

    @Test
    void getFriendsOfUserTest() {
        String user1 = "mrko";
        List<List<String>> friends1 = new ArrayList<>(List.of());
        friends1.add(List.of("donut", "andole"));
        friends1.add(List.of("donut", "jun"));
        friends1.add(List.of("donut", "mrko"));
        friends1.add(List.of("shakevan", "andole"));
        friends1.add(List.of("shakeven", "jun"));
        friends1.add(List.of("shakevan", "mrko"));

        List<String> result1 = getFriendsOfUser(user1, friends1);

        assertThat(result1).isEqualTo(List.of("donut", "shakevan"));
    }
}