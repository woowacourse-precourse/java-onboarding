/*
 * Problem7.java
 *
 * 2022-11-01
 *
 */
package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 우아한 테크코스 - 프리코스 1주차 추천친구 계산
 *
 * @author 이준현
 * @version 1.00 2022년 11월 01일
 */
public class Problem7 {

    /**
     * 전체 user들을 저장하고 있는 Set
     */
    private static final HashSet<String> users = new HashSet<>();
    /**
     * friends들을 통해 파악된 연결된 친구 그래프를 구현시킨 Map
     */
    private static final HashMap<String, List<String>> network = new HashMap<>();
    /**
     * 특정 유저를 중심으로 구성된 추천점수표
     */
    private static final HashMap<String, Integer> recommendedScore = new HashMap<>();

    /**
     * 주어진 입력값들이 문제의 제한사하하항에 유효한지 확인하는 method
     *
     * @param user     user 이름
     * @param friends  List
     * @param visitors List
     * @return 값이 모두 유효할 시 true, 부적합할 시 false return
     */
    public static boolean validCheck(String user, List<List<String>> friends, List<String> visitors) {
        if (user.length() < 1 || user.length() > 30) {
            return false;
        }
        if (friends.size() < 1 || friends.size() > 10000) {
            return false;
        }
        for (List<String> friend : friends) {
            if (friend.size() != 2) {
                return false;
            }
            if (friend.get(0).length() < 1 || friend.get(0).length() > 30) {
                return false;
            }
            if (friend.get(1).length() < 1 || friend.get(1).length() > 30) {
                return false;
            }
        }
        if (visitors.size() > 10000) {
            return false;
        }
        if (friends.stream().distinct().count() != friends.size()) {
            return false;
        }
        return true;
    }

    /**
     * 전체 user목록을 만드는 기능
     *
     * @param user     중심이 되는 user 정보
     * @param friends  전체 친구의 구성도를 알 수 있는 friends List
     * @param visitors user가 방문한 사람들의 정보가 담긴 List
     */
    public static void makeUser(String user, List<List<String>> friends, List<String> visitors) {
        users.add(user);
        for (List<String> friend : friends) {
            users.addAll(friend);
        }
        users.addAll(visitors);
    }

    /**
     * 전체 친구 구성도를 파악해 unDirected Graph를 만드는 기능
     *
     * @param friends 친구 구성도를 나타내는 List
     */
    public static void makeNetwork(List<List<String>> friends) {
        for (String name : users) {
            network.put(name, new ArrayList<>());
        }
        for (List<String> friend : friends) {
            List<String> connectedFirstFriend = network.get(friend.get(0));
            List<String> connectedSecondFriend = network.get(friend.get(1));
            connectedFirstFriend.add(friend.get(1));
            connectedSecondFriend.add(friend.get(0));
            network.put(friend.get(0), connectedFirstFriend);
            network.put(friend.get(1), connectedSecondFriend);
        }
    }

    /**
     * 특정 user를 중심으로 문제의 알고리즘에 따라 추천점수를 계산하는 기능.
     * 친구의 친구들일때 인당 +10점, 내가 방문한 사람일떄 + 1점
     *
     * @param user     중심이 될 user
     * @param visitors user가 방문한 사람들의 정보가 담긴 List
     */
    public static void recommendedScoreCalculation(String user, List<String> visitors) {
        for (String name : users) {
            recommendedScore.put(name, 0);
            if (Objects.equals(name, user)) {
                recommendedScore.put(name, -1);
            }
        }

        List<String> userFriends = network.get(user);

        for (String friend : userFriends) {
            recommendedScore.put(friend, -1);
        }
        for (String friend : userFriends) {
            List<String> connectedFriend = network.get(friend);
            for (String connectedFriendName : connectedFriend) {
                Integer originScore = recommendedScore.get(connectedFriendName);
                if (originScore != -1) {
                    originScore += 10;
                    recommendedScore.put(connectedFriendName, originScore);
                }
            }
        }
        for (String visitor : visitors) {
            Integer originScore = recommendedScore.get(visitor);
            if (originScore != -1) {
                originScore += 1;
                recommendedScore.put(visitor, originScore);
            }
        }
    }

    /**
     * 점수 계산을 통해 최종적으로 가장 높은 추천점수를 받은 사람을 추출하는 기능
     *
     * @return 점수별로 내림차순, 점수가 같을시 이름순으로 오름차순 정렬하여 List로 return
     */
    public static List<String> getRecommendedFriend() {
        List<String> result = new ArrayList<>(Collections.emptyList());
        List<Map.Entry<String, Integer>> sortedFriend = recommendedScore
                .entrySet()
                .stream()
                .sorted(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if (Objects.equals(o1.getValue(), o2.getValue())) {
                            return o1.getKey().compareTo(o2.getKey());
                        }
                        return o2.getValue().compareTo(o1.getValue());
                    }
                }).collect(Collectors.toList());
        for (Map.Entry<String, Integer> recommendedFriend : sortedFriend) {
            if (recommendedFriend.getValue() > 0) {
                result.add(recommendedFriend.getKey());
            }
        }
        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        if (!validCheck(user, friends, visitors)) {
            throw new IllegalStateException("잘못된 입력입니다.");
        }
        makeUser(user, friends, visitors);
        makeNetwork(friends);
        recommendedScoreCalculation(user, visitors);
        answer = getRecommendedFriend();
        return answer;
    }
}
