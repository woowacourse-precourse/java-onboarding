package onboarding.unitTest.problem3;

import onboarding.problem3.NumberCount;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
public class NumberCountTest {

    @ParameterizedTest(name = "NumberCount369 test : {0}")
    @ArgumentsSource(NumberCount369TestData.class)
    void NumberCount369Test(int number, int expected){
        assertThat(new NumberCount().count369Under(number)).isEqualTo(expected);
    }

    static class NumberCount369TestData implements ArgumentsProvider{

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(333, 228),
                    Arguments.of(4444, 4963),
                    Arguments.of(55555, 75926),
                    Arguments.of(666666, 1162965),
                    Arguments.of(7777777, 15962963)
            );
        }
    }
}
