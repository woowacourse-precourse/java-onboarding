package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        //함께아는 친구 userPointEntry
        Map<String, Integer> friendsOfFriendsPoint = calculatePoint(getFriendOfFriends(user, friends), PointType.FRIEND_OF_FRIENDS);
        //직접 아는 친구
        List<String> friend = getFriends(user, friends);
        //방문한 친구 userPointEntry중에 직접 아는 친구 삭제
        Map<String, Integer> visitPoint = removeByKey(calculatePoint(visitors, PointType.VISIT), friend);
        //총 유저들의 pointEntry
        Map<String, Integer> userPointEntry = mergeMapSumValue(friendsOfFriendsPoint, visitPoint);
        //정렬 및 사이즈 제한
        getEntryDescByValue(userPointEntry, 5).forEach((key, value) -> {
            answer.add(key);
        });

        return answer;
    }

    /**
     * @param user    : 문자열(기준이되는 user이름)
     * @param friends : 문자열 리스트(친구 관계 정보)
     * @return user와 친구인 사람과 친구인 user를 문자열 리스트형으로 반환
     */
    private static List<String> getFriendOfFriends(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();
        List<String> userFriends = getFriends(user, friends);
        for (String userFriend : userFriends) {
            result.addAll(getFriends(userFriend, friends));
            if (result.contains(user)) {
                result.remove(user);
            }
        }
        return result;
    }
    //방문과 함께 친구인 유저의 포인트가 다르기 때문에 enum으로 관리(추후에 Point 적립 타입이 늘어나도 필드를 추가하면 재사용 가능)
    enum PointType {
        VISIT(1),
        FRIEND_OF_FRIENDS(10);

        private final int value;

        private PointType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    /**
     * @param user    : 문자열(기준이되는 user이름)
     * @param friends : 문자열 리스트(친구 관계 정보)
     * @return 친구관계에서 user와 직접적으로 친구인 문자열 리스트 반환
     */
    private static List<String> getFriends(String user, List<List<String>> friends) {
        List<List<String>> userFriends = friends.stream().filter(friend -> friend.contains(user)).collect(Collectors.toList());
        List<String> result = userFriends.stream().flatMap(Collection::stream).distinct().collect(Collectors.toList());
        result.remove(user);

        return result;
    }

    /**
     * @param users : 문자열 리스트(포인트를 받을 수 있는 이름)
     * @param pointType enum 타입 (VISIT, FRIEND_OF_FRIENDS)을 가지고 타입에 해당하는 포인트 value를 가지고 있다.
     * @return users를 Key로 point를 value로 반환하는데, pointType의 value를 더해 Map<String, Integer>을 반환함
     */
    private static Map<String, Integer> calculatePoint(List<String> users, PointType pointType) {
        Map<String, Integer> userPointMap = new HashMap<>();
        for (String user : users) {
            if (userPointMap.containsKey(user)) {
                userPointMap.replace(user, userPointMap.get(user) + pointType.getValue());
            }else{
                userPointMap.put(user, pointType.getValue());
            }
        }

        return userPointMap;
    }

    /**
     * @param firstMap : Map<String, Integer>(합치고 싶은 Map)
     * @param secondMap : Map<String, Integer>(합치고 싶은 Map)
     * @return Key가 같은 것들 끼리는 value를 더하며 합쳐 같은 타입의 하나의 Map으로 반환
     */
    private static Map<String, Integer> mergeMapSumValue(Map<String, Integer> firstMap, Map<String, Integer> secondMap){
        secondMap.forEach((key, value) -> firstMap.merge(key, value, (v1, v2) -> v1 + v2));
        return firstMap;
    }

    /**
     * @param map : Map<String, Integer>(정렬하고자 하는 Map)
     * @param size : 반환하고자 하는 Map의 size
     * @return map의 Value 기준 내림차순으로 정렬하고 Value 가 같은것 끼리는 Key 오름차순으로 정렬
     */
    private static Map<String, Integer> getEntryDescByValue(Map<String, Integer> map, int size){
        LinkedHashMap<String, Integer> entrySet = map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue()).thenComparing(Map.Entry.comparingByKey()))
                .limit(size)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return entrySet;
    }

    /**
     * @param map : Map<String, Integer>(지우고자 하는 object가 있는 map)
     * @param keyList : 문자열 리스트(지우고자 하는 Key 리스트)
     * @return map에서 keyList를 지우고 반환
     */
    private static Map<String, Integer> removeByKey(Map<String, Integer> map, List<String> keyList){
        for(String key : keyList){
            map.remove(key);
        }
        return map;
    }

}
