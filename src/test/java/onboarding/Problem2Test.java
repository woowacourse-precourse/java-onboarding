package onboarding;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Problem2Test {

	@Test
	void duplicateNumberAtTheBeginning() {
		String cryptogram = "bbrown";
		String result = "rown";
		assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
	}

	@Test
	void duplicateNumberAtTheEnd() {
		String cryptogram = "rownbb";
		String result = "rown";
		assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
	}
	
	@Test
	void duplicateAtLeastThree() {
		String cryptogram = "bbbrown";
		String result = "rown";
		assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
	}
}
