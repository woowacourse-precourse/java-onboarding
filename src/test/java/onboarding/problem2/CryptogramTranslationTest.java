package onboarding.problem2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CryptogramTranslationTest {

	@Test
	void translate_cryptogram() {
		CryptogramTranslation cryptogramTranslation = new CryptogramTranslation();
		assertThat(cryptogramTranslation.translate("aadbbbcccded")).isEqualTo("ed");
		assertThat(cryptogramTranslation.translate("adbbbcded")).isEqualTo("adcded");
	}
}
