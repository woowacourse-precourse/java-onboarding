package onboarding.problem3;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomIteratorTest {

    Counter<Integer> counter;
    CustomIterator<Integer> iterator;

    @BeforeEach
    public void init() {
        counter = new ClapCounter();
    }

    @Test
    void 주어진_조건에_맞춰_반복을돈다() throws Exception {
        iterator = new Iterator369(13, counter);
        iterator.iterateOnCondition();

        assertThat(counter.getCount()).isEqualTo(4);
    }
}