package onboarding.problem5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PennyGameTest {
    @Test
    void separate_money_only_50000() {
        int money = 69543;
        Assertions.assertThat(PennyGame.start(money)).isEqualTo(List.of(1, 1, 1, 4, 1, 0, 0, 4, 3));
    }

    @Test
    void if_not_MIN_OR_MAX() {
        int lessMin = 0;
        int overMax = 1_000_001;
        assertAll(() -> assertThrows(PennyException.class, () -> PennyGame.start(lessMin)),
                () -> assertThrows(PennyException.class, () -> PennyGame.start(overMax)));
    }
}
