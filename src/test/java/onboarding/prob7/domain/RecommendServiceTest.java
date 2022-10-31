package onboarding.prob7.domain;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RecommendServiceTest {

    private static Stream<Arguments> argumentsStream1() {
        DummyUser user1 = new DummyUser();
        PriorityQueue<User> queue1 = user1.getNumberOfUser(10);
        List<String> ret1 = user1.top5();
        DummyUser user2 = new DummyUser();
        PriorityQueue<User> queue2 = user2.getNumberOfUser(100);
        List<String> ret2 = user2.top5();
        return Stream.of(
            Arguments.of("랜덤 테스트1", queue1, ret1),
            Arguments.of("렌덤 테스트2", queue2, ret2)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test1(String message, PriorityQueue<User> candidatantPriorityQueue, List<String> result) {
        RecommendService service = new RecommendService("name", Collections.EMPTY_LIST, Collections.EMPTY_LIST);
        List<String> candidates = service.pickFive(candidatantPriorityQueue);
        Assertions.assertEquals(result.size(), candidates.size());
        IntStream.range(0, result.size()).forEach(i -> Assertions.assertEquals(result.get(i), candidates.get(i)));
    }

}
