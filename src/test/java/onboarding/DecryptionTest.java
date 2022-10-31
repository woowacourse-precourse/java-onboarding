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

	@Test
	public void 암호_해독_테스트() {
		//given
		String cryptogram = "browoanoommnaon";
		String cryptogram2 = "browoannaon";
		String cryptogram3 = "browoaaon";
		String cryptogram4 = "browoon";

		//when
		Decryption decryption = new Decryption(cryptogram);
		Decryption decryption2 = new Decryption(cryptogram2);
		Decryption decryption3 = new Decryption(cryptogram3);
		Decryption decryption4 = new Decryption(cryptogram4);

		//then
		String result = decryption.decipher();
		assertThat("browoannaon").isEqualTo(result);

		String result2 = decryption2.decipher();
		assertThat("browoaaon").isEqualTo(result2);

		String result3 = decryption3.decipher();
		assertThat("browoon").isEqualTo(result3);

		String result4 = decryption4.decipher();
		assertThat("brown").isEqualTo(result4);
	}
}
