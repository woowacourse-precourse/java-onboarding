package onboarding.problem07.entity.wrapper;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import onboarding.problem07.infra.exception.NameLengthException;
import onboarding.problem07.infra.exception.NameNotSmallLetterCaseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

  @ParameterizedTest
  @ValueSource(strings = {"", "abaalkshdfkljhasdlkjfhaskdjfhoiu"})
  public void nameLengthExceptionTest(String name) throws Exception {
    assertThatThrownBy(() -> Name.from(name)).isInstanceOf(NameLengthException.class);
  }

  @Test
  public void nameNotSmallLetterException() throws Exception {
    assertThatThrownBy(() -> Name.from("ER")).isInstanceOf(NameNotSmallLetterCaseException.class);

  }

}
