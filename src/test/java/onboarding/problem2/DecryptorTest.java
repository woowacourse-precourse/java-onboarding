package onboarding.problem2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import onboarding.Problem2.Decryptor;

public class DecryptorTest {

	@Nested
	class Decrpyt {

		@Test
		void case1() throws Exception {
			// given
			final String cryptogram = "browoanoommnaon";
			final String expected = "brown";

			// when
			final String result = Decryptor.decrypt(cryptogram);

			// then
			assertThat(result).isEqualTo(expected);
		}

		@Test
		void case2() throws Exception {
			// given
			final String cryptogram = "zyelleyz";
			final String expected = "";

			// when
			final String result = Decryptor.decrypt(cryptogram);

			// then
			assertThat(result).isEqualTo(expected);
		}

		@Test
		void case3() throws Exception {
			// given
			final String cryptogram = "abbaa";
			final String expected = "a";

			// when
			final String result = Decryptor.decrypt(cryptogram);

			// then
			assertThat(result).isEqualTo(expected);
		}

	}

}
