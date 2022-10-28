package onboarding.problem2;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class cryptoGameTest {

    @Test
    void findDuplicate() {
        String cryptogram = "browoanoommnaon";
        String result = "brown";
        CryptoGame cryptoGame = new CryptoGame(cryptogram);
        assertThat(cryptoGame.remove()).isEqualTo(result);
    }

    @Test
    void case2() {
        String cryptogram = "zyelleyz";
        String result = "";
        CryptoGame cryptoGame = new CryptoGame(cryptogram);
        assertThat(cryptoGame.remove()).isEqualTo(result);
    }

    @Test
    void case3() {
        String cryptogram = "aaabdddc";
        String result = "bc";
        CryptoGame cryptoGame = new CryptoGame(cryptogram);
        assertThat(cryptoGame.remove()).isEqualTo(result);
    }

    @Test
    void if_not_MIN() {
        String cryptogram = "a";
        assertThrows(CryptoException.class, ()-> new CryptoGame(cryptogram));
    }
}
