package onboarding;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem7Test {

    private final List<List<String>> friends = List.of(List.of("donut", "andole"), List.of("donut", "jun"), List.of("donut", "mrko"), List.of("shakevan", "andole"), List.of("shakevan", "jun"), List.of("shakevan", "mrko"));
    private final List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

    @Test
    void parseFriends() {
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

    @Test
    void findAllUserWithoutMainCharacter() {
        Map<String, List<String>> parsedFriends = Problem7.parseFriends(friends);
        List<String> allUserWithoutMainCharacter = Problem7.findAllUserWithoutMainCharacter("mrko", parsedFriends, visitors);

        Assertions.assertThat(allUserWithoutMainCharacter)
            .contains("donut", "andole", "jun", "shakevan", "bedi");
    }

    //    @Test
    //    void exceptAlreadyFriends() {
    //        List<String> exceptAlreadyFriends = Problem7.exceptAlreadyFriends("mrko", List.of("donut", "shakevan"));
    //
    //        Assertions.assertThat(exceptAlreadyFriends).contains()
    //    }

}