package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        //user의 친구 리스트에 담기
        Set<String> fr = new HashSet<>();
        for (List<String> friend : friends) {
            fr.add(friend.get(0));
        }

        Map<String, Integer> nameAndScore = new HashMap<>();

        //user의 친구의 친구 리스트에 담기
        List<String> oneDari = new ArrayList<>();
        for (List<String> friend : friends) {
            if (!friend.get(1).equals(user)) {
                oneDari.add(friend.get(1));
            }
        }

        for (String s : oneDari) {
            if (nameAndScore.containsKey(s)) {
                Integer integer = nameAndScore.get(s);
                integer += 10;
                nameAndScore.replace(s, integer);
            }
            if (!nameAndScore.containsKey(s)) {
                nameAndScore.put(s, 10);
            }
        }

        //방문자 제거 추가
        List<String> vi = new ArrayList<>(visitors);
        //방문자 리스트중 친구들 제거
        for (String s : fr) {
            vi.remove(s);
        }

        for (String s : vi) {
            if (nameAndScore.containsKey(s)) {
                Integer integer = nameAndScore.get(s);
                integer += 1;
                nameAndScore.replace(s, integer);
            }
            if (!nameAndScore.containsKey(s)) {
                nameAndScore.put(s, 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(nameAndScore.entrySet());
        list.sort((o1, o2) -> {
            int comparison = (o1.getValue() - o2.getValue()) * -1;
            return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
        });

        list.stream().limit(5).filter(i -> answer.add(i.getKey())).collect(Collectors.toList());

        return answer;
    }
}
