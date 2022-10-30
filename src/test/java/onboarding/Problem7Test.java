package onboarding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class Problem7Test {

    @Test
    void 사용자목록테스트() {
        String user = "hansu";
        List<List<String>> friends = List.of(
                List.of("hansu", "sungjoon"),
                List.of("hansu", "jiwon"),
                List.of("sungjoon", "chaemin"),
                List.of("minjae", "hansu"),
                List.of("jaewoo", "minjae"),
                List.of("hansu", "jaewoo")
        );
        List<String> visitors = List.of("sungjoon", "sungjoon", "minjae", "jiwon", "invidam", "invidam", "sonny");
        Map<String, Integer> result = new HashMap<String, Integer>();
        result.put("hansu", 0);
        result.put("sungjoon", 0);
        result.put("jiwon", 0);
        result.put("chaemin", 0);
        result.put("minjae", 0);
        result.put("jaewoo", 0);
        result.put("invidam", 0);
        result.put("sonny", 0);

        assertThat(Problem7.makeUserPoints(user, friends, visitors)).isEqualTo(result);
    }

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
        Map<String, List<String>> relationShips = Problem7.makeRelationShips(friends);
        List<String> result = List.of("sungjoon", "jiwon", "minjae", "jaewoo");

        assertThat(Problem7.fillUserFriends(user, relationShips)).isEqualTo(result);
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
        Map<String, List<String>> relationShips = Problem7.makeRelationShips(friends);
        List<String> userFriends = Problem7.fillUserFriends(user, relationShips);
        Map<String, Integer> result = new HashMap<String, Integer>();
        result.put("chaemin", 10);

        assertThat(Problem7.enrichPointFrom(relationShips, user, userFriends)).isEqualTo(result);

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
        Map<String, List<String>> relationShips = Problem7.makeRelationShips(friends);
        List<String> userFriends = Problem7.fillUserFriends(user, relationShips);

        List<String> visitors = List.of("hansu", "sungjoon", "sungjoon", "minjae", "jiwon", "invidam", "invidam",
                "sonny");
        Map<String, Integer> result = new HashMap<String, Integer>();
        result.put("invidam", 2);
        result.put("sonny", 1);

        assertThat(Problem7.enrichPointFrom(visitors, user, userFriends)).isEqualTo(result);

    }


}