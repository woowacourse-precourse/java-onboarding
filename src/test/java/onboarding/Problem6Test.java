package onboarding;

import static onboarding.Problem6.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Problem6Test {
	public static String[] targetNicknameArr;

	@BeforeEach
	void beforeEach() {
		targetNicknameArr = new String[2];
	}

	@Test
	void isTwoSameLetterExist_메서드로_변경_대상인지_확인() {
		List<String> compareForm = List.of("jm@email.com","제이엠");
		targetNicknameArr[0] = "제";
		targetNicknameArr[1] = "이";


		assertThat(isTwoSameLetterExist(compareForm, targetNicknameArr)).isTrue();
	}
}
