package onboarding;

import static onboarding.Problem4.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Problem4Test {

	@Test
	void reverseWord_메서드로_소문자_알파벳_반대로_만들기() {
		init();
		makeFrogDictionary();
		separateLetter("a");
		assertThat(reverseWord()).isEqualTo("z");
	}

	@Test
	void reverseWord_메서드로_대문자_알파벳_반대로_만들기() {
		init();
		makeFrogDictionary();
		separateLetter("A");
		assertThat(reverseWord()).isEqualTo("Z");
	}
}
