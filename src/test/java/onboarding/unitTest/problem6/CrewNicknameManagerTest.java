package onboarding.unitTest.problem6;

import onboarding.exception.InputException;
import onboarding.problem6.Crew;
import onboarding.problem6.CrewNicknameManager;
import org.junit.jupiter.api.*;
import org.mockito.MockedConstruction;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.mockConstruction;

@Nested
public class CrewNicknameManagerTest {

    @Test
    @DisplayName("Normal Case")
    void crewNicknameManagerTestWhenNormal(){
        try {
            new CrewNicknameManager(List.of(
                    List.of("pobi","pobi@email.com"), List.of("chan","chan@email.com")));
        } catch (InputException e){
            fail("Occur Exception");
        }

    }

    @Test
    @DisplayName("When number of crew is 0")
    void crewNicknameManagerTestCrewNumIs0(){
        try {
            new CrewNicknameManager(List.of());
            fail("Not Occur Exception");
        } catch (InputException e){
        }

    }

    @Test
    @DisplayName("When number of crew is over 10000")
    void crewNicknameManagerTestCrewNumIsOver10000(){
        try {
            new CrewNicknameManager(listSizeOver10000());
            fail("Not Occur Exception");
        } catch (InputException e){
        }

    }

    @BeforeAll
    static void mockingConstruction(){
        MockedConstruction mockCrew = mockConstruction(Crew.class);
    }

    List<List<String>> listSizeOver10000(){
        List<List<String>> data = new ArrayList<>();
        for (int i=0; i<20000; i++){
            data.add(List.of());
        }
        return data;
    }
}
