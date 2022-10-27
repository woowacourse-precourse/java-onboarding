package onboarding.problem1;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckPagesTest {
	@Test
	void check_page_number_is_null() {
		Assertions.assertThat(CheckPages.of(null)).isFalse();
	}

	@Test
	void check_page_number_size() {
		List<Integer> list1 = List.of(1);
		Assertions.assertThat(CheckPages.of(list1)).isFalse();

		List<Integer> list2 = List.of(2, 3, 4);
		Assertions.assertThat(CheckPages.of(list2)).isFalse();
	}

	@Test
	void check_page_number_is_consecutive_numbers() {
		List<Integer> list1 = List.of(3, 8);
		Assertions.assertThat(CheckPages.of(list1)).isFalse();

		List<Integer> list2 = List.of(15, 100);
		Assertions.assertThat(CheckPages.of(list2)).isFalse();
	}

	@Test
	void check_page_number_range() {
		List<Integer> list1 = List.of(0, 1);
		Assertions.assertThat(CheckPages.of(list1)).isFalse();

		List<Integer> list2 = List.of(399, 400);
		Assertions.assertThat(CheckPages.of(list2)).isFalse();
	}

	@Test
	void check_page_number_of_first_number_is_not_odd() {
		List<Integer> list1 = List.of(6, 7);
		Assertions.assertThat(CheckPages.of(list1)).isFalse();

		List<Integer> list2 = List.of(100, 101);
		Assertions.assertThat(CheckPages.of(list2)).isFalse();
	}

	@Test
	void check_page_number_correct_number() {
		List<Integer> list1 = List.of(3, 4);
		Assertions.assertThat(CheckPages.of(list1)).isTrue();

		List<Integer> list2 = List.of(99, 100);
		Assertions.assertThat(CheckPages.of(list2)).isTrue();
	}

}
