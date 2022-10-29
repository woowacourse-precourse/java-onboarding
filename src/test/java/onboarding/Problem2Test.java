package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Problem2Test {

	@Test
	void 입력_범위에_맞지_않는_경우() {
		assertThrows(IllegalArgumentException.class, () ->
			Problem2.solution(""));
	}

	@Test
	void 입력이_소문자가_아닌_경우() {
		assertThrows(IllegalArgumentException.class, () ->
			Problem2.solution("ABABAB"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem2.solution("DSJjdsSJD"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem2.solution("#@(@#dsa"));
	}

	@Test
	void 같은_문자_마지막_인덱스_확인() {
		assertThat(Problem2.getSameCharCount('o', "ooonmwn")).isEqualTo(3);
		assertThat(Problem2.getSameCharCount('b', "bbbbb")).isEqualTo(5);
		assertThat(Problem2.getSameCharCount('a', "abcde")).isEqualTo(1);
		assertThat(Problem2.getSameCharCount('a', "mm")).isEqualTo(0);
	}

	@Test
	void 올바른_입출력() {
		assertThat(Problem2.solution("hellooookk")).isEqualTo("he");
		assertThat(Problem2.solution("nnnnnn")).isEqualTo("");
		assertThat(Problem2.solution("llllllla")).isEqualTo("a");
		assertThat(Problem2.solution("wwwwwddddqqqqwd")).isEqualTo("wd");
		assertThat(Problem2.solution("qwerttrewq")).isEqualTo("");
		assertThat(Problem2.solution("qqqqqwwwweeeerrrr")).isEqualTo("");
		assertThat(Problem2.solution("qwqwqwqwqw")).isEqualTo("qwqwqwqwqw");
		assertThat(Problem2.solution("qqwweeq")).isEqualTo("q");
		assertThat(Problem2.solution("wrqqwweeq")).isEqualTo("wrq");
		assertThat(Problem2.solution("q")).isEqualTo("q");
	}

}