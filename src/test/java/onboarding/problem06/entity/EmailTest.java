package onboarding.problem06.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import onboarding.problem06.infra.exception.EmailFormatException;
import onboarding.problem06.infra.exception.EmailLengthException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EmailTest {

  @ParameterizedTest
  @ValueSource(strings = {"@email.com", "abcdefghij@email.com"})
  public void emailLengthExceptionTest(String email) throws Exception {
    assertThatThrownBy(() -> Email.from(email)).isInstanceOf(EmailLengthException.class);
  }

  @Test
  public void emailFormatExceptionTest() throws Exception {
    assertThatThrownBy(() -> Email.from("abcd@abc.com")).isInstanceOf(EmailFormatException.class);
  }

}
