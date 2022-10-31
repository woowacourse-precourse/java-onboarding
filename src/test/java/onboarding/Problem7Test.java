package onboarding;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem7Test {
    @Test
    void case1() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = Collections.emptyList();
        List<String> result = List.of("andole", "jun");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }
    @Test
    void onlyNotFriendVisitorCase1() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("mrko", "andole"),
                List.of("mrko", "jun")
        );
        List<String> visitors = List.of("jun","andole","jun","abc");
        List<String> result = List.of("abc");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }
    @Test
    void maxValueTimeTest() {
        long startTime = System.currentTimeMillis();
        String user = "mrko";
        List<List<String>> friends = new ArrayList<>(List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        ));
        for (int i = 0; i < 995; i++) {
            friends.add(new ArrayList<>(
                    List.of((""+(char)i),""+(char)(996+i))));
        }
        List<String> visitors = Collections.emptyList();
        List<String> result = List.of("andole", "jun");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        long endTime =System.currentTimeMillis();
        long time = (endTime-startTime)/1000;
        assertThat(1L).isGreaterThan(time);


    }


}