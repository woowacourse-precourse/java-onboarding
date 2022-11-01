package onboarding.problem05.entity;

import static org.junit.jupiter.api.Assertions.*;

import onboarding.problem05.infra.exception.MoneyOutOfValueException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

  @ParameterizedTest
  @ValueSource(ints = {0, 1000001})
  public void moneyExceptionTest(int money) throws Exception {
    Assertions.assertThatThrownBy(() -> Money.from(money))
        .isInstanceOf(MoneyOutOfValueException.class);
  }

}
