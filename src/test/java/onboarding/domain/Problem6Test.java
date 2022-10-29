package onboarding.domain;

import onboarding.domain.problem6.Nickname;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Problem6Test {
    @ParameterizedTest
    @CsvSource({"제이엠,엠제이","제이엠,제이슨","제이슨,엠제이"})
    public void overlapTest(String nickname1, String nickname2) {
        Nickname JM = new Nickname(nickname1);
        assertThat(JM.hasOverlap(new Nickname(nickname2))).isTrue();
    }
    @ParameterizedTest
    @CsvSource({"워니,이제엠","워니,제이슨","이제엠,엠제이"})
    public void overlapTest2(String nickname1, String nickname2) {
        Nickname JM = new Nickname(nickname1);
        assertThat(JM.hasOverlap(new Nickname(nickname2))).isFalse();
    }

}
