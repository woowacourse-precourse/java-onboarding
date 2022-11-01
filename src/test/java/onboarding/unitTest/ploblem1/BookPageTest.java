package onboarding.unitTest.ploblem1;

import onboarding.exception.InputException;
import onboarding.problem1.BookPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.fail;

@Nested
public class BookPageTest {

    @DisplayName("bookPage normal case Test")
    @ParameterizedTest(name = "{displayName} : Case {index}")
    @ArgumentsSource(BookPageTestNormalData.class)
    void bookPageNormalCaseTest(List<Integer> bookPage){
        try {
            new BookPage(bookPage);
        } catch (InputException e){
            fail("Occur Exception");
        }
    }

    static class BookPageTestNormalData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(List.of(77,78)),
                    Arguments.of(List.of(335,336))
            );
        }
    }

    @DisplayName("bookPage abnormal case Test")
    @ParameterizedTest(name = "{displayName} : {1}")
    @ArgumentsSource(BookPageTestAbnormalData.class)
    void bookPageAbnormalCaseTest(List<Integer> bookPage, String message){
        try {
            new BookPage(bookPage);
            fail("Not Occur Exception");
        } catch (InputException e){

        }
    }

    static class BookPageTestAbnormalData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(List.of(77,78,79), "List Size is not 2"),
                    Arguments.of(List.of(78,79), "Left Page id not odd"),
                    Arguments.of(List.of(77,79), "Right page is not next page of left page"),
                    Arguments.of(List.of(1001,1002), "Over max page")
            );
        }
    }

}
