package onboarding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

/**
 * - 사용자와 함께 아는 친구를 찾아, 해당 친구의 점수를 10점 더한다.
 * - 사용자의 타임라인에 방문한 친구를 찾아, 해당 친구의 점수를 1점 더한다.
 * - 친구들의 점수가 큰 순서대로 최대 5개까지 구하고, 그들의 이름을 결과값으로 반환한다.
 * - 만약 점수가 0이라면 결과값에 포함시키지 않는다.
 * - 만약 두 친구의 점수가 같다면 이름 순서대로 결과값에 포함시킨다.
 */
class Problem7Test {

    String user;
    List<List<String>> friends;

    @BeforeEach
    void init() {
        user = "mrko";
        friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
    }

    @Test
    @DisplayName("사용자와 함께 아는 친구를 찾는다.")
    void findMutualFriend() {
        List<String> userFriends = getUserFriends(user, friends);
        assertThat(userFriends).containsExactly("donut", "shakevan");
        List<String> mutualFriends = getMutualFriends(user, userFriends, friends);
        assertThat(mutualFriends).contains("jun", "andole");
    }

    private List<String> getMutualFriends(String user, List<String> userFriends, List<List<String>> friends) {
        Set<String> set = new HashSet<>();
        for (List<String> friend : friends) {
            if (!friend.contains(user)) {
                String a = friend.get(0), b = friend.get(1);
                if (userFriends.contains(a)) set.add(b);
                else if (userFriends.contains(b)) set.add(a);
            }
        }
        return new ArrayList<>(set);
    }

    private List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> list = new ArrayList<>();
        for (List<String> friend : friends) {
            String a = friend.get(0), b = friend.get(1);
            if (a.equals(user)) list.add(b);
            else if (b.equals(user)) list.add(a);
        }
        return list;
    }
}