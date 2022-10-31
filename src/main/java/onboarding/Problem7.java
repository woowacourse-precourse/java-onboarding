package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 기능 구현 목록
 * 1. user의 친구들 얻기
 * 2. user친구의 친구들 얻기.
 *  2.1 Key: user친구, Value: user친구의 친구들
 * 3. user친구의 친구들 순회 하면서 friendScore 합산
 *  3.1 단 user친구는 friendScore에 포함하지 않는다.
 * 4. visitors 순회 하면서 visitorScore 합산
 *  4.1 단 user친구는 visitorScore에 포함하지 않는다.
 * 5. friendScore, visitorScore 병합
 * 6. Score 내림차순 정렬 후 이름 오름차순 정렬
 *  6.1 최대 5명 return
 */
public class Problem7 {

    private static List<String> getFriends(String user, List<List<String>> friends){

        List<String> userFriends = new ArrayList<>();
        for(int i=0; i< friends.size(); i++){
            List<String> friend = friends.get(i);
            if (friend.get(0) == user){
                userFriends.add(friend.get(1));
            } else if (friend.get(1) == user) {
                userFriends.add(friend.get(0));
            }
        }

        return userFriends;
    }

    private static HashMap<String, List<String>> getFriendsOfFriends(String user, List<List<String>> friends, List<String> userFriends){

        HashMap<String, List<String>> userFriendsOfFriends = new HashMap<>();

        for (int i=0; i< friends.size(); i++){
            List<String> friend = friends.get(i);
            for (String userFriend : userFriends){
                if (friend.get(0) == userFriend && friend.get(1) != user){

                    if (userFriendsOfFriends.containsKey(userFriend)){
                        List<String> friendsOfFriends = userFriendsOfFriends.get(userFriend);
                        friendsOfFriends.add(friend.get(1));

                        userFriendsOfFriends.put(userFriend, friendsOfFriends);

                    }else{

                        List<String> friendsOfFriends = new ArrayList<>();
                        friendsOfFriends.add(friend.get(1));

                        userFriendsOfFriends.put(userFriend, friendsOfFriends);
                    }
                } else if (friend.get(1) == userFriend && friend.get(0) != user) {

                    if (userFriendsOfFriends.containsKey(userFriend)){

                        List<String> friendsOfFriends = userFriendsOfFriends.get(userFriend);
                        friendsOfFriends.add(friend.get(0));

                        userFriendsOfFriends.put(userFriend, friendsOfFriends);

                    }else{

                        List<String> friendsOfFriends = new ArrayList<>();
                        friendsOfFriends.add(friend.get(0));

                        userFriendsOfFriends.put(userFriend, friendsOfFriends);
                    }
                }
            }
        }

        return userFriendsOfFriends;
    }
    private static HashMap<String, Integer> getFriendsScore(List<String> userFriends, HashMap<String, List<String>> userFriendsOfFriends){

        HashMap<String, Integer> friendsScore = new HashMap<>();

        for(String friendKey : userFriendsOfFriends.keySet()){
            List<String> friendsOfFriends = userFriendsOfFriends.get(friendKey);

            for (String value : friendsOfFriends){

                if (!userFriends.contains(value)){

                    if (friendsScore.containsKey(value)){
                        int score = friendsScore.get(value);
                        score += 10;
                        friendsScore.put(value, score);

                    }else{
                        int score = 10;
                        friendsScore.put(value, score);
                    }
                }
            }
        }

        return friendsScore;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> userFriends = getFriends(user, friends);
        HashMap<String, List<String>> userFriendsOfFriends = getFriendsOfFriends(user, friends, userFriends);
        HashMap<String, Integer> friendsScore = getFriendsScore(userFriends, userFriendsOfFriends);
        
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
