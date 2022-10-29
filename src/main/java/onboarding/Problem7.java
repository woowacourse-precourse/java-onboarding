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
    static String userName;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> result = new ArrayList<>();
        Map<String, Integer> friendsPoint_map = new HashMap<>();
        Integer [] tmpArray;

        userName = user;

        //예외 확인
        checkException(user, friends, visitors);

        //사용자와 이미 친구인 목록을 구함
        List<String> userFriends_list = findUserFriends(user, friends);

        //친구의 친구인 목록을 구하고 점수를 구함
        List<String> friendsOfFriend_list = findFriendsOfFriend(userFriends_list, friends);
        //친구의 점수표를 Map에 저장
        friendsPoint_map = saveUserPoint(friendsPoint_map, friendsOfFriend_list, knowPoint);

        //visitor 점수를 추가하기 위해
        //단, 이미 친구인 사람은 제거함
        //visitor UnsupportedOperationException error 발생해서 list를 복제함
        List<String> removeUser_list= removeDuplication(saveVisitorList(visitors), userFriends_list);

        //친구의 점수표를 MAP에 저장
        friendsPoint_map = saveUserPoint(friendsPoint_map, removeUser_list, visitPoint);



        tmpArray = sortList(friendsPoint_map);

        List<String> recommedList = getKey(tmpArray, friendsPoint_map);
        saveSortCheckPoint(tmpArray);
        recommedList = sortList(saveSortCheckPoint(tmpArray), recommedList);

        int min = Math.min(recommedList.size(), recommendNum);

        for (int i = 0; i < min; i++)
            result.add(recommedList.get(i));

        answer = result;

        friendsPoint_map.clear();

        return answer;
    }

    //특정 사람과 친구인 사람 구하기
    public static List<String> findUserFriends(String user, List<List<String>> friends_list) {
        List<String> userFriendsList = new ArrayList<>();
        String friends = "";

        for (int i = 0; i < friends_list.size(); i++) {
            if (user.equals(friends_list.get(i).get(firstFriend))) {
                if (!user.equals(userName) && userName.equals(friends_list.get(i).get(secondFriend)))
                    continue;
                userFriendsList.add(friends_list.get(i).get(secondFriend));
            }
            if (user.equals((friends_list.get(i).get(secondFriend)))) {
                if (!user.equals(userName) && userName.equals(friends_list.get(i).get(secondFriend)))
                    continue;
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

    //사용자와 친구인 친구의 목록을 구해서 점수를 주는 함수
    public static List<String> findFriendsOfFriend(List<String> userFriendsList, List<List<String>> friends_list) {
        List<String> friendOfFriendsList;

        //사용자와 친구인 친구의 목록
        friendOfFriendsList = findUserFriends(userFriendsList.get(0), friends_list);
        for (int i = 1; i < userFriendsList.size(); i++)
            friendOfFriendsList.addAll(findUserFriends(userFriendsList.get(i), friends_list));

        //사용자와 친구인 목록은 삭제
        removeDuplication(friendOfFriendsList,userFriendsList);

        return friendOfFriendsList;
    }
    public static List<String> removeDuplication(List<String> basicList, List<String> keywordList) {
        for (int i = 0; i < basicList.size(); i++) {
            //사용자의 친구가 리스트에 있을 경우
            for (int j = 0; j < keywordList.size(); j++) {
                if (basicList.get(i).equals(keywordList.get(j))) {
                    basicList.remove(i);
                    break;
                }
            }
        }

        return basicList;
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
    public static List<String> getKey(Integer[] valueList, Map<String, Integer> friendsPoint_map) {
        List<String> recommendFriendsList = new ArrayList<>();

        for (int i = 0; i < valueList.length; i++) {
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
        Integer [] intArray = values.toArray(new Integer[0]);

        Arrays.sort(intArray, Collections.reverseOrder());

        return intArray;
    }
    public static List<Integer> saveSortCheckPoint(Integer[] intArray) {
        int cnt;
        List<Integer> checkPointList = new ArrayList<>();

        for (int i = 0; i < intArray.length; i++)
        {
            cnt = i + 1;
            while (intArray[i] == intArray[cnt])
                cnt++;

            i = cnt;
            checkPointList.add(cnt);
        }

        return checkPointList;
    }
    public static List<String> sortList(List<Integer> checkPointList, List<String> recommendFriendsList) {
        int cnt = 0;
        // ArrayList를 배열로 변환
        int arrListSize = recommendFriendsList.size();
        String arr[] = recommendFriendsList.toArray(new String[arrListSize]);

        for (int i = 0; i < checkPointList.size(); i++) {
            cnt += i;

            int key = checkPointList.get(i);

            Arrays.sort(arr, cnt, key);
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
