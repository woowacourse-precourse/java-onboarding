package onboarding.problem5;

import static org.assertj.core.api.Assertions.assertThat;

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
}
