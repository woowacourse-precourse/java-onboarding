package onboarding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import onboarding.Problem7.UserPoint;
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

        assertThat(Problem7.getPointFrom(relationShips, user, userFriends)).isEqualTo(result);

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

        assertThat(Problem7.getPointFrom(visitors, user, userFriends)).isEqualTo(result);

    }

    @Test
    void 결과정렬테스트() {
        List<UserPoint> list = new ArrayList<>();

        list.add(new UserPoint("ahansu", 1));
        list.add(new UserPoint("chansu", 1));
        list.add(new UserPoint("sungjoon", 20));
        list.add(new UserPoint("minji", -3));
        list.add(new UserPoint("faker", 5));
        list.add(new UserPoint("chovy", 40));
        list.add(new UserPoint("invidam", 7));

        List<UserPoint> result = new ArrayList<>();

        result.add(new UserPoint("chovy", 40));
        result.add(new UserPoint("sungjoon", 20));
        result.add(new UserPoint("invidam", 7));
        result.add(new UserPoint("faker", 5));
        result.add(new UserPoint("ahansu", 1));
        result.add(new UserPoint("chansu", 1));
        result.add(new UserPoint("minji", -3));

        Problem7.sortUserPoints(list);

        assertThat(list).isEqualTo(result);

    }

}