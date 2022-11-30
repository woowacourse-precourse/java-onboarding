package onboarding;

import static onboarding.enums.problem2.Init.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class Problem2Test {

	@Test
	void countSameLetter_메서드로_중복되는_알파벳_수_구하기() {
		String input = "qwertyyyy";
		Problem2.init();
		Problem2.separateLetters(input);
		assertThat(Problem2.countSameLetter(INIT_SAME_LETTER_COUNT.getInitialValueNumber(), 5)).isEqualTo(4);
	}
}
