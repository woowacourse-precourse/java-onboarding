package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem7Test {

    @Test
    void returnFriendName() {

        List<String> friend = List.of("donut", "andole");

        String result1 = Problem7.returnFriendName(friend, "andole");
        assertThat(result1).isEqualTo("donut");

        String result2 = Problem7.returnFriendName(friend, "donut");
        assertThat(result2).isEqualTo("andole");
    }

    @Test
    void makeFriendsList() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );

        List<String> result = Problem7.makeFriendsList(user, friends);

        assertThat(result).contains("donut", "shakevan");
    }

    @Test
    void makeScoreMap() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> friendsList = Problem7.makeFriendsList(user, friends);


        HashMap<String, Integer> result = Problem7.makeScoreMap(friends, friendsList, visitors, user);

        assertThat(result.keySet()).contains("andole", "jun", "bedi");
    }
}