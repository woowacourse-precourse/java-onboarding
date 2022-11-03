package onboarding.clapgame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClapGameTest {

	@DisplayName("3의 배수의 숫자인지 판별")
	@Test
	void 숫자_판별() {
		assertThat(ClapUnit.isClapNumber(3)).isTrue();
		assertThat(ClapUnit.isClapNumber(0)).isFalse();
		assertThat(ClapUnit.isClapNumber(1)).isFalse();
	}

	@DisplayName("특정 숫자의 손뼉을 쳐야 하는 횟수 반환")
	@Test
	void 숫자_손뼉_횟수() {
		assertThat(
			ClapGame.countClapCount(0)
		).isEqualTo(0);

		assertThat(
			ClapGame.countClapCount(3)
		).isEqualTo(1);

		assertThat(
			ClapGame.countClapCount(13)
		).isEqualTo(1);

		assertThat(
			ClapGame.countClapCount(33)
		).isEqualTo(2);
	}

	@DisplayName("특정 숫자 범위까지의 전체 손뼉 횟수 테스트")
	@Test
	void 전체_손뼉_횟수_반환() {
		assertThat(
			ClapGame.getClapCount(33)
		).isEqualTo(14);
	}
}
