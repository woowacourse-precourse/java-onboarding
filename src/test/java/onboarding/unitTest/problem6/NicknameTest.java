package onboarding.unitTest.problem6;

import onboarding.exception.InputException;
import onboarding.problem6.Nickname;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class NicknameTest {

    @Nested
    class NormalNicknameTest{

        @ParameterizedTest(name = "Case : {0}")
        @ArgumentsSource(NormalNicknameTestData.class)
        void nicknameTestWhenNormal(String nickname){
            assertThat(new Nickname(nickname).getNickname()).isEqualTo(nickname);
        }
    }

    static class NormalNicknameTestData implements ArgumentsProvider{

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("포비"),
                    Arguments.of("귀찮")
            );
        }
    }

    @Nested
    class AbnormalNicknameTest{

        @ParameterizedTest(name = "Case : {0}")
        @ArgumentsSource(AbnormalNicknameTestData.class)
        void nicknameTestWhenAbnormal(String nickname){
            try {
                new Nickname(nickname);
                fail("Not Occur Exception");
            } catch (InputException e){

            }
        }
    }

    static class AbnormalNicknameTestData implements ArgumentsProvider{
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("4비"),
                    Arguments.of(""),
                    Arguments.of("가나다라마바사아자차카타파하에해으헤으헤으허허")
            );
        }
    }
}
