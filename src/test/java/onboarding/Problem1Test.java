package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static onboarding.Problem1.validatePage;
import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    @Test
    public void validatePageTest() {
        // given
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);

        // when
        boolean checkPobiNumber = validatePage(pobi);
        boolean checkCrongNumber = validatePage(crong);

        // then
        assertThat(checkPobiNumber).isEqualTo(true);
        assertThat(checkCrongNumber).isEqualTo(true);
    }

    @Test
    public void validatePageFailTest() {
        // given
        List<Integer> pobi = List.of(99, 102);
        List<Integer> crong = List.of(211, 212);
        List<Integer> james = List.of(0, 1);
        List<Integer> mac = List.of(401, 402);

        // when
        boolean checkPobiNumber = validatePage(pobi);
        boolean checkCrongNumber = validatePage(crong);
        boolean checkJamesNumber = validatePage(james);
        boolean checkMacNumber = validatePage(mac);

        // then
        assertThat(checkPobiNumber).isEqualTo(false);
        assertThat(checkCrongNumber).isEqualTo(true);
        assertThat(checkJamesNumber).isEqualTo(false);
        assertThat(checkMacNumber).isEqualTo(false);
    }
}