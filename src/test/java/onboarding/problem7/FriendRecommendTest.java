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
        SnsId andole = new SnsId("andole");
        SnsId jun = new SnsId("jun");

        List<SnsId> friends = List.of(jun, andole);

        Map<String, Integer> result = new HashMap<>();
        result.put("jun", 10);
        result.put("andole", 10);

        RecommendFriendFinder recommendFriendFinder = new RecommendFriendFinder();
        Map<String, Integer> acquaintanceResult = recommendFriendFinder.getAcquaintanceResult(friends);
        assertTrue(acquaintanceResult.equals(result));
    }

    @Test
    void getVisitResult() {
        SnsId donut = new SnsId("donut");
        SnsId shakevan = new SnsId("shakevan");
        SnsId aizza = new SnsId("aizza");
        SnsId bepperoni = new SnsId("bepperoni");
        SnsId cheese = new SnsId("cheese");
        SnsId bedi = new SnsId("bedi");

        List<SnsId> friends = List.of(donut, shakevan);
        List<SnsId> visitors = List.of(bedi, bedi, donut, bedi, shakevan, aizza, cheese, bepperoni);
        Map<String, Integer> result = new HashMap<>();
        result.put("bedi", 3);
        result.put("aizza", 1);
        result.put("cheese", 1);
        result.put("bepperoni", 1);
        RecommendFriendFinder recommendFriendFinder = new RecommendFriendFinder();
        assertThat(recommendFriendFinder.getVisitResult(friends, visitors).equals(result)).isTrue();
    }
}
