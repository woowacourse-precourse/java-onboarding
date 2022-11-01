package onboarding.problem2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringPatternUtilsTest {
	@Test
	public void 소문자_테스트() {
	    //given
		String input = "abc";
		String input1 = "ABC";
		String input2 = "A23BCd";
		//then
		assertThat(StringPatternUtils.isFormedLowerCase(input)).isTrue();
		assertThat(StringPatternUtils.isFormedLowerCase(input1)).isFalse();
		assertThat(StringPatternUtils.isFormedLowerCase(input2)).isFalse();
	}
}
