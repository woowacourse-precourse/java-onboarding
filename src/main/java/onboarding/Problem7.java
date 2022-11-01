package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        LinkedHashMap<String, Integer> commonFriendCount = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> visitCount = new LinkedHashMap<>();
        HashMap<String, Integer> scoreResult = new HashMap<>();

        // 친구 집합
        TreeSet<String> friendSet = findFriends(user, friends);

        // 본인과 친구 제외한 집합
        TreeSet<String> peopleSet = findPeople(user, friends, visitors, friendSet);

        // 함께 아는 친구의 수
        for (String person : peopleSet) {
            commonFriendCount.put(person, makeCommonFriends(person, friends).size());
        }

        // 타임 라인에 방문한 횟수
        for (String person : peopleSet) {
            visitCount.put(person, countVisits(person, visitors));
        }

        // 점수 계산
        for (String person : peopleSet) {
            scoreResult.put(person, makeScores(person, commonFriendCount, visitCount));
        }

        // 추천 점수가 0점인 경우 추천하지 않으며
        scoreResult = removeZeros(scoreResult);

        // 점수가 가장 높은 순으로 정렬하며,
        // 추천 점수가 같은 경우는 이름순으로 정렬한다.
        List<Map.Entry<String, Integer>> finalResult = sortResult(scoreResult);

        // 최대 5명
        List<String> answer = maxFive(finalResult);

        return answer;
    }

    /**
     * 사용자 친구의 집합을 찾는다.
     * @param user 사용자 이름
     * @param friends 주어진 친구 관계 매개변수
     * @return 사용자 친구의 집합
     */
    private static TreeSet<String> findFriends(String user, List<List<String>> friends) {
        TreeSet<String> Set = new TreeSet<>();

        for (List<String> e : friends) {
            int indexOfMe = e.indexOf(user);

            // 사용자 친구의 이름을 집합에 넣는다.
            if (indexOfMe == 1) {
                String friendName = e.get(0);
                Set.add(friendName);
            } else if (indexOfMe == 0) {
                String friendName = e.get(1);
                Set.add(friendName);
            }
        }
        return Set;
    }

    /**
     * 본인과 친구가 아닌 사람의 집합을 찾는다.
     * @param user 사용자 이름
     * @param friends 주어진 친구 관계 매개변수
     * @param visitors 주어진 타임 라인 방문자 매개변수
     * @param friendSet 사용자 친구의 집합
     * @return 본인과 친구가 아닌 사람의 집합
     */
    private static TreeSet<String> findPeople(String user, List<List<String>> friends, List<String> visitors, TreeSet<String> friendSet) {
        TreeSet<String> Set = new TreeSet<>();

        // 주어진 친구 관계에 등장하는 이름을 집합에 넣는다.
        for (List<String> e : friends) {
            Set.add(e.get(0));
            Set.add(e.get(1));
        }

        // 주어진 타임 라인 방문자 이름을 집합에 넣는다.
        for (String e : visitors) {
            Set.add(e);
        }

        // 사용자와 사용자의 친구를 집합에서 뺀다.
        Set.remove(user);
        Set.removeAll(friendSet);

        return Set;
    }

    /**
     * 함께 아는 친구의 집합을 만든다.
     * @param person 본인과 친구를 제외한 사람
     * @param friends 주어진 친구 관계 매개변수
     * @return 함께 아는 친구의 집합
     */
    private static TreeSet<String> makeCommonFriends(String person, List<List<String>> friends) {
        TreeSet<String> commonFriendSet = new TreeSet<>();

        // 본인과 친구를 제외한 함께 아는 친구를 찾고 집합에 넣는다.
        for (List<String> friend : friends) {
            if (friend.contains(person)) {
                int indexOfPerson = friend.indexOf(person);
                if (indexOfPerson == 1) {
                    String personName = friend.get(0);
                    commonFriendSet.add(personName);
                } else if (indexOfPerson == 0) {
                    String personName = friend.get(1);
                    commonFriendSet.add(personName);
                }
            }
        }

        return commonFriendSet;
    }

    /**
     * 타임 라인에 방문한 횟수를 계산한다.
     * @param person 본인과 친구를 제외한 사람
     * @param visitors 주어진 타임 라인 방문자 매개변수
     * @return 타임 라인에 방문한 횟수
     */
    private static int countVisits(String person, List<String> visitors) {
        int count = 0;

        // 본인과 친구를 제외한 사람의 타임 라인 방문한 횟수를 계산한다.
        for (String visitor : visitors) {
            if (visitor.contains(person)) {
                count = count + 1;
            }
        }

        return count;
    }

    /**
     * 추천 점수를 계산한다.
     * @param person 본인과 친구를 제외한 사람
     * @param commonFriendCount 함께 아는 친구의 수
     * @param visitCount 타임 라인에 방문한 횟수
     * @return 추천 점수
     */
    private static int makeScores(String person, LinkedHashMap<String, Integer> commonFriendCount, LinkedHashMap<String, Integer> visitCount) {
        int commonFriendScore = 10 * commonFriendCount.get(person);
        int visitScore = visitCount.get(person);
        return commonFriendScore + visitScore;
    }

    /**
     * 추천 점수가 0점인 경우 추천하지 않는다.
     * @param scoreResult 본인과 친구를 제외한 사람의 이름과 추천 점수
     * @return 추천 점수가 0점인 경우를 제외한 결과
     * */
    private static HashMap<String, Integer> removeZeros(HashMap<String, Integer> scoreResult) {
        scoreResult.values().remove(0);
        return scoreResult;
    }

    /**
     * 점수가 가장 높은 순으로 정렬하며,
     * 추천 점수가 같은 경우는 이름순으로 정렬한다.
     * @param scoreResult 본인과 친구를 제외한 사람의 이름과 추천 점수
     * @return 조건대로 정렬한 결과
     */
    private static List<Map.Entry<String, Integer>> sortResult(HashMap<String, Integer> scoreResult) {
        List<Map.Entry<String, Integer>> finalResult = new LinkedList<>(scoreResult.entrySet());

        // 점수가 가장 높은 순으로 정렬, 추천 점수가 같은 경우는 이름순으로 정렬
        Collections.sort(finalResult, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparison = (o1.getValue() - o2.getValue()) * -1;
                return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
            }
        });

        return finalResult;
    }

    /**
     * 최대 5명을 return
     * @param finalResult 본인과 친구를 제외한 사람의 이름과 추천 점수 목록을 정렬한 결과
     * @return 본인과 친구를 제외한 사람의 이름과 추천 점수 목록을 최대 5개로 정렬한 결과
     */

    private static List<String> maxFive(List<Map.Entry<String, Integer>> finalResult) {
        List<String> answer = new ArrayList<>();

        // 결과가 5개 이상일 경우와 미만일 때
        if (finalResult.size() >= 5) {
            for (int i = 0; i <= 4; i++) {
                answer.add(finalResult.get(i).getKey());
            }
        } else if (finalResult.size() < 5) {
            for (int i = 0; i <= finalResult.size() - 1; i++) {
                answer.add(finalResult.get(i).getKey());
            }
        }

        return answer;
    }
}
