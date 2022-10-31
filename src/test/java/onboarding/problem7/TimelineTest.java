package onboarding.problem7;

import onboarding.problem1.problem7.Timeline;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TimelineTest {
    @Test
    @DisplayName("CRUD Test")
    void validateTimeline(){
        Timeline timeline = new Timeline();
        timeline.addVisitInfo("1","2");
        timeline.addVisitInfo("1","2");
        timeline.addVisitInfo("1","3");
        timeline.addVisitInfo("1","3");
        timeline.addVisitInfo("1","3");
        timeline.addVisitInfo("1","4");
        timeline.addVisitInfo("4","1");
        timeline.addVisitInfo("4","1");


        Assertions.assertThat(timeline.getVisitTimes("1","2")).isEqualTo(2);
        Assertions.assertThat(timeline.getVisitTimes("1","3")).isEqualTo(3);
        Assertions.assertThat(timeline.getVisitTimes("1","4")).isEqualTo(1);
        Assertions.assertThat(timeline.getVisitTimes("4","1")).isEqualTo(2);
    }
}
