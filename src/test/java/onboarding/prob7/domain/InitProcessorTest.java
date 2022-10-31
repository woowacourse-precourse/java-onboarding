package onboarding.prob7.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InitProcessorTest {

    private static Stream<Arguments> argumentsStream1() {
        return Stream.of(
            Arguments.of("user=mack, tableOfFriends={{mack, jack}, {lee, liam}}",
                "mack",
                List.of(
                    List.of("mack", "jack"),
                    List.of("lee", "liam")
                ),
                Stream.of("jack").sorted().collect(Collectors.toList())
            ),
            Arguments.of("user=mack, tableOfFriends={{mack, jack}, {lee, liam}}",
                "mack",
                List.of(
                    List.of("mack", "jack"),
                    List.of("mack", "liam"),
                    List.of("mack", "lee")
                ),
                Stream.of("jack", "lee", "liam").sorted().collect(Collectors.toList())
            ),
            Arguments.of("user=mack, tableOfFriends={{mack, jack}, {lee, liam}}",
                "mack",
                List.of(
                    List.of("mack", "jack"),
                    List.of("mack", "liam"),
                    List.of("liam", "lee")
                ),
                Stream.of("jack", "liam").sorted().collect(Collectors.toList())
            )
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test1(String message, String user, List<List<String>> tableOfFriends, List<String> result) {
        InitProcessor initProcessor = new InitProcessor();
        List<String> sortedFriends = initProcessor.getSortedFriends(user, tableOfFriends);
        Assertions.assertEquals(result.size(), sortedFriends.size());
        IntStream.range(0, result.size()).forEach(i -> Assertions.assertEquals(result.get(i), sortedFriends.get(i)));
    }

    private static Stream<Arguments> argumentsStream2() {
        return Stream.of(
            Arguments.of("user=mack, tableOfFriends={{mack, jack}, {lee, liam}}, visitors={dubi}",
                "mack",
                List.of(
                    List.of("mack", "jack"),
                    List.of("lee", "liam")
                ),
                List.of("dubi"),
                Stream.of("dubi", "jack", "lee", "liam").sorted().collect(Collectors.toList())
            ),
            Arguments.of("user=mack, tableOfFriends={{mack, jack}, {lee, liam}}, visitors={dubi, totto}",
                "mack",
                List.of(
                    List.of("mack", "jack"),
                    List.of("lee", "liam")
                ),
                List.of("dubi", "totto"),
                Stream.of("dubi", "jack", "totto", "lee", "liam").sorted().collect(Collectors.toList())
            )
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream2")
    void test2(String message, String user, List<List<String>> tableOfFriends, List<String> visitors, List<String> result) {
        InitProcessor initProcessor = new InitProcessor();
        List<String> candidates = initProcessor.getSortedAllUserExceptMyself(user, tableOfFriends, visitors);
        Assertions.assertEquals(result.size(), candidates.size());
        IntStream.range(0, result.size()).forEach(i -> Assertions.assertEquals(result.get(i), candidates.get(i)));
    }

    private static Stream<Arguments> argumentsStream3() {
        return Stream.of(
            Arguments.of("user=mack, tableOfFriends={{mack, jack}, {lee, liam}}, visitors={dubi}",
                "mack",
                List.of(
                    List.of("mack", "jack"),
                    List.of("lee", "liam")
                ),
                List.of("dubi"),
                Stream.of("dubi", "lee", "liam").sorted().collect(Collectors.toList())
            ),
            Arguments.of("user=mack, tableOfFriends={{mack, jack}, {lee, liam}}, visitors={dubi, totto}",
                "mack",
                List.of(
                    List.of("mack", "jack"),
                    List.of("lee", "liam")
                ),
                List.of("dubi", "totto"),
                Stream.of("dubi", "totto", "lee", "liam").sorted().collect(Collectors.toList())
            ),
            Arguments.of("user=mack, tableOfFriends={{mack, jack}, {lee, liam}}, visitors={dubi, totto}",
                "mack",
                List.of(
                    List.of("mack", "jack"),
                    List.of("mack", "dubi"),
                    List.of("lee", "liam")
                ),
                List.of("dubi", "totto"),
                Stream.of("totto", "lee", "liam").sorted().collect(Collectors.toList())
            )
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream3")
    void test3(String message, String user, List<List<String>> tableOfFriends, List<String> visitors, List<String> result) {
        InitProcessor initProcessor = new InitProcessor();
        List<String> candidates = initProcessor.getCandidates(user, tableOfFriends, visitors);
        Assertions.assertEquals(result.size(), candidates.size());
        IntStream.range(0, result.size()).forEach(i -> Assertions.assertEquals(result.get(i), candidates.get(i)));
    }

}
