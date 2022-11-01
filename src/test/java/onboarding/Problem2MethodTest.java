package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static onboarding.Problem2.removeRepeated;
import static onboarding.Problem2.repeatedNum;
import static org.assertj.core.api.Assertions.assertThat;

public class Problem2MethodTest {

    @Test
    void reapeatedNumTest() {
        String cryptogram1 = "azzzac";
        String cryptogram2 = "zzzzzzz";
        String cryptogram3 = "zxczxc";
        assertThat(repeatedNum(cryptogram1)).isEqualTo(List.of(1, 1, 3));
        assertThat(repeatedNum(cryptogram2)).isEqualTo(List.of(1, 0, 6));
        assertThat(repeatedNum(cryptogram3)).isEqualTo(List.of(-1, -1, -1));
    }

    @Test
    void removeRepeatedTest() {
        String cryptogram1 = "azzzac";
        String cryptogram2 = "zzzzzz";
        String cryptogram3 = "zzzaaa";

        assertThat(removeRepeated(cryptogram1, 1, 3)).isEqualTo("aac");
        assertThat(removeRepeated(cryptogram2, 0, 6)).isEqualTo("");
        assertThat(removeRepeated(cryptogram3, 0, 2)).isEqualTo("aaa");
    }
}
