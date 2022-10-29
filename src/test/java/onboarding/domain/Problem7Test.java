package onboarding.domain;

import onboarding.domain.Problem7.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.management.relation.Relation;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Problem7Test {
    private Map<String,List<String>> relationTable;
    @BeforeEach
    public void setUp() {
        relationTable = Map.of(
                "donut", List.of("andole", "jun", "mrko"),
                "andole", List.of("donut", "shakevan"),
                "jun", List.of("donut", "shakevan"),
                "shakevan", List.of("andole", "muko", "jun"),
                "mrko", List.of("donut", "shakevan")
        );
    }
    @Test
    public void countTestZero() {
        Score score = new Score(relationTable);
        assertThat(score.count("mrko","donut")).isEqualTo(0);
    }
    @Test
    public void countTestTwo() {
        Score score = new Score(relationTable);
        assertThat(score.count("mrko","jun")).isEqualTo(2);
    }
}
