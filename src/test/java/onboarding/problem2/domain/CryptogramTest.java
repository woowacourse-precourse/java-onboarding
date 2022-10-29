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

    @DisplayName("암호 두개의 길이가 같은지 비교한다.")
    @Test
    void compare_cryptogram_length() {
        Assertions.assertAll(
                () -> assertThat(new Cryptogram("").compareLength(new Cryptogram(""))).isTrue(),
                () -> assertThat(new Cryptogram("").compareLength(new Cryptogram(" "))).isFalse(),
                () -> assertThat(new Cryptogram("abc").compareLength(new Cryptogram("cde"))).isTrue(),
                () -> assertThat(new Cryptogram("aabc").compareLength(new Cryptogram("abcd"))).isTrue()
        );
    }
}
