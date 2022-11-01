package onboarding.problem3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ThreeSixNineGameTest {
	@Test
	public void 박수_횟수_테스드() {
	    //given
		ThreeSixNineGame threeSixNineGame = new ThreeSixNineGame(1);
		int inputNumber = 13;
		int inputNumber2 = 369;
		int inputNumber3 = 212;
		//then
		assertThat(1).isEqualTo(threeSixNineGame.getClapCount(inputNumber));
		assertThat(3).isEqualTo(threeSixNineGame.getClapCount(inputNumber2));
		assertThat(0).isEqualTo(threeSixNineGame.getClapCount(inputNumber3));
	}

	@Test
	public void 입력값_유효성_테스트() {
		ThreeSixNineGame threeSixNineGame = new ThreeSixNineGame(1);
		ThreeSixNineGame threeSixNineGame2 = new ThreeSixNineGame(10000);
		assertThatThrownBy(() -> new ThreeSixNineGame(0))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new ThreeSixNineGame(10001))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
