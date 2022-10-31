package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 유저의 친구 목록 반환
        HashSet<String> userFriend = userFriend(user,friends);

        // 유저의 친구의 친구 목록 및 점수 반환
        HashMap friendScore = friendScore(user,friends,userFriend);

        // 유저 타임라인 방문자 및 점수 추가
        HashMap addVisitorScore = addVisitorScore(friendScore,visitors);

        // 최종 점수에서 이미 친구인 유저 삭제
        for (String friend : userFriend){
            if (friendScore.get(friend) != null){
                friendScore.remove(friend);
            }
        }

        // 최종 스코어 기준 정렬 및 반환
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(friendScore.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<String> answer = new ArrayList<String>();
        for(Map.Entry<String, Integer> entry : entryList){
            answer.add(entry.getKey().toString());
        }

        return answer;
    }



    //유저의 친구 목록 반환
    public static HashSet<String> userFriend(String user, List<List<String>>friends){
        HashSet<String> userFriends = new HashSet<String>();
        for(List<String> friend : friends){
            if(friend.get(0).equals(user)){
                userFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                userFriends.add(friend.get(0));
            }
        }
        System.out.println(userFriends);

        return userFriends;
    }

    // 유저 친구 목록 기반 친구의 친구 목록 및 점수 반환
    public static HashMap<String, Integer> friendScore(String user, List<List<String>>friends, HashSet<String> userFriends){

        HashMap<String,Integer> friendScore = new HashMap<>();
        for(String userFriend : userFriends){

            for(List<String>friend : friends){
                if (friend.get(0)==userFriend && friend.get(1) != user){
                    String friendOfFriend = friend.get(1);
                    if(friendScore.get(friendOfFriend) == null){
                        friendScore.put(friendOfFriend, 10);
                    }else{
                     int previousScore = friendScore.get(friendOfFriend);
                     friendScore.put(friendOfFriend,previousScore+10);
                    }
                }
            }
        }

        return friendScore;
    }

    // 유저 타임라인 방문자 목록 및 점수 반환
    public static HashMap<String, Integer> addVisitorScore(HashMap<String, Integer> friendScore, List<String>visitors){

        Set<String> friendSet = new HashSet<String>(visitors);
        for (String visitor : friendSet){
            int visitorScore = Collections.frequency(visitors,visitor);
            if(friendScore.get(visitor) == null){
                friendScore.put(visitor, visitorScore);
            } else {
                int previousScore = friendScore.get(visitor);
                friendScore.put(visitor, previousScore+visitorScore);
            }

        }

        return friendScore;
    }
}