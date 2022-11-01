package onboarding.problem6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DuplicateFinderTest {
    @Test
    void find_the_email_the_duplicate_nick() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
        DuplicateNickMemberFinder crews = new DuplicateNickMemberFinder();
        assertThat(crews.findDuplicateNick(forms)).isEqualTo(result);
    }
}
