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

    static Map<String, Integer> friendsPointMap = new HashMap<>();

    static String userName;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> result = new ArrayList<>();
        Integer [] tmpArray;

        userName = user;

        //예외 확인
        checkException(friends, visitors);

        givePoint(user, visitors, friends);
        tmpArray = sortList();

        List<String> recommedList = getKey(sortList());
        saveSortCheckPoint(tmpArray);
        recommedList = sortList(saveSortCheckPoint(tmpArray), recommedList);

        int min = Math.min(recommedList.size(), recommendNum);

        for (int i = 0; i < min; i++)
            result.add(recommedList.get(i));

        answer = result;

        friendsPointMap.clear();

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
    public static List<String> saveVisitorList(List<String> visitors)
    {
        List<String> visitorsList = new ArrayList<>();

        for (int i = 0; i < visitors.size(); i++)
            visitorsList.add(visitors.get(i));

        return visitorsList;
    }
    public static void givePoint(String user, List<String> visitors, List<List<String>> friends_list)
    {
        List<String> userFriendsList;

        //사용자와 친구인 목록
        userFriendsList = findUserFriends(user, friends_list);

        //친구의 친구 목록을 구하고 점수를 구함
        saveUserPoint(findFriendsOfFriend(userFriendsList, friends_list), knowPoint);
        saveUserPoint(removeDuplication(saveVisitorList(visitors), userFriendsList), visitPoint);
    }
    //사용자와 친구인 친구의 목록을 구해서 점수를 주는 함수
    public static List<String> findFriendsOfFriend(List<String> userFriendsList, List<List<String>> friends_list)
    {
        List<String> friendOfFriendsList;

        //사용자와 친구인 친구의 목록
        friendOfFriendsList = findUserFriends(userFriendsList.get(0), friends_list);
        for (int i = 1; i < userFriendsList.size(); i++)
            friendOfFriendsList.addAll(findUserFriends(userFriendsList.get(i), friends_list));

        //사용자와 친구인 목록은 삭제
        removeDuplication(friendOfFriendsList,userFriendsList);

        return friendOfFriendsList;
    }
    public static List<String> removeDuplication(List<String> basicList, List<String> keywordList)
    {
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
    public static Map<String, Integer> saveUserPoint(List<String> userList, int point) {
        int tmp = point;
        String key = "";

        for (int i = 0; i < userList.size(); i++) {
            point = tmp;
            key = userList.get(i);

            if (friendsPointMap.containsKey(key))
                point = friendsPointMap.get(key) + point;

            friendsPointMap.put(key, point);
        }

        return friendsPointMap;
    }

    //value 로 key 찾기
    public static List<String> getKey(Integer[] valueList) {
        List<String> recommendFriendsList = new ArrayList<>();

        for (int i = 0; i < valueList.length; i++) {
            for (String key : friendsPointMap.keySet()) {
                if (valueList[i] == friendsPointMap.get(key)) {
                    if (recommendFriendsList.contains(key))
                        continue;
                    recommendFriendsList.add(key);
                    break;
                }
            }
        }

        return recommendFriendsList;
    }
    public static Integer[] sortList() {
        Collection <Integer> values = friendsPointMap.values();
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
    public static void checkException(List<List<String>> friends, List<String> visitors)
    {
        //null 체크
        checkNullException(friends, visitors);
        /*
        아이디 체크
         */
        //사용자 아이디
        checkUserNameException(userName);
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
    public static void checkNullException(List<List<String>> friends, List<String> visitors) {
        String errorMessage = "NULL ERROR";
        if (friends == null || visitors == null)
            throw new IllegalArgumentException(errorMessage);
        if (userName == null)
            throw new IllegalArgumentException(errorMessage);
    }
    //리스트 길이 체크
    public static void checkListException(int length) {
        if (length < 1 || length > 10000)
            throw new IllegalArgumentException("LIST ERROR");
    }

}
