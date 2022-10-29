package onboarding.problem5.objects;

import onboarding.problem4.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyValidationTest {

    @Test
    @DisplayName("Money 가 유효하면 인스턴스 생성 성공한다.")
    void MoneyValidation_success() {
        // given
        int money = 10000;

        // when
        MoneyValidation validation = new MoneyValidation(money);

        // then
        assertThat(validation).isNotNull();
    }

    @Test
    @DisplayName("Money 가 유효하지 않으면 인스턴스 생성 시 예외가 발생한다.")
    void MoneyValidation_fail() {
        // given
        int money = 1111111111;

        // when && then
        assertThatThrownBy(() -> new MoneyValidation(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Money is Not Valid!!!");
    }
}