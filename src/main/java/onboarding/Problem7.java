package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<List<String>> friendsList = new ArrayList<>(friends);
        List<String> userFriendsList = getUserFriendsList(user, friendsList);

        HashMap<String, Integer> userFriendScore = getUserFriendScore(userFriendsList, friendsList);

        List<String> answer = Collections.emptyList();
        return answer;
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

}
