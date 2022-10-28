package onboarding.unitTest;

import onboarding.Problem4;
import onboarding.problem4.LetterReverser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.MockedStatic;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

public class Problem4UnitTest {

    @Nested
    class LetterReverserTest{

        @ParameterizedTest(name = "Case : {0}")
        @ArgumentsSource(LetterReverserTestData.class)
        void letterReverseChangerTest(char letter, Character expected){
            assertThat(LetterReverser.reverseOnlyEnglish(letter)).isEqualTo(expected);
        }
    }

    static class LetterReverserTestData implements ArgumentsProvider{
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

    @Nested
    class Problem4ApplicationUnitTest{
        private final char CHANGED_LETTER = 'A';
        private MockedStatic<LetterReverser> mockLetterReverser;

        @ParameterizedTest(name = "Case : {0}")
        @ArgumentsSource(Problem4ApplicationUnitTestData.class)
        void problem4ApplicationUnitTest(String word, String expected){
            mockingReverseOnlyOneLetter();
            assertThat(Problem4.solution(word)).isEqualTo(expected);
        }

        @BeforeEach
        void mockClass() {
            mockLetterReverser = mockStatic(LetterReverser.class);
        }

        @AfterEach
        void closeMockedClass() {
            mockLetterReverser.close();
        }

        void mockingReverseOnlyOneLetter(){
            given(LetterReverser.reverseOnlyEnglish(anyChar()))
                    .willReturn(CHANGED_LETTER);
        }
    }

    static class Problem4ApplicationUnitTestData implements ArgumentsProvider{
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("Hello World","AAAAAAAAAAA"),
                    Arguments.of("WooWaTechCourse","AAAAAAAAAAAAAAA"),
                    Arguments.of("Come on","AAAAAAA")
            );
        }
    }
}
