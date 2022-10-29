package onboarding.problem1.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PageTest {

    @Test
    void create() {
        Page actual = new Page(3, 4);

        assertThat(actual).isEqualTo(new Page(3, 4));
    }

    @DisplayName("오른쪽 페이지 번호에서 왼쪽 페이지 번호를 뺀 값이 1이 아니면 IllegalArgumentException 에외를 throw 한다.")
    @Test
    void valid_sequence() {
        assertThatThrownBy(() -> new Page(99, 102)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 이하혹은 400이상의 숫자가 포함되면 IllegalArgumentException 예외를 throw 한다.")
    @Test
    void valid_page_bound() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new Page(1, 2)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Page(399, 400)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
