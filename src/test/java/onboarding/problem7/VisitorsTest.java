package onboarding.problem7;

import onboarding.problem7.exception.FriendsException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VisitorsTest {
    @Test
    void getVisitor() {
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        SnsId bedi = new SnsId("bedi");
        SnsId donut = new SnsId("donut");
        SnsId shakaven = new SnsId("shakevan");

        Visitors visitors1 = new Visitors(visitors);

        assertThat(visitors1.getVisitors()).isEqualTo(List.of(bedi, bedi, donut, bedi, shakaven));
    }
}