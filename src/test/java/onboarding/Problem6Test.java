package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem6Test {
    Problem6 problem = new Problem6();
    @Test
    @DisplayName("Duplicate And ASC Test")
    void printEmailTest() {
        List<String> list1 = List.of("email0", "email1", "email0");
        List<String> result1 = List.of("email0", "email1");
        assertThat(problem.printEmail(list1)).isEqualTo(result1);
        List<String> list2 = List.of("c", "b", "a");
        List<String> result2 = List.of("a", "b", "c");
        assertThat(problem.printEmail(list2)).isEqualTo(result2);
    }

    @Test
    @DisplayName("NickName Test")
    void nameTest() {
        List<List<String>> forms1 = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "nown")
        );
        boolean result1 = true;
        assertThat(Problem6.nameException(forms1)).isEqualTo(result1);
        List<List<String>> forms2 = List.of(
                List.of("jm@email.com", "제이엠제이엠제이엠제이엠제이엠제이엠제이엠제이엠제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "nown")
        );
        boolean result2 = true;
        assertThat(Problem6.nameException(forms2)).isEqualTo(result2);
    }

    @Test
    @DisplayName("Email Test")
    void emailTest() {
        List<List<String>> forms1 = List.of(
                List.of("jm@e.com", "제이엠")
        );
        boolean result1 = true;
        assertThat(Problem6.emailException(forms1)).isEqualTo(result1);
        List<List<String>> forms2 = List.of(
                List.of("jm@naver.com", "제이엠"),
                List.of("jasonnnnnnnnnn@email.com", "제이슨")
        );
        boolean result2 = true;
        assertThat(Problem6.emailException(forms2)).isEqualTo(result2);
    }
}
