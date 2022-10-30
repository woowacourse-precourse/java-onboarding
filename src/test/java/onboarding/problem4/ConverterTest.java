package onboarding.problem4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import onboarding.Problem4.Converter;

public class ConverterTest {

	@Nested
	class IsLowerCaseAlphabet {

		@Test
		void a_True() throws Exception {
			// given
			final char alphabet = 'a';

			// when
			final boolean result = Converter.isLowerCaseAlphabet(alphabet);

			// then
			assertThat(result).isTrue();
		}

		@Test
		void A_False() throws Exception {
			// given
			final char alphabet = 'A';

			// when
			final boolean result = Converter.isLowerCaseAlphabet(alphabet);

			// then
			assertThat(result).isFalse();
		}

	}

	@Nested
	class IsUpperCaseAlphabet {

		@Test
		void A_True() throws Exception {
			// given
			final char alphabet = 'A';

			// when
			final boolean result = Converter.isUpperCaseAlphabet(alphabet);

			// then
			assertThat(result).isTrue();
		}

		@Test
		void a_False() throws Exception {
			// given
			final char alphabet = 'a';

			// when
			final boolean result = Converter.isUpperCaseAlphabet(alphabet);

			// then
			assertThat(result).isFalse();
		}

	}

	@Nested
	class ReverseLowerCase {

		@Test
		void a_z() throws Exception {
			// given
			final char alphabet = 'a';
			final char expected = 'z';

			// when
			final char result = Converter.reverseLowerCase(alphabet);

			// then
			assertThat(result).isEqualTo(expected);
		}

		@Test
		void j_q() throws Exception {
			// given
			final char alphabet = 'j';
			final char expected = 'q';

			// when
			final char result = Converter.reverseLowerCase(alphabet);

			// then
			assertThat(result).isEqualTo(expected);
		}

	}

	@Nested
	class ReverseUpperCase {

		@Test
		void a_z() throws Exception {
			// given
			final char alphabet = 'Z';
			final char expected = 'A';

			// when
			final char result = Converter.reverseUpperCase(alphabet);

			// then
			assertThat(result).isEqualTo(expected);
		}

		@Test
		void j_q() throws Exception {
			// given
			final char alphabet = 'Q';
			final char expected = 'J';

			// when
			final char result = Converter.reverseUpperCase(alphabet);

			// then
			assertThat(result).isEqualTo(expected);
		}

	}

	@Nested
	class Convert {

		@Test
		void MethodName_StateUnderTest_ExpectedBehavior() throws Exception {
			// given
			final String word = "I love you";
			final String expected = "R olev blf";

			// when
			final String result = Converter.convert(word);

			// then
			assertThat(result).isEqualTo(expected);
		}

	}

}
