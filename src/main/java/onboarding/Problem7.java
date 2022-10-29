package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    static final int firstFriend = 0;
    static final int secondFriend = 1;
    static final int knowPoint = 10;
    static final int visitPoint = 1;
    static final int recommendNum = 5;
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

        friendsOfFriend_list = remove(user, friendsOfFriend_list);

        for (int i = 0; i < userFriends_list.size(); i++)
            friendsOfFriend_list = remove(userFriends_list.get(i), friendsOfFriend_list);


        //친구의 점수표를 Map에 저장
        friendsPoint_map = saveUserPoint(friendsPoint_map, friendsOfFriend_list, knowPoint);

        //visitor 점수를 추가하기 위해
        //단, 이미 친구인 사람은 제거함
        //visitor UnsupportedOperationException error 발생해서 list를 복제함

        List<String> visitors_list = saveVisitorList(visitors);

        for (int i = 0; i < userFriends_list.size(); i++) {
            visitors_list = remove(userFriends_list.get(i), visitors_list);
        }

        //친구의 점수표를 MAP에 저장
        friendsPoint_map = saveUserPoint(friendsPoint_map, visitors_list, visitPoint);

        //point가 가장 높은 순으로 배열로 저장
        point_array = sortList(friendsPoint_map);

        int cnt = Math.max(point_array.length , recommendNum);
        if (cnt == point_array.length)
            cnt = testDuplicationPoint(point_array);
        if (cnt == recommendNum)
            cnt = point_array.length;


        //point가 가장 높은 순으로 리스트를 정렬
        List<String> recommedList = getKey(point_array, friendsPoint_map, cnt);

        //saveSortCheckPointTest
        //saveSortCheckPoint(point_array);
        recommedList = sortList(saveSortCheckPointTest(point_array, recommedList.size()), recommedList);

        int min = Math.min(recommedList.size(), recommendNum);

        for (int i = 0; i < min; i++)
            result.add(recommedList.get(i));

        answer = result;

        return answer;
    }

    //특정 사람과 친구인 사람 구하기
    public static List<String> findUserFriends(String user, List<List<String>> friends_list) {
        List<String> userFriendsList = new ArrayList<>();
        String friends = "";

        for (int i = 0; i < friends_list.size(); i++) {
            if (user.equals(friends_list.get(i).get(firstFriend))) {
                userFriendsList.add(friends_list.get(i).get(secondFriend));
            }
            if (user.equals((friends_list.get(i).get(secondFriend)))) {
                userFriendsList.add(friends_list.get(i).get(firstFriend));
            }
        }

        return userFriendsList;
    }

    //visitor UnsupportedOperationException error 발생해서 list를 복제함
    public static List<String> saveVisitorList(List<String> visitors) {
        List<String> visitorsList = new ArrayList<>();

        for (int i = 0; i < visitors.size(); i++)
            visitorsList.add(visitors.get(i));

        return visitorsList;
    }

    //친구의 친구 목록 저장
    public static List<String> findFriendsOfFriend(List<String> userFriends_list, List<List<String>> friends_list) {
        List<String> friendsOfFriends_list = new ArrayList<>();

        for (int i = 0; i < userFriends_list.size(); i++)
            friendsOfFriends_list.addAll(findUserFriends(userFriends_list.get(i), friends_list));

        return friendsOfFriends_list;
    }
    public static List<String> remove(String user, List<String> friendsOfFiends_list) {
        for (int i = 0; i < friendsOfFiends_list.size(); i++)
        {
            if (friendsOfFiends_list.get(i).equals(user))
            {
                friendsOfFiends_list.remove(i);
                i--;
            }
        }
        return friendsOfFiends_list;
    }

    //친구 점수표를 Map에 저장
    public static Map<String, Integer> saveUserPoint(Map<String,Integer> friendsPoint_map, List<String> userList, int point) {
        int tmp = point;
        String key = "";

        for (int i = 0; i < userList.size(); i++) {
            point = tmp;
            key = userList.get(i);

            if (friendsPoint_map.containsKey(key))
                point = friendsPoint_map.get(key) + point;

            friendsPoint_map.put(key, point);
        }

        return friendsPoint_map;
    }

    //value 로 key 찾기
    public static List<String> getKey(Integer[] valueList, Map<String, Integer> friendsPoint_map, int cnt) {
        List<String> recommendFriendsList = new ArrayList<>();

        System.out.println("cnt = " + cnt + " valueList = " + valueList.length);
        for (int i = 0; i < cnt; i++) {
            for (String key : friendsPoint_map.keySet()) {
                if (valueList[i] == friendsPoint_map.get(key)) {
                    if (recommendFriendsList.contains(key))
                        continue;
                    recommendFriendsList.add(key);
                    break;
                }
            }
        }

        return recommendFriendsList;
    }
    public static Integer[] sortList(Map<String, Integer> friendsPoint_map) {
        Collection <Integer> values = friendsPoint_map.values();
        Integer [] point_array = values.toArray(new Integer[0]);

        Arrays.sort(point_array, Collections.reverseOrder());

        return point_array;
    }

    public static List<Integer> saveSortCheckPointTest(Integer[] point_array, int length) {
        boolean isVisited = false;

        List<Integer> checkPointList = new ArrayList<>();

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
                checkPointList.add(i);
            if (isVisited)
            {
                checkPointList.add(i + cnt);
                i += cnt;
            }
        }

        return checkPointList;
    }
    public static int testDuplicationPoint(Integer[] point_array) {
        int cnt = recommendNum;
        int lastValue = point_array[recommendNum - 1];

        for (int i = recommendNum - 1; i < point_array.length - 1; i++) {
            if (point_array[i] == lastValue)
                cnt++;
            else
                return cnt;
        }

        return cnt;
    }
    public static List<String> sortList(List<Integer> checkPointList, List<String> recommendFriendsList) {
        int cnt = 0;
        // ArrayList를 배열로 변환
        int arrListSize = recommendFriendsList.size();
        String arr[] = recommendFriendsList.toArray(new String[arrListSize]);

        for (int i = 0; i < checkPointList.size(); i++) {
            if (i == 0)
            {
                Arrays.sort(arr, i, (cnt + checkPointList.get(i)));
                continue;
            }
            Arrays.sort(arr, (cnt + 1), checkPointList.get(i) + 1);


           System.out.println((cnt + 1) + "번 부터" + checkPointList.get(i) + "번 까지 정렬 : " + Arrays.asList(arr));

            cnt = checkPointList.get(i);
        }
        recommendFriendsList = Arrays.asList(arr);

        return recommendFriendsList;
    }

    /*
    예외 처리 함수
     */
    public static void checkException(String user ,List<List<String>> friends, List<String> visitors) {
        //null 체크
        checkNullException(user ,friends, visitors);
        /*
        아이디 체크
         */
        //사용자 아이디
        checkUserNameException(user);
        //friends 리스트 아이디
        for (int i = 0; i < friends.size(); i++)
        {
            checkUserNameException(friends.get(i).get(firstFriend));
            checkUserNameException(friends.get(i).get(secondFriend));
        }
        //visitor 리스트 아이디
        for (int i = 0; i < visitors.size(); i++)
            checkUserNameException(visitors.get(i));
        //리스트 길이 확인
        checkListException(friends.size());
        checkListException(visitors.size());
    }
    //사용자 아이디 체크
    public static void checkUserNameException(String user) {
        String errorMessage = "USER NAME ERROR";

        if (user.length() < 1 || user.length() > 30)
            throw new IllegalArgumentException(errorMessage);
        //소문자인지
        for (int i = 0; i < user.length(); i++)
            if (Character.isUpperCase(user.charAt(i)))
                throw new IllegalArgumentException(errorMessage);
    }
    public static void checkNullException(String user, List<List<String>> friends, List<String> visitors) {
        String errorMessage = "NULL ERROR";
        if (friends == null || visitors == null)
            throw new IllegalArgumentException(errorMessage);
        if (user == null)
            throw new IllegalArgumentException(errorMessage);
    }
    //리스트 길이 체크
    public static void checkListException(int length) {
        if (length < 1 || length > 10000)
            throw new IllegalArgumentException("LIST ERROR");
    }

}
