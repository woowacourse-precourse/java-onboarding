package onboarding.problem5;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankTest {

	private static final List<Integer> AMOUNTS = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

	@Test
	@DisplayName("최대한 큰 화폐 위주로 출금한다")
	void withdraw_big_amount_first() {
		Bank bank = new Bank(AMOUNTS);
		List<Integer> expected = List.of(0, 1, 1, 0, 1, 1, 1, 0, 0);

		assertThat(bank.withdraw(15650)).containsExactlyElementsOf(expected);
	}

	@Test
	@DisplayName("들어간 액수가 반환된 액수와 같다")
	void withdrawn_amount_is_consistent() {
		int balance = 15650;
		Bank bank = new Bank(AMOUNTS);
		List<Integer> counts = bank.withdraw(balance);

		int total = 0;
		for (int i = 0; i < AMOUNTS.size(); i++) {
			Integer amount = AMOUNTS.get(i);
			total += amount * counts.get(i);
		}

		assertThat(total).isEqualTo(balance);
	}
}
