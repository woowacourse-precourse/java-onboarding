package onboarding;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem7Test {

    private final List<List<String>> friends = List.of(List.of("donut", "andole"), List.of("donut", "jun"), List.of("donut", "mrko"), List.of("shakevan", "andole"), List.of("shakevan", "jun"), List.of("shakevan", "mrko"));
    private final List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
    Map<String, List<String>> userToFriends = Problem7.parseFriends(friends);

    @Test
    void parseFriends() {
        Assertions.assertThat(userToFriends.get("donut"))
            .contains("andole", "jun", "mrko");
        Assertions.assertThat(userToFriends.get("andole"))
            .contains("donut", "shakevan");
        Assertions.assertThat(userToFriends.get("jun"))
            .contains("donut", "shakevan");
        Assertions.assertThat(userToFriends.get("mrko"))
            .contains("donut", "shakevan");
        Assertions.assertThat(userToFriends.get("shakevan"))
            .contains("andole", "jun", "mrko");
    }

    @Test
    void findAllUserWithoutMainCharacter() {
        List<String> allUserWithoutMainCharacter = Problem7.findAllUserWithoutMainCharacter("mrko", userToFriends, visitors);

        Assertions.assertThat(allUserWithoutMainCharacter)
            .contains("donut", "andole", "jun", "shakevan", "bedi");
    }

    @Test
    void exceptAlreadyFriends() {
        List<String> notFriends = Problem7.exceptAlreadyFriends(List.of("donut", "andole", "jun", "shakevan", "bedi"), List.of("donut", "shakevan"));

        Assertions.assertThat(notFriends)
            .contains("andole", "jun", "bedi");
    }

    @Test
    void countBothKnowFriends() {
        Map<String, Integer> bothKnowFriendsCount = Problem7.countBothKnowFriends("mrko", userToFriends);

        Assertions.assertThat(bothKnowFriendsCount.get("andole"))
            .isEqualTo(2);
        Assertions.assertThat(bothKnowFriendsCount.get("jun"))
            .isEqualTo(2);
    }

    @Test
    void countVisit() {
        Map<String, Integer> visitCount = Problem7.countVisit(List.of("bedi", "bedi", "donut", "bedi", "shakevan"));

        Assertions.assertThat(visitCount.get("bedi"))
            .isEqualTo(3);
        Assertions.assertThat(visitCount.get("donut"))
            .isEqualTo(1);
        Assertions.assertThat(visitCount.get("shakevan"))
            .isEqualTo(1);
    }
}