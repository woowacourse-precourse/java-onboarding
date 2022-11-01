package onboarding.problem7;

import onboarding.Problem7;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class RecommenderTest {

    Map<String, Member> store;
    MrKoRecommender recommender;

    public RecommenderTest() {
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );

        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        store = Problem7.setMemberStore(friends, visitors);
        Problem7.setUserVisitors("mrko", visitors);
        recommender = new MrKoRecommender(store);
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
        Assertions.assertThat(recommender.isFriend(mrko.getName(), donut.getName())).isEqualTo(true);
    }

    @Test
    public void 같은친구를맺는지테스트() throws Exception {
        //given
        Member shakevan = new Member("shakevan");
        Member donut = new Member("donut");

        //when;
        shakevan.getFriends().add(donut);
        donut.getFriends().add(shakevan);
        //then
        Assertions.assertThat(recommender.hasCoFriend(shakevan.getName(), donut.getName())).isEqualTo(true);
    }

    @Test
    public void 방문수테스트() throws Exception {
        //given
        String user = "mrko";
        String visitor = "bedi";

        //when
        int visits = recommender.countVisits(user, visitor);

        //then

        Assertions.assertThat(visits).isEqualTo(3);
    }

    @Test
    public void 추천점수테스트() throws Exception {
        //given
        String user = "mrko";
        String[] memberNames = store.keySet().toArray(new String[0]);

        //when
        int[] scores = recommender.calculateScores(user, memberNames, new int[store.size()]);

        //then
        Assertions.assertThat(scores).isEqualTo(new int[]{10, 10, 0, 3, 0, 0});
    }
}