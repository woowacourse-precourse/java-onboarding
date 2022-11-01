package onboarding.problem07.entity.wrapper;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import onboarding.problem07.infra.exception.NameLengthException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

  @ParameterizedTest
  @ValueSource(strings = {"", "abaalkshdfkljhasdlkjfhaskdjfhoiu"})
  public void nameLengthExceptionTest(String name) throws Exception {

    assertThatThrownBy(() -> Name.from(name)).isInstanceOf(NameLengthException.class);

  }

}
