package onboarding.problem3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameTest {

	@ParameterizedTest(name = "1부터 숫자까지 손뼉의 개수를 센다")
	@CsvSource(value = {"3=1", "33=14", "13=4"}, delimiter = '=')
	void count_claps(int number, int expected) {
		Game game = new Game(number);

		Assertions.assertThat(game.countClaps()).isEqualTo(expected);
	}
}
