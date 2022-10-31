package onboarding.billcounter;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BillCounterTest {

	@DisplayName("돈 단위에 따른 개수 반환 테스트")
	@Test
	void 돈_단위_별_개수_반환() {
		BillCounter counter = new BillCounter(50_237);
		assertThat(
			counter.getNumberOfBills(BillUnit.FIFTY_THOUSAND_WON)
		).isEqualTo(1);
		assertThat(
			counter.getNumberOfBills(BillUnit.TEN_THOUSAND_WON)
		).isEqualTo(5);
	}

	@DisplayName("단위별 전체 돈 개수 반환 테스트")
	@Test
	void 단위별_전체_돈_개수_반환() {
		BillCounter counter = new BillCounter(50_237);
		List<Integer> bills = counter.getBills();
		assertThat(bills).isEqualTo(List.of(1, 0, 0, 0, 0, 2, 0, 3, 7));

		counter = new BillCounter(15_000);
		bills = counter.getBills();
		assertThat(bills).isEqualTo(List.of(0, 1, 1, 0, 0, 0, 0, 0, 0));

		counter = new BillCounter(95_459);
		bills = counter.getBills();
		assertThat(bills).isEqualTo(List.of(1, 4, 1, 0, 0, 4, 1, 0, 9));
	}
}
