package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        HashMap<String, Integer> friendScore = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            if(friends.get(i).get(0)==user){
                userFriends.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1)==user) {
                userFriends.add(friends.get(i).get(0));
            }
        }

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < userFriends.size(); j++) {
                if(friends.get(i).get(0) == userFriends.get(j)){
                    friendScore.put(friends.get(i).get(1), friendScore.getOrDefault(friends.get(i).get(1),0)+10 );
                }else if(friends.get(i).get(1)== userFriends.get(j)){
                    friendScore.put(friends.get(i).get(0), friendScore.getOrDefault(friends.get(i).get(0),0)+10 );
                }
            }
        }
        friendScore.remove(user); //user 지우기

        for (int i = 0; i < visitors.size(); i++) {
            friendScore.put(visitors.get(i), friendScore.getOrDefault(visitors.get(i), 0) + 1);
        }

        for (int i = 0; i < userFriends.size(); i++) { //이미 친구인 사람 지우기
            friendScore.remove(userFriends.get(i));
        }

        //크기순으로 정렬
        List<String> listKeySet = new ArrayList<>(friendScore.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (friendScore.get(value2).compareTo(friendScore.get(value1))));
        for(String key : listKeySet) {
            if(friendScore.get(key)!=0){
                answer.add(key);
            }
            if(answer.size() ==5){
                break;
            }

           // System.out.println("key : " + key + " , " + "value : " + friendScore.get(key));
        }







        return answer;
    }
}
