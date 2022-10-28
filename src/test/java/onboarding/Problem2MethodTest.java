package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static onboarding.Problem2.reapeatedNum;
import static org.assertj.core.api.Assertions.assertThat;

public class Problem2MethodTest {

    @Test
    void reapeatedNumTest() {
        String cryptogram1 = "azzzac";
        String cryptogram2 = "zzzzzzz";
        String cryptogram3 = "zxczxc";
        assertThat(reapeatedNum(cryptogram1)).isEqualTo(List.of(1, 1, 3));
        assertThat(reapeatedNum(cryptogram2)).isEqualTo(List.of(1, 0, 6));
        assertThat(reapeatedNum(cryptogram3)).isEqualTo(List.of(-1, -1, -1));
    }
}
