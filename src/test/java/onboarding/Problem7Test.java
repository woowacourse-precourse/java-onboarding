package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Problem7Test {

	@Test
	void scoreClassTest() {
		String username = "kim";
		int score = 10;

		Problem7.Score user1 = new Problem7.Score(username, score);

		assertThat(user1).isInstanceOf(Problem7.Score.class);
		assertThat(user1.score).isEqualTo(10);

		user1.addScore10();
		assertThat(user1.score).isEqualTo(20);

		user1.addScore1();
		assertThat(user1.score).isEqualTo(21);
	}
}
