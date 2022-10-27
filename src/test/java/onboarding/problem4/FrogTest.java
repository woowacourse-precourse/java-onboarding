package onboarding.problem4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FrogTest {

	@Test
	@DisplayName("엄마 말씀을 사전을 보고 반대로 변환한다")
	void flip_word_from_mother() {
		Frog frog = new Frog(new FrogDictionary());
		String word = "I love you 2";

		Assertions.assertThat(frog.convert(word)).isEqualTo("R olev blf 2");
	}
}
