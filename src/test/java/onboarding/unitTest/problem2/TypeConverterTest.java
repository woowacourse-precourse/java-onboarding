package onboarding.unitTest.problem2;

import onboarding.problem2.TypeConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
public class TypeConverterTest {

    @DisplayName("string to characterList Test")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ArgumentsSource(StringToCharListTestData.class)
    void stringToCharacterListTest(String string, List<Character> characterList){
        assertThat(TypeConverter.stringToCharacterList(string)).isEqualTo(characterList);
    }

    @DisplayName("characterList to string Test")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ArgumentsSource(StringToCharListTestData.class)
    void characterListToStringTest(String string, List<Character> characterList){
        assertThat(TypeConverter.characterListToString(characterList)).isEqualTo(string);
    }

    static class StringToCharListTestData implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("Hello", List.of('H','e','l','l','o')),
                    Arguments.of("World", List.of('W','o','r','l','d')),
                    Arguments.of("Woo wa", List.of('W','o','o',' ','w','a'))
            );
        }
    }
}
