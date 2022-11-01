package onboarding.problem2.service;

import onboarding.problem2.domain.Cryptogram;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CryptogramDecodeServiceTest {

    private static Stream<Arguments> provideForDecode() {
        return Stream.of(
                Arguments.of(new Cryptogram(""), ""),
                Arguments.of(new Cryptogram("aaaaaaaa"), ""),
                Arguments.of(new Cryptogram("alla"), ""),
                Arguments.of(new Cryptogram("a"), "a"),
                Arguments.of(new Cryptogram("allaa"), "a"),
                Arguments.of(new Cryptogram("allac"), "c"),
                Arguments.of(new Cryptogram("browoanoommnaon"), "brown"),
                Arguments.of(new Cryptogram("zyelleyz"), "")
        );
    }

    @ParameterizedTest(name = "2자 이상의 연속하는 중복 문자들을 삭제한 암호의 길이가 삭제 전 암호의 길이와 같으면 해독한 문자열을 반환한다.")
    @MethodSource("provideForDecode")
    void decode(Cryptogram cryptogram, String expected) {
        Assertions.assertThat(CryptogramDecodeService.decode(cryptogram)).isEqualTo(expected);
    }
}
