package onboarding.problem3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import onboarding.Problem3.Game;

public class GameTest {

	@Nested
	class CountClaps {

		@Test
		void number13_Claps1() throws Exception {
			// given
			final int number = 13;
			final int expected = 1;

			// when
			final int result = Game.countClaps(number);

			// then
			assertThat(result).isEqualTo(expected);
		}

		@Test
		void number1396_Claps3() throws Exception {
			// given
			final int number = 1396;
			final int expected = 3;

			// when
			final int result = Game.countClaps(number);

			// then
			assertThat(result).isEqualTo(expected);
		}

		@Test
		void number13963_Claps4() throws Exception {
			// given
			final int number = 13963;
			final int expected = 4;

			// when
			final int result = Game.countClaps(number);

			// then
			assertThat(result).isEqualTo(expected);
		}

	}

	@Nested
	class CountClapsUpTo {

		@Test
		void number13_TotalClaps4() throws Exception {
			// given
			final int number = 13;
			final int expected = 4;

			// when
			final int result = Game.countClapsUpTo(number);

			// then
			assertThat(result).isEqualTo(expected);
		}

		@Test
		void number33_TotalClaps14() throws Exception {
			// given
			final int number = 33;
			final int expected = 14;

			// when
			final int result = Game.countClapsUpTo(number);

			// then
			assertThat(result).isEqualTo(expected);
		}

	}

}
