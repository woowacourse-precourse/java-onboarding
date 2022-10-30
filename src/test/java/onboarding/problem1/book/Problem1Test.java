package onboarding.problem1.book;

import static onboarding.Problem1.Status.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import onboarding.Problem1;
import onboarding.Problem1.Book;
import onboarding.Problem1.Game;
import onboarding.Problem1.Member;
import onboarding.Problem1.Page;
import onboarding.Problem1.Status;

class Problem1Test {

	@Nested
	class open {

		@Test
		void LeftPageIsOddAndRightPageIsEvenAndPageIsConsecutiveAndPageIsNotOutOfRange_True() throws Exception {
			// given
			final Page page = Page.of(List.of(3, 4));

			// when
			final boolean result = Book.open(page);

			// then
			assertThat(result).isTrue();
		}

		@Test
		void LeftPageIsOddAndRightPageIsEvenAndPageIsConsecutiveAndPageIsOutOfRange_False() throws Exception {
			// given
			final Page page = Page.of(List.of(1, 2));

			// when
			final boolean result = Book.open(page);

			// then
			assertThat(result).isFalse();
		}

		@Test
		void LeftPageIsOddAndRightPageIsEvenAndPageIsNotConsecutiveAndPageIsNotOutOfRange_False() throws Exception {
			// given
			final Page page = Page.of(List.of(3, 6));

			// when
			final boolean result = Book.open(page);

			// then
			assertThat(result).isFalse();
		}

		@Test
		void LeftPageIsOddAndRightPageIsOddAndPageIsConsecutiveAndPageIsNotOutOfRange_False() throws Exception {
			// given
			final Page page = Page.of(List.of(3, 5));

			// when
			final boolean result = Book.open(page);

			// then
			assertThat(result).isFalse();
		}

		@Test
		void LeftPageIsEvenAndRightPageIsEvenAndPageIsConsecutiveAndPageIsNotOutOfRange_False() throws Exception {
			// given
			final Page page = Page.of(List.of(3, 5));

			// when
			final boolean result = Book.open(page);

			// then
			assertThat(result).isFalse();
		}

	}

	@Nested
	class calculateScore {

		@Test
		void Page97And98_72() throws Exception {
			// given
			final Page page = Page.of(List.of(97, 98));

			// when
			final int result = Game.calculateScore(page);

			// then
			assertThat(result).isEqualTo(72);
		}

		@Test
		void Page197And198_72() throws Exception {
			// given
			final Page page = Page.of(List.of(197, 198));

			// when
			final int result = Game.calculateScore(page);

			// then
			assertThat(result).isEqualTo(72);
		}

		@Test
		void Page131And132_6() throws Exception {
			// given
			final Page page = Page.of(List.of(131, 132));

			// when
			final int result = Game.calculateScore(page);

			// then
			assertThat(result).isEqualTo(6);
		}

		@Test
		void Page211And212_5() throws Exception {
			// given
			final Page page = Page.of(List.of(211, 212));

			// when
			final int result = Game.calculateScore(page);

			// then
			assertThat(result).isEqualTo(5);
		}

	}

	@Nested
	class play {

		@Test
		void PobiPage97And98AndCrongPage197And198_Draw() throws Exception {
			// given
			final Member pobi = Member.of("pobi", List.of(97, 98));
			final Member crong = Member.of("crong", List.of(197, 198));

			// when
			final Status result = Game.play(pobi, crong);

			// then
			assertThat(result).isEqualTo(DRAW);
		}

		@Test
		void PobiPage131And132AndCrongPage211And212_PobiWin() throws Exception {
			// given
			final Member pobi = Member.of("pobi", List.of(131, 132));
			final Member crong = Member.of("crong", List.of(211, 212));

			// when
			final Status result = Game.play(pobi, crong);

			// then
			assertThat(result).isEqualTo(POBI_WIN);
		}

		@Test
		void PobiPage11And12AndCrongPage233And234_CrongWin() throws Exception {
			// given
			final Member pobi = Member.of("pobi", List.of(11, 12));
			final Member crong = Member.of("crong", List.of(233, 234));

			// when
			final Status result = Game.play(pobi, crong);

			// then
			assertThat(result).isEqualTo(CRONG_WIN);
		}

		@Test
		void PobiPage11And14AndCrongPage233And234_Error() throws Exception {
			// given
			final Member pobi = Member.of("pobi", List.of(11, 14));
			final Member crong = Member.of("crong", List.of(233, 234));

			// when
			final Status result = Game.play(pobi, crong);

			// then
			assertThat(result).isEqualTo(ERROR);
		}

	}

}