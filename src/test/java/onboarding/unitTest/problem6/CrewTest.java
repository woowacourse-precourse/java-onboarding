package onboarding.unitTest.problem6;

import onboarding.problem6.Crew;
import onboarding.problem6.Email;
import onboarding.problem6.Nickname;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.MockedConstruction;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.*;

@Nested
public class CrewTest {

    @DisplayName("CrewConstructor Test")
    @ParameterizedTest(name = "{displayName} : Case {index}")
    @ArgumentsSource(CrewFromTestData.class)
    void constructCrewTest(List<String> form, boolean isNormalCase) {
        try (MockedConstruction mockEmail = mockConstruction(Email.class);
             MockedConstruction mockNickname = mockConstruction(Nickname.class)){

            if (isNormalCase){
                checkNotOccurExceptionWhenConstructCrew();
            } else {
                checkOccurExceptionWhenConstructCrew();
            }
        }
    }

    void checkNotOccurExceptionWhenConstructCrew(){
        try{
            new Crew(List.of("a", "b"));
        } catch (Exception e){
            fail("Occur Exception");
        }
    }

    void checkOccurExceptionWhenConstructCrew(){
        try{
            new Crew(List.of("a", "b"));
        } catch (Exception e){
            fail("Occur Exception");
        }
    }


    static class CrewFromTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(List.of("pobi@email.com", "포비"), true),
                    Arguments.of(List.of(), false),
                    Arguments.of(List.of("pobi@naver.com"), false),
                    Arguments.of(List.of("pobi@email.com", "포비", ""), false)
            );
        }
    }



}
