package onboarding.problem03.entity;

import onboarding.problem03.infra.exception.GameNumberOutOfRange;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameStationTest {

  @ParameterizedTest
  @ValueSource(ints = {0, 10001})
  public void gameNumberExceptionTest(int number) throws Exception {
    Assertions.assertThatThrownBy(() -> GameStation.from(number))
        .isInstanceOf(GameNumberOutOfRange.class);
  }

}
