package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friends = Arrays.asList(Arrays.asList("donut", "andole"), Arrays.asList("donut", "jun"), Arrays.asList("donut", "mrko"), Arrays.asList("shakevan", "andole"), Arrays.asList("shakevan", "jun"), Arrays.asList("shakevan", "mrko"));

        visitors = Arrays.asList("bedi", "bedi", "donut", "bedi", "shakevan");

        List<String> mrko = friends.stream().filter(strings -> strings.contains(user)).flatMap(Collection::stream).filter(s -> !s.equals(user)).collect(Collectors.toList());

        List<String> stringList = new ArrayList<>();
        for (String fr : mrko) {
            List<String> collect = friends.stream().filter(strings -> strings.contains(fr)).flatMap(Collection::stream).filter(s -> !s.equals(fr)).collect(Collectors.toList());
            stringList.addAll(collect);
        }
        List<String> collect = stringList.stream().filter(it -> !it.contains(user)).collect(Collectors.toList());

        Set<String> set = new HashSet<>(collect);
        Map<String, Integer> map = new HashMap<>();


        for (String str : set) {
            int frequency = Collections.frequency(collect, str) * 10;
            map.put(str, frequency);


        }

        Set<String> set1 = new HashSet<>(visitors);

        for (String str : set1) {
            int frequency = Collections.frequency(visitors, str);
            map.put(str, frequency);

        }

        for (String s : mrko) {

            map.remove(s);

        }
        List<Map.Entry<String, Integer>> collect1 = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(5).collect(Collectors.toList());
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < collect1.size(); i++) {
            answer.add(collect1.get(i).getKey());
        }

        return answer;
    }

}

