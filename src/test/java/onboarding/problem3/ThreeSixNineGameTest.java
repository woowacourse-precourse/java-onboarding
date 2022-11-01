package onboarding.problem3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ThreeSixNineGameTest {
	@Test
	public void 박수_횟수_테스트() {
	    //given
		ThreeSixNineGame threeSixNineGame = new ThreeSixNineGame();
		int inputNumber = 13;
		int inputNumber2 = 369;
		int inputNumber3 = 212;
		//then
		assertThat(1).isEqualTo(threeSixNineGame.getClapCount(inputNumber));
		assertThat(3).isEqualTo(threeSixNineGame.getClapCount(inputNumber2));
		assertThat(0).isEqualTo(threeSixNineGame.getClapCount(inputNumber3));
	}
}
