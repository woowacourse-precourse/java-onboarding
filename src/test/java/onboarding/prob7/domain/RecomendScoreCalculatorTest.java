package onboarding.prob7.domain;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RecomendScoreCalculatorTest {

    private static Stream<Arguments> argumentsStream1() {
        return Stream.of(
            Arguments.of("candidant=mack, visitors={dubi}", "mack", List.of("dubi"), 0),
            Arguments.of("candidant=mack, visitors={mack, mack}", "mack", List.of("mack", "mack"),
                2),
            Arguments.of("candidant=mack, visitors={dubi, liam, hyde}", "mack",
                List.of("dubi", "liam", "hyde"), 0)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test1(String message, String candidant, List<String> visitors, int result) {
        RecommendScoreCalculator calculator = new RecommendScoreCalculator();
        int visitScore = calculator.getVisitScore(candidant, visitors);
        Assertions.assertEquals(result, visitScore);
    }

    private static Stream<Arguments> argumentsStream2() {
        return Stream.of(
            Arguments.of(
                "candidant=mack, tableOfFriends={ {mack, jack} }, friends = {jack}, closeScore = 10",
                "mack",
                List.of(List.of("mack", "jack")),
                List.of("jack"),
                10
            ),
            Arguments.of(
                "candidant=mack, tableOfFriends={ {mack, jack}, {liam, jack}, {keta, mack} }, friends = {jack, keta}, closeScore = 20",
                "mack",
                List.of(
                    List.of("mack", "jack"),
                    List.of("liam", "jack"),
                    List.of("keta", "mack")
                ),
                List.of("jack", "keta"),
                20
            ),
            Arguments.of(
                "candidant=mack, tableOfFriends={ {donut, andole}, {donut, jun}, {donut, mrko}, {shakevan, andole}, {shakevan, jun}, {shakevan, mrko} }, friends = {jack, keta}, closeScore = 20",
                "andole",
                List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
                ),
                List.of("donut", "shakevan"),
                20
            ),
            Arguments.of(
                "candidant=mack, tableOfFriends={ {donut, andole}, {donut, jun}, {donut, mrko}, {shakevan, andole}, {shakevan, jun}, {shakevan, mrko} }, friends = {jack, keta}, closeScore = 20",
                "jun",
                List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
                ),
                List.of("donut", "shakevan"),
                20
            ),
            Arguments.of(
                "candidant=shakevan, tableOfFriends={ {donut, andole}, {donut, jun}, {donut, mrko}, {shakevan, andole}, {shakevan, jun}, {shakevan, mrko} }, friends = {jack, keta}, closeScore = 20",
                "shakevan",
                List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
                ),
                List.of("donut", "shakevan"),
                0
            )
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream2")
    void test2(String message, String candidant, List<List<String>> tableOfFriends,
        List<String> friends, int result) {
        RecommendScoreCalculator calculator = new RecommendScoreCalculator();
        int closeScore = calculator.getCloseScore(candidant, tableOfFriends, friends);
        Assertions.assertEquals(result, closeScore);
    }
}
