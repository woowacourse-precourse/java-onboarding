package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class Problem7 {
    //user의 친구 찾기
    public static List<String> findFriendsOfUser (List<List<String>> friends, String user) {
        List<String> friendsOfUser = new ArrayList<String>();

        for(List<String> person : friends) { //user와 친구이면 add
            if(person.get(0) == user) {
                friendsOfUser.add(person.get(1));
            }
            else if(person.get(1) == user) {
                friendsOfUser.add(person.get(0));
            }
        }
        return friendsOfUser;
    }

    //score에 점수 추가
    public static void addScore (Map<String, Integer> score, String name, final int POINT){
        if(!score.containsKey(name)) { //저장된 이름(key)이 없으면
            score.put(name, POINT);
        }
        else { //저장된 이름이 있으면
            score.put(name, score.get(name) + POINT);
        }
    }

    //친구의 친구이면 +10점
    public static void giveScoreToFriendOfFriend (Map<String, Integer> score, String user, List<List<String>> friends, List<String> friendsOfUser) {
        final int POINT = 10;

        for(String friendName : friendsOfUser) {
            for(List<String> person : friends) {
                if(friendName == person.get(0)) { //friends의 첫번째 원소가 친구인 경우
                    addScore(score, person.get(1), POINT);
                }
                else if(friendName == person.get(1)) { //friends의 두번째 원소가 친구인 경우
                    addScore(score, person.get(0), POINT);
                }
            }
        }
    }

    //방문객이면 +1점
    public static void giveScoreToVisitor(Map<String, Integer> score, List<String> visitors) {
        final int POINT = 1;
        for(String person : visitors) {
            addScore(score, person, POINT);
        }
    }

    //유효하지 않은 정보 제거하기
    public static void removeMeAndFriend(Map<String, Integer> score, List<String> friendsOfUser, String user){
        for(String person : friendsOfUser) {
            if(score.containsKey(person)) { //user의 친구 삭제
                score.remove(person);
            }
        }
        if(score.containsKey(user)) { //user 삭제
            score.remove(user);
        }
    }

    // 정렬 : 1순위 - 점수(내림차순), 2순위 - 이름(사전순)
    public static List<Entry<String, Integer>> sortScore(Map<String, Integer> score) {
        List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(score.entrySet());

        Collections.sort(entryList, (obj1, obj2) -> {
            if(obj1.getValue() == obj2.getValue()) {
                return obj1.getKey().compareTo(obj2.getKey()); //2순위
            }
            return obj2.getValue().compareTo(obj1.getValue()); //1순위
        });
        return entryList;
    }

    //추천 5명 가져오기
    public static List<String> getFiveResult (List<Entry<String, Integer>> entryList){
        List<String> result = new ArrayList<String>();
        final int MAX_NUM = 5;

        for(int i = 0; i< entryList.size(); i++) {
            if(i == MAX_NUM) {
                break;
            }
            result.add(entryList.get(i).getKey());
        }
        return result;
    }

    //솔루션 메소드
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Integer> score = new HashMap<>(); //score의 key:이름, value:점수
        List<Entry<String, Integer>> entryList;

        List<String> friendsOfUser = findFriendsOfUser(friends, user); //user의 친구 찾기

        giveScoreToFriendOfFriend(score, user, friends, friendsOfUser); //친구의 친구 점수 추가
        giveScoreToVisitor(score, visitors); //방분객 점수 추가

        removeMeAndFriend(score, friendsOfUser, user); //유효하지 않은 정보 제거
        entryList = sortScore(score); //정렬
        answer = getFiveResult(entryList); //추천 5명 가져오기

        return answer;
    }
}
