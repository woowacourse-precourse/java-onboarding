package onboarding.problem3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Number369CounterTest {

	@Test
	void number_369_count(){
		Number369Counter number369Counter = new Number369Counter();
		Assertions.assertThat(number369Counter.getFirstCount(35)).isEqualTo(1);
		Assertions.assertThat(number369Counter.getFirstCount(50)).isEqualTo(0);
		Assertions.assertThat(number369Counter.getFirstCount(965)).isEqualTo(2);
	}
}
