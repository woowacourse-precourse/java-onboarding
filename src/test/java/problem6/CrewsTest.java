package problem6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CrewsTest {

    @Test
    void 여러크루들중_닉네임중복_발생하는경우_리스트반환() {
        Crews crews = new Crews(createTestInputCrews());
        List<String> emails = crews.filterDuplicateCrew();

        assertThat(emails).contains("jason@email.com", "jm@email.com", "mj@email.com");
    }

    @Test
    void 여러크루들중_닉네임중복_발생하는경우_오름차순으로_리스트반환() {
        Crews crews = new Crews(createTestInputCrews());
        List<String> emails = crews.filterDuplicateCrew();

        assertThat(emails).containsExactly("jason@email.com", "jm@email.com", "mj@email.com");
    }

    private List<List<String>> createTestInputCrews() {
        List<List<String>> crewList = new ArrayList<>();

        crewList.add(List.of("jm@email.com", "제이엠"));
        crewList.add(List.of("jason@email.com", "제이슨"));
        crewList.add(List.of("woniee@email.com", "워니"));
        crewList.add(List.of("mj@email.com", "엠제이"));
        crewList.add(List.of("nowm@email.com", "이제엠"));
        return crewList;
    }
}
