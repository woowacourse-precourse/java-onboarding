package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> friendList = new ArrayList<>();
        HashMap<String, Integer> score = new HashMap<>();
        List<List<String>> list = new ArrayList<>();

        // 친구 찾기
        friends.forEach(fr -> {
            if (fr.get(0).equals(user)) {
                friendList.add(fr.get(1));
            }
            if (fr.get(1).equals(user)) {
                friendList.add(fr.get(0));
            }
        });

        // 0점 리스트 만들기
        friends.forEach(fr -> {
            if (!fr.get(0).equals(user) && !friendList.contains(fr.get(0))) {
                score.put(fr.get(0), 0);
            }
            if (!fr.get(1).equals(user) && !friendList.contains(fr.get(1))) {
                score.put(fr.get(1), 0);
            }
        });
        visitors.forEach(vi -> {
            if (!vi.equals(user) && !friendList.contains(vi)) {
                score.put(vi, 0);
            }
            if (!vi.equals(user) && !friendList.contains(vi)) {
                score.put(vi, 0);
            }
        });

        // 사용자와 함께 아는 친구의 수 점수 적용
        friends.forEach(fr -> {
            if (friendList.contains(fr.get(0)) && score.containsKey(fr.get(1))) {
                score.replace(fr.get(1), score.get(fr.get(1)) + 10);
            }
            if (friendList.contains(fr.get(1)) && score.containsKey(fr.get(0))) {
                score.replace(fr.get(0), score.get(fr.get(0)) + 10);
            }
        });

        // 사용자의 타임 라인에 방문한 횟수 점수 적용
        visitors.forEach(vi -> {
            if (score.containsKey(vi)) {
                score.replace(vi, score.get(vi) + 1);
            }
        });

        Iterator<String> keys = score.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            Integer value = score.get(key);
            list.add(Arrays.asList(key, value.toString()));
        }

        list.sort(new ScoreComparator());

        return list.stream().map(el -> el.get(0)).collect(Collectors.toList());

    }
}

class ScoreComparator implements Comparator<List<String>> {

    @Override
    public int compare(List<String> o1, List<String> o2) {
        if (Integer.parseInt(o1.get(1)) > Integer.parseInt(o2.get(1))) {
            return -1;
        } else if (Integer.parseInt(o1.get(1)) < Integer.parseInt(o2.get(1))) {
            return 1;
        } else {
            return o1.get(0).compareTo(o2.get(0));
        }

    }
}
