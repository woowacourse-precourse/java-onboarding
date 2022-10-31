package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PageGameTest {
	@Test
	public void PageGameTest() {
	    //given
		List<Integer> pobi = Arrays.asList(97, 98);
		List<Integer> crong = Arrays.asList(197, 198);

	    List<Integer> pobi2 = Arrays.asList(131, 132);
		List<Integer> crong2 = Arrays.asList(211, 212);

	    //when
		PageGame pageGame = new PageGame(pobi, crong);
		int result = pageGame.result();

		PageGame pageGame2 = new PageGame(pobi2, crong2);
		int result2 = pageGame2.result();

		//then
		assertThat(0).isEqualTo(result);
		assertThat(1).isEqualTo(result2);
	}
}
