package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        /* HashMap Key-Value 쌍으로 친구관계 정리 */
        Map<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            String friendA = friends.get(i).get(0);
            String friendB = friends.get(i).get(1);

            if (hashMap.containsKey(friendA)) {
                List<String> listValue = hashMap.get(friendA);
                listValue.add(friendB);
                hashMap.put(friendA, listValue);
            } else {
                List<String> listValue = new ArrayList<String>();
                listValue.add(friendB);
                hashMap.put(friendA, listValue);
            }

            if (hashMap.containsKey(friendB)) {
                List<String> listValue = hashMap.get(friendB);
                listValue.add(friendA);
                hashMap.put(friendB, listValue);
            } else {
                List<String> listValue = new ArrayList<String>();
                listValue.add(friendA);
                hashMap.put(friendB, listValue);
            }
        }
        System.out.println(hashMap);

        /* 함께 아는 친구 점수추가 */
        Set<String> setFriends = new HashSet<>(hashMap.keySet());
        Map<String, Integer> hashMapScores = new HashMap<>();

        setFriends.remove(user);
        for (String friendA: setFriends) {
            for (String friendB: hashMap.get(friendA)) {
                if (hashMap.get(user).contains(friendB)) {
                    if (hashMapScores.containsKey(friendA)) {
                        Integer score = hashMapScores.get(friendA) + 10;
                        hashMapScores.put(friendA, score);
                    } else {
                        hashMapScores.put(friendA, 10);
                    }
                }
            }
        }
        System.out.println(setFriends);

        /* 타임라인 방문기록 점수추가 */
        for (int i = 0; i < visitors.size(); i++) {
            String key = visitors.get(i);
            if (hashMapScores.containsKey(key)) {
                Integer score = hashMapScores.get(key) + 1;
                hashMapScores.put(key, score);
            } else {
                hashMapScores.put(key, 1);
            }
        }
        System.out.println(hashMapScores);

        /* User의 기존 친구에 해당하는 친구 삭제 */
        for (String friend: hashMap.get(user)) {
            hashMapScores.remove(friend);
        }
        System.out.println(hashMapScores);

        /* 점수별 친구목록으로 변환 */
        Map<Integer, List<String>> reverseKeyValueHashMapScores = new HashMap<>();
        for (String key: hashMapScores.keySet()) {
            Integer value = hashMapScores.get(key);
            if (reverseKeyValueHashMapScores.containsKey(value)) {
                List<String> temp = reverseKeyValueHashMapScores.get(value);
                temp.add(key);
                temp = temp.stream().sorted().collect(Collectors.toList());         // 이름 오름차순으로 정렬
                reverseKeyValueHashMapScores.put(value, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(key);
                temp = temp.stream().sorted().collect(Collectors.toList());         // 이름 오름차순으로 정렬
                reverseKeyValueHashMapScores.put(value, temp);
            }
        }
        System.out.println(reverseKeyValueHashMapScores);

        /* 점수 내림차순으로 정렬 */
//        List<String> answer = Collections.emptyList();
        List<String> answer = new ArrayList<>();
        List<Map.Entry<Integer, List<String>>> entries = reverseKeyValueHashMapScores.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toList());
        for (Map.Entry<Integer, List<String>> entry: entries) {
            for (String friend: entry.getValue()) {
                answer.add(friend);
            }

        }

        return answer;
    }
}
