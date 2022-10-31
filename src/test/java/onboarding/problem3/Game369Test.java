package onboarding.problem3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Game369Test {

	@Test
	void game_369(){
		Game369 game369 = new Game369();
		Assertions.assertThat(game369.getCount(6)).isEqualTo(2);
		Assertions.assertThat(game369.getCount(8)).isEqualTo(2);

		Assertions.assertThat(game369.getCount(36)).isEqualTo(18);
		Assertions.assertThat(game369.getCount(33)).isEqualTo(14);
	}
}
