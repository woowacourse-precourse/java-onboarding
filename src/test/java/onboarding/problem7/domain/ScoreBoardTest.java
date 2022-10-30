package onboarding.problem7.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class ScoreBoardTest {

    private ScoreBoard scoreBoard;

    @BeforeEach
    void setUp() {
        String user = "mrko";
        Map<String, Set<String>> friendList = new FriendList(List.of(
                List.of("pobi", "yunsik"),
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        )).allFriendList();
        List<String> visitors = List.of("andole", "jun", "bedi");
        this.scoreBoard = new ScoreBoard(user, friendList, visitors);
    }

    @ParameterizedTest(name = "미스터코의 친구 추천 규칙에 따라 점수를 부여한다.")
    @CsvSource(value = {"pobi:0", "yunsik:0", "jun:21", "bedi:1"}, delimiter = ':')
    void scoreBoard(String id, int score) {
        Map<String, Integer> scoreBoardMap = this.scoreBoard.scoreBoard();
        assertThat(scoreBoardMap.get(id)).isEqualTo(score);
    }
}
