package onboarding.problem1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PageTest {
    @Test
    @DisplayName("페이지 방향에 맞지 않는 값")
    void validateWrongDirectionCheck(){
        //방향에 맞지 않는 값
        Assertions.assertThatThrownBy(() -> new Page(123,false))
            .isInstanceOf(IllegalStateException.class);

        //방향에 맞는 값
        new Page(100,false);
        new Page(101,true);
    }

    @Test
    @DisplayName("범위 밖의 값")
    void validateRangeCheck(){
        Assertions.assertThatThrownBy(() -> new Page(401,true))
            .isInstanceOf(IllegalStateException.class);

        Assertions.assertThatThrownBy(() -> new Page(0,false))
            .isInstanceOf(IllegalStateException.class);

        //범위 내의 값
        new Page(100,false);
    }

    @Test
    @DisplayName("페이지 합 메서드 검증")
    void validateGetPageSum(){
        Assertions.assertThat(new Page(123,true).getPageSum()).isEqualTo(6);
        Assertions.assertThat(new Page(135,true).getPageSum()).isEqualTo(9);
    }

    @Test
    @DisplayName("페이지 곱 메서드 검증")
    void validateGetPageProduct(){
        //Assertions.assertThat(new Page(123,true).getPageProduct()).isEqualTo(6);
        System.out.println(new Page(105,true).getPageProduct());
        Assertions.assertThat(new Page(105,true).getPageProduct()).isEqualTo(0);
    }

    @Test
    @DisplayName("페이지 최대값 메서드 검증")
    void validateGetMaxValue(){
        Assertions.assertThat(new Page(124,false).getMaxValue()).isEqualTo(8);
        Assertions.assertThat(new Page(105,true).getMaxValue()).isEqualTo(6);
    }
}

