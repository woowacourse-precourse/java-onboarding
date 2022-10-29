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
		).isEqualTo('z');

		assertThat(
			TreeFrog.translateCode('g')
		).isEqualTo('T');

		assertThat(
			TreeFrog.translateCode('Z')
		).isEqualTo('a');
	}
}
