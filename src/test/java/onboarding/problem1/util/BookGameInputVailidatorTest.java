package onboarding.problem1.util;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookGameInputVailidatorTest {
	@Nested
	class Problem1Test {
		@Test
		void 플레이어가_가진_리스트에_널이_들어있는가() {
			// give
			List<Integer> pobi = new ArrayList<>();
			pobi.add(98);
			pobi.add(null);
			// when
			boolean result = true;
			// then
			assertThat(BookGameInputVailidator.playerHasNullItem(pobi)).isEqualTo(result);
		}

		@Test
		void 플레이어가_가진_리스트의_길이체크() {
			// give
			List<Integer> pobi = new ArrayList<>();
			pobi.add(97);
			pobi.add(98);
			// when
			boolean result = true;
			// then
			assertThat(BookGameInputVailidator.listLengthValidator(pobi)).isEqualTo(result);
		}

		@Test
		void 플레이어가_가진_리스트의_page값_범위_체크() {
			// give
			List<Integer> pobi = new ArrayList<>();
			pobi.add(97);
			pobi.add(98);
			// when
			boolean result = true;
			// then
			assertThat(BookGameInputVailidator.pageRangeValidator(pobi)).isEqualTo(result);
		}

		@Test
		void 플레이어가_가진_리스트의_왼쪽페이지와_우측페이지가_연번인지_체크() {
			// give
			List<Integer> pobi = new ArrayList<>();
			pobi.add(97);
			pobi.add(98);
			// when
			boolean result = true;
			// then
			assertThat(BookGameInputVailidator.nextPageValidator(pobi)).isEqualTo(result);
		}

		@Test
		void 플레이어가_가진_리스트의_왼쪽_페이지가_홀수인지_체크() {
			// give
			List<Integer> pobi = new ArrayList<>();
			pobi.add(97);
			pobi.add(98);
			// when
			boolean result = true;
			// then
			assertThat(BookGameInputVailidator.oddPageValidator(pobi)).isEqualTo(result);
		}

		@Test
		void 플레이어가_가진_리스트의_오른쪽_페이지가_짝수인지_체크() {
			// give
			List<Integer> pobi = new ArrayList<>();
			pobi.add(99);
			pobi.add(100);
			// when
			boolean result = true;
			// then
			assertThat(BookGameInputVailidator.evenPageValidator(pobi)).isEqualTo(result);
		}
	}
}
