package onboarding.problem2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CryptogramTest {

    @Test
    void create() {
        Cryptogram cryptogram = new Cryptogram("abc");

        assertThat(cryptogram).isEqualTo(new Cryptogram("abc"));
    }

    @DisplayName("2자 이상의 연속하는 중복 문자들을 삭제한다.")
    @Test
    void delete_consecutive_character() {
        Assertions.assertAll(
                () -> assertThat(new Cryptogram("zaax").deleteConsecutiveCharacter()).isEqualTo(new Cryptogram("zx")),
                () -> assertThat(new Cryptogram("aaaaaaa").deleteConsecutiveCharacter()).isEqualTo(new Cryptogram("")),
                () -> assertThat(new Cryptogram("z").deleteConsecutiveCharacter()).isEqualTo(new Cryptogram("z"))

        );
    }
}
