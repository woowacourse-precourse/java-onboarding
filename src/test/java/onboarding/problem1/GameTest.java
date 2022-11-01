package onboarding.problem1;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    @DisplayName("예외 처리 테스트")
    void exceptionHandlingTest(){

        Assertions.assertThat(Game.getResult(
                Arrays.asList(11,12),
                Arrays.asList(301,401)))
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("게임 결과 검증 테스트")
    void validateGameResult(){
        //Exception
        Assertions.assertThat(Game.getResult(
                Arrays.asList(11,12),
                Arrays.asList(301,401)))
            .isEqualTo(-1);

        //Win
        Assertions.assertThat(Game.getResult(
                Arrays.asList(299,300),
                Arrays.asList(11,12)))
            .isEqualTo(1);

        //Lose
        Assertions.assertThat(Game.getResult(
                Arrays.asList(11,12),
                Arrays.asList(299,300)))
            .isEqualTo(2);

        //Draw
        Assertions.assertThat(Game.getResult(
                Arrays.asList(11,12),
                Arrays.asList(101,102)))
            .isEqualTo(0);
    }
}
