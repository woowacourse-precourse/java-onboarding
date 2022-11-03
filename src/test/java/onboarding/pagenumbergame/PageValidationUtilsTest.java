package onboarding.pagenumbergame;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PageValidationUtilsTest {

	@DisplayName("페이지 숫자 검증")
	@Test
	void 페이지_숫자_검증() {
		assertThat(PageValidationUtils.validatePageNumber(1)).isFalse();
		assertThat(PageValidationUtils.validatePageNumber(400)).isFalse();
		assertThat(PageValidationUtils.validatePageNumber(2)).isTrue();
		assertThat(PageValidationUtils.validatePageNumber(5)).isTrue();
	}

	@DisplayName("페이지 숫자 순서 검증")
	@Test
	void 페이지_숫자_순서_검증() {
		assertThat(PageValidationUtils.validatePageOrder(List.of(99, 102))).isFalse();
		assertThat(PageValidationUtils.validatePageOrder(List.of(100, 99))).isFalse();
		assertThat(PageValidationUtils.validatePageOrder(List.of(100, 100))).isFalse();

		assertThat(PageValidationUtils.validatePageOrder(List.of(99, 100))).isTrue();
		assertThat(PageValidationUtils.validatePageOrder(List.of(197, 198))).isTrue();
		assertThat(PageValidationUtils.validatePageOrder(List.of(211, 212))).isTrue();
	}

	@DisplayName("페이지 전체 숫자 검증")
	@Test
	void 페이지_전체_검증() {
		assertThat(PageValidationUtils.validatePage(List.of(1, 2))).isFalse();
		assertThat(PageValidationUtils.validatePage(List.of(399, 400))).isFalse();
		assertThat(PageValidationUtils.validatePage(List.of(100, 100))).isFalse();
		assertThat(PageValidationUtils.validatePage(List.of(97, 98))).isTrue();
	}

	@DisplayName("페이지 숫자 매개변수 검증")
	@Test
	void 페이지_숫자_매개변수_검증() {
		assertThat(PageValidationUtils.validatePage(null)).isFalse();
		assertThat(PageValidationUtils.validatePage(List.of(99))).isFalse();
		assertThat(PageValidationUtils.validatePage(List.of(99, 100, 101))).isFalse();
		assertThat(PageValidationUtils.validatePage(List.of(99, 100, 101, 102))).isFalse();
	}
}
