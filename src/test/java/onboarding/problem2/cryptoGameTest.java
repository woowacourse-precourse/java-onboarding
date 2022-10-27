package onboarding.problem2;

import onboarding.Problem2;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class cryptoGameTest {

        @Test
        void findDuplicate() {
            String cryptogram = "browoanoommnaon";
            String result = "brown";
            assertThat(CryptoGame.remove(cryptogram)).isEqualTo(result);
        }

        @Test
        void case2() {
            String cryptogram = "zyelleyz";
            String result = "";
            assertThat(CryptoGame.remove(cryptogram)).isEqualTo(result);
        }
        @Test
        void case3() {
            String cryptogram = "aaabdddc";
            String result = "bc";
            assertThat(CryptoGame.remove(cryptogram)).isEqualTo(result);
        }
}
