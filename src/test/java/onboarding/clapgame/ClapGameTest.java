package onboarding.clapgame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClapGameTest {

	@DisplayName("손뼉을 쳐야 하는 숫자인지 판별")
	@Test
	void 숫자_판별() {
		assertThat(ClapGame.isClappedWith(13)).isTrue();
		assertThat(ClapGame.isClappedWith(33)).isTrue();
		assertThat(ClapGame.isClappedWith(0)).isFalse();
		assertThat(ClapGame.isClappedWith(1)).isFalse();
	}
}
