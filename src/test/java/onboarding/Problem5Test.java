package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    @Test
    public void 화폐단위로분류() throws Exception {
        //given
        int money = 10_031;
        Map<Integer,Integer> store = new HashMap<>(Map.of(
                50000, 0,
                10000, 0,
                5000, 0,
                1000, 0,
                500, 0,
                100, 0,
                50, 0,
                10, 0,
                1, 0
        ));

        //when
        int leftMoney = Problem5.extractUnits(money, 10000, store);

        //then
        Assertions.assertThat(leftMoney).isEqualTo(31);
    }

    @Test
    public void 맵values리스트반환() throws Exception {
        //given
        Map<Integer,Integer> store = new HashMap<>(Map.of(
                50000, 1,
                10000, 2,
                5000, 3,
                1000, 4,
                500, 5,
                100, 6,
                50, 7,
                10, 8,
                1, 9
        ));

        //when
        List<Integer> valuesList = Problem5.valuesToList(store);

        //then
        Assertions.assertThat(valuesList).isEqualTo(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }
}