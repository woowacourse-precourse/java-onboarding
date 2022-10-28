package onboarding.problem2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CryptogramTest {
    @Test
    @DisplayName("연속하는 중복 문자가 있으면 삭제 후 새로운 객체 반환")
    void isOverlapCharacterExist() {
        Cryptogram cryptogram = new Cryptogram("zyellleyz");
        assertAll(
                () -> assertThat(cryptogram.decrypt()).isTrue(),
                () -> assertThat(cryptogram.cryptogram()).isEqualTo("zyeeyz")
        );
    }
    
    @Test
    @DisplayName("연속하는 중복 문자가 없다면 기존 객체 반환")
    void isOverlapCharacterNotExist() {
        Cryptogram cryptogram = new Cryptogram("abc");
        assertAll(
                () -> assertThat(cryptogram.decrypt()).isFalse(),
                () -> assertThat(cryptogram.cryptogram()).isEqualTo("abc")
        );
    }
}
