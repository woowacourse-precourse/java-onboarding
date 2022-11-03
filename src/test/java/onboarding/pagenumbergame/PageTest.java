package onboarding.pagenumbergame;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PageTest {

	@DisplayName("페이지 번호 최대값 생성 테스트")
	@Test
	void 페이지_번호_최대값_생성() {
		Page page1 = new Page(97);
		Page page2 = new Page(98);

		assertThat(page1.getScore()).isEqualTo(63);
		assertThat(page2.getScore()).isEqualTo(72);

		assertThat(new Page(197).getScore()).isEqualTo(63);
		assertThat(new Page(198).getScore()).isEqualTo(72);

		assertThat(new Page(99).getScore()).isEqualTo(81);
		assertThat(new Page(102).getScore()).isEqualTo(3);
	}

	@DisplayName("페이지 최대값 생성 테스트")
	@Test
	void 페이지_최대값_생성_테스트() {
		Pages pages = new Pages(List.of(97, 98));
		assertThat(pages.getScore()).isEqualTo(72);

		pages = new Pages(List.of(211, 212));
		assertThat(pages.getScore()).isEqualTo(5);
	}

	@DisplayName("페이지 비교 테스트::예시 1")
	@Test
	void 페이지_생성_예시1() {
		PageNumberGame pageNumberGame
			= new PageNumberGame(List.of(97, 98), List.of(197, 198));
		assertThat(pageNumberGame.play()).isEqualTo(0);
	}

	@DisplayName("페이지 비교 테스트::예시 2")
	@Test
	void 페이지_생성_예시2() {
		List<Integer> pobi = List.of(131, 132);
		List<Integer> crong = List.of(211, 212);

		assertThat(
			new PageNumberGame(pobi, crong).play()
		).isEqualTo(1);
		assertThat(
			new PageNumberGame(crong, pobi).play()
		).isEqualTo(2);
	}

	@DisplayName("페이지 비교 테스트::예시 3")
	@Test
	void 페이지_생성_예시3() {
		List<Integer> pobi = List.of(99, 102);
		List<Integer> crong = List.of(211, 212);

		assertThat(
			new PageNumberGame(crong, pobi).play()
		).isEqualTo(-1);
	}
}
