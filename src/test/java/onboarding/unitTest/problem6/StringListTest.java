package onboarding.unitTest.problem6;

import onboarding.problem6.StringList;
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
public class StringListTest {

    @ParameterizedTest(name = "Case : {index}")
    @ArgumentsSource(SoringStingListTestData.class)
    void sortStringListTest(List<String> list, List<String> expected){
        assertThat(StringList.sort(list)).isEqualTo(expected);
    }

    static class SoringStingListTestData implements ArgumentsProvider{

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(List.of("cc","bb","aa"), List.of("aa","bb","cc")),
                    Arguments.of(List.of("ad","abb","abc"), List.of("abb","abc","ad")),
                    Arguments.of(List.of("h","g","f","e","d","c","b","a","z"), List.of("a","b","c","d","e","f","g","h","z")),
                    Arguments.of(List.of("a"), List.of("a")),
                    Arguments.of(List.of(), List.of())
            );
        }
    }
}
