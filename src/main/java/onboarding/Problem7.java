package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // List<String> answer = Collections.emptyList();
        HashMap<String,ArrayList<String>> friendMap = getFriendMap(friends);
        HashMap<String, Integer> scoreMap = new HashMap<>();
        scoreMap = getFreindScore(user, friendMap, scoreMap);
        scoreMap = getVisitorScore(user, visitors, friendMap, scoreMap);
        return get5Score(scoreMap);
    }

    private static HashMap<String, ArrayList<String>> getFriendMap(List<List<String>> friends) {
        // friends를 HashMap에 저장한다
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for(int i = 0; i < friends.size(); i++){
            String id1 = friends.get(i).get(0);
            String id2 = friends.get(i).get(1);
            if(!hashMap.containsKey(id1)){
                ArrayList<String> list = new ArrayList<>();
                hashMap.put(id1, list);
            }
            if(!hashMap.containsKey(id2)){
                ArrayList<String> list = new ArrayList<>();
                hashMap.put(id2, list);
            }
            hashMap.get(id1).add(id2);
            hashMap.get(id2).add(id1);
        }
        return hashMap;
    }

    private static List<String> get5Score(HashMap<String, Integer> scoreMap) {
        List<String> keySet = new ArrayList<>(scoreMap.keySet());
        Collections.sort(keySet, (String s1, String s2) -> {
            if(scoreMap.get(s1).equals(scoreMap.get(s2))){
                return s1.compareTo(s2);
            }
            return scoreMap.get(s2) - scoreMap.get(s1);
        });
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < keySet.size() & i <= 5; i++){
            answer.add(keySet.get(i));
        }
        return answer;
    }

    private static HashMap<String, Integer> getVisitorScore(String user, List<String> visitors, HashMap<String, ArrayList<String>> hashMap, HashMap<String, Integer> scoreMap) {
        // (친구를 제외하여) 사용자의 타임 라인에 방문한 사람에게 1점씩 부여한다
        for(String friend: visitors){
            // user의 친구인 경우 제외
            if(!hashMap.get(user).contains(friend)){
                scoreMap.put(friend, scoreMap.getOrDefault(friend, 0) + 1);
            }
        }
        return scoreMap;
    }

    private static HashMap<String, Integer> getFreindScore(String user, HashMap<String, ArrayList<String>> hashMap, HashMap<String, Integer> scoreMap) {
        // 사용자와 함께 아는 친구에게 10점 부여한다
        for(String friend: hashMap.get(user)){
            for(String friendOf: hashMap.get(friend)){
                // user와 user의 친구인 경우 제외
                if(!friendOf.equals(user) & !hashMap.get(user).contains(friendOf)){
                    scoreMap.put(friendOf, scoreMap.getOrDefault(friendOf, 0) + 10);
                }
            }
        }
        return scoreMap;
    }
}
