package onboarding.problem7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FriendsTest {

    @Test
    void findAcquaintance() {
        SnsId user = new SnsId("mrko");
        SnsId andole = new SnsId("andole");
        SnsId jun = new SnsId("jun");
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );

        List<SnsId> result = List.of(andole, jun);
        Friends friends1 = new Friends(friends);

        assertThat(friends1.findAcquaintance(user)).isEqualTo(result);
    }
}