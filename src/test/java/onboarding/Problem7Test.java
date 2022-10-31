package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem7Test {

    //    private final List<List<String>> friends = List.of(List.of("donut", "andole"), List.of("donut", "jun"), List.of("donut", "mrko"), List.of("shakevan", "andole"), List.of("shakevan", "jun"), List.of("shakevan", "mrko"));
    //    Map<String, List<String>> userToFriends = Problem7.parseFriendsInput("mrko", friends);
    //
    //    @Test
    //    void parseFriendsInput() {
    //        Assertions.assertThat(userToFriends.get("donut"))
    //            .contains("andole", "jun", "mrko");
    //        Assertions.assertThat(userToFriends.get("andole"))
    //            .contains("donut", "shakevan");
    //        Assertions.assertThat(userToFriends.get("jun"))
    //            .contains("donut", "shakevan");
    //        Assertions.assertThat(userToFriends.get("mrko"))
    //            .contains("donut", "shakevan");
    //        Assertions.assertThat(userToFriends.get("shakevan"))
    //            .contains("andole", "jun", "mrko");
    //    }
    //
    //    @Test
    //    void computeBothKnowFriendsScore() {
    //        Map<String, Integer> bothKnowFriendsCount = Problem7.computeBothKnowFriendsScore("mrko", userToFriends);
    //
    //        Assertions.assertThat(bothKnowFriendsCount.get("andole"))
    //            .isEqualTo(20);
    //        Assertions.assertThat(bothKnowFriendsCount.get("jun"))
    //            .isEqualTo(20);
    //        Assertions.assertThat(bothKnowFriendsCount.get("donut"))
    //            .isEqualTo(0);
    //        Assertions.assertThat(bothKnowFriendsCount.get("shakevan"))
    //            .isEqualTo(0);
    //    }
    //
    //    @Test
    //    void computeVisitScore() {
    //        Map<String, Integer> visitCount = Problem7.computeVisitScore(List.of("bedi", "bedi", "donut", "bedi", "shakevan"));
    //
    //        Assertions.assertThat(visitCount.get("bedi"))
    //            .isEqualTo(3);
    //        Assertions.assertThat(visitCount.get("donut"))
    //            .isEqualTo(1);
    //        Assertions.assertThat(visitCount.get("shakevan"))
    //            .isEqualTo(1);
    //    }
    //
    //    @Test
    //    void computeRecommendScore() {
    //        Map<String, Integer> bothKnowFriendsCount = Problem7.computeBothKnowFriendsScore("mrko", userToFriends);
    //        Map<String, Integer> visitCount = Problem7.computeVisitScore(List.of("bedi", "bedi", "donut", "bedi", "shakevan"));
    //        Map<String, Integer> recommendScore = Problem7.computeRecommendScore(bothKnowFriendsCount, visitCount);
    //
    //        Assertions.assertThat(recommendScore.get("donut"))
    //            .isEqualTo(1);
    //        Assertions.assertThat(recommendScore.get("andole"))
    //            .isEqualTo(20);
    //        Assertions.assertThat(recommendScore.get("jun"))
    //            .isEqualTo(20);
    //        Assertions.assertThat(recommendScore.get("shakevan"))
    //            .isEqualTo(1);
    //        Assertions.assertThat(recommendScore.get("bedi"))
    //            .isEqualTo(3);
    //    }
    //
    //    @Test
    //    void computeAnswer() {
    //        Map<String, Integer> bothKnowFriendsCount = Problem7.computeBothKnowFriendsScore("mrko", userToFriends);
    //        Map<String, Integer> visitCount = Problem7.computeVisitScore(List.of("bedi", "bedi", "donut", "bedi", "shakevan"));
    //        Map<String, Integer> recommendScore = Problem7.computeRecommendScore(bothKnowFriendsCount, visitCount);
    //
    //        List<String> answer = Problem7.computeAnswer("mrko", List.of("donut", "shakevan"), recommendScore);
    //        Assertions.assertThat(answer.size())
    //            .isEqualTo(3);
    //        Assertions.assertThat(answer.get(0))
    //            .isEqualTo("andole");
    //        Assertions.assertThat(answer.get(1))
    //            .isEqualTo("jun");
    //        Assertions.assertThat(answer.get(2))
    //            .isEqualTo("bedi");
    //    }

    @Test
    void validateUser() {
        Assertions.assertThatCode(() -> Problem7.validateUser("abc"))
            .doesNotThrowAnyException();

        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, 31)
            .forEach(i -> stringBuilder.append("a"));
        Assertions.assertThatThrownBy(() -> Problem7.validateUser(""));
        Assertions.assertThatThrownBy(() -> Problem7.validateUser("123"));
        Assertions.assertThatThrownBy(() -> Problem7.validateUser("A"));
        Assertions.assertThatThrownBy(() -> Problem7.validateUser(stringBuilder.toString()));
    }

    @Test
    void validateFriends() {
        StringBuilder size30String = new StringBuilder();
        IntStream.range(0, 30)
            .forEach(i -> size30String.append("a"));
        List<List<String>> size10001List = new ArrayList<>();
        IntStream.range(0, 10001)
            .forEach(i -> size10001List.add(List.of("abc", "def")));
        String size31String = size30String + "a";

        Assertions.assertThatCode(() -> Problem7.validateFriends(List.of(List.of("abc", "def"))))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> Problem7.validateFriends(List.of(List.of("abc", size30String.toString()))))
            .doesNotThrowAnyException();

        Assertions.assertThatThrownBy(() -> Problem7.validateFriends(List.of()));
        Assertions.assertThatThrownBy(() -> Problem7.validateFriends(size10001List));
        Assertions.assertThatThrownBy(() -> Problem7.validateFriends(List.of(List.of("abc"))));
        Assertions.assertThatThrownBy(() -> Problem7.validateFriends(List.of(List.of("abc", "def", "ghi"))));
        Assertions.assertThatThrownBy(() -> Problem7.validateFriends(List.of(List.of("abc", size31String))));
        Assertions.assertThatThrownBy(() -> Problem7.validateFriends(List.of(List.of("abc", "d1f"))));
        Assertions.assertThatThrownBy(() -> Problem7.validateFriends(List.of(List.of("Abc", "def"))));
    }

    @Test
    void validateVisitors() {
        List<String> size10001List = new ArrayList<>();
        IntStream.range(0, 10001)
            .forEach(i -> size10001List.add("abc"));
        StringBuilder size31String = new StringBuilder();
        IntStream.range(0, 31)
            .forEach(i -> size31String.append("a"));

        Assertions.assertThatCode(() -> Problem7.validateVisitors(List.of("abc")));
        Assertions.assertThatCode(() -> Problem7.validateVisitors(List.of()));

        Assertions.assertThatThrownBy(() -> Problem7.validateVisitors(size10001List));
        Assertions.assertThatThrownBy(() -> Problem7.validateVisitors(List.of("")));
        Assertions.assertThatThrownBy(() -> Problem7.validateVisitors(List.of(size31String.toString())));
        Assertions.assertThatThrownBy(() -> Problem7.validateVisitors(List.of("1a")));
        Assertions.assertThatThrownBy(() -> Problem7.validateVisitors(List.of("1A")));
        Assertions.assertThatThrownBy(() -> Problem7.validateVisitors(List.of("1")));
        Assertions.assertThatThrownBy(() -> Problem7.validateVisitors(List.of("A")));

    }

    @Test
    void 테스트케이스1() {
        List<String> solution = Problem7.solution("a", List.of(List.of("f", "g"), List.of("d", "e"), List.of("b", "c")), List.of("f", "g", "d", "e", "b", "c"));

        Assertions.assertThat(solution.size())
            .isEqualTo(5);
        Assertions.assertThat(solution.get(0))
            .isEqualTo("b");
        Assertions.assertThat(solution.get(1))
            .isEqualTo("c");
        Assertions.assertThat(solution.get(2))
            .isEqualTo("d");
        Assertions.assertThat(solution.get(3))
            .isEqualTo("e");
        Assertions.assertThat(solution.get(4))
            .isEqualTo("f");
    }
}