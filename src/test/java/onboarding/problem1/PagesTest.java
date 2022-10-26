package onboarding.problem1;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PagesTest {

	@Test
	@DisplayName("최대 점수를 계산할 수 있다")
	void calculate_maximum_score() {
		List<Integer> pageNumbers = List.of(97, 98);
		Pages pages = new Pages(pageNumbers);

		assertThat(pages.calculateScore()).isEqualTo(72);
	}

	@Test
	@DisplayName("페이지는 이어져야 한다")
	void pages_are_consecutive() {
		List<Integer> pageNumbers = List.of(97, 99);

		assertThatIllegalArgumentException().isThrownBy(() -> new Pages(pageNumbers));
	}
}
