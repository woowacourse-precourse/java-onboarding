package onboarding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import onboarding.Problem7.RelationShips;
import org.junit.jupiter.api.Test;

class Problem7Test {

    @Test
    void 사용자친구목록테스트() {
        String user = "hansu";
        List<List<String>> friends = List.of(
                List.of("hansu", "sungjoon"),
                List.of("hansu", "jiwon"),
                List.of("sungjoon", "chaemin"),
                List.of("minjae", "hansu"),
                List.of("jaewoo", "minjae"),
                List.of("hansu", "jaewoo")
        );
        RelationShips relationShips = Problem7.makeRelationShips(friends);
        List<String> result = List.of("sungjoon", "jiwon", "minjae", "jaewoo");

        assertThat(relationShips.friendsFor(user)).isEqualTo(result);
    }

    @Test
    void 함께아는친구점수테스트() {
        String user = "hansu";
        List<List<String>> friends = List.of(
                List.of("hansu", "sungjoon"),
                List.of("hansu", "jiwon"),
                List.of("sungjoon", "chaemin"),
                List.of("minjae", "hansu"),
                List.of("jaewoo", "minjae"),
                List.of("hansu", "jaewoo")
        );

        RelationShips relationShips = Problem7.makeRelationShips(friends);
        List<String> userFriends = relationShips.friendsFor(user);
        Map<String, Integer> result = new HashMap<String, Integer>();
        result.put("chaemin", 10);

        assertThat(Problem7.makeUserPointMap(relationShips, user, userFriends).value()).isEqualTo(result);

    }

    @Test
    void 타임라인포인트테스트() {
        String user = "hansu";

        List<List<String>> friends = List.of(
                List.of("hansu", "sungjoon"),
                List.of("hansu", "jiwon"),
                List.of("sungjoon", "chaemin"),
                List.of("minjae", "hansu"),
                List.of("jaewoo", "minjae"),
                List.of("hansu", "jaewoo")
        );
        RelationShips relationShips = Problem7.makeRelationShips(friends);
        List<String> userFriends = relationShips.friendsFor(user);

        List<String> visitors = List.of("hansu", "sungjoon", "sungjoon", "minjae", "jiwon", "invidam", "invidam",
                "sonny");
        Map<String, Integer> result = new HashMap<String, Integer>();
        result.put("invidam", 2);
        result.put("sonny", 1);

        assertThat(Problem7.makeUserPointMap(visitors, user, userFriends).value()).isEqualTo(result);

    }

    @Test
    void 결과테스트() {
        String user = "hansu";
        List<List<String>> friends = List.of(
                List.of("hansu", "sungjoon"),
                List.of("hansu", "jiwon"),
                List.of("sungjoon", "chaemin"),
                List.of("sungjoon", "chiho"),
                List.of("minjae", "hansu"),
                List.of("jaewoo", "minjae"),
                List.of("jaewoo", "wonbin"),
                List.of("wonbin", "minjae"),
                List.of("hansu", "jaewoo")
        );
        List<String> visitors = List.of("sungjoon", "sungjoon", "minjae", "jiwon", "invidam", "invidam", "sonny");
        List<String> result = List.of("wonbin", "chaemin", "chiho", "invidam", "sonny");

        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void 작은결과테스트() {
        String user = "hansu";
        List<List<String>> friends = List.of(
                List.of("hansu", "sungjoon"),
                List.of("hansu", "jiwon")
        );
        List<String> visitors = List.of("sungjoon", "sungjoon", "invidam", "invidam", "sonny");
        List<String> result = List.of("invidam", "sonny");

        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void 사용자아이디예외테스트() {
        String user = "hansu";
        List<List<String>> friends = List.of(
                List.of("hansu", "sungjoon"),
                List.of("hansu", "jiwon")
        );
        List<List<String>> invalidFriends = List.of(
                List.of("hansu", "sungjoon"),
                List.of("hansu", "jiw0n")
        );
        List<String> visitors = List.of("sungjoon", "sungjoon", "invidam", "invidam", "sonny");
        List<String> invalidVisitors = List.of("sungjoon123", "sungjoon", "invidam", "invidam", "sonny");
        List<String> result = List.of("invidam", "sonny");

        assertThrows(InputMismatchException.class, () -> Problem7.solution("박한수", friends, visitors));
        assertThrows(InputMismatchException.class, () -> Problem7.solution(user, invalidFriends, visitors));
        assertThrows(InputMismatchException.class, () -> Problem7.solution(user, friends, invalidVisitors));
    }

    @Test
    void 리스트길이() {
        String user = "hansu";
        List<List<String>> friends = List.of(
                List.of("hansu", "sungjoon"),
                List.of("hansu", "jiwon")
        );
        List<List<String>> invalidFriends = new ArrayList<>();
        for (int i = 0; i < 10_005; ++i) {
            invalidFriends.add(
                    List.of("hansu", "jiwon"));
        }
        List<String> visitors = List.of("sungjoon", "sungjoon", "invidam", "invidam", "sonny");
        List<String> invalidVisitors = new ArrayList<>();
        for (int i = 0; i < 10_005; ++i) {
            invalidVisitors.add("sungjoon");
        }
        List<String> result = List.of("invidam", "sonny");

        assertThrows(InputMismatchException.class, () -> Problem7.solution(user, invalidFriends, visitors));
        assertThrows(InputMismatchException.class, () -> Problem7.solution(user, Collections.emptyList(), visitors));
        assertThrows(InputMismatchException.class, () -> Problem7.solution(user, friends, invalidVisitors));
        assertThrows(InputMismatchException.class, () -> Problem7.solution(user, friends, Collections.emptyList()));
    }
}