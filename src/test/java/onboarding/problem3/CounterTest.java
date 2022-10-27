package onboarding.problem3;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CounterTest {

    Counter<Integer> counter;

    @BeforeEach
    public void init() {
        this.counter = new ClapCounter();
    }

    @Test
    void 현재_박수_횟수_반환_성공() throws Exception {
        Integer result = counter.getCount();

        assertThat(result).isZero();
    }

    @Test
    void 박수치면_현재_박수_횟수_증가() throws Exception {
        for(int i = 0; i < 5; i++) {
            counter.countUp();
        }
        Integer result = counter.getCount();

        assertThat(result).isEqualTo(5);
    }
}