package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 모든 아이디 파악
        Map<String, Integer> allUsers = findAllUsers(friends, visitors);

        // 예외 처리
        if (checkInvalid(user, friends, allUsers, visitors)) {
            return null;
        }

        // User 의 친구 관계
        List<String> userFriends = findUserFriends(user, friends);

        // User 친구 리스트와 친구 관계인 사람 찾기
        List<String> relatedFriends = findRelatedFriends(userFriends, friends);

        // 알고리즘 규칙에 따른 점수 부여
        Map<String, Integer> result = giveScores(allUsers, user, userFriends, relatedFriends, visitors);

        // 최종 결과
        return getTotalScore(result);

    }

    // 예외 처리
    private static boolean checkInvalid(String user, List<List<String>> friends, Map<String, Integer> allUsers, List<String> visitors) {
        // user 길이는 1이상 30이하
        if (user.length() < 1 || user.length() > 30) {
            return true;
        }
        // friends 길이는 1이상 10000이하
        if (friends.size() < 1 || friends.size() > 10000) {
            return true;
        }
        // 아이디 길이는 1이상 30이하, 알파벳 소문자로만 구성
        for (String name : allUsers.keySet()) {
            if (name.length() < 1 || name.length() > 30 || !name.matches("[a-z]+")) {
                return true;
            }
        }
        // visitors 길이는 0이상 10000이하
        if (visitors.size() > 10000) {
            return true;
        }

        return false;
    }

    // 최종 결과 형식에 맞게 반환
    private static List<String> getTotalScore(Map<String, Integer> result) {
        List<String> answer = new ArrayList<>();

        // 친구 추천 규칙에 따라 최대 5명
        for (Map.Entry<String, Integer> pair : result.entrySet()) {
            String name = pair.getKey();
            int value = pair.getValue();

            // 0점인 경우 추천하지 않음
            if (value > 0) {
                answer.add(name);
            }
            if (answer.size() >= 5) {
                break;
            }
        }
        return answer;
    }

    // 친구 추천 알고리즘에 따른 최종 점수 부여
    private static Map<String, Integer> giveScores(Map<String, Integer> allUsers, String user, List<String> userFriends, List<String> relatedFriends, List<String> visitors) {
        for (Map.Entry<String, Integer> pair : allUsers.entrySet()) {
            String current = pair.getKey();

            // 사용자 본인 제외
            if (current.equals(user)) {
                continue;
            }
            // 직접 친구 제외
            if (userFriends.contains(current)) {
                continue;
            }

            // 함께 아는 친구 10점
            if (relatedFriends.contains(current)) {
                int occurrences = Collections.frequency(relatedFriends, current);
                pair.setValue(pair.getValue() + occurrences * 10);
            }
            // 타임라인 방문 횟수 1점
            if (visitors.contains(current)) {
                int occurrences = Collections.frequency(visitors, current);
                pair.setValue(pair.getValue() + occurrences * 1);
            }
        }

        // 사용자 본인, 직접 친구 제외
        allUsers.put(user, 0);
        for (String name : userFriends) {
            allUsers.put(name, 0);
        }

        // 높은 점수 순, 값은 점수는 알파벳 순으로 정렬
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        allUsers.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        return sortAlphabetical(sortedMap);

    }

    private static List<String> findRelatedFriends(List<String> userFriends, List<List<String>> friends) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            String first = friends.get(i).get(0);
            String sec = friends.get(i).get(1);

            if (userFriends.contains(first)) {
                result.add(sec);
                continue;
            }
            if (userFriends.contains(sec)) {
                result.add(first);
            }
        }
        return result;
    }

    // SNS 모든 사용자 파악
    private static Map<String, Integer> findAllUsers(List<List<String>> friends, List<String> visitors) {
        Set<String> result = new HashSet<>();

        // Friends 리스트에서의 사용자
        for (int i = 0; i < friends.size(); i++) {
            String first = friends.get(i).get(0);
            String sec = friends.get(i).get(1);

            result.add(first);
            result.add(sec);
        }

        // Visitors 리스트에서의 사용자
        for (int i = 0; i < visitors.size(); i++) {
            String usr = visitors.get(i);
            result.add(usr);
        }

        // Set 을 Map 으로 변환, value->0
        return result.stream().collect(Collectors.toMap(x -> x, x -> 0));
    }

    // User 의 친구 찾기
    private static List<String> findUserFriends(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            String first = friends.get(i).get(0);
            String sec = friends.get(i).get(1);

            if (first.equals(user)) {
                result.add(sec);
                continue;
            }
            if (sec.equals(user)) {
                result.add(first);
            }
        }
        return result;
    }

    // 같은 value 값에서 key 알파벳 순서대로 정렬하는 함수
    public static <String, Integer extends Comparable<? super Integer>> Map<String , Integer> sortAlphabetical(Map<String , Integer> map) {

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String , Integer> o2) {
                int val = o2.getValue().compareTo(o1.getValue());
                if (val == 0) { // 같은 값일때 key 비교
                    return o1.getKey().toString().compareTo(o2.getKey().toString());
                }
                return val;
            }
        });
        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String , Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
