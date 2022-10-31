package onboarding;

import java.util.*;

public class Problem7 {

    private static final List<String> USER_FRIEND = new ArrayList<>();
    private static final Map<String,Integer> TABLE = new HashMap();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // 사용자와 함께 아는 친구의 수 알고리즘 고려
        calculateSameFriendScore(user, friends);
        // 사용자의 타임 라인에 방문한 횟수 알고리즘 고려
        calculateVisitScore(visitors);
        // 친구 추천 목록 반환
        getAnswer(answer,getSortedList(), user);


        return answer;
    }

    private static void calculateSameFriendScore(String user, List<List<String>> friends) {

        // user의 친구를 user_friend 리스트에 저장
        setUserFriends(user, friends);


        for (String name:USER_FRIEND){
            for (List<String> friend_set : friends) {
                if (isPersonForSameFriendScore(user, name, friend_set)) addScore(name_of_friend(friend_set,name));
            }
        }

    }

    private static void addScore(String person) {

        if (nameIsAlreadyInTABLE(person)) TABLE.replace(person, TABLE.get(person) + 10);
        if (!nameIsAlreadyInTABLE(person)) TABLE.put(person, 10);
    }

    private static boolean nameIsAlreadyInTABLE(String person) {
        return TABLE.containsKey(person);
    }

    private static boolean isPersonForSameFriendScore(String user, String name, List<String> friend_set) {
        return friend_set.contains(name) && !(name_of_friend(friend_set, name).equals(user));
    }

    private static void setUserFriends(String user, List<List<String>> friends) {
        for (List<String> friend_set : friends) {
            if (friend_set.contains(user)) USER_FRIEND.add(name_of_friend(friend_set, user));
        }
    }


    private static void calculateVisitScore(List<String> visitors) {
        for (String name: visitors){
            if (nameIsAlreadyInTABLE(name)) TABLE.replace(name, TABLE.get(name)+1);
            if (!nameIsAlreadyInTABLE(name)) TABLE.put(name,1);
        }
    }

    private static List<String> getSortedList() {
        List<String> list = new ArrayList<>(TABLE.keySet());
        list.sort((s1,s2)-> TABLE.get(s2)- TABLE.get(s1));
        // 정렬
        return list;
    }

    private static void getAnswer(List<String> answer, List<String> list, String user) {
        int count = 0;
        for (String key: list){
            if (count==5) break;
            if (key.equals(user) || USER_FRIEND.contains(key)) continue;
            answer.add(key);
            count++;
        }
    }
    private static String name_of_friend (List<String> friend_set, String user) {
        if (friend_set.indexOf(user)==0) return friend_set.get(1);
        if (friend_set.indexOf(user)==1) return friend_set.get(0);
        return "";
    }
}
