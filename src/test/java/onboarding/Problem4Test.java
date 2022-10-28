package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Problem4Test {

	@Test
	void 입력이_범위에_맞는지() {
		assertThrows(IllegalArgumentException.class, () ->
			Problem4.solution(""));
	}

	@Test
	void 알파벳인지_확인() {
		assertThat(Problem4.isAlpha('A')).isEqualTo(true);
		assertThat(Problem4.isAlpha('a')).isEqualTo(true);
		assertThat(Problem4.isAlpha('B')).isEqualTo(true);
		assertThat(Problem4.isAlpha('Z')).isEqualTo(true);
		assertThat(Problem4.isAlpha('z')).isEqualTo(true);
	}

	@Test
	void 알파벳이_아닌지_확인() {
		assertThat(Problem4.isAlpha('[')).isEqualTo(false);
		assertThat(Problem4.isAlpha('!')).isEqualTo(false);
		assertThat(Problem4.isAlpha('$')).isEqualTo(false);
	}

}