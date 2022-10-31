package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<String> answer = Collections.emptyList();
        List<String> result = new ArrayList<>();
        Map<String, Integer> friendsPoint_map = new HashMap<>();
        Integer [] point_array;

        //예외 확인
        checkException(user, friends, visitors);

        //사용자와 이미 친구인 목록을 구함
        List<String> userFriends_list = findUserFriends(user, friends);

        //친구의 친구인 목록을 구함
        List<String> friendsOfFriend_list = findFriendsOfFriend(userFriends_list, friends);

        friendsOfFriend_list = removeDuplication(user, friendsOfFriend_list);

        for (int i = 0; i < userFriends_list.size(); i++)
            friendsOfFriend_list = removeDuplication(userFriends_list.get(i), friendsOfFriend_list);


        //친구의 점수표를 Map에 저장
        friendsPoint_map = saveUserPoint(friendsPoint_map, friendsOfFriend_list, User.knowPoint.info);

        //visitor 점수를 추가하기 위해
        //단, 이미 친구인 사람은 제거함
        //visitor UnsupportedOperationException error 발생해서 list를 복제함

        List<String> visitors_list = saveVisitorList(visitors);

        for (int i = 0; i < userFriends_list.size(); i++) {
            visitors_list = removeDuplication(userFriends_list.get(i), visitors_list);
        }

        //친구의 점수표를 MAP에 저장
        friendsPoint_map = saveUserPoint(friendsPoint_map, visitors_list, User.visitPoint.info);

        //point가 가장 높은 순으로 배열로 저장
        point_array = sortByPoint(friendsPoint_map);

        int cnt = Math.max(point_array.length , User.recommendNum.info);
        if (cnt == point_array.length)
            cnt = saveDuplicationRange(point_array);
        if (cnt == User.recommendNum.info)
            cnt = point_array.length;


        //point가 가장 높은 순으로 리스트를 정렬
        List<String> recommedList = findUserByPoint(point_array, friendsPoint_map, cnt);

        recommedList = sortByUser(saveCheckpointForSort(point_array, recommedList.size()), recommedList);

        int min = Math.min(recommedList.size(), User.recommendNum.info);

        for (int i = 0; i < min; i++)
            result.add(recommedList.get(i));

        answer = result;

        return answer;
    }

    //특정 사람과 친구인 사람 구하기
    public static List<String> findUserFriends(String user, List<List<String>> friends_list) {
        List<String> userFriends_list = new ArrayList<>();

        for (int i = 0; i < friends_list.size(); i++) {
            if (user.equals(friends_list.get(i).get(User.first.info))) {
                userFriends_list.add(friends_list.get(i).get(User.second.info));
            }
            if (user.equals((friends_list.get(i).get(User.second.info)))) {
                userFriends_list.add(friends_list.get(i).get(User.first.info));
            }
        }

        return userFriends_list;
    }
    //친구의 친구 목록 저장
    public static List<String> findFriendsOfFriend(List<String> userFriends_list, List<List<String>> friends_list) {
        List<String> friendsOfFriends_list = new ArrayList<>();

        for (int i = 0; i < userFriends_list.size(); i++)
            friendsOfFriends_list.addAll(findUserFriends(userFriends_list.get(i), friends_list));

        return friendsOfFriends_list;
    }
    //point별로 user 찾기
    public static List<String> findUserByPoint(Integer[] point_array, Map<String, Integer> friendsPoint_map, int length) {
        List<String> recommendFriends_list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            for (String key : friendsPoint_map.keySet()) {
                if (point_array[i] == friendsPoint_map.get(key)) {
                    if (recommendFriends_list.contains(key))
                        continue;
                    recommendFriends_list.add(key);
                    break;
                }
            }
        }

        return recommendFriends_list;
    }
    public static List<String> removeDuplication(String user, List<String> friendsOfFiends_list) {
        for (int i = 0; i < friendsOfFiends_list.size(); i++) {
            if (friendsOfFiends_list.get(i).equals(user)) {
                friendsOfFiends_list.remove(i);
                i--;
            }
        }

        return friendsOfFiends_list;
    }
    //visitor UnsupportedOperationException error 발생해서 list를 복제함
    public static List<Integer> saveCheckpointForSort(Integer[] point_array, int length) {
        boolean isVisited = false;
        List<Integer> checkpoint_list = new ArrayList<>();

        for (int i = 0; i < length - 1; i++) {
            int cnt = 0;
            for (int j = i + 1; j < length; j++) {
                if (point_array[i] == point_array[j]) {
                    isVisited = true;
                    cnt++;
                }
                if (point_array[i] != point_array[j])
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
    public static Map<String, Integer> saveUserPoint(Map<String,Integer> friendsPoint_map, List<String> friends_list, int point) {
        String key;
        int tmp = point;

        for (int i = 0; i < friends_list.size(); i++) {
            point = tmp;
            key = friends_list.get(i);

            if (friendsPoint_map.containsKey(key))
                point = friendsPoint_map.get(key) + point;

            friendsPoint_map.put(key, point);
        }

        return friendsPoint_map;
    }
    public static List<String> saveVisitorList(List<String> visitors) {
        List<String> visitors_list = new ArrayList<>();

        for (int i = 0; i < visitors.size(); i++)
            visitors_list.add(visitors.get(i));

        return visitors_list;
    }
    public static Integer[] sortByPoint(Map<String, Integer> friendsPoint_map) {
        Collection <Integer> values = friendsPoint_map.values();
        Integer [] point_array = values.toArray(new Integer[0]);

        Arrays.sort(point_array, Collections.reverseOrder());

        return point_array;
    }
    public static List<String> sortByUser(List<Integer> checkPointList, List<String> recommendFriends_list) {
        int cnt = 0;
        String recommendFriends_array[] = recommendFriends_list.toArray(new String[recommendFriends_list.size()]);

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

    /*
    예외 처리 함수
     */
    public static void checkException(String user ,List<List<String>> friends, List<String> visitors) {
        checkNullException(user ,friends, visitors);
        checkUserNameException(user);

        for (int i = 0; i < friends.size(); i++) {
            checkUserNameException(friends.get(i).get(User.first.info));
            checkUserNameException(friends.get(i).get(User.second.info));
        }

        for (int i = 0; i < visitors.size(); i++)
            checkUserNameException(visitors.get(i));

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
