package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> makePeopleList(String user, List<List<String>> friends, List<String> visitors) {
        List<String> list = new ArrayList<>();
        list.add(user);
        for (List<String> friend : friends) {
            list = addToList(list, friend);
        }
        list = addToList(list, visitors);
        return list;
    }
    private static List<String> addToList(List<String> list, List<String> target) {
        List<String> tmp = target.stream()
            .filter(x -> !list.contains(x))
            .collect(Collectors.toList());
        tmp.addAll(list);
        return tmp;
    }
}
