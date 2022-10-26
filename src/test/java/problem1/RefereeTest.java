package problem1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RefereeTest {

    @Test
    void 포비가_이기는경우_1() {
        Referee referee = new Referee(List.of(34, 35), List.of(3, 4));
        int result = referee.playGame();
        Assertions.assertThat(result).isEqualTo(1);
    }
}
