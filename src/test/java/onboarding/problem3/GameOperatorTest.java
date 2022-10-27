package onboarding.problem3;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameOperatorTest {

    Counter<Integer> counter;
    CustomIterator<Integer> iterator;
    GameOperator gameOperator;
    
    @Test
    void 게임_진행_성공() throws Exception {
        counter = new ClapCounter();
        iterator = new Iterator369(30, counter);
        gameOperator = new GameOperator(iterator);

        gameOperator.start();
        Integer result = counter.getCount();
        assertThat(result).isEqualTo(10);
    }
}