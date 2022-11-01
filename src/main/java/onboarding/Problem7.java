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
    
    private static TreeSet<String> findFriends(String user, List<List<String>> friends) {
        TreeSet<String> Set = new TreeSet<>();
        for (List<String> e : friends) {
            int indexOfMe = e.indexOf(user);
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

    private static TreeSet<String> findPeople(String user, List<List<String>> friends, List<String> visitors, TreeSet<String> friendSet) {
        TreeSet<String> Set = new TreeSet<>();
        for (List<String> e : friends) {
            Set.add(e.get(0));
            Set.add(e.get(1));
        }
        for (String e : visitors) {
            Set.add(e);
        }
        Set.remove(user);
        Set.removeAll(friendSet);
        return Set;
    }

    private static TreeSet<String> makeCommonFriends(String person, List<List<String>> friends) {
        TreeSet<String> commonFriendSet = new TreeSet<>();
        for (List<String> friend : friends) {
            if (friend.contains(person)) {
                int indexOfPerson = friend.indexOf(person);
                if (indexOfPerson == 1) {
                    String friendName = friend.get(0);
                    commonFriendSet.add(friendName);
                } else if (indexOfPerson == 0) {
                    String friendName = friend.get(1);
                    commonFriendSet.add(friendName);
                }
            }
        }
        return commonFriendSet;
    }

    private static int countVisits(String person, List<String> visitors) {
        int count = 0;
        for (String visitor : visitors) {
            if (visitor.contains(person)) {
                count = count + 1;
            }
        }
        return count;
    }

    private static int makeScores(String person, LinkedHashMap<String, Integer> commonFriendCount, LinkedHashMap<String, Integer> visitCount) {
        int commonFriendScore = 10 * commonFriendCount.get(person);
        int visitScore = visitCount.get(person);
        return commonFriendScore + visitScore;
    }

    /**
     * 추천 점수가 0점인 경우 추천하지 않으며
     * @param scoreResult
     * @return scoreResult
     * */
    private static HashMap<String, Integer> removeZeros(HashMap<String, Integer> scoreResult) {
        scoreResult.values().remove(0);
        return scoreResult;
    }

    /**
     * 점수가 가장 높은 순으로 정렬하며,
     * 추천 점수가 같은 경우는 이름순으로 정렬한다.
     * @param scoreResult
     * @return finalResult
     */
    private static List<Map.Entry<String, Integer>> sortResult(HashMap<String, Integer> scoreResult) {
        List<Map.Entry<String, Integer>> finalResult = new LinkedList<>(scoreResult.entrySet());
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
     * 최대 5명
     * @param finalResult
     * @return answer
     */

    private static List<String> maxFive(List<Map.Entry<String, Integer>> finalResult) {
        List<String> answer = new ArrayList<>();
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
