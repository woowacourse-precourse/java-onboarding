package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static HashMap<String, Integer> recommends = new HashMap<>();

    /*
    * friends 각 원소에서 친구 찾기 함수
    */
    private static String findFriendInPairs(String user, List<String> pairs) {

        return pairs.get(0).equals(user) ?
               pairs.get(1) :
               pairs.get(0);
    }

    /*
     * 유저의 친구 리스트 얻는 함수
     */
    private static List<String> getfriendListOfUser(String user, List<List<String>> friends) {
        ArrayList<String> friendList = new ArrayList<>();

        for(List<String> pairs : friends) {
            if(pairs.contains(user)) {
                String addFriend = findFriendInPairs(user, pairs);
                friendList.add(addFriend);
            }
        }

        return friendList;
    }

    /*
     * 사용자와 함께 아는 친구에게 점수를 부여하는 함수
     */
    private static void setScoreToFriendOfUserFriend(List<String> friendsOfUserFriends) {

        for(String friend: friendsOfUserFriends)
            recommends.putIfAbsent(friend, 10);
    }

    /*
     * 친구 관계 정보에 따른 점수 부여 함수
     */
    private static void getFriendsScore(String user, List<List<String>> friends) {
        List<String> userFriends = getfriendListOfUser(user, friends);

        for(String friend : userFriends) {
            List<String> friendsOfUserFriends = getfriendListOfUser(friend, friends);
            friendsOfUserFriends.remove(user);
            friendsOfUserFriends.removeAll(userFriends);

            setScoreToFriendOfUserFriend(friendsOfUserFriends);

        }
    }

    /*
     * 방문 기록에 따른 점수 부여 함수
     */
    private static void getVisitorsScore(List<String> userFriends, List<String> visitors) {

        for(String visitor : visitors) {
            if(recommends.containsKey(visitor)) {
                recommends.put(visitor, recommends.get(visitor) + 1);

            } else if(!userFriends.contains(visitor)){
                recommends.put(visitor, 1);
            }
        }
    }

    /*
     * HashMap 정렬
     * 점수 내림차순 , 점수 같을 시 이름 오름차순
     */
    public static int compareByScoreAndName(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        int comparison = (o1.getValue() - o2.getValue()) * -1;
        return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
    }

    private static List<Map.Entry<String, Integer>> sort(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        entries.sort(Problem7::compareByScoreAndName);

        return entries;
    }

    /*
     * Entry -> List 로 변환하는 함수
     */
    private static List<String> convertEntriesToList(List<Map.Entry<String, Integer>> entries) {
        List<String> result = new ArrayList<>(Collections.emptyList());

        for(Map.Entry<String, Integer> entry: entries)
            result.add(entry.getKey());

        return result;

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = getfriendListOfUser(user, friends);
        getFriendsScore(user, friends);
        getVisitorsScore(userFriends, visitors);

        List<Map.Entry<String, Integer>> entries = sort(recommends);
        List<String> recommendResult = convertEntriesToList(entries);

        return recommendResult.size() == 0 ?
                Collections.emptyList() :
                recommendResult.stream().limit(5).collect(Collectors.toList());

    }
}
