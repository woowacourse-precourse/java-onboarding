package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        /* HashMap Key-Value 쌍으로 친구관계 정보 정리 */
        Map<String, List<String>> hashMap = new HashMap<>();
        for (List<String> friend : friends) {   // 각각의 친구 관계 정보에 대해
            String friendA = friend.get(0);     // 친구A
            String friendB = friend.get(1);     // 친구B

            // 친구A에 대한 친구관계 정보 갱신
            if (hashMap.containsKey(friendA)) {     // 친구관계에 친구A Key가 이미 존재한다면
                List<String> tempValue = hashMap.get(friendA);  // 친구A Key의 Value
                tempValue.add(friendB);                         // 친구A Value 갱신
                hashMap.put(friendA, tempValue);                // 친구A Key-Value 갱신
            } else {                                // 친구관계에 친구A Key가 존재하지 않는다면
                List<String> tempValue = new ArrayList<>();     // 친구A Key의 Value 생성
                tempValue.add(friendB);                         // 친구A Value 갱신
                hashMap.put(friendA, tempValue);                // 친구A Key-Value 갱신
            }

            // 친구B에 대한 친구관계 정보 갱신
            if (hashMap.containsKey(friendB)) {     // 친구관계에 친구B Key가 이미 존재한다면
                List<String> tempValue = hashMap.get(friendB);  // 친구B Key의 Value
                tempValue.add(friendA);                         // 친구B Value 갱신
                hashMap.put(friendB, tempValue);                // 친구B Key-Value 갱신
            } else {                                // 친구관계에 친구B Key가 존재하지 않는다면
                List<String> tempValue = new ArrayList<>();     // 친구B Key의 Value 생성
                tempValue.add(friendA);                         // 친구B Value 갱신
                hashMap.put(friendB, tempValue);                // 친구B Key-Value 갱신
            }
        }

        /* 함께 아는 친구 점수추가 */
        Set<String> hashSet = new HashSet<>(hashMap.keySet());      // 각 친구 정보
        Map<String, Integer> scoresHashMap = new HashMap<>();       // 각 친구별 점수 정보

        hashSet.remove(user);                                           // user를 제외한
        for (String friendA : hashSet) {                                // 각각의 친구 A에 대해,
            for (String friendB : hashMap.get(friendA)) {               // A의 친구목록에 대해 각각의 B가
                if (hashMap.get(user).contains(friendB)) {              // user의 친구목록에 존재한다면,
                    if (scoresHashMap.containsKey(friendA)) {               // 친구 A의 친구점수가 이미 존재할 경우
                        Integer score = scoresHashMap.get(friendA) + 10;        // 기존점수 + 10
                        scoresHashMap.put(friendA, score);                      // 친구점수 정보 갱신
                    } else {                                                // 친구 A의 친구점수가 존재하지 않는 경우
                        scoresHashMap.put(friendA, 10);                         // 친구점수 정보 삽입
                    }
                }
            }
        }

        /* 타임라인 방문기록 점수추가 */
        for (String visitor : visitors) {                       // 각각의 타임라인 방문자에 대해
            if (scoresHashMap.containsKey(visitor)) {           // 해당 방문자의 친구점수 정보가 이미 존재할 경우
                Integer score = scoresHashMap.get(visitor) + 1;     // 기존점수 + 1
                scoresHashMap.put(visitor, score);                  // 친구점수 정보 갱신
            } else {                                            // 해당 방문자의 친구점수 정보가 존재하지 않는 경우
                scoresHashMap.put(visitor, 1);                      // 친구점수 정보 삽입
            }
        }

        /* User의 기존 친구에 해당하는 친구점수 정보 삭제 */
        for (String friend : hashMap.get(user)) {       // User의 각각의 친구에 대해
            scoresHashMap.remove(friend);               // 해당 친구의 친구점수 정보 삭제
        }

        /* 점수별 친구목록으로 변환 및 이름 오름차순 정렬 */
        Map<Integer, List<String>> reverseKeyValueScoresHashMap = new HashMap<>();  // Key-Value 반전결과 HashMap
        for (String key : scoresHashMap.keySet()) {                     // 각각의 Key(이름)
            Integer value = scoresHashMap.get(key);                     // 각각의 Value(점수)
            if (reverseKeyValueScoresHashMap.containsKey(value)) {                  // 해당 점수가 Key 값으로 이미 존재하는 경우
                List<String> tempList = reverseKeyValueScoresHashMap.get(value);    // 해당 점수 Key 값의 Value 추출
                tempList.add(key);                                                  // Value에 이름 추가
                tempList.stream().sorted().collect(Collectors.toList());            // 이름 오름차순 정렬
                reverseKeyValueScoresHashMap.put(value, tempList);                  // {점수 : 이름} Key-Value 쌍 갱신
            } else {                                                                // 해당 점수가 Key 값으로 존재하지 않는 경우
                List<String> tempList = new ArrayList<>();                          // 해당 점수 Key 값의 Value 생성
                tempList.add(key);                                                  // Value에 이름 추가
                tempList.stream().sorted().collect(Collectors.toList());            // 이름 오름차순 정렬
                reverseKeyValueScoresHashMap.put(value, tempList);                  // {점수 : 이름} Key-Value 쌍 갱신
            }
        }

        /* 점수 내림차순으로 정렬 */
        List<String> answer = new ArrayList<>();
        List<Map.Entry<Integer, List<String>>> entries = reverseKeyValueScoresHashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))        // Key(점수)기준 내림차순 정렬
                .collect(Collectors.toList());                                      // List 형으로 반환
        for (Map.Entry<Integer, List<String>> entry : entries) {    // 각각의 Entry(점수)에 대해
            for (String friend : entry.getValue()) {                // 해당 Entry의 Value(이름목록)의 각각의 이름에 대해
                answer.add(friend);                                 // answer에 추가
            }
        }

        return answer;
    }
}
