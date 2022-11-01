package onboarding.problem7.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


public class FriendListTest {

    private FriendList friendList;

    @BeforeEach
    void setUp() {
        this.friendList = new FriendList(List.of(
                List.of("pobi", "yunsik"),
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        ));
    }

    @Test
    void create() {
        assertThat(this.friendList).isEqualTo(new FriendList(List.of(
                List.of("pobi", "yunsik"),
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        )));
    }

    private static Stream<Arguments> provideForFindById() {
        return Stream.of(
                Arguments.of("null", Set.of()),
                Arguments.of("pobi", Set.of("yunsik")),
                Arguments.of("donut", Set.of("andole", "jun", "mrko")),
                Arguments.of("shakevan", Set.of("andole", "jun", "mrko")),
                Arguments.of("jun", Set.of("donut", "shakevan"))
        );
    }

    @ParameterizedTest(name = "아이디로 친구 목록을 가져오기")
    @MethodSource("provideForFindById")
    void find_by_id(String id, Set<String> idList) {
        assertThat(this.friendList.friendList(id)).containsAll(idList);
    }
}
