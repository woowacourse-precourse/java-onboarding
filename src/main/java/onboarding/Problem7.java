package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 친구 관계 정리
        Map<String, List<String>> persons = new HashMap<>();
        Map<String, Integer> scores = new HashMap<>();
        for (List<String> friend : friends) {
            String first = friend.get(0);
            String second = friend.get(1);
            if (!persons.containsKey(first)) {
                persons.put(first, new ArrayList<>());
                scores.put(first, 0);
            }
            if (!persons.containsKey(second)) {
                persons.put(second, new ArrayList<>());
                scores.put(second, 0);
            }
            List<String> list1 = persons.get(first);
            List<String> list2 = persons.get(second);
            list1.add(second);
            list2.add(first);
            persons.put(first, list1);
            persons.put(second, list2);

        }
        for (String visitor : visitors) {
            if (!persons.containsKey(visitor)) {
                persons.put(visitor, new ArrayList<>());
                scores.put(visitor, 0);
            }
        }

        // 사용자와 함께 아는 친구의 수 계산
        List<String> friendsOfUser = persons.get(user);
        for (String person : persons.keySet()) {
            if (person == user) {
                continue;
            }
            List<String> compareFriends = persons.get(person);
            int count = 0;
            for (String friend : friendsOfUser) {
                if (compareFriends.contains(friend)) count++;
            }
            scores.put(person, count * 10);
        }

        // 사용자의 타임라인에 방문한 횟수 계산
        for (String visitor : visitors) {
            Integer score = scores.get(visitor);
            score++;
            scores.put(visitor, score);
        }

        // 점수가 높은 순으로 정렬
        List<Entry<String, Integer>> listEntries = new ArrayList<Entry<String, Integer>>(scores.entrySet());
        Collections.sort(listEntries, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        List<String> result = new ArrayList<>();
        for (Entry<String, Integer> entry : listEntries) {
            if (entry.getValue() == 0) break;
            if (!friendsOfUser.contains(entry.getKey())) result.add(entry.getKey());
        }
        if (result.size() >= 5) return result.subList(0, 5);
        else return result;
    }
}
