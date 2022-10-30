package onboarding.problem5;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import onboarding.Problem5.Bank;

public class BankTest {

	@Nested
	class Convert {

		@Test
		void case1() throws Exception {
			// given
			final int money = 50_237;
			final List<Integer> expected = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);

			// when
			final List<Integer> result = Bank.convert(money);

			// then
			assertThat(result).isEqualTo(expected);
		}

		@Test
		void case2() throws Exception {
			// given
			final int money = 15_000;
			final List<Integer> expected = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);

			// when
			final List<Integer> result = Bank.convert(money);

			// then
			assertThat(result).isEqualTo(expected);
		}

	}

}
