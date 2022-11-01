package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private List<String> getOnesFriends(List<List<String>> friends, String user) {
        List<String> result = new ArrayList<>();
        friends.stream().filter(e -> e.contains(user)).forEach(result::addAll);
        return result.stream().filter(element -> !element.equals(user)).collect(Collectors.toList());
    }
}
