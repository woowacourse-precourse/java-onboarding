package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendFactory {

    public static List<String> getRecommendFriendList(List<Recommend> recommendList) {
        HashMap<String, Integer> map = new HashMap<>();
        input(recommendList, map);

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + " : " + stringIntegerEntry.getValue());
        }

        return map.entrySet().stream()
                .sorted((o1, o2) -> {
                    if (Objects.equals(o1.getValue(), o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return o2.getValue().compareTo(o1.getValue());
                })
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toUnmodifiableList());
    }

    private static void input(List<Recommend> recommendList, HashMap<String, Integer> map) {
        recommendList.forEach(recommend ->
                        map.put(recommend.getName(), map.getOrDefault(recommend.getName(), 0) + recommend.getScore())
        );
    }
}
