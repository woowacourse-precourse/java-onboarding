package onboarding.unitTest.problem4;

import onboarding.problem4.LetterReverser;
import onboarding.problem4.StringReverser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

public class StringReverserTest {

    private final char CHANGED_LETTER = 'A';
    private MockedStatic<LetterReverser> mockLetterReverser;

    @ParameterizedTest(name = "Case : {0}")
    @ArgumentsSource(StringReverserUnitTestData.class)
    void StringReverserUnitTest(String word, String expected){
        mockingReverseConstantLetter();
        assertThat(StringReverser.reverse(word)).isEqualTo(expected);
    }

    @BeforeEach
    void mockClass() {
        mockLetterReverser = mockStatic(LetterReverser.class);
    }

    @AfterEach
    void closeMockedClass() {
        mockLetterReverser.close();
    }

    void mockingReverseConstantLetter(){
        given(LetterReverser.reverseOnlyEnglish(anyChar()))
                .willReturn(CHANGED_LETTER);
    }

    static class StringReverserUnitTestData implements ArgumentsProvider {
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
