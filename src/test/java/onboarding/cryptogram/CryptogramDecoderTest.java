package onboarding.cryptogram;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CryptogramDecoderTest {

	@DisplayName("암호문 길이 검증")
	@Test
	void 암호문_길이_검증() {
		assertThat(
			CryptogramDecoder.validateLength("")
		).isFalse();

		assertThat(
			CryptogramDecoder.validateLength("0".repeat(1000))
		).isTrue();

		assertThat(
			CryptogramDecoder.validateLength("0".repeat(1001))
		).isFalse();
	}

	@DisplayName("암호문 형식 검증")
	@Test
	void 암호문_형식_검증() {
		String[] INVALID_CRYPTOGRAMS = {
			"Brown", "Brown123", "", null,
			"123", "BROWN", "bro+_&wn" };

		for (String cryptogram : INVALID_CRYPTOGRAMS) {
			assertThat(
				CryptogramDecoder.isValidFormat(cryptogram)
			).isFalse();
		}
		assertThat(
			CryptogramDecoder.isValidFormat("brown")
		).isTrue();
	}

	@DisplayName("연속하는 중복 문자 판별 테스트")
	@Test
	void 연속_중복_문자_테스트() {
		assertThat(CryptogramDecoder
			.containsRepetitions("browoanoommnaon")
		).isTrue();
		assertThat(CryptogramDecoder
			.containsRepetitions("browoannaon")
		).isTrue();
		assertThat(CryptogramDecoder
			.containsRepetitions("browoaaon")
		).isTrue();
		assertThat(CryptogramDecoder
			.containsRepetitions("browoon")
		).isTrue();
		assertThat(CryptogramDecoder
			.containsRepetitions("brown")
		).isFalse();
		assertThat(CryptogramDecoder
			.containsRepetitions("z")
		).isFalse();
		assertThat(CryptogramDecoder
			.containsRepetitions("zwz")
		).isFalse();
		assertThat(CryptogramDecoder
			.containsRepetitions("zezz")
		).isTrue();
		assertThat(CryptogramDecoder
			.containsRepetitions("zzze")
		).isTrue();
	}

	@DisplayName("연속하는 중복 문자 제거 테스트")
	@Test
	void 연속_중복_문자_제거() {
		// 테스트 케이스 1
		String clearText = CryptogramDecoder.removeRepetitions("browoanoommnaon");
		assertThat(clearText).isEqualTo("browoannaon");
		clearText = CryptogramDecoder.removeRepetitions(clearText);
		assertThat(clearText).isEqualTo("browoaaon");
		clearText = CryptogramDecoder.removeRepetitions(clearText);
		assertThat(clearText).isEqualTo("browoon");
		clearText = CryptogramDecoder.removeRepetitions(clearText);
		assertThat(clearText).isEqualTo("brown");

		// 테스트 케이스 2
		clearText = CryptogramDecoder.removeRepetitions("zyelleyz");
		assertThat(clearText).isEqualTo("zyeeyz");
		clearText = CryptogramDecoder.removeRepetitions(clearText);
		assertThat(clearText).isEqualTo("zyyz");
		clearText = CryptogramDecoder.removeRepetitions(clearText);
		assertThat(clearText).isEqualTo("zz");
		clearText = CryptogramDecoder.removeRepetitions(clearText);
		assertThat(clearText).isEqualTo("");
	}

	@DisplayName("암호문 해독 테스트")
	@Test
	void 암호문_해독() {
		assertThat(
			CryptogramDecoder.decrypt("browoanoommnaon")
		).isEqualTo("brown");

		assertThat(
			CryptogramDecoder.decrypt("zyelleyz")
		).isEqualTo("");

		assertThat(
			CryptogramDecoder.decrypt("zyellleyz")
		).isEqualTo("");
	}
}
