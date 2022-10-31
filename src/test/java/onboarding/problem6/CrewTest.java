package onboarding.problem6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CrewTest {
    @Test
    void check_the_crew_duplicate_nick() {
        Crew crew1 = new Crew(List.of("jm@email.com", "제이엠"));
        Crew crew2 = new Crew(List.of("jason@email.com", "제이슨"));
        Crew crew3 = new Crew(List.of("mj@email.com", "엠제이"));

        assertAll(() -> assertThat(crew1.isDuplicate(crew2)).isTrue(),
                () -> assertThat(crew2.isDuplicate(crew3)).isTrue());
    }
}
