package onboarding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class DecryptionTest {
	@Test
	public void 암호문_입력_성공_테스트() {
	    //given
		String cryptogram = "browoanoommnaon";
		//when
		Decryption decryption = new Decryption(cryptogram);
	    //then
		assertThat(decryption).isNotNull();
	}

	@Test
	public void 암호문_입력_실패_테스트() {
		//given
		String cryptogram = "ABC";
		String cryptogram2 = "123asdf";
		String cryptogram3 = "에러에러";
		//then
		assertThatThrownBy(() -> new Decryption(cryptogram))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new Decryption(cryptogram2))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new Decryption(cryptogram3))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
