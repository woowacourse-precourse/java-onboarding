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
}
