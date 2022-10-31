package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Problem7 {
    enum User{
        knowPoint(10),
        visitPoint(1),
        recommendNum(5),
        first(0),
        second(1);
        private final int info;
        User(int info){
            this.info = info;
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendsPoint_map = new HashMap<>();
        List<String> answer;
        List<String> friendsOfFriend_list;
        List<String> userFriends_list;
        List<String> visitors_list;

        checkException(user, friends, visitors);

        //사용자와 이미 친구인 목록을 구함
        userFriends_list = findFriendsByUser(user, friends);

        //친구의 친구인 목록을 구함
        friendsOfFriend_list = findFriendsOfFriend(userFriends_list, friends);
        removeDuplication(user, friendsOfFriend_list);
        visitors_list = saveVisitorList(visitors);

        saveFriendsForRecommend(friendsOfFriend_list, visitors_list, userFriends_list);

        savePointByRules(friendsPoint_map, friendsOfFriend_list, visitors_list);

        answer = saveRecommendUser(findRecommendUserByPoint(friendsPoint_map));

        return answer;
    }
    public static void excludeCloseFriends(List<String> userFriends_list, List<String> user_list) {
        for (String s : userFriends_list) {
            removeDuplication(s, user_list);
        }
    }
    //중복인 사용자 찾아서 제거
    public static void removeDuplication(String user, List<String> friendsOfFiends_list) {
        for (int i = 0; i < friendsOfFiends_list.size(); i++) {
            if (friendsOfFiends_list.get(i).equals(user)) {
                friendsOfFiends_list.remove(i);
                i--;
            }
        }
    }
    public static void saveFriendsForRecommend(List<String> friendsOfFriend, List<String> visitors, List<String> userFriends) {
        excludeCloseFriends(userFriends, friendsOfFriend);
        excludeCloseFriends(userFriends, visitors);
    }
    public static void saveUserPoint(Map<String,Integer> friendsPoint_map, List<String> friends_list, int point) {
        String key;
        int tmp = point;

        for (String s : friends_list) {
            point = tmp;
            key = s;

            if (friendsPoint_map.containsKey(key))
                point = friendsPoint_map.get(key) + point;

            friendsPoint_map.put(key, point);
        }

    }
    public static void savePointByRules(Map<String, Integer> friendsPoint, List<String> friendsOfFriend, List<String> visitors) {
        savePointByFriends(friendsPoint, friendsOfFriend, User.knowPoint.info);
        savePointByFriends(friendsPoint, visitors, User.visitPoint.info);
    }
    public static void savePointByFriends(Map<String,Integer> friendsPoint_map, List<String> friends_list, int point) {
        saveUserPoint(friendsPoint_map, friends_list, point);
    }
    public static int saveRecommendLength(Integer[] point) {
        int length = Math.max(point.length , User.recommendNum.info);
        if (length == point.length)
            length = saveDuplicationRange(point);
        if (length == User.recommendNum.info)
            length = point.length;

        return length;
    }
    public static int saveDuplicationRange(Integer[] point_array) {
        int cnt = User.recommendNum.info;
        int lastValue = point_array[User.recommendNum.info - 1];

        for (int i = User.recommendNum.info - 1; i < point_array.length - 1; i++) {
            if (point_array[i] == lastValue)
                cnt++;
            if (point_array[i] != lastValue)
                return cnt;
        }

        return cnt;
    }
    public static Integer[] sortByPoint(Map<String, Integer> friendsPoint_map) {
        Collection <Integer> values = friendsPoint_map.values();
        Integer [] point_array = values.toArray(new Integer[0]);

        Arrays.sort(point_array, Collections.reverseOrder());

        return point_array;
    }
    public static List<String> sortByUser(List<Integer> checkPointList, List<String> recommendFriends_list) {
        int cnt = 0;
        String[] recommendFriends_array = recommendFriends_list.toArray(new String[0]);

        for (int i = 0; i < checkPointList.size(); i++) {
            if (i == 0) {
                Arrays.sort(recommendFriends_array, i, (cnt + checkPointList.get(i)));
                continue;
            }
            Arrays.sort(recommendFriends_array, (cnt + 1), checkPointList.get(i) + 1);

            cnt = checkPointList.get(i);
        }
        recommendFriends_list = Arrays.asList(recommendFriends_array);

        return recommendFriends_list;
    }
    //친구의 친구 목록 저장
    public static List<String> findFriendsOfFriend(List<String> userFriends, List<List<String>> friends) {
        List<String> friendsOfFriends = new ArrayList<>();

        for (String closeFriends : userFriends)
            friendsOfFriends.addAll(findFriendsByUser(closeFriends, friends));

        return friendsOfFriends;
    }
    //point별로 user 찾기
    public static List<String> findFriendsByUser(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();

        for (List<String> closeFriends : friends) {
            if (user.equals(closeFriends.get(User.first.info))) {
                userFriends.add(closeFriends.get(User.second.info));
            }
            if (user.equals((closeFriends.get(User.second.info)))) {
                userFriends.add(closeFriends.get(User.first.info));
            }
        }

        return userFriends;
    }
    public static List<String> findUserByPoint(Integer[] point_array, Map<String, Integer> friendsPoint_map, int length) {
        List<String> recommendFriends_list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            for (String key : friendsPoint_map.keySet()) {
                if (Objects.equals(point_array[i], friendsPoint_map.get(key))) {
                    if (recommendFriends_list.contains(key))
                        continue;
                    recommendFriends_list.add(key);
                    break;
                }
            }
        }

        return recommendFriends_list;
    }
    public static List<String> saveRecommendUser(List<String> recommend) {
        List<String> recommendUser = new ArrayList<>();
        int min = Math.min(recommend.size(), User.recommendNum.info);

        for (int i = 0; i < min; i++)
            recommendUser.add(recommend.get(i));

        return recommendUser;
    }
    public static List<String> findRecommendUserByPoint(Map<String, Integer> friendsPoint_map) {
        Integer[] point = sortByPoint(friendsPoint_map);

        //point가 가장 높은 순으로 리스트를 정렬
        List<String> recommedUser = findUserByPoint(point, friendsPoint_map, saveRecommendLength(point));

        return sortByUser(saveCheckpointForSort(point, recommedUser.size()), recommedUser);
    }
    public static List<Integer> saveCheckpointForSort(Integer[] point_array, int length) {
        boolean isVisited = false;
        List<Integer> checkpoint_list = new ArrayList<>();

        for (int i = 0; i < length - 1; i++) {
            int cnt = 0;
            for (int j = i + 1; j < length; j++) {
                if (Objects.equals(point_array[i], point_array[j])) {
                    isVisited = true;
                    cnt++;
                }
                if (!Objects.equals(point_array[i], point_array[j]))
                    break;
            }
            if (!isVisited)
                checkpoint_list.add(i);
            if (isVisited) {
                checkpoint_list.add(i + cnt);
                i += cnt;
            }
        }

        return checkpoint_list;
    }
    public static List<String> saveVisitorList(List<String> visitors) {

        return new ArrayList<>(visitors);
    }
    /*
    예외 처리 함수
     */
    public static void checkException(String user ,List<List<String>> friends, List<String> visitors) {
        checkNullException(user ,friends, visitors);
        checkUserNameException(user);

        for (List<String> friend : friends) {
            checkUserNameException(friend.get(User.first.info));
            checkUserNameException(friend.get(User.second.info));
        }

        for (String visitor : visitors)
            checkUserNameException(visitor);

        checkListException(friends.size());
        checkListException(visitors.size());
    }
    public static void checkListException(int length) {
        if (length < 1 || length > 10000)
            throw new IllegalArgumentException("LIST ERROR");
    }
    public static void checkNullException(String user, List<List<String>> friends, List<String> visitors) {
        String errorMessage = "NULL ERROR";
        if (friends == null || visitors == null)
            throw new IllegalArgumentException(errorMessage);
        if (user == null)
            throw new IllegalArgumentException(errorMessage);
    }
    public static void checkUserNameException(String user) {
        String errorMessage = "USER NAME ERROR";

        if (user.length() < 1 || user.length() > 30)
            throw new IllegalArgumentException(errorMessage);

        for (int i = 0; i < user.length(); i++)
            if (Character.isUpperCase(user.charAt(i)))
                throw new IllegalArgumentException(errorMessage);
    }
}
