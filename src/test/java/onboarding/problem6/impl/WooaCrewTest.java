package onboarding.problem6.impl;

import onboarding.problem6.crew.validator.CrewValidator;
import onboarding.problem6.crew.WooaCrew;
import onboarding.problem6.crew.validator.CrewValidatorV1;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WooaCrewTest {
    @Test
    public void constructionTest() {
        List<String> data = new ArrayList<>(Arrays.asList(
                "test@email.com",
                "닉네임"));
        CrewValidator validator = new CrewValidatorV1();
        construct(data, validator);
    }

    @Test
    public void constructionFailTest1() {
        List<String> data = new ArrayList<>(Arrays.asList(
                "test@email.com",
                "for",
                "Geeks"));
        CrewValidator validator = new CrewValidatorV1();

        assertThrows(IllegalArgumentException.class, () -> construct(data, validator));
    }

    @Test
    public void constructionFailTest2() {
        List<String> data = new ArrayList<>(Arrays.asList(
                "test@email.com",
                "Eng"));
        CrewValidator validator = new CrewValidatorV1();

        assertThrows(IllegalArgumentException.class, () -> construct(data, validator));
    }

    @Test
    public void constructionFailTest3() {
        List<String> data = new ArrayList<>(Arrays.asList(
                "test@gggggmail.com",
                "테스트"));
        CrewValidator validator = new CrewValidatorV1();

        assertThrows(IllegalArgumentException.class, () -> construct(data, validator));
    }

    private void construct(List<String> data, CrewValidator validator) {
        WooaCrew crew = new WooaCrew(data, validator);
    }

}