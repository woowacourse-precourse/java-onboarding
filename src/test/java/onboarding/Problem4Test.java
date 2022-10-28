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

	@Test
	void 청개구리_사전대로_변환() {
		assertThat(Problem4.getValueFromTreeFrogDict('A')).isEqualTo('Z');
		assertThat(Problem4.getValueFromTreeFrogDict('b')).isEqualTo('y');
		assertThat(Problem4.getValueFromTreeFrogDict('z')).isEqualTo('a');
		assertThat(Problem4.getValueFromTreeFrogDict('M')).isEqualTo('N');
		assertThat(Problem4.getValueFromTreeFrogDict('n')).isEqualTo('m');
	}

	@Test
	void 알파벳인지_구분해서_변환() {
		assertThat(Problem4.changeValueFromTreeFrogDict('A')).isEqualTo('Z');
		assertThat(Problem4.changeValueFromTreeFrogDict(' ')).isEqualTo(' ');
		assertThat(Problem4.changeValueFromTreeFrogDict('[')).isEqualTo('[');
	}

	@Test
	void 올바른_입출력() {
		assertThat(Problem4.solution("    ")).isEqualTo("    ");
		assertThat(Problem4.solution("<>?:;\\\"'[]{}|-=_+!@#$%^&*()1234567890~`;"))
			.isEqualTo("<>?:;\\\"'[]{}|-=_+!@#$%^&*()1234567890~`;");
		assertThat(Problem4.solution("Hello")).isEqualTo("Svool");
	}

}