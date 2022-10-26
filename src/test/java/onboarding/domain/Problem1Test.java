package onboarding.domain;

import onboarding.domain.problem1.Page;
import onboarding.domain.problem1.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class Problem1Test {

    @Test
    public void testPage() {
        Page page = new Page(124);
        assertThat(page.getLargeValue()).isEqualTo(8);
    }
    @Test
    public void testTwoPage() {
        Person person = new Person(List.of(123,124));
        assertThat(person.getLargeValue()).isEqualTo(8);
    }
    @Test
    public void validPagesContinuous() {
        assertThatThrownBy(() -> {
            Person person = new Person(List.of(123,456));
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void validPagesOdd() {
        assertThatThrownBy(() -> {
            Person person = new Person(List.of(124,125));
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
