package onboarding;

import java.util.*;

class FriendRecommend {
    /**
     * 페이지 번호 게임에 쓰이는 메소드들을 정의한 클래스입니다.
     *
     * 모두 외부에 기능을 제공하기 위한 메소드들이고,
     * 인스턴스 변수의 값을 참조하거나 수정하지 않기 때문에
     * 불필요한 인스턴스의 생성을 줄이기 위해 클래스 메소드로 선언했습니다.
     *
     */
    public static Set<String> getUserSet(List<List<String>> friends, List<String> visitors) {
        /**
         * 모든 user들로 이루어진 집합을 반환하는 메소드
         */

        Set<String> userSet = new HashSet<>();

        for (List<String> i : friends) {    // add from friends list
            for (String user : i) {
                userSet.add(user);
            }
        }

        for (String user : visitors) {  // add from visitors list
            userSet.add(user);
        }

        return userSet;
    }

    public static Set<String> getFriendSet(String user, List<List<String>> friends) {
        /**
         * 특정 user의 친구들로 이루어진 집합을 반환하는 메소드
         */

        Set<String> friendSet = new HashSet<>();
        int idx;

        for (List<String> relation : friends) {
            idx = relation.indexOf(user);

            switch (idx) {
                case 0:
                    friendSet.add(relation.get(1));
                    break;
                case 1:
                    friendSet.add(relation.get(0));
                    break;
                case -1:
                    break;
            }
        }

        return friendSet;
    }

    public static Map<String, Set<String>> getRelationMap(List<List<String>> friends, List<String> visitors) {
        /**
         * 전체 user들의 친구 관계도를 나타내는 Map을 반환하는 메소드
         *
         * key: user name
         * value: user의 친구들로 이루어진 Set
         */

        Map<String, Set<String>> relationMap = new HashMap<>();
        Set<String> userSet = getUserSet(friends, visitors);

        for (String user : userSet) {
            relationMap.put(user, getFriendSet(user, friends));
        }

        return relationMap;
    }

    public static Map<String, Integer> getScoreMap(String user, Map<String, Set<String>> relationMap, List<String> visitors) {
        /**
         * 특정 user와의 '친구 점수' 관계를 나타내는 Map을 반환하는 메소드
         *
         * key: user의 friend
         * value: 친구 점수
         */

        Map<String, Integer> scoreMap = new HashMap<>();
        Set<String> intersection = new HashSet<>(relationMap.get(user));
        int totalScore = 0;

        for (String key : relationMap.keySet()) {
            if (key.equals(user) || relationMap.get(user).contains(key)){
                continue;
            }
            intersection.retainAll(relationMap.get(key));
            totalScore = intersection.size() * 10 + Collections.frequency(visitors, key);

            scoreMap.put(key, totalScore);
        }

        return scoreMap;
    }

    public static void createRecommendation(int capacity, Map<String, Integer> scoreMap, List<String> answer) {
        /**
         * 주어진 제한조건(최대 수용 인원)에 맞춰 친구 추천 목록을 작성해주는 메소드
         */

        List<String> preAnswer = new ArrayList<>();

        while (capacity != 0 && scoreMap.size() != 0) { // answer list의 수용공간이 가득 차거나 점수 관계도에 더 이상 뽑아낼 친구들이 없으면 loop가 종료됨
            preAnswer.clear();

            int maxValue = Collections.max(scoreMap.values());  // 최대 value 값

            for (Map.Entry<String, Integer> m : scoreMap.entrySet()) {   // Map에서 해당 value를 갖는 모든 key값을 뽑아냄
                if (m.getValue() == maxValue) {
                    preAnswer.add(m.getKey());  // 임시 답변 만들기
                }
            }

            for (String k : preAnswer) {
                scoreMap.remove(k); // 원래 scoreMap에서 제거
            }

            Collections.sort(preAnswer);

            if (preAnswer.size() > capacity) {  // 남아있는 자리의 수 만큼만 넣어야 함
                for (int i = 0; i < capacity; i++) {
                    answer.add(preAnswer.get(i));
                }
                break;
            } else {    // 다 넣어야 함
                for (String key : preAnswer) {
                    answer.add(key);
                }
                capacity -= preAnswer.size();
            }
        }
    }
}

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, Set<String>> relationMap = FriendRecommend.getRelationMap(friends, visitors);   // 전체 user의 친구 관계도
        Map<String, Integer> scoreMap = FriendRecommend.getScoreMap(user, relationMap, visitors);   // 특정 user와의 점수 관계도

        FriendRecommend.createRecommendation(5, scoreMap, answer);  // create recommendation list

        return answer;
    }
}
