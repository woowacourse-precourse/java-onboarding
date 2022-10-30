package onboarding.domain;

import onboarding.domain.Problem7.Relation;
import onboarding.domain.Problem7.ScoreTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Problem7Test {
    private Relation relation;
    private List<List<String>> friends;

    @BeforeEach
    public void setUp() {
        friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );

        relation = new Relation(friends);
    }
    @Test
    public void countTestZero() {
        assertThat(relation.countAcquaintance("mrko","donut")).isEqualTo(0);
    }
    @Test
    public void countTestTwo() {
        assertThat(relation.countAcquaintance("mrko","jun")).isEqualTo(2);
    }
    @Test
    public void friendTest() {
        assertThat(relation.friendOf("mrko")).isEqualTo(List.of("donut","shakevan"));
    }
}
