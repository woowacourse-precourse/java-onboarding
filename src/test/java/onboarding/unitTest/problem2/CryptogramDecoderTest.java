package onboarding.unitTest.problem2;

import onboarding.problem2.CryptogramDecoder;
import onboarding.problem2.TypeConverter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.ArgumentMatcher;
import org.mockito.MockedStatic;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

@Nested
public class CryptogramDecoderTest {

    private MockedStatic<TypeConverter> mockLetterReverser;

    @ParameterizedTest(name = "Case {index}")
    @ArgumentsSource(CryptogramDecoderTestData.class)
    void cryptogramDecoderTest(List<Character> cryptogramCharList, List<Character> decodedCharList){

        given(TypeConverter.stringToCharacterList(anyString())).willReturn(cryptogramCharList);
        given(TypeConverter.characterListToString(sameCharacterList(decodedCharList))).willReturn("pass");

        assertThat(CryptogramDecoder.decode("something")).isEqualTo("pass");
    }

    private List<Character> sameCharacterList(List<Character> list){
        return argThat(new ArgumentMatcher<List<Character>>() {
            @Override
            public boolean matches(List<Character> argument) {
                if (list.size() != argument.size()) return false;
                for (int i=0; i<list.size(); i++){
                    if(list.get(i) != argument.get(i)) return false;
                }
                return true;
            }
        });
    }

    @BeforeEach
    void mockClass() {
        mockLetterReverser = mockStatic(TypeConverter.class);
    }

    @AfterEach
    void closeMockedClass() {
        mockLetterReverser.close();
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
