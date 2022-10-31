package onboarding.problem01.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PageTest {

  @DisplayName("Page Init Test")
  @Test
  public void pageInitTest() throws Exception {
    Assertions.assertDoesNotThrow(() -> Page.from(100));
  }

  @DisplayName("Page의 숫자가 범위에 벗어날 경우")
  @ParameterizedTest
  @ValueSource(ints = {0, 401})
  public void pageOutOfRangeExceptionTest(int page) throws Exception {
    assertThat(Page.from(page)).isEqualTo(Page.from(-1));
  }

}
