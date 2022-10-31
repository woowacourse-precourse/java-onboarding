package onboarding;

import onboarding.problem7.SNS;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        SNS sns = new SNS();
        sns.setDatas(friends, visitors);
        return sns.recommendFriend(user);
    }
}
