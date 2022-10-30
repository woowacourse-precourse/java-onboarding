package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    /*
    [기능 목록]
    1. 친구 추천 점수를 기록하기 위해 Map<> 타입의 변수를 초기화 하기
    2. 현재 유저와 친구인 사람의 이름을 리스트로 반환하기
    3. 내 타임라인 방문자들의 친구 추천 점수를 올리기
        (단, 2번 메서드를 활용하여 이미 친구인 사람이 방문했을 경우는 점수를 올리지 않는다.)
    4. 나와 함께 아는 친구를 바탕으로 추천 스코어 반영하기
    5. Map 형의 친구 추천 스코어를 Value 를 기준으로 하여 정렬한 후, 리스트로 변환하기 (단, value 가 0인 Key는 변환하지 않는다.)
     */

    // 추천 친구 스코어를 기록하기 위한 recommendScore 셋팅
    public static Map<String, Integer> initRecommendScore(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Integer> recommendScore = new HashMap<>();

        for (List<String> friend : friends) {
            for (String name : friend) {
                if (!user.equals(name)) {
                    recommendScore.put(name, 0);
                }
            }
        }

        for (String visitor : visitors) {
            recommendScore.put(visitor, 0);
        }

        return recommendScore;
    }

    // 현재 유저의 친구인 사람 리스트로 반환하기
    public static List<String> extractWhoIsMyFriends(String user, List<List<String>> friends) {

        List<String> userFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                if (friend.get(0).equals(user)) {
                    userFriends.add(friend.get(1));
                } else if (friend.get(1).equals(user)) {
                    userFriends.add(friend.get(0));
                }
            }
        }
        return userFriends;
    }

    // 모든 유저 이름 가져오기 (방문자 및, 친구 관계 리스트를 바탕으로 모든 유저의 이름을 가져온다.)
    public static List<String> loadAllUsers(List<List<String>> friends, List<String> visitors) {
        List<String> allUsers = new ArrayList<>();

        // 친구 관계 2차원 리스트 에서 모든 유저 목록 추출 (중복된 이름은 추가하지 않는다.)
        for (List<String> friend : friends) {
            for (String name : friend) {
                if (!allUsers.contains(name)) {
                    allUsers.add(name);
                }
            }
        }

        // 방문 유저 리스트에서 모든 유저 목록 추출 (중복된 이름은 추가하지 않는다.)
        for (String visitor : visitors) {
            if (!allUsers.contains(visitor)) {
                allUsers.add(visitor);
            }
        }

        return allUsers;
    }

    // 내 타임라인 방문자 추천 스코어 반영하기 (단, 이미 친구인 사람은 스코어를 고려하지 않는다.)
    public static void setVisitorsScore(
            Map<String, Integer> recommendScore, List<String> visitors, List<String> userFriends) {

        for (String visitor : visitors) {
            // 이미 친구인 사람은 추천 스코어를 올리지 않도록 한다.
            if (!userFriends.contains(visitor)) {
                recommendScore.put(visitor, (recommendScore.get(visitor) + 1));
            }
        }
    }

    // 나와 함께 아는 친구를 바탕으로 추천 스코어 반영하기
    public static void setTogetherAcquaintanceScore(
            String user, Map<String, Integer> recommendScore, List<List<String>> friendsShip, List<String> myFriends) {

        // 내 친구의 수만큼 반복한다. (친구가 없다면 반복하지 않고 종료)
        for (String myFriend : myFriends) {
            // 전체 유저의 친구 관계를 순회한다.
            // 친구 관계를 나타내는 리스트를 하나씩 순회하며
            for (List<String> friendShip : friendsShip) {
                // 내 친구목록에 있는 이름과 일치한 항목이 있고, 내 이름이 들어있지 않은 항목을 가진
                // 리스트 원소라면 그 원소는 나와 함께하는 친구를 가리키는 것이다.
                if (friendShip.get(0).equals(myFriend) && !friendShip.get(1).equals(user)) {
                    recommendScore.put(friendShip.get(1), (recommendScore.get(friendShip.get(1)) + 10));
                }

                else if (friendShip.get(1).equals(myFriend) && !friendShip.get(0).equals(user)) {
                    recommendScore.put(friendShip.get(0), (recommendScore.get(friendShip.get(0)) + 10));
                }
            }
        }
    }

    // Map 형의 친구 추천 스코어를 Value 를 기준으로 하여 정렬한 후, 리스트로 변환하기 (단, value 가 0인 Key 는 변환하지 않는다.)
    public static List<String> convertRecommendScoreMapToSortedList(
            Map<String, Integer> recommendScore, List<String> myFriends) {

        List<String> result = new ArrayList<>();

        // 221030 : 19:00 추가사항
        // 이름순으로 먼저 정렬한 후
        // Value 값으로 정렬한다.
        List<Map.Entry<String, Integer>> entries = recommendScore.entrySet().stream()
                .filter(value -> value.getValue() != 0)
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        // 221030 : 19:00 추가사항
        // 반환하는 List 의 크기는 5가 넘지 않아야 하는 조건 추가 -> result.size() < 5
        // 이미 내 친구인 유저인지 판별하는 조건 추가 -> !myFriends.contains(entry.getKey())
        for (Map.Entry<String, Integer> entry : entries) {
            if (!myFriends.contains(entry.getKey()) && result.size() < 5) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 친구 추천 스코어
        Map<String, Integer> recommendScore = initRecommendScore(user, friends, visitors);

        // 유저의 현재 친구 목록
        List<String> myFriends = extractWhoIsMyFriends(user, friends);

        // 친구 추천 스코어에 타임라인 방문자 점수 반영하기
        setVisitorsScore(recommendScore, visitors, myFriends);

        // 친구 추천 스코어에 함께 아는 친구 점수 반영하기
        setTogetherAcquaintanceScore(user, recommendScore, friends, myFriends);

        // 221030 : 19:00 추가사항에 따른 매개변수 추가
        // myFriends -> 함께 아는 친구 점수 반영 과정에서 이미 내 친구인 사람은 제외해야하므로 추가하였다.
        return convertRecommendScoreMapToSortedList(recommendScore, myFriends);
    }
}
