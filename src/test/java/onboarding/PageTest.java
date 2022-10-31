package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PageTest {
	@Test
	public void 페이지_홀수_짝수_테스트() {
	    //given
		List<Integer> input = Arrays.asList(3, 4);
		BookPage bookPage = new BookPage(input);
	    //then
		assertThat(bookPage.isOdd(input.get(0))).isTrue();
	}

	@Test
	public void 점수_구하기_테스트() {
	    //given
		List<Integer> input = Arrays.asList(31, 32);
		BookPage bookPage = new BookPage(input);
	    //when
		int score = bookPage.getScore();
	    //then
		assertThat(6).isEqualTo(score);
	}

	@Test
	public void 페이지_점수_비교_테스트() {
	    //given
		List<Integer> input = Arrays.asList(311, 312);
		BookPage pobiBookPage = new BookPage(input);
		List<Integer> input2 = Arrays.asList(301, 302);
		BookPage crongBookPage = new BookPage(input2);
	    //when
		int compare = pobiBookPage.compareTo(crongBookPage);
		//then
		assertThat(compare > 0).isTrue();
	}
}
