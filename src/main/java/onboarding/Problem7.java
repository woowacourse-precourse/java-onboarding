package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static final Map<String, Set<String>> friendsRelationRepository = new HashMap<>();
    private static final Map<String, Integer> friendsScoreRepository = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //친구 관계에 대한 Map 을 형성
        friends.forEach(x-> saveFriendRelation(x.get(0), x.get(1)));

        //user 에 대한 정보와 visitor 에 대한 정보를 바탕 으로 점수를 할당
        assignScore(user, visitors);

        //정렬을 수행
        Map<String, Integer> sortedFriendsScoreRepository = sortMap(friendsScoreRepository);

        //결과 반환
        List<String> recommendedFriends = new ArrayList<>(sortedFriendsScoreRepository.keySet());
        return restrictedList(recommendedFriends);
    }


    private static List<String> restrictedList(List<String> list) {
        if (list.size() <= 5) {
            return list;
        }
        return list.subList(0,5);
    }

    private static Map<String, Integer> sortMap(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> myCompare(o1, o2));

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        entries.forEach(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }
    private static int myCompare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        if (o1.getValue() == o2.getValue()) {
            return o1.getKey().compareTo(o2.getKey());
        }
        return o2.getValue() - o1.getValue();
    }

    private static void saveFriendRelation(String friends1, String friends2) {
        if (!friendsRelationRepository.containsKey(friends1)) {
            friendsRelationRepository.put(friends1, new HashSet<>());
        }
        if (!friendsRelationRepository.containsKey(friends2)) {
            friendsRelationRepository.put(friends2, new HashSet<>());
        }
        friendsRelationRepository.get(friends1).add(friends2);
        friendsRelationRepository.get(friends2).add(friends1);
    }

    private static void assignScore(String user, List<String> visitor) {
        assign_10score(user);
        assign_1score(user, visitor);
    }
    private static void assign_10score(String user){
        Set<String> friendsOfUser = friendsRelationRepository.get(user);
        List<String> friendsOfFriends = friendsOfUser.stream().
                map(friendsRelationRepository::get).
                flatMap(Collection::stream).
                filter(x-> !x.equals(user)).
                collect(Collectors.toList());

        friendsOfFriends.stream().
                filter(x -> !friendsOfUser.contains(x)).
                forEach(x -> friendsScoreRepository.put(x, friendsScoreRepository.getOrDefault(x, 0) + 10));
    }
    static void assign_1score(String user, List<String> visitor) {
        visitor.stream().
                filter(x -> !x.equals(user) && !friendsRelationRepository.get(user).contains(x)).
                forEach(x -> friendsScoreRepository.put(x, friendsScoreRepository.getOrDefault(x, 0)+1));
    }
}
