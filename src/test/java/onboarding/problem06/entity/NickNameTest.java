package onboarding.problem06.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import onboarding.problem06.infra.exception.NickNameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NickNameTest {

  @ParameterizedTest
  @ValueSource(strings = {"", "가나다라마바사아자차카타파하가나다라마바사아자차카타파하"})
  public void nickNameExceptionTest(String name) throws Exception {
    assertThatThrownBy(() -> NickName.from(name)).isInstanceOf(NickNameException.class);
  }
}
