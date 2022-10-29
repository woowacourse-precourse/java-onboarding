package onboarding.treefrog;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TreeFrogTest {

	@DisplayName("알파벳 사전 기반 변환 테스트")
	@Test
	void 알파벳_변환() {
		assertThat(
			TreeFrog.translateCode('A')
		).isEqualTo("Z");

		assertThat(
			TreeFrog.translateCode('g')
		).isEqualTo("t");

		assertThat(
			TreeFrog.translateCode('Z')
		).isEqualTo("A");
	}

	@DisplayName("알파벳 사전 변환 공백문자 처리 테스트")
	@Test
	void 공백문자_처리() {
		assertThat(
			TreeFrog.translateCode(' ')
		).isEqualTo(" ");

		assertThat(
			TreeFrog.translateCode('\n')
		).isEqualTo("\n");

		assertThat(
			TreeFrog.translateCode('\r')
		).isEqualTo("\r");

		assertThat(
			TreeFrog.translateCode('	')
		).isEqualTo("	");
	}
}
