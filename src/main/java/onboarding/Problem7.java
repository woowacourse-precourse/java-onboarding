package onboarding;


import java.util.*;
import java.util.Map.Entry;

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
    private static HashMap<String, Integer> getVisitorsScore(List<String> userFriends, List<String> visitors){

        HashMap<String, Integer> visitorsScore = new HashMap<>();

        for (String visitor : visitors){
            if (!userFriends.contains(visitor)){

                if (visitorsScore.containsKey(visitor)){
                    int score = visitorsScore.get(visitor);
                    score += 1;
                    visitorsScore.put(visitor, score);

                }else{
                    int score = 1;
                    visitorsScore.put(visitor, score);
                }
            }
        }

        return visitorsScore;
    }

    private static HashMap<String, Integer> sumScore(HashMap<String, Integer> friendsScore, HashMap<String, Integer> visitorsScore){
        HashMap<String, Integer> allScore = new HashMap<String, Integer>(friendsScore);
        for (String visitor : visitorsScore.keySet()) {
            if (allScore.containsKey(visitor)){
                int score = allScore.get(visitor);
                score += visitorsScore.get(visitor);

                allScore.put(visitor, score);
            }else {
                int score = visitorsScore.get(visitor);

                allScore.put(visitor,score);
            }
        }

        return allScore;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> userFriends = getFriends(user, friends);
        HashMap<String, List<String>> userFriendsOfFriends = getFriendsOfFriends(user, friends, userFriends);
        HashMap<String, Integer> friendsScore = getFriendsScore(userFriends, userFriendsOfFriends);
        HashMap<String, Integer> visitorsScore = getVisitorsScore(userFriends, visitors);
        HashMap<String, Integer> allScore = sumScore(friendsScore, visitorsScore);

        List<Entry<String,Integer>> entryList = new ArrayList<Entry<String,Integer>>(allScore.entrySet());
        Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                int comparision = o2.getValue().compareTo(o1.getValue());
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });

        List<String> answer = new ArrayList<>();
        int cnt = 1;
        for (Entry<String,Integer> entry : entryList){
            if (cnt <= 5){
                answer.add(entry.getKey());
                cnt += 1;
                continue;
            }
            break;
        }

        return answer;
    }
}
