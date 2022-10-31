package onboarding.unitTest.problem4;

import onboarding.problem4.LetterReverser;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
public class LetterReverserTest {

    @ParameterizedTest(name = "Case : {0}")
    @ArgumentsSource(LetterReverserTestData.class)
    void letterReverseChangerTest(char letter, Character expected){
        assertThat(LetterReverser.reverseOnlyEnglish(letter)).isEqualTo(expected);
    }

    static class LetterReverserTestData implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of('a','z'),
                    Arguments.of('f','u'),
                    Arguments.of('M','N'),
                    Arguments.of('T','G'),
                    Arguments.of('*','*'),
                    Arguments.of(' ',' ')
            );
        }
    }
}
