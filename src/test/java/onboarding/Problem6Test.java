package onboarding;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class Problem6Test {

    static List<List<String>> forms = List.of(
            List.of("jm@email.com", "제이엠"),
            List.of("jason@email.com", "제이슨"),
            List.of("woniee@email.com", "워니"),
            List.of("mj@email.com", "엠제이"),
            List.of("nowm@email.com", "이제엠")
    );
    static Set<String> emails = new HashSet<>();
    static Map<String, String> nameMap = new HashMap<>();

    // solution 테스트
    @Test
    void solution() {
        checkNicknames(forms);
        List<String> answer = new ArrayList<>(emails);
        answer.sort(Comparator.naturalOrder());
        System.out.println("end");
    }
}