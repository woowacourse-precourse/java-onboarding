package onboarding.problem7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VisitorsTest {
    @Test
    void getVisitor() {
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        SnsId bedi = new SnsId("bedi");
        SnsId donut = new SnsId("donut");
        SnsId shakaven = new SnsId("shakevan");

        VisitorIds visitors1 = new VisitorIds(visitors);

        assertThat(visitors1.getVisitors()).isEqualTo(List.of(bedi, bedi, donut, bedi, shakaven));
    }
}