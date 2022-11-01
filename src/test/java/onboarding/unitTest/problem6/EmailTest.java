package onboarding.unitTest.problem6;

import onboarding.exception.InputException;
import onboarding.problem6.Email;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class EmailTest {

    @Nested
    class NormalEmailTest{

        @ParameterizedTest(name = "Case : {0}")
        @ArgumentsSource(NormalEmailTestData.class)
        void emailTestWhenNormal(String email){
            assertThat(new Email(email).getEmail()).isEqualTo(email);
        }

    }

    static class NormalEmailTestData implements ArgumentsProvider{
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("woowa@email.com"),
                    Arguments.of("leegwichan@email.com")
            );
        }
    }

    @Nested
    class AbnormalEmailTest{

        @ParameterizedTest(name = "Case : {0}")
        @ArgumentsSource(AbnormalEmailTestData.class)
        void emailTestWhenAbnormal(String email){
            try {
                new Email(email);
                fail("Not Occur Exception");
            } catch (InputException e){

            }
        }
    }

    static class AbnormalEmailTestData implements ArgumentsProvider{

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("@@email.comwoowa"),
                    Arguments.of("leegwichan@naver.com"),
                    Arguments.of("AAAAAAAAAAAAAAAAAAA@email.com")
            );
        }
    }
}
