package onboarding;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.MockedStatic;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class Problem1UnitTest {

    @Nested
    class BookPageDiscriminatorTest{

        @ParameterizedTest(name = "{2}")
        @ArgumentsSource(BookPageDiscriminatorTestData.class)
        void bookPageDiscriminatorTest(List<Integer> book, boolean expect, String message){
            assertThat(BookPageDiscriminator.isProperBookPage(book)).isEqualTo(expect);
        }
    }

    static class BookPageDiscriminatorTestData implements ArgumentsProvider{

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(List.of(77,78), true, "Normal Case"),
                    Arguments.of(List.of(77,78,79), false, "List Size is not 2"),
                    Arguments.of(List.of(78,79), false, "Left Page id not odd"),
                    Arguments.of(List.of(77,79), false, "Right page is not next page of left page"),
                    Arguments.of(List.of(1001,1002), false, "Over max page")
            );
        }
    }

    @Nested
    class BookScoreCalculatorTest{

        @ParameterizedTest(name = "{2}")
        @ArgumentsSource(BookScoreCalculatorTestData.class)
        void bookScoreCalculatorTest(List<Integer> book, int expect, String message){
            assertThat(BookScoreCalculator.score(book)).isEqualTo(expect);
        }
    }

    static class BookScoreCalculatorTestData implements ArgumentsProvider{

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

    @Nested
    class Problem1ApplicationUnitTest{
        private final List<Integer> POBI_CASE = List.of(97,98);
        private final List<Integer> CRONG_CASE = List.of(131,132);

        private MockedStatic<BookPageDiscriminator> mockBookPageDiscriminator;
        private MockedStatic<BookScoreCalculator> mockBookScoreCalculator;

        @DisplayName("Problem1ApplicationUnitTest")
        @ParameterizedTest(name = "{4}")
        @ArgumentsSource(Problem1ApplicationUnitTestData.class)
        void bookScoreCalculatorTest(boolean isBookProper, int pobiScore, int crongScore, int expected, String message){
            mockingBookPageIsProper(isBookProper);
            mockingBookScore(pobiScore, crongScore);
            assertThat(Problem1.solution(POBI_CASE, CRONG_CASE)).isEqualTo(expected);
        }

        @BeforeEach
        void beforeAll() {
            mockBookPageDiscriminator = mockStatic(BookPageDiscriminator.class);
            mockBookScoreCalculator = mockStatic(BookScoreCalculator.class);
        }

        @AfterEach
        void afterAll() {
            mockBookPageDiscriminator.close();
            mockBookScoreCalculator.close();
        }

        void mockingBookPageIsProper(boolean willReturn){
            given(BookPageDiscriminator.isProperBookPage(anyList(), anyList()))
                    .willReturn(willReturn);
        }

        void mockingBookScore(int pobiScore, int crongScore){
            given(BookScoreCalculator.score(POBI_CASE)).willReturn(pobiScore);
            given(BookScoreCalculator.score(CRONG_CASE)).willReturn(crongScore);
        }
    }

    static class Problem1ApplicationUnitTestData implements ArgumentsProvider{

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(false, 100, 100, -1, "exceptional circumstance case"),
                    Arguments.of(true, 100, 10, 1, "Pobi win case"),
                    Arguments.of(true, 10, 100, 2, "Crong win case"),
                    Arguments.of(true, 100, 100, 0, "Draw case")
            );
        }
    }
}