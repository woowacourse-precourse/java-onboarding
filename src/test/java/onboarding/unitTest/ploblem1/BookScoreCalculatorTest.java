package onboarding.unitTest.ploblem1;

import onboarding.problem1.BookPage;
import onboarding.problem1.BookScoreCalculator;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.MockedConstruction;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

public class BookScoreCalculatorTest {

    @ParameterizedTest(name = "{2}")
    @ArgumentsSource(BookScoreCalculatorTestData.class)
    void bookScoreCalculatorTest(List<Integer> bookData, int expect, String message){
        try (MockedConstruction mocked = mockConstruction(BookPage.class)){
            final BookPage bookPage = new BookPage(bookData);
            when(bookPage.getLeftPage()).thenReturn(bookData.get(0));
            when(bookPage.getRightPage()).thenReturn(bookData.get(1));

            assertThat(BookScoreCalculator.score(bookPage)).isEqualTo(expect);
        }
    }

    static class BookScoreCalculatorTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(List.of(77,78), 56, "Case 1"),
                    Arguments.of(List.of(211,212), 5, "Case 2"),
                    Arguments.of(List.of(101,102), 3, "Case 3"),
                    Arguments.of(List.of(131,132), 6, "Case 4")
            );
        }
    }
}
