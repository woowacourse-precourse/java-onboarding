package onboarding.unitTest;

import onboarding.problem2.CryptogramDecoder;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem2UnitTest {

    @Nested
    class CryptogramDecoderTest{

        @ParameterizedTest(name = "Case {index}")
        @ArgumentsSource(CryptogramDecoderTestData.class)
        void cryptogramDecoderTest(List<Character> cryptogramCharList, List<Character> decodedCharList){
            assertThat(CryptogramDecoder.decode(cryptogramCharList)).isEqualTo(decodedCharList);
        }

    }

    static class CryptogramDecoderTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(List.of('c','b','b','c'), List.of()),
                    Arguments.of(List.of('a','b','c','d'), List.of('a','b','c','d')),
                    Arguments.of(List.of('c','b','c','c'), List.of('c','b')),
                    Arguments.of(List.of('c','b','c','c','c'), List.of('c','b')),
                    Arguments.of(List.of(), List.of())
            );
        }
    }
}
