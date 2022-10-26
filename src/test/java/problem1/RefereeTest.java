package problem1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    @Test
    void 포비가_이기는경우_1() {
        Referee referee = new Referee(List.of(34, 35), List.of(3, 4));
        int result = referee.playGame();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 크롱이_이기는경우_2() {
        Referee referee = new Referee(List.of(3, 4), List.of(34, 35));
        int result = referee.playGame();
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 무승부는_0() {
        Referee referee = new Referee(List.of(3, 4), List.of(3, 4));
        int result = referee.playGame();
        assertThat(result).isEqualTo(0);
    }
}
