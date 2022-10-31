package onboarding.problem6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CrewTest {
    @Test
    void check_the_crew_duplicate_nick() {
        Member crew1 = new Member(List.of("jm@email.com", "제이엠"));
        Member crew2 = new Member(List.of("jason@email.com", "제이슨"));
        Member crew3 = new Member(List.of("mj@email.com", "엠제이"));

        assertAll(() -> assertThat(crew1.isDuplicate(crew2)).isTrue(),
                () -> assertThat(crew2.isDuplicate(crew3)).isTrue());
    }
}
