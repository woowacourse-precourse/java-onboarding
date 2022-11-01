package onboarding.problem7;

import onboarding.Problem7;
import onboarding.problem7.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Problem7Test {
    @Test
    public void 멤버등록테스트() throws Exception {
        //given
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        //when
        Map<String, Member> store = Problem7.setMemberStore(friends, visitors);

        //then
        Assertions.assertThat(store.size()).isEqualTo(6);
    }
    @Test
    public void 멤버친구등록테스트() throws Exception {
        //given
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        //when
        Map<String,Member> store = Problem7.setMemberStore(friends, visitors);
        List<Member> findFriends = store.get("donut").getFriends();

        //then
        Assertions.assertThat(findFriends.get(0)).isEqualTo(store.get("andole"));
        Assertions.assertThat(findFriends.get(1)).isEqualTo(store.get("jun"));
        Assertions.assertThat(findFriends.get(2)).isEqualTo(store.get("mrko"));
    }

    @Test
    public void 두멤버가친구인지테스트() throws Exception {
        //given
        Member mrko = new Member("mrko");
        Member donut = new Member("donut");

        //when;
        mrko.getFriends().add(donut);
        donut.getFriends().add(mrko);
        //then
        Assertions.assertThat(donut.isFriendOf(mrko)).isEqualTo(true);
    }

    @Test
    public void 방문자인지테스트() throws Exception {
        //given
        String user = "mrko";

        Member mrko = new Member("mrko");
        Member donut = new Member("donut");

        //when
        mrko.getVisitors().add(donut);

        //then
        Assertions.assertThat(donut.isVisitorOf(mrko)).isEqualTo(true);
    }
}