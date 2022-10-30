package onboarding;

import onboarding.problem7.Controller;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Controller.getSolution(user, friends, visitors);
        return answer;
    }
}
