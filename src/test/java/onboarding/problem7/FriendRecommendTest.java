package onboarding.problem7;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FriendRecommendTest {

    @Test
    void recommend_by_acquaintances_among_visitors_() {
        SNSId user = new SNSId("mrko");
        SNSId donut = new SNSId("donut");
        SNSId andole = new SNSId("andole");
        SNSId shakevan = new SNSId("shakevan");
        SNSId jun = new SNSId("jun");
        List<List<SNSId>> friends = List.of(
                List.of(donut, andole),
                List.of(donut, jun),
                List.of(donut, user),
                List.of(shakevan, andole),
                List.of(shakevan, jun),
                List.of(shakevan, user)
        );

        Map<String, Integer> result = new HashMap<>();
        result.put("jun", 10);
        result.put("andole", 10);

        RecommendFriendFinder recommendFriendFinder = new RecommendFriendFinder();
        Map<String, Integer> acquaintanceResult = recommendFriendFinder.getAcquaintanceResult(user, friends);
        assertTrue(acquaintanceResult.equals(result));
    }

    @Test
    void getVisitResult() {
        SNSId user = new SNSId("mrko");
        SNSId donut = new SNSId("donut");
        SNSId andole = new SNSId("andole");
        SNSId shakevan = new SNSId("shakevan");
        SNSId jun = new SNSId("jun");
        SNSId aizza = new SNSId("aizza");
        SNSId bepperoni = new SNSId("bepperoni");
        SNSId cheese = new SNSId("cheese");
        SNSId bedi = new SNSId("bedi");

        List<List<SNSId>> friends = List.of(
                List.of(donut, andole),
                List.of(donut, jun),
                List.of(donut, user),
                List.of(donut, aizza),
                List.of(donut, bepperoni),
                List.of(shakevan, andole),
                List.of(shakevan, jun),
                List.of(shakevan, user),
                List.of(shakevan, cheese)
        );
        List<SNSId> visitors = List.of(bedi, bedi,donut, bedi, shakevan, aizza, cheese, bepperoni);
        Map<String, Integer> result = new HashMap<>();
        result.put("bedi", 3);
        result.put("aizza", 1);
        result.put("cheese", 1);
        result.put("bepperoni", 1);
        RecommendFriendFinder recommendFriendFinder = new RecommendFriendFinder();
        assertThat(recommendFriendFinder.getVisitResult(user, friends, visitors).equals(result)).isTrue();
    }
}
