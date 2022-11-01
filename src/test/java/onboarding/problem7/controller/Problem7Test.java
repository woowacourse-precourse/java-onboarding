package onboarding.problem7.controller;

import onboarding.problem7.domain.Users;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
        
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case2() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andol"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("jun", "andol", "andole", "bedi");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case3() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("andole", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("jun", "bedi");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case4() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andol"),
                List.of("donut", "junn"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "junb"),
                List.of("shakevan", "juna"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andol", "andole", "jun", "juna", "junb");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case5() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andol"),
                List.of("donut", "junn"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan", "junb", "juna");
        List<String> result = List.of("andol", "andole", "jun", "junn", "bedi");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case6() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andol"),
                List.of("donut", "junn"),
                List.of("junn", "junns"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan", "junb", "juna");
        List<String> result = List.of("andol", "andole", "jun", "junn", "bedi");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case7() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("jun", "junn"),
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case8() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "donut")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("shakevan", "andole", "jun", "bedi");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case9() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("jun");
        List<String> result = List.of("jun");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case10() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("shakevan", "mrko"),
                List.of("shakevan", "jun")
        );
        List<String> visitors = List.of();
        List<String> result = List.of("jun");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case11() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("shakevan", "junn"),
                List.of("shakevan", "jun")
        );
        List<String> visitors = List.of("abc");
        List<String> result = List.of("abc");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case12() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("jun", "andole", "bedi");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case13() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("jun", "bedi", "andole");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case14() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("mrko", "jun"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "bedi");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case15() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("mrko", "jun"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("jun", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "bedi");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case16() {
        String user = "andole";
        List<List<String>> friends = List.of(
                List.of("andole", "jun"),
                List.of("donut", "jun"),
                List.of("donut", "shakevan"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "bedi"),
                List.of("anne", "jun")
        );
        List<String> visitors = List.of("donut", "mrko", "peter", "sam");
        List<String> result = List.of("donut", "anne", "bedi", "mrko", "peter");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case17() {
        String user = "andole";
        List<List<String>> friends = List.of(
                List.of("andole", "jun"),
                List.of("andole", "bedi"),
                List.of("jun", "shakevan"),
                List.of("jun", "kane"),
                List.of("jun", "sam"),
                List.of("bedi", "shakevan"),
                List.of("bedi", "anne"),
                List.of("bedi", "sam"),
                List.of("anne", "mrko")
        );
        List<String> visitors = List.of("donut", "anne", "mrko", "mrko", "sam");
        List<String> result = List.of("sam", "shakevan", "anne", "kane", "mrko");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
    
    @Test
    void case18() {
        String user = "hello";
        List<List<String>> friends = List.of(
                List.of("andole", "jun"),
                List.of("andole", "bedi"),
                List.of("jun", "shakevan"),
                List.of("jun", "kane"),
                List.of("jun", "sam"),
                List.of("bedi", "shakevan"),
                List.of("bedi", "anne"),
                List.of("bedi", "sam"),
                List.of("anne", "mrko")
        );
        List<String> visitors = List.of("donut", "anne", "mrko", "mrko", "sam");
        List<String> result = List.of("mrko", "anne", "donut", "sam");
        Users users = new Users(user, friends, visitors);
    
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        assertThat(users.recommendedFriends(user)).isEqualTo(result);
    }
}
