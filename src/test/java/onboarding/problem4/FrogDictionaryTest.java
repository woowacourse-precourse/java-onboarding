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

	@Test
	public void 알파벳_변환_테스트() {
	    //given
		char lowerInput = 'a';
		char lowerInput2 = 'm';
		char lowerInput3 = 'n';
		char lowerInput4 = 'z';

		char upperInput = 'A';
		char upperInput2 = 'M';
		char upperInput3 = 'N';
		char upperInput4 = 'Z';

	    //then
		assertThat(FrogDictionary.convert(lowerInput)).isEqualTo('z');
		assertThat(FrogDictionary.convert(lowerInput2)).isEqualTo('n');
		assertThat(FrogDictionary.convert(lowerInput3)).isEqualTo('m');
		assertThat(FrogDictionary.convert(lowerInput4)).isEqualTo('a');

		assertThat(FrogDictionary.convert(upperInput)).isEqualTo('Z');
		assertThat(FrogDictionary.convert(upperInput2)).isEqualTo('N');
		assertThat(FrogDictionary.convert(upperInput3)).isEqualTo('M');
		assertThat(FrogDictionary.convert(upperInput4)).isEqualTo('A');
	}
}
