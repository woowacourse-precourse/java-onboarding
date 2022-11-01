package onboarding.problem5.objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyUnitCounterTest {

    @Test
    @DisplayName("돈의 단위를 세어서 리스트를 반환한다.")
    void getUnitCounts() {
        // given
        int money = 14000; // 만원 1장, 천원 4장, 나머지 0
        MoneyUnitCounter counter = new MoneyUnitCounter();

        // 돈 단위 목록 인덱스 -> 편의상 한글로 진행
        int 오만원 = 0;
        int 만원 = 1;
        int 오천원 = 2;
        int 천원 = 3;
        int 오백원 = 4;
        int 백원 = 5;
        int 오십원 = 6;
        int 십원 = 7;
        int 일원 = 8;

        // when
        List<Integer> result = counter.getUnitCounts(money);

        // then
        assertAll(
                () -> assertThat(result.isEmpty()).isFalse(),
                () -> assertThat(result.get(만원).equals(1)),
                () -> assertThat(result.get(천원).equals(4))
        );

    }

}