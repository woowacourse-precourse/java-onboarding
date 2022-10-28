package onboarding.problem1;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("예외처리 기능 테스트")
class PageValidCheckerTest {
	PageValidChecker pageValidChecker;

	@BeforeEach
	public void beforeEach() {
		pageValidChecker = new PageValidCheckerImp();
	}

	@Test
	void 범위_넘긴_경우_예외() {
		// given
		List<Integer> user1 = List.of(-1, 0);
		List<Integer> user2 = List.of(401, 402);
		List<Integer> user3 = List.of(301, 302);

		// when
		boolean isValid1 = pageValidChecker.checkValid(user1);
		boolean isValid2 = pageValidChecker.checkValid(user2);
		boolean isValid3 = pageValidChecker.checkValid(user3);

		// then
		assertThat(isValid1).isFalse();
		assertThat(isValid2).isFalse();
		assertThat(isValid3).isTrue();
	}

	@Test
	void 첫페이지_마지막페이지_포함_예외() {
		// given
		List<Integer> user1 = List.of(1, 2);
		List<Integer> user2 = List.of(399, 400);
		List<Integer> user3 = List.of(301, 302);

		// when
		boolean isValid1 = pageValidChecker.checkValid(user1);
		boolean isValid2 = pageValidChecker.checkValid(user2);
		boolean isValid3 = pageValidChecker.checkValid(user3);

		// then
		assertThat(isValid1).isFalse();
		assertThat(isValid2).isFalse();
		assertThat(isValid3).isTrue();
	}

	@Test
	void 두수가_연속되지않을_경우_예외() {
		// given
		List<Integer> user1 = List.of(3, 6);
		List<Integer> user2 = List.of(5, 4);
		List<Integer> user3 = List.of(301, 302);

		// when
		boolean isValid1 = pageValidChecker.checkValid(user1);
		boolean isValid2 = pageValidChecker.checkValid(user2);
		boolean isValid3 = pageValidChecker.checkValid(user3);

		// then
		assertThat(isValid1).isFalse();
		assertThat(isValid2).isFalse();
		assertThat(isValid3).isTrue();
	}

	@Test
	void 홀수_짝수_아닌_경우() {
		// given
		List<Integer> user1 = List.of(4, 5);
		List<Integer> user2 = List.of(6, 7);
		List<Integer> user3 = List.of(301, 302);

		// when
		boolean isValid1 = pageValidChecker.checkValid(user1);
		boolean isValid2 = pageValidChecker.checkValid(user2);
		boolean isValid3 = pageValidChecker.checkValid(user3);

		// then
		assertThat(isValid1).isFalse();
		assertThat(isValid2).isFalse();
		assertThat(isValid3).isTrue();
	}
}
