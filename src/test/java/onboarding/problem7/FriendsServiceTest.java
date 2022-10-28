package onboarding.problem7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FriendsServiceTest {

    @DisplayName("사용자가 아는 친구의 수를 잘 구한다.")
    @Test
    void getRelationship() {
        FriendsService friendsService = new FriendsService();

        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );

        Map<String, Integer> relationship = friendsService.getRelationship(user, friends);
        System.out.println(relationship);
    }

}