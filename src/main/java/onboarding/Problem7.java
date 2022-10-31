package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> interactionFriendMap = new HashMap<>();

        makeMap(user, friends, interactionFriendMap);

        List<String> user_friend = new ArrayList<>();
        user_friend = interactionFriendMap.get(user);
        Map<String, Integer> friendNameByScore = new HashMap<>();

        userFriendDelete(interactionFriendMap, user_friend);

        friendScorePut(visitors, interactionFriendMap, user_friend, friendNameByScore);

        removeNoResult(user, friendNameByScore, visitors,
            user_friend); 

        List<Integer> friendsScores = new ArrayList<>(friendNameByScore.values());
        List<String> friendsNames = new ArrayList<>(friendNameByScore.keySet());

        sortResultByRequirements(friendNameByScore, friendsScores,
            friendsNames);

        List<String> result = printResult(friendsScores,
            friendsNames);

        return result;


    }

    private static void userFriendDelete(Map<String, List<String>> map, List<String> user_friend) {
        for (String s : user_friend) {
            map.remove(s);
        }
    }

    private static void makeMap(String user, List<List<String>> friends,
        Map<String, List<String>> map) {
        List<String> user_list = new ArrayList<>();
        user_list.add(user);
        map.put(user, new ArrayList<>());

        addUserFriend(friends, user_list);
        List<String> result = getNoDuplicateUserList(user_list);

        putMapUser(map, result);

        addFriendsNameToMap(friends, map);
    }

    private static void addFriendsNameToMap(List<List<String>> friends, Map<String, List<String>> map) {
        for (int i = 0; i < friends.size(); i++) {
            addListByFriendsName(friends, map, i);
        }
    }

    private static void putMapUser(Map<String, List<String>> map, List<String> result) {
        for (int i = 0; i < result.size(); i++) {
            putMapUserList(map, result.get(i));
        }
    }

    private static void addUserFriend(List<List<String>> friends, List<String> user_list) {
        for (int i = 0; i < friends.size(); i++) {
            addUserList(friends, user_list, i);
        }
    }

    private static void friendScorePut(List<String> visitors, Map<String, List<String>> map,
        List<String> user_friend, Map<String, Integer> friendNameByScore) {
        initalizedFriendScore(visitors, map, friendNameByScore);
        plusVisitorScore(visitors, friendNameByScore);
        for (String s : map.keySet()) { // friend_score에 넣는 부분
            for (int i = 0; i < user_friend.size(); i++) {
                for (int j = 0; j < map.get(s).size(); j++) {
                    if (isSameFriendWithUser(map, user_friend, s, i, j)) {
                        plusSameFriendScore(friendNameByScore, s);
                    }
                }
            }
        }
    }

    private static void plusVisitorScore(List<String> visitors, Map<String, Integer> friendNameByScore) {
        for (String s : visitors) {
            plusVisitorScore(friendNameByScore, s);
        }
    }

    private static void initalizedFriendScore(List<String> visitors, Map<String, List<String>> map,
        Map<String, Integer> friend_score) {
        for (String s : map.keySet()) {
            initFriendScored(friend_score, s);
        }

        for (String s : visitors) {
            initFriendScored(friend_score, s);
        }
    }

    private static void removeNoResult(String user, Map<String, Integer> friend_score,
        List<String> visitors, List<String> user_friend) {
        deleteUserFriends(user, friend_score);
        for (String s : visitors) { // 방문자 제거
            deleteVisitor(friend_score, user_friend, s);
        }
        List<String> removed = new ArrayList<>();
        for (String s : friend_score.keySet()) {
            addZeroList(friend_score, removed, s);
        }
        removedZeroScore(friend_score, removed);
    }

    private static void addZeroList(Map<String, Integer> friend_score, List<String> removed,
        String s) {
        if (isNoScored(friend_score, s)) {
            removed.add(s); //0점인 경우도 제거하기위한 제거리스트
        }
    }

    private static void removedZeroScore(Map<String, Integer> friend_score, List<String> removed) {
        for (int i = 0; i < removed.size(); i++) {
            friend_score.remove(removed.get(i)); // 0점인 친구들 제거
        }
    }

    private static void deleteUserFriends(String user, Map<String, Integer> friend_score) {
        if (isFriendWithUser(user, friend_score)) {
            friend_score.remove(user);
        }
    }

    private static void deleteVisitor(Map<String, Integer> friend_score, List<String> user_friend,
        String s) {
        if (isUserFriendInVisitor(user_friend, s)) {
            friend_score.remove(s);
        }
    }


    private static List<String> printResult(List<Integer> listValueSet, List<String> listKeySet) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < listKeySet.size(); i++) {
            List<String> comporatorWithSameScored = new ArrayList<>(); // comporatorWithSameScored 점수가 같을 경우 알파벳 순으로 출력시킬 수 있도록 분류
            if (isSameNameInResult(listKeySet, result, i)) { // 점수 동일 여부 확인 후 이미 알파벳 순으로 정렬되고 결과 값으로 들어갈 수도 있는 경우 건너뛰기
                continue;
            }
            addNowIndexName(listKeySet, i, comporatorWithSameScored);
            for (int j = i + 1; j < listKeySet.size(); j++) {
                addIfScoredSameCase(listValueSet, listKeySet, i, comporatorWithSameScored, j);
            }
            Collections.sort(comporatorWithSameScored); // 만약 점수가 같지 않고 고유한 값인 경우 comp에는 값이 1개, 같은 경우 점수가 같은 만큼의 size가 나오게 됨.
            putCompToResult(result, comporatorWithSameScored);
        }
        return result;
    }

    private static void putCompToResult(List<String> result, List<String> comporatorWithSameScored) {
        for (int j = 0; j < comporatorWithSameScored.size(); j++) { // result에는 comp에서 이미 알파벳 정렬이 끝난 친구와 미리미리 상관없이 넣은 친구들을 위하여 넣음
            putCompToResult(result, comporatorWithSameScored, j);
        }
    }

    private static void putCompToResult(List<String> result, List<String> comp, int j) {
        if (isSizeOverFlow(result.size(), 5)) {
            result.add(comp.get(j));
        }
    }

    private static void addListByFriendsName(List<List<String>> friends, Map<String, List<String>> map,
        int i) {
        String friend1 = friends.get(i).get(0);
        String friend2 = friends.get(i).get(1);

        addEachOther(map, friend1, friend2);
    }

    private static void addEachOther(Map<String, List<String>> map, String friend1, String friend2) {
        map.get(friend1).add(friend2);
        map.get(friend2).add(friend1); // 친구1,2,3 추가 (양방향적으로)
    }

    private static void putMapUserList(Map<String, List<String>> map, String result) {
        map.put(result, new ArrayList<>());
    }

    private static List<String> getNoDuplicateUserList(List<String> user_list) {
        Set<String> set = new HashSet<>(user_list);
        List<String> result = new ArrayList<>(set); // 중복되어있는 친구 이름 중복된 이름 제거
        return result;
    }

    private static void addUserList(List<List<String>> friends, List<String> user_list, int i) {
        user_list.add(friends.get(i).get(0));
        user_list.add(friends.get(i).get(1));
    }
    private static boolean isSameFriendWithUser(Map<String, List<String>> map, List<String> user_friend,
        String s, int i, int j) {
        return user_friend.get(i).equals(map.get(s).get(j));
    }

    private static void initFriendScored(Map<String, Integer> friend_score, String s) {
        friend_score.put(s, 0);
    }

    private static void plusVisitorScore(Map<String, Integer> friend_score, String s) {
        int a = friend_score.get(s) + 1;
        friend_score.put(s, a);
    }

    private static void plusSameFriendScore(Map<String, Integer> friend_score, String s) {
        int a = friend_score.get(s) + 10;
        friend_score.put(s, a);
    }

    private static boolean isNoScored(Map<String, Integer> friend_score, String s) {
        return friend_score.get(s) == 0;
    }

    private static boolean isUserFriendInVisitor(List<String> user_friend, String s) {
        return user_friend.contains(s);
    }

    private static boolean isFriendWithUser(String user, Map<String, Integer> friend_score) {
        return friend_score.containsKey(user);
    }

    private static void sortResultByRequirements(Map<String, Integer> friend_score, List<Integer> listValueSet,
        List<String> listKeySet) {
        sortedByScoredDescentInName(friend_score, listKeySet); // 점수별로 내림차순으로 친구 이름 정렬

        sortedByScoredDescent(listValueSet); // 점수 내림차순
    }

    private static void sortedByScoredDescent(List<Integer> listValueSet) {
        Collections.sort(listValueSet, Collections.reverseOrder());
    }

    private static void sortedByScoredDescentInName(Map<String, Integer> friend_score, List<String> listKeySet) {
        Collections.sort(listKeySet, (value1, value2) -> (friend_score.get(value2)
            .compareTo(friend_score.get(value1))));
    }

    private static boolean isSizeOverFlow(int result, int x) {
        return result < x;
    }

    private static void addNowIndexName(List<String> listKeySet, int i, List<String> comp) {
        comp.add(listKeySet.get(i));
    }

    private static void addIfScoredSameCase(List<Integer> listValueSet, List<String> listKeySet, int i,
        List<String> comp, int j) {
        if (listValueSet.get(i) == listValueSet.get(
            j)) {   //-> 이거 하는 이유? 그 comp라는게 존재하는 이유가 점수 같을 경우 알파벳순으로 추출할 문자열들을 추가하기 위함.
            comp.add(listKeySet.get(j));
        }
    }

    private static boolean isSameNameInResult(List<String> listKeySet, List<String> result, int i) {
        return result.contains(
            listKeySet.get(i));
    }

}
