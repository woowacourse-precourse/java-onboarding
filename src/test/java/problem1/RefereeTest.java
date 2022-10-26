package problem1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RefereeTest {

    @Test
    void 포비가_이기는경우_1() {
        Referee referee = new Referee(List.of(34, 35), List.of(3, 4));
        assertThat(referee.playGame()).isEqualTo(GameResultStatus.POBI_WIN);
    }

    @Test
    void 크롱이_이기는경우_2() {
        Referee referee = new Referee(List.of(3, 4), List.of(34, 35));
        assertThat(referee.playGame()).isEqualTo(GameResultStatus.CRONG_WIN);
    }

    @Test
    void 무승부는_0() {
        Referee referee = new Referee(List.of(3, 4), List.of(3, 4));
        assertThat(referee.playGame()).isEqualTo(GameResultStatus.DRAW);
    }

    @Test
    void 왼쪽페이지_홀수_오른쪽페이지_짝수_아니면_예외() {
        assertThatThrownBy(() -> new Referee(List.of(4, 5), List.of(3, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 입력 값 입니다.");
    }
}
