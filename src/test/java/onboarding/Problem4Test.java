package onboarding;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class Problem4Test {

	@Test
	void 테스트케이스추가(){
		String val = "     ";
		assertThat(Problem4.solution(val)).isEqualTo(val);

		val = " _ _ _AN";
		assertThat(Problem4.solution(val)).isEqualTo(" _ _ _ZM");

		val = " <>?:;\"'[]{}|-=_+!@#$%^&*()1234567890~`";
		assertThat(Problem4.solution(val)).isEqualTo(val);

		val = "Choi*SanG)Won";
		assertThat(Problem4.solution(val)).isEqualTo("Xslr*HzmT)Dlm");

	}
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

	@Test
	void 아스키코드를_문자로_변경(){
		List<Integer> val = Arrays.asList(73, 32, 76, 111, 118, 101, 32, 89, 111, 117);
		assertThat(Problem4.turnAsciiIntoWord(val)).isEqualTo("I Love You");

		List<Integer> Choi_Sang_Won = Arrays.asList(67, 104, 111, 105, 32, 83, 97, 110, 103, 32, 87, 111, 110);
		assertThat(Problem4.turnAsciiIntoWord(Choi_Sang_Won)).isEqualTo("Choi Sang Won");

		val = Arrays.asList(98 + 23);
		assertThat(Problem4.turnAsciiIntoWord(val)).isEqualTo("y");

	}

	@Test
	void 청개구리_사전대로_알파벳_변경() {
		int val1 = 97;
		int val2 = 122;
		changeWord(val1, val2);

		val1 = 65;
		val2 = 90;
		changeWord(val1, val2);

		int val = 32;
		int space = Problem4.changeWordReferToGreenFrogDic(val);
		assertThat(Problem4.turnAsciiIntoWord(Collections.singletonList(space))).isEqualTo(" ");
	}

	private static void changeWord(int val1, int val2) {
		for (int i = 0; i <= 25; i++) {
			int changeVal1 = Problem4.changeWordReferToGreenFrogDic(val1 + i);
			// System.out.print("BEFORE : " + Character.toString((char)(val1 + i)) + " / AFTER : ");
			// System.out.println(Character.toString((char)changeVal1) + " -> FINAL : " + Character.toString((char) (val2 -i)));
			assertThat(changeVal1).isEqualTo(val2 - i);
		}
	}

}