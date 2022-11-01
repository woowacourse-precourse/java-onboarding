package onboarding.problem5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AccountTest {
	@Test
	public void 오만원단위_출금_테스트() {
	    //given
		int budget = 310000;
		Account account = new Account(budget);
		//when
		int count = account.withdraw(MoneyUnit.FIFTY_THOUSAND);
	    //then
		assertThat(6).isEqualTo(count);
	}

	@Test
	public void 출금_테스트() {
		//given
		int budget = 50237;
		int budget2 = 15000;
		Account account = new Account(budget);
		Account account2 = new Account(budget2);
		//when
		List<Integer> result = account.withdraw();
		List<Integer> result2 = account2.withdraw();
		//then
		assertThat(Arrays.asList(1, 0, 0, 0, 0, 2, 0, 3, 7)).isEqualTo(result);
		assertThat(Arrays.asList(0, 1, 1, 0, 0, 0, 0, 0, 0)).isEqualTo(result2);
	}

	@Test
	public void 금액_유효성_테스트() {
		int correctBudget = Account.MIN_MONEY;
		int correctBudget2 = Account.MAX_MONEY;
		int wrongBudget = Account.MIN_MONEY - 1;
		int wrongBudget2 = Account.MAX_MONEY + 1;

		Account account = new Account(correctBudget);
		Account account1 = new Account(correctBudget2);

		assertThatThrownBy(() -> new Account(wrongBudget))
			.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> new Account(wrongBudget2))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
