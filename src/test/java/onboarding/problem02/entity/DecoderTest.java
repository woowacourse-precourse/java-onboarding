package onboarding.problem02.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import onboarding.problem02.infra.util.exception.WithoutPermitLetterException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DecoderTest {
  
  @Test
  public void decoderInitTest() throws Exception {
    Assertions.assertDoesNotThrow(() -> Decoder.form("abcd"));
  }

  @ParameterizedTest
  @ValueSource(strings = {"123", "DERE"})
  public void smallLetterExceptionTest(String str) throws Exception {
    assertThatThrownBy(() -> Decoder.form(str))
        .isInstanceOf(WithoutPermitLetterException.class);
  }

  @Test
  public void stringOutOfRangeInDecoderExceptionText() throws Exception {
    assertThatThrownBy(() -> Decoder.form(""))
        .isInstanceOf(StringIndexOutOfBoundsException.class);
  }

}
