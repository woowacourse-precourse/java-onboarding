package onboarding.domain;

import onboarding.domain.problem6.NickName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Problem6Test {
    @Test
    public void overlapTest1() {
        NickName jm = new NickName("제이엠");
        assertThat(jm.hasOverlap(new NickName("제이슨"))).isTrue();
    }
    @Test
    public void overlapTest2() {
        NickName jm = new NickName("제이엠");
        assertThat(jm.hasOverlap(new NickName("워니"))).isFalse();
    }
    @Test
    public void overlapTest3() {
        NickName jm = new NickName("제이엠");
        assertThat(jm.hasOverlap(new NickName("엠제이"))).isTrue();
    }
    @Test
    public void overlapTest4() {
        NickName jm = new NickName("이제엠");
        assertThat(jm.hasOverlap(new NickName("엠제이"))).isFalse();
    }
}
