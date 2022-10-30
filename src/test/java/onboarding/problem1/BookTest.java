package onboarding.problem1;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import onboarding.Problem1;

public class BookTest {

	@Nested
	class Open {

		@Test
		void LeftPageIsOddAndRightPageIsEvenAndPageIsConsecutiveAndPageIsNotOutOfRange_True() throws Exception {
			// given
			final Problem1.Page page = Problem1.Page.of(List.of(3, 4));

			// when
			final boolean result = Problem1.Book.open(page);

			// then
			assertThat(result).isTrue();
		}

		@Test
		void LeftPageIsOddAndRightPageIsEvenAndPageIsConsecutiveAndPageIsOutOfRange_False() throws Exception {
			// given
			final Problem1.Page page = Problem1.Page.of(List.of(1, 2));

			// when
			final boolean result = Problem1.Book.open(page);

			// then
			assertThat(result).isFalse();
		}

		@Test
		void LeftPageIsOddAndRightPageIsEvenAndPageIsNotConsecutiveAndPageIsNotOutOfRange_False() throws Exception {
			// given
			final Problem1.Page page = Problem1.Page.of(List.of(3, 6));

			// when
			final boolean result = Problem1.Book.open(page);

			// then
			assertThat(result).isFalse();
		}

		@Test
		void LeftPageIsOddAndRightPageIsOddAndPageIsConsecutiveAndPageIsNotOutOfRange_False() throws Exception {
			// given
			final Problem1.Page page = Problem1.Page.of(List.of(3, 5));

			// when
			final boolean result = Problem1.Book.open(page);

			// then
			assertThat(result).isFalse();
		}

		@Test
		void LeftPageIsEvenAndRightPageIsEvenAndPageIsConsecutiveAndPageIsNotOutOfRange_False() throws Exception {
			// given
			final Problem1.Page page = Problem1.Page.of(List.of(3, 5));

			// when
			final boolean result = Problem1.Book.open(page);

			// then
			assertThat(result).isFalse();
		}

	}

}
