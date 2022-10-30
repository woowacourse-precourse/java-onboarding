package onboarding.problem1;

import static onboarding.Problem1.Status.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import onboarding.Problem1;

public class GameTest {

	@Nested
	class CalculateScore {

		@Test
		void Page97And98_72() throws Exception {
			// given
			final Problem1.Page page = Problem1.Page.of(List.of(97, 98));

			// when
			final int result = Problem1.Game.calculateScore(page);

			// then
			assertThat(result).isEqualTo(72);
		}

		@Test
		void Page197And198_72() throws Exception {
			// given
			final Problem1.Page page = Problem1.Page.of(List.of(197, 198));

			// when
			final int result = Problem1.Game.calculateScore(page);

			// then
			assertThat(result).isEqualTo(72);
		}

		@Test
		void Page131And132_6() throws Exception {
			// given
			final Problem1.Page page = Problem1.Page.of(List.of(131, 132));

			// when
			final int result = Problem1.Game.calculateScore(page);

			// then
			assertThat(result).isEqualTo(6);
		}

		@Test
		void Page211And212_5() throws Exception {
			// given
			final Problem1.Page page = Problem1.Page.of(List.of(211, 212));

			// when
			final int result = Problem1.Game.calculateScore(page);

			// then
			assertThat(result).isEqualTo(5);
		}

	}

	@Nested
	class Play {

		@Test
		void PobiPage97And98AndCrongPage197And198_Draw() throws Exception {
			// given
			final Problem1.Member pobi = Problem1.Member.of("pobi", List.of(97, 98));
			final Problem1.Member crong = Problem1.Member.of("crong", List.of(197, 198));

			// when
			final Problem1.Status result = Problem1.Game.play(pobi, crong);

			// then
			assertThat(result).isEqualTo(DRAW);
		}

		@Test
		void PobiPage131And132AndCrongPage211And212_PobiWin() throws Exception {
			// given
			final Problem1.Member pobi = Problem1.Member.of("pobi", List.of(131, 132));
			final Problem1.Member crong = Problem1.Member.of("crong", List.of(211, 212));

			// when
			final Problem1.Status result = Problem1.Game.play(pobi, crong);

			// then
			assertThat(result).isEqualTo(POBI_WIN);
		}

		@Test
		void PobiPage11And12AndCrongPage233And234_CrongWin() throws Exception {
			// given
			final Problem1.Member pobi = Problem1.Member.of("pobi", List.of(11, 12));
			final Problem1.Member crong = Problem1.Member.of("crong", List.of(233, 234));

			// when
			final Problem1.Status result = Problem1.Game.play(pobi, crong);

			// then
			assertThat(result).isEqualTo(CRONG_WIN);
		}

		@Test
		void PobiPage11And14AndCrongPage233And234_Error() throws Exception {
			// given
			final Problem1.Member pobi = Problem1.Member.of("pobi", List.of(11, 14));
			final Problem1.Member crong = Problem1.Member.of("crong", List.of(233, 234));

			// when
			final Problem1.Status result = Problem1.Game.play(pobi, crong);

			// then
			assertThat(result).isEqualTo(ERROR);
		}

	}

}
