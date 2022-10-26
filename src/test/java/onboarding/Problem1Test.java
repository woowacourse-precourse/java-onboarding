package onboarding;

import onboarding.problem1.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Problem1Test {

    @Test
    public void testPage() {
        Page page = new Page(124);
        assertThat(page.getLargeValue()).isEqualTo(8);
    }
    @Test
    public void testTwoPage() {
        Person person = new Person(Arrays.asList(123,124));
        assertThat(person.getLargeValue()).isEqualTo(8);
    }
}
