package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> warningEmail = new ArrayList<>();

        return warningEmail;
    }

    public static List<List<String>> notMe(List<List<String>> forms, List<String> me) {

        List<List<String>> withoutMe = new ArrayList<>(forms);
        withoutMe.remove(me);

        return withoutMe;
    }

}
