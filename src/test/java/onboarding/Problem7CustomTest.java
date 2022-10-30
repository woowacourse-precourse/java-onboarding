package onboarding;

import onboarding.problem7.Problem7Validation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem7CustomTest {
    /*
     *   문자열 길이 관련 테스트는 이미 overriding하여 작성하여 다른 테스트 코드들로
     *   확인 했으니, 배열의 길이가 맞는 테스트 코드, 소문자를 확인하는 테스트 코드만 작성한다.
     */

    private static final int MIN_INPUT = 1;
    private static final int MAX_INPUT = 30;


    @Nested
    class Problem7Test {

        @Test
        void 리스트의길이를만족하지않는경우() {
            List<String> zeroLengthList = new ArrayList<>();
            boolean impossible = Problem7Validation.problem7Validation("m", Collections.emptyList(), List.of("m"));
            assertThat(impossible).isFalse();
        }

        @Test
        void 리스트의길이를만족하는경우() {
            List<List<String>> possibleList = new ArrayList<>(List.of(List.of("a","b")));
            boolean possible = Problem7Validation.problem7Validation("m", possibleList, List.of("m"));
            assertThat(possible).isTrue();
        }

        @Test
        void 소문자가아닌경우() {
            List<List<String>> possibleList = new ArrayList<>(List.of(List.of("a","b")));
            boolean impossible = Problem7Validation.problem7Validation("M", possibleList, List.of("m"));
            assertThat(impossible).isFalse();
        }

        @Test
        void 소문자만있는경우() {
            List<List<String>> possibleList = new ArrayList<>(List.of(List.of("a","b")));
            boolean possible = Problem7Validation.problem7Validation("m", possibleList, List.of("m"));
            assertThat(possible).isTrue();
        }
    }
}
