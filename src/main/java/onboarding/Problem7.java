package onboarding;

import java.util.*;
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        
        return answer;
    }
    public static List<String> commendList(String user, List<List<String>> friends, List<String> visitors){
        Set<String> totalFriends = new HashSet<>();     // 친구 추천 목록

        for(int i=0; i< friends.size();i++) {
            for(int j =0; j<friends.get(0).size(); j++) {
                totalFriends.add(friends.get(i).get(j));        // friends에 있는 목록
            }
        }
        for(int i=0; i<visitors.size();i++) {
            totalFriends.add(visitors.get(i));                  // visitors 목록
        }

        for(int i=0; i< friends.size();i++) {
            for(int j=0; j<friends.get(i).size(); j++) {
                totalFriends.add(friends.get(i).get(j));        // 친구추천 목록 추가
            }

            if (friends.get(i).get(0).equals(user)) {
                totalFriends.remove(friends.get(i).get(1));         // 친구는 친구추천 목록에서 제거

            }else if (friends.get(i).get(1).equals(user)) {
                totalFriends.remove(friends.get(i).get(0));

            }
        }
        totalFriends.remove(user);      // 자신도 친구추천 목록에서 제거
        List<String> totalList = new ArrayList<>(totalFriends);
        return totalList;
    }
    // 추천친구 목록, 점수 Map 생성 메서드
    public Map<String,Integer> friendsAndScore(String user, List<List<String>> friends, List<String> visitors){
        List<String> totalList = commendList(user,friends,visitors);        // 친구추천 리스트
        Map<String,Integer> scoreMap = new HashMap<>();  // 추천친구 목록, 점수 MAP

        for(int i=0; i< totalList.size(); i++) {
            scoreMap.put(totalList.get(i),0);
        }
        // 친구목록에서 10점씩
        for(int i=0; i< friends.size(); i++) {
            for(int j=0; j<friends.get(j).size(); j++) {
                if (scoreMap.containsKey(friends.get(i).get(j))){
                    scoreMap.replace(friends.get(i).get(j), scoreMap.get(friends.get(i).get(j))+10); // 친구당 10점 추가
                }
            }
        }
        // 방문자에서 1점씩
        for(int i=0; i<visitors.size();i++) {
            if(scoreMap.containsKey(visitors.get(i))) {
                scoreMap.replace(visitors.get(i), scoreMap.get(visitors.get(i))+1); // 친구당 10점 추가
            }
        }
        return scoreMap;

    }
}
