package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 예외 처리
        if (user == null || user.length() < 1 || user.length() > 30) {
            return List.of("제한사항 위반");
        } else if (friends.size() < 1 || friends.size() > 10000) {
            return List.of("제한사항 위반");
        } else if (visitors.size() < 0 || visitors.size() > 10000) {
            return List.of("제한사항 위반");
        }

        // 결과 저장용
        HashMap<String, Integer> resultSet = new HashMap<>();
        // 유저친구 체크용
        HashSet<String> userFriends = new HashSet<>();

        friends = new ArrayList<>(friends);

        // 제한 사항 체크
        for (int i=0; i<friends.size(); i++) {
            if (friends.get(i).size() != 2) {
                return List.of("제한사항 위반");
            } else if (!friends.get(i).get(1).matches("^[a-z]*$")) {
                return List.of("제한사항 위반");
            } else if (!friends.get(i).get(0).matches("^[a-z]*$")) {
                return List.of("제한사항 위반");
            }
            if (friends.size() > 1) {
                // 뒤집어서 중복 체크
                List<String> reverse = new ArrayList<>(friends.get(i));
                Collections.reverse(reverse);
                if (friends.contains(reverse)) {
                    return List.of("제한사항 위반");
                }
            }

            // 친구 찾기
            if (friends.get(i).get(0).equals(user)) {
                // 친구 추가
                userFriends.add(friends.get(i).get(1));
                // 친구 점수 설정 (이미 친구이므로 추천되면 안 됨)
                if (!resultSet.containsKey(friends.get(i).get(1))) {
                    resultSet.put(friends.get(i).get(1), -1000000);
                }
                // 해당 원소 삭제
                friends.remove(i);
                i--;
            } else if (friends.get(i).get(1).equals(user)) {
                // 친구 추가
                userFriends.add(friends.get(i).get(0));
                // 친구 점수 설정 (이미 친구이므로 추천되면 안 됨)
                if (!resultSet.containsKey(friends.get(i).get(0))) {
                    resultSet.put(friends.get(i).get(0), -1000000);
                }
                friends.remove(i);
                i--;
            } else {
                // 친구 아니라면 함께 아는 친구 찾기
                if (userFriends.contains(friends.get(i).get(0))) {
                    // 10점 추가 (없으면 생성)
                    resultSet.putIfAbsent(friends.get(i).get(1), 0);
                    resultSet.put(friends.get(i).get(1), resultSet.get(friends.get(i).get(1)) + 10);
                    // 해당 원소 삭제
                    friends.remove(i);
                    i--;
                } else if (userFriends.contains(friends.get(i).get(1))) {
                    // 10점 추가 (없으면 생성)
                    resultSet.putIfAbsent(friends.get(i).get(0), 0);
                    resultSet.put(friends.get(i).get(0), resultSet.get(friends.get(i).get(0)) + 10);
                    // 해당 원소 삭제
                    friends.remove(i);
                    i--;
                }
            }
        }

        // 함께 아는 친구 마저 찾기
        for (List<String> friend : friends) {
            if (userFriends.contains(friend.get(0))) {
                // 10점 추가 (없으면 생성)
                resultSet.putIfAbsent(friend.get(1), 0);
                resultSet.put(friend.get(1), resultSet.get(friend.get(1)) + 10);
            } else if (userFriends.contains(friend.get(1))) {
                // 10점 추가 (없으면 생성)
                resultSet.putIfAbsent(friend.get(0), 0);
                resultSet.put(friend.get(0), resultSet.get(friend.get(0)) + 10);
            }
        }

        // 방문자 점수 설정
        for (String visitor : visitors) {
            if (resultSet.containsKey(visitor)) {
                resultSet.put(visitor, resultSet.get(visitor) + 1);
            } else {
                resultSet.put(visitor, 1);
            }
        }

        // 점수 1점 이상인 사람만 추출
        List<String> answer = new ArrayList<>();
        for (String key : resultSet.keySet()) {
            if (resultSet.get(key) > 0) {
                answer.add(key);
            }
        }

        // 예외 처리
        if (answer.size() == 0) {
            return List.of("제한사항 위반");
        }

        // 점수 내림차순
        answer.sort((o1, o2) -> {
            if (resultSet.get(o1) > resultSet.get(o2)) {
                return -1;
            } else if (resultSet.get(o1) < resultSet.get(o2)) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        });

        // 상위 5명만 추출
        if (answer.size() > 5) {
            answer = answer.subList(0, 5);
        }

        return answer;
    }
}
