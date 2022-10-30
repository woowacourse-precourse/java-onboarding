package onboarding.problem1.book;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import onboarding.Problem1;
import onboarding.Problem1.Book;
import onboarding.Problem1.Page;

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
			final int result = Problem1.Game.calculateScore(page);

			// then
			assertThat(result).isEqualTo(72);
		}

		@Test
		void Page197And198_72() throws Exception {
			// given
			final Page page = Page.of(List.of(197, 198));

			// when
			final int result = Problem1.Game.calculateScore(page);

			// then
			assertThat(result).isEqualTo(72);
		}

		@Test
		void Page131And132_6() throws Exception {
			// given
			final Page page = Page.of(List.of(131, 132));

			// when
			final int result = Problem1.Game.calculateScore(page);

			// then
			assertThat(result).isEqualTo(6);
		}

		@Test
		void Page211And212_5() throws Exception {
			// given
			final Page page = Page.of(List.of(211, 212));

			// when
			final int result = Problem1.Game.calculateScore(page);

			// then
			assertThat(result).isEqualTo(5);
		}

	}

}