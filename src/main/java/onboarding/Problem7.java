package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<List<String>> friendsList = new ArrayList<>(friends);
        List<String> userFriendsList = getUserFriendsList(user, friendsList);

        HashMap<String, Integer> userFriendScore = getUserFriendScore(userFriendsList, friendsList);
        HashMap<String, Integer> visitorScore = getVisitorScore(userFriendsList, visitors);

        // 추천 점수 합치기
        HashMap<String, Integer> score = mergeScore(userFriendScore, visitorScore);

        // 정렬
        List<String> recommendedList = sortScore(score);

        // 최대 5명만 return
        if (recommendedList.size() > 5) {
            recommendedList.subList(0, 5);
        }

        return recommendedList;
    }

    // 사용자의 친구 리스트를 반환하는 함수
    public static List<String> getUserFriendsList(String user, List<List<String>> friendsList){

        List<String> userFriendsList = new ArrayList<>();
        for(int i = 0; i< friendsList.size(); i++){
            List<String> friend = new ArrayList<>(friendsList.get(i));
            if (friend.contains(user)) {
                friendsList.remove(friend);
                friend.remove(user);
                userFriendsList.add(friend.get(0));
            }
        }

        return userFriendsList;
    }

    // 사용자와 함께 아는 친구가 있는 사람의 추천 점수를 계산하는 함수
    public static HashMap<String, Integer> getUserFriendScore(List<String> userFriendsList, List<List<String>> friendsList){
        HashMap<String, Integer> userFriendScore = new HashMap<>();

        for(String name: userFriendsList){
            for (List<String> friend : friendsList) {
                friend = new ArrayList<>(friend);
                if (friend.contains(name)) {
                    friend.remove(name);
                    if(userFriendScore.containsKey(friend.get(0))){
                        userFriendScore.replace(friend.get(0), userFriendScore.get(friend.get(0)) + 10);
                    }else{
                        userFriendScore.put(friend.get(0), 10);
                    }
                }
            }
        }
        return userFriendScore;
    }

    // 사용자의 타임 라인에 방문한 사람의 추천 점수를 계산하는 함수
    public static HashMap<String, Integer> getVisitorScore(List<String> userFriendsList, List<String> visitors){
        HashMap<String, Integer> visitorScore = new HashMap<>();

        for(String visitor: visitors){
            if(!userFriendsList.contains(visitor)){ // 사용자와 친구가 아닐 경우에만 계산
                if(visitorScore.containsKey(visitor)){
                    visitorScore.replace(visitor, visitorScore.get(visitor) + 1);
                }else {
                    visitorScore.put(visitor, 1);
                }
            }
        }
        return visitorScore;
    }

    // 두 개의 HashMap을 합쳐주는 함수
    public static HashMap<String, Integer> mergeScore(HashMap<String, Integer> score1, HashMap<String, Integer> score2){
        score2.forEach((key, value) -> score1.merge(key, value, (value1, value2) -> value1 + value2));
        return score1;
    }

    // HashMap을 정렬해주는 함수
    public static List<String> sortScore(HashMap<String, Integer> score){
        List<String> listKeySet = new ArrayList<>(score.keySet());
        listKeySet.sort(String::compareTo); // 이름 순으로 정렬
        listKeySet.sort((value1, value2) -> (score.get(value2).compareTo(score.get(value1)))); // 추천 점수가 높은 순으로 정렬

        return listKeySet;
    }



}
