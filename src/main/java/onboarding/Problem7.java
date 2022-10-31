package onboarding;

import java.util.Collections;
import java.util.List;

import onboarding.problemseven.domain.Sns;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Sns sns = new Sns();
        sns.saveFriends(friends);

        List<String> answer = sns.recommendFriend(user,visitors);
        return answer;
    }
}
