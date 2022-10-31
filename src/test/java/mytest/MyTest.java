package mytest;

import onboarding.Problem4;
import onboarding.Problem6;
import onboarding.Problem7;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyTest {

    @Nested
    class Problem7Test {
        @Test
        void case1() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("andole", "jun", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case2() {
            String user = "jzakka";
            List<List<String>> friends = List.of(
                    List.of("jzakka", "chung"),
                    List.of("jzakka", "sang"),
                    List.of("hwa", "ryan"),
                    List.of("tei", "chung"),
                    List.of("naokazu", "chung"),
                    List.of("shindo", "ryan"),
                    List.of("jzakka", "eru"),
                    List.of("chung", "hwa"),
                    List.of("sang", "hwa"),
                    List.of("ryan", "jzakka"),
                    List.of("shindo", "eru")
            );
            List<String> visitors = List.of("chung", "chung", "chung", "chung", "chung", "sonata","santafe","avante");
            List<String> result = List.of("hwa", "shindo", "naokazu", "tei", "avante");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }

    @Nested
    class Problem6Test {
        @Test
        void case1() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        void case2() {
            List<List<String>> forms = List.of(
                    List.of("mouse@email.com", "정상화"),
                    List.of("chung@email.com", "화상정"),
                    List.of("sanghwa@email.com", "상화정"),
                    List.of("jzakka@email.com", "작까"),
                    List.of("zheng@email.com", "쩡샹허"),
                    List.of("abnormal@email.com", "비정상")
            );
            List<String> result = List.of("abnormal@email.com", "mouse@email.com", "sanghwa@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    }

    @Nested
    class Problem4Test {
        @Test
        void case1() {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void case2() {
            String word = "You LOVE mE";
            String result = "Blf OLEV nV";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
    }
}
