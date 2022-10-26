package onboarding;

import onboarding.problem2.Cryptogram;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Problem2Test {
    @Test
    public void findTest() {
        Cryptogram cryptogram = new Cryptogram("browoanoommnaon");
        cryptogram.remove();
        assertThat(cryptogram.toString()).isEqualTo("browoannaon");
    }
}
