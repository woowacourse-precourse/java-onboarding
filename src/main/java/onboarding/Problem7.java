package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> friendSet = new HashSet<>(); // 전체 친구들이 담긴 Set
        Map<String, Set<String>> friendMap = new HashMap<>();  // 친구목록
        Map<String, Integer> scoreMap = new HashMap<>(); // 점수 목록

        makeFriendSet(friends, friendSet);
        makeFriendMap(friends, friendSet, friendMap);
        makeScoreMap(visitors, friendSet, friendMap, scoreMap);
        // 사용자와 함께 하는 친구의 수마다 10점씩 추가
        addScores(user, friendSet, friendMap, scoreMap);

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(scoreMap.entrySet());

        entries.sort((o1, o2)->{
            if(o1.getValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey());
            return o2.getValue() - o1.getValue();
        });

        sortedByScores(user, answer, friendMap, entries);
        return answer;
    }

    /**
     * friendSet 초기화 : 기능 목록 1 */
    private static void makeFriendSet(List<List<String>> friends, Set<String> friendSet) {
        for (List<String> friend : friends) {
            friendSet.add(friend.get(0));
            friendSet.add(friend.get(1));
        }
    }

    /**
     * friendMap 초기화 : 기능 목록 1
     * * */
    private static void makeFriendMap(List<List<String>> friends, Set<String> friendSet, Map<String, Set<String>> friendMap) {
        for (List<String> friend : friends) {
            Set<String> temp1 = friendMap.getOrDefault(friend.get(0), new HashSet<>());
            Set<String> temp2 = friendMap.getOrDefault(friend.get(1), new HashSet<>());

            temp1.add(friend.get(1));
            temp2.add(friend.get(0));

            friendMap.put(friend.get(0), temp1);
            friendMap.put(friend.get(1), temp2);
        }
    }

    /**
     * scoreMap 초기화, 방문자는 1점씩 추가
     * */
    private static void makeScoreMap(List<String> visitors, Set<String> friendSet, Map<String, Set<String>> friendMap, Map<String, Integer> scoreMap) {
        // 점수 0으로 초기화
        for (String s : friendSet) {
            scoreMap.put(s,0);
        }
        for (String visitor : visitors){
            if(!friendSet.contains(visitor)){
                friendSet.add(visitor);  // 새로운 친구 추가
                friendMap.put(visitor, new HashSet<>());
            }
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0)+1);
        }
    }

    /**
     * 사용자와 함께 아는 친구마다 10점씩 추가 */
    private static void addScores(String user, Set<String> friendSet, Map<String, Set<String>> friendMap, Map<String, Integer> scoreMap) {
        for (String userFriend : friendMap.get(user)) {  // userFriend : 사용자의 친구
            for (String friend : friendSet) {
                if(friend.equals(user)) continue;
                for (String s1 : friendMap.get(friend)) {
                    if(s1.equals(userFriend)){
                        scoreMap.put(friend, scoreMap.getOrDefault(friend, 0)+10);
                    }
                }
            }
        }
    }

    private static void sortedByScores(String user, List<String> answer, Map<String, Set<String>> friendMap, ArrayList<Map.Entry<String, Integer>> entries) {
        for(int i = 0; i< entries.size(); i++){
            if(answer.size()==5) break;
            int flag = 0;
            String key = entries.get(i).getKey();
            if(key.equals(user)) continue;
            for (String s : friendMap.get(user)) {
                // user의 친구목록에 있는 사람이면 flag = 1
                if(key.equals(s)) flag = 1;
            }
            if(flag ==0) answer.add(key);
        }
    }

}
