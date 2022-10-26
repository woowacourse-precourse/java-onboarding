package onboarding;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Problem4Test {
	@Test
	void 범위확인() {
		assertThrows(IllegalArgumentException.class, () ->
			Problem4.checkValidRange(1001)
		);

		assertThrows(IllegalArgumentException.class, () ->
			Problem4.checkValidRange(0)
		);
	}

	@Test
	void 아스키코드로변경(){
		String val = "I Love You";
		List<Integer> result = Arrays.asList(73, 32, 76, 111, 118, 101, 32, 89, 111, 117);
		// 73 32 76 111 118 101 32 89 111 117

		assertThat(Problem4.turnWordIntoAscii(val.split(""))).isEqualTo(result);
		val = "Choi Sang Won";
		List<Integer> Choi_Sang_Won = Arrays.asList(67, 104, 111, 105, 32, 83, 97, 110, 103, 32, 87, 111, 110);

		assertThat(Problem4.turnWordIntoAscii(val.split(""))).isEqualTo(Choi_Sang_Won);

	}
}