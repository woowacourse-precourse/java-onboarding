package onboarding.problem2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptogramTest {
    @Test
    @DisplayName("두 문자가 같은 문자인지 확인하기")
    void isEqualsTwoChar() {
        Cryptogram cryptogram = new Cryptogram();
        assertThat(cryptogram.isEquals('a', 'a')).isTrue();
    }
    
    @Test
    @DisplayName("연속된 같은 두 문자가 있으면 삭제 후 새로운 객체 반환")
    void removeAndReturnTrue() {
        Cryptogram cryptogram = new Cryptogram("browoanoommnaon");
        assertThat(cryptogram.remove().getCryptogram()).isEqualTo("browoanmmnaon");
    }
    
    @Test
    @DisplayName("연속된 같은 두 문자가 없으면 기존 객체 반환")
    void returnExistingObject() {
        Cryptogram cryptogram = new Cryptogram("brown");
        assertThat(cryptogram.remove().getCryptogram()).isEqualTo("brown");
    }
}
