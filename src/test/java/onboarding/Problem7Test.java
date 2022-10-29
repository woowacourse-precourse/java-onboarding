package onboarding;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem7Test {

    @Test
    void parseFriends() {
        List<List<String>> friends = List.of(List.of("donut", "andole"), List.of("donut", "jun"), List.of("donut", "mrko"), List.of("shakevan", "andole"), List.of("shakevan", "jun"), List.of("shakevan", "mrko"));
        Map<String, List<String>> parsedFriends = Problem7.parseFriends(friends);

        Assertions.assertThat(parsedFriends.get("donut"))
            .contains("andole", "jun", "mrko");
        Assertions.assertThat(parsedFriends.get("andole"))
            .contains("donut", "shakevan");
        Assertions.assertThat(parsedFriends.get("jun"))
            .contains("donut", "shakevan");
        Assertions.assertThat(parsedFriends.get("mrko"))
            .contains("donut", "shakevan");
        Assertions.assertThat(parsedFriends.get("shakevan"))
            .contains("andole", "jun", "mrko");
    }
}