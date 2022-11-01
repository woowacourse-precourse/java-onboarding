package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NickNameTest {
	@Test
	public void 닉네임_유효성_테스트() {
	    //given
		String inputCorrectNickName = "제이엠";
		String inputWrongNickName = "제이엠1";
		String inputWrongNickName2 = "제b1";
		String inputWrongNickName3 = "제이엠제이엠제이엠제이엠제이엠제이엠제이";
		String inputWrongNickName4 = "";

		NickName nickName = new NickName(inputCorrectNickName);
		assertThatThrownBy(() -> new NickName(inputWrongNickName))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new NickName(inputWrongNickName2))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new NickName(inputWrongNickName3))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new NickName(inputWrongNickName4))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
