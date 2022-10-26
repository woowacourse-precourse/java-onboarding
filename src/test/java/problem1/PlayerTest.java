package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(List.of(123, 124));
    }

    @Test
    void 각자리의_숫자를_더하는_기능() {
        int result = player.addDigitNumber(123);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 각자리의_숫자를_곱하는_기능() {
        int result = player.multipleDigitNumber(234);
        assertThat(result).isEqualTo(24);
    }

    @Test
    void 두수중_큰수를_고르는_기능() {
        int result = player.calculateMaxNumber(123, 124);
        assertThat(result).isEqualTo(124);
    }
}
