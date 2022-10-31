package onboarding.problem5;

import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankTest {

	private static final List<Integer> SORTED_AMOUNTS = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

	@Test
	@DisplayName("최대한 큰 화폐 위주로 출금한다")
	void withdraw_big_amount_first() {
		Bank bank = new Bank(SORTED_AMOUNTS);
		List<Integer> expected = List.of(0, 1, 1, 0, 1, 1, 1, 0, 0);

		assertThat(bank.withdraw(15650)).containsExactlyElementsOf(expected);
	}

	@Test
	@DisplayName("들어간 액수가 반환된 액수와 같다")
	void withdrawn_amount_is_consistent() {
		int balance = 15650;
		Bank bank = new Bank(SORTED_AMOUNTS);
		List<Integer> counts = bank.withdraw(balance);

		assertThat(calculateTotal(counts)).isEqualTo(balance);
	}

	@Test
	@DisplayName("화폐단위를 정렬한다")
	void amounts_are_sorted() {
		List<Integer> shuffledAmounts = new ArrayList<>(SORTED_AMOUNTS);
		shuffle(shuffledAmounts);

		Bank bank = new Bank(shuffledAmounts);
		List<Integer> expected = List.of(1, 1, 1, 0, 1, 1, 1, 0, 0);

		assertThat(bank.withdraw(65650)).containsExactlyElementsOf(expected);
	}

	private int calculateTotal(List<Integer> counts) {
		int total = 0;
		for (int i = 0; i < SORTED_AMOUNTS.size(); i++) {
			Integer amount = SORTED_AMOUNTS.get(i);
			total += amount * counts.get(i);
		}
		return total;
	}
}
