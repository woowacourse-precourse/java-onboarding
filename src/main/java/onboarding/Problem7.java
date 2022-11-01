package onboarding;

import ExceptionValidation.P7ExceptionValidation;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        if (!(P7ExceptionValidation.p7ExceptionValidation(user, friends, visitors))) {
            return Collections.emptyList();
        }

    }


}
