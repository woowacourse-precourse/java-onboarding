package onboarding;

import onboarding.problem7.exception.IllegalRegexException;
import onboarding.problem7.exception.RecommendListNotExistException;
import onboarding.problem7.exception.UserNameLengthNotSatisfiedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Problem7AdditionalTest {
    @Test
    @DisplayName("user 길이 0")
    void userLengthZero () throws Exception {
        //given
        String user = "";
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
        //then
        assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                .isInstanceOf(UserNameLengthNotSatisfiedException.class);
    }

    @Test
    @DisplayName("user 길이 초과")
    void overflowUserLength () throws Exception {
        //given
        String user = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";//31자
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
        //then
        assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                .isInstanceOf(UserNameLengthNotSatisfiedException.class);
    }

    @Test
    @DisplayName("friend 요소 아이디 길이 초과")
    void overflowFriendUserLength() throws Exception {
        //given
        String user = "shakevan";
        List<List<String>> friends = List.of(
                List.of("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", //31자
                        "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        //when
        //then
        assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                .isInstanceOf(UserNameLengthNotSatisfiedException.class);
    }

    @Test
    @DisplayName("friend 길이 0")
    void friendSizeZero() throws Exception {
        //given
        String user = "shakevan";
        List<List<String>> friends = List.of(
                List.of("", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        //when
        //then
        assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                .isInstanceOf(UserNameLengthNotSatisfiedException.class);
    }

    @Test
    @DisplayName("추천 친구가 없는 경우")
    void isEmptyRecommendFriend() throws Exception {
        String user = "shakevan";
        List<List<String>> friends = List.of(
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of();

        //when
        //then
        assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                .isInstanceOf(RecommendListNotExistException.class);

    }
    
    @Test
    @DisplayName("사용자 ID가 소문자로만 이루어지지 않음")
    void userNameNotLowerCase() throws Exception {
        //given
        String user = "shakevan";
        List<List<String>> friends = List.of(
                List.of("KKK", "andole"),
                List.of("doKut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        //when
        //then
        assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                .isInstanceOf(IllegalRegexException.class);
    }

    @Test
    @DisplayName("visitor point 체크")
    void visitorPoint() throws Exception {
        //given
        String user = "aaa";
        List<List<String>> friends = List.of(
                List.of("kkk", "aaa")
        );
        List<String> visitors = List.of("bbb", "bbb", "bbb", "cc", "cc", "aa", "aa", "dd");
        List<String> expect = List.of("bbb", "aa", "cc", "dd");
        //when
        List<String> result = Problem7.solution(user, friends, visitors);
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("visitor point와 함께아는 친구 포인트가 같을 때 체크")
    void visitorPointEqualFrientPoint() throws Exception {
        //given
        String user = "aaa";
        List<List<String>> friends = List.of(
                List.of("kkk", "aaa"),
                List.of("kkk", "ccc")
        );
        List<String> visitors = List.of("bbb", "bbb", "bbb", "bbb","bbb","bbb","bbb","bbb","bbb","bbb");
        List<String> expect = List.of("bbb","ccc");
        //when
        List<String> result = Problem7.solution(user, friends, visitors);
        //then
        assertThat(result).isEqualTo(expect);
    }


}
