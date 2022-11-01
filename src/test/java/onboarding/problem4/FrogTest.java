package onboarding.problem4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class FrogTest {
	@Test
	public void 입력_문자열_예외처리_테스트() {
	    //given
		String word = "I Love You";
		Frog frog = new Frog(word);

		String word2 = "";
		assertThatThrownBy(() -> new Frog(word2))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
