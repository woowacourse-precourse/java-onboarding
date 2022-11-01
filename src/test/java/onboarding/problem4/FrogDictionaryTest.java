package onboarding.problem4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FrogDictionaryTest {
	@Test
	public void 알파벳_확인_테스트() {
		//given
		char input = 'a';
		char input2 = 'D';
		char input3 = '3';
		//then
		assertThat(FrogDictionary.isAlphabet(input)).isTrue();
		assertThat(FrogDictionary.isAlphabet(input2)).isTrue();
		assertThat(FrogDictionary.isAlphabet(input3)).isFalse();
	}
}
