package onboarding.problem7.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SocialNetworkServiceTest {

    @DisplayName("친구 추천 리스트를 반환한다.")
    @Test
    void recommendFriend() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("pobi", "yunsik"),
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("andole", "jun", "bedi");

        Assertions.assertThat(SocialNetworkService.recommendFriends(user, friends, visitors))
                .containsExactly("andole", "jun", "bedi");
    }
}
