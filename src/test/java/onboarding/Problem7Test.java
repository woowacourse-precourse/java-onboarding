package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem7Test {

    @Test
    public void getAlreadyFriendWithUserListFromFriendsTest() {
        //given
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );

        //when
        List<String> alreadyFriendWithUserListFromFriends = Problem7.getAlreadyFriendWithUserListFromFriends(user, friends);

        //then
        assertThat(alreadyFriendWithUserListFromFriends).containsExactly("donut", "shakevan");
    }

    @Test
    public void getPotentialFriendWithUserListFromFriendsAndVisitorsTest() {
        //given
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

        //when
        List<String> potentialFriendWithUserListFromFriendsAndVisitors = Problem7.getPotentialFriendWithUserListFromFriendsAndVisitors(user, friends, visitors);

        //then
        assertThat(potentialFriendWithUserListFromFriendsAndVisitors).containsExactly("andole", "jun", "bedi");
    }

    @Test
    public void howManyKnowEachOtherWithUserTest() {
        //given
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

        //when
        int howManyKnowEachOtherWithUser = Problem7.howManyKnowEachOtherWithUser(user, friends, "andole");

        //then
        assertThat(howManyKnowEachOtherWithUser).isEqualTo(2);
    }

    @Test
    public void howManyKnowEachOtherWithUserTest2() {
        //given
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

        //when
        int howManyKnowEachOtherWithUser = Problem7.howManyKnowEachOtherWithUser(user, friends, "jun");

        //then
        assertThat(howManyKnowEachOtherWithUser).isEqualTo(2);
    }

    @Test
    public void howManyKnowEachOtherWithUserTest3() {
        //given
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

        //when
        int howManyKnowEachOtherWithUser = Problem7.howManyKnowEachOtherWithUser(user, friends, "bedi");

        //then
        assertThat(howManyKnowEachOtherWithUser).isEqualTo(0);
    }

    @Test
    public void calculateScoreTest() {
        //given
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

        String potentialFriend = "andole";
        int howManyKnowEachOtherWithUser = Problem7.howManyKnowEachOtherWithUser(user, friends, potentialFriend);

        //when
        int calculateScore = Problem7.calculateScore(howManyKnowEachOtherWithUser, potentialFriend, visitors);

        //then
        assertThat(calculateScore).isEqualTo(20);
    }

    @Test
    public void calculateScoreTest2() {
        //given
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

        String potentialFriend = "jun";
        int howManyKnowEachOtherWithUser = Problem7.howManyKnowEachOtherWithUser(user, friends, potentialFriend);

        //when
        int calculateScore = Problem7.calculateScore(howManyKnowEachOtherWithUser, potentialFriend, visitors);

        //then
        assertThat(calculateScore).isEqualTo(20);
    }

    @Test
    public void calculateScoreTest3() {
        //given
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

        String potentialFriend = "bedi";
        int howManyKnowEachOtherWithUser = Problem7.howManyKnowEachOtherWithUser(user, friends, potentialFriend);

        //when
        int calculateScore = Problem7.calculateScore(howManyKnowEachOtherWithUser, potentialFriend, visitors);

        //then
        assertThat(calculateScore).isEqualTo(3);
    }
}