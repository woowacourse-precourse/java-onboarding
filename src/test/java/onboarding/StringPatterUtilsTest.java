package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringPatterUtilsTest {
	@Test
	public void 소문자_테스트() {
	    //given
		String input = "abc";
		String input1 = "ABC";
		String input2 = "A23BCd";
		//then
		assertThat(StringPatterUtils.isFormedLowerCase(input)).isTrue();
		assertThat(StringPatterUtils.isFormedLowerCase(input1)).isFalse();
		assertThat(StringPatterUtils.isFormedLowerCase(input2)).isFalse();
	}
}
