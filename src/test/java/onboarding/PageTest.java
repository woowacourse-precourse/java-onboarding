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
		assertThat(bookPage.isEven(input.get(1))).isTrue();
	}

}
