package onboarding;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem2Test {

	@Test
	void 범위체크() {
		assertThrows(IllegalArgumentException.class, () ->
			Problem2.solution("")
		);
	}

	@Test
	void test(){
		String words = "zyelleyz";
		Assertions.assertThat(Problem2.solution(words)).isEqualTo("");
	}
	@Test
	void 테스트케이스_추가() {
		String words = "hello";
		Assertions.assertThat(Problem2.solution(words)).isEqualTo("heo");
		words = "aaaaaa";
		Assertions.assertThat(Problem2.solution(words)).isEqualTo("");
		words = "browoanoommnaon";
		Assertions.assertThat(Problem2.solution(words)).isEqualTo("brown");
		words = "aaabbbcccddd";
		Assertions.assertThat(Problem2.solution(words)).isEqualTo("");
		words = "a";
		Assertions.assertThat(Problem2.solution(words)).isEqualTo("a");
		words = "zyelleyz";
		Assertions.assertThat(Problem2.solution(words)).isEqualTo("");
		words = "abcccddb";
		Assertions.assertThat(Problem2.solution(words)).isEqualTo("a");
		words = "ababcdcdababcdcd";
		Assertions.assertThat(Problem2.solution(words)).isEqualTo("ababcdcdababcdcd");
		words = "zyellezz";
		Assertions.assertThat(Problem2.solution(words)).isEqualTo("zy");
		words = "zyelleyzz";
		Assertions.assertThat(Problem2.solution(words)).isEqualTo("");
		words = "zzzzzzzzzzmmmmmz";
		Assertions.assertThat(Problem2.solution(words)).isEqualTo("z");
		words = "hellllleeeelo";
		Assertions.assertThat(Problem2.solution(words)).isEqualTo("hlo");
		words = "holellllleeeelo";
		Assertions.assertThat(Problem2.solution(words)).isEqualTo("h");
		words = "aabbccddeeffggghhhiiiihhh";
		Assertions.assertThat(Problem2.solution(words)).isEqualTo("");
	}
}