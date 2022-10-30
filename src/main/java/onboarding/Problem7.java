package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static List<String> getUsers(List<List<String>> friends) {
        Stream<String> flattenUserStream = friends.stream().flatMap(Collection::stream);
        List<String> userList = flattenUserStream
                                        .distinct()
                                        .collect(Collectors.toList());
        return userList;
    }
}
