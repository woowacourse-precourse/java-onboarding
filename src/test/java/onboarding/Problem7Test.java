package onboarding;

import onboarding.problem7.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Problem7Test {
    @Test
    public void 멤버수테스트() throws Exception {
        //given
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );

        //when
        Map<String, Member> store = Problem7.setMemberStore(friends);

        //then
        Assertions.assertThat(store.size()).isEqualTo(5);
    }
    @Test
    public void 멤버친구수테스트() throws Exception {
        //given
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );

        //when
        Map<String,Member> store = Problem7.setMemberStore(friends);
        List<Member> findFriends = store.get("donut").getFriends();

        //then
        Assertions.assertThat(findFriends.get(0)).isEqualTo(store.get("andole"));
        Assertions.assertThat(findFriends.get(1)).isEqualTo(store.get("jun"));
        Assertions.assertThat(findFriends.get(2)).isEqualTo(store.get("mrko"));
    }

}