package onboarding.problem5;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtmTest {

    Integer[] cachTypes = {50000,10000,5000,1000,500,100,50,10,1};
    Atm atm = new WonAtm(cachTypes);

    @Test
    void 돈을_0원_넣었을때_0으로_이루어진_배열_반환() throws Exception {
        List<Integer> result = atm.exchange(0);

        assertThat(result).containsOnly(0,0,0,0,0,0,0,0,0);
    }

    @Test
    void 돈을_1원_넣었을때_1원_1개_반환() throws Exception {
        List<Integer> result = atm.exchange(1);

        assertThat(result).containsOnly(0,0,0,0,0,0,0,0,1);
    }

    @Test
    void 돈을_60원_넣었을때_50원_1개_10원_1개_반환() throws Exception {
        List<Integer> result = atm.exchange(60);

        assertThat(result).containsOnly(0,0,0,0,0,0,1,1,0);
    }

    @Test
    void 돈을_61원_넣었을때_50원_1개_10원_1개_1원_1개_반환() throws Exception {
        List<Integer> result = atm.exchange(61);

        assertThat(result).containsOnly(0,0,0,0,0,0,1,1,1);
    }

    @Test
    void 돈을_600원_넣었을때_500원_1개_100원_1개_반환() throws Exception {
        List<Integer> result = atm.exchange(600);

        assertThat(result).containsOnly(0,0,0,0,1,1,0,0,0);
    }

    @Test
    void 돈을_66661원_넣었을때_각각_1개씩_반환() throws Exception {
        List<Integer> result = atm.exchange(66661);

        assertThat(result).containsOnly(1,1,1,1,1,1,1,1,1);
    }
}