package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class Problem6Test {

    @Test
    void nameMatchingTest() {
        String str1 = "제이엠";
        String str2 = "이엠제";
        String str3 = "제엠이";
        String str4 = "크롱";
        String str5 = "크크크크크크크크크크크롱";
        assertThat(Problem6.hasDuplicatedWords(str1, str2)).isEqualTo("제이엠");
        assertThat(Problem6.hasDuplicatedWords(str2, str3)).isNull();
        assertThat(Problem6.hasDuplicatedWords(str2, str4)).isNull();
        assertThat(Problem6.hasDuplicatedWords(str4, str5)).isEqualTo("크롱");
    }

    @Test
    void mapTest() {
        Map<String, Set<String>> map = new HashMap<>();
        map.put("제이엠", new HashSet<>());
        map.get("제이엠").add("jm@email.com");
        map.get("제이엠").add("jm@email.com");
        map.get("제이엠").add("abc@email.com");
        assertThat(map.get("제이엠").size()).isEqualTo(2);
    }

    @Test
    void sortTest() {
        // '@'가 1보다 큼
        List<String> list = Arrays.asList("hello2@email.com", "hello1@email.com", "hello@email.com");
        Collections.sort(list);
        assertThat(list).isEqualTo(Arrays.asList("hello1@email.com", "hello2@email.com", "hello@email.com"));
    }


    @Nested
    class FormsTest {
        @Test
        void case1() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            assertThat(Problem6.solution(forms)).isEqualTo(List.of("jason@email.com", "jm@email.com", "mj@email.com"));
        }

        @Test
        void case2() {
            List<List<String>> forms = List.of(
                    List.of("jason@email.com", "제이슨"),
                    List.of("hello@email.com", "토마스타이슨"),
                    List.of("hello1@email.com", "마이클마이클이클립스이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("jm@email.com", "제이엠"),
                    List.of("jm@email.com", "이엠제"),
                    List.of("nowm@email.com", "이제엠")
            );
            assertThat(Problem6.solution(forms)).isEqualTo(List.of("hello@email.com", "hello1@email.com", "jason@email.com", "jm@email.com", "mj@email.com"));
        }

        @Test
        void case3() {
            List<List<String>> forms = List.of(
                    List.of("jason@email.com", "제이슨"),
                    List.of("hello@email.com", "토마스타이슨"),
                    List.of("hello1@email.com", "마이클마이클이클립스이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("jm@email.com", "제이엠"),
                    List.of("jm@email.com", "이엠제이"),
                    List.of("xy@email.com", "크"),
                    List.of("xy@email.com", "크"),
                    List.of("xy@email.com", "크"),
                    List.of("xy@email.com", "크")
            );
            assertThat(Problem6.solution(forms)).isEqualTo(List.of("hello@email.com", "hello1@email.com", "jason@email.com", "jm@email.com", "mj@email.com"));
        }
    }
}