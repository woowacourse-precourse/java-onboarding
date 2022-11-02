package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap<String, Integer> recommendMap = buildRecommendMap(user, friends, visitors);

        List<String> key = buildKey(recommendMap);

        return getAnswer(key);
    }

    public static List<String> getAnswer(List<String> key){

        int end = Math.min(key.size(), 5); // 추천 친구를 최대 5명으로 설정

        return key.subList(0, end);
    }

    public static List<String> buildKey(HashMap<String, Integer> recommendMap){
        List<String> key = new ArrayList<String>(recommendMap.keySet());

        keySort(key, recommendMap);

        return key;
    }

    public static void keySort(List<String> key, HashMap<String, Integer> recommendMap){
        key.sort(new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                int result = recommendMap.get(o2).compareTo(recommendMap.get(o1));
                if(result == 0){
                    result = o1.compareTo(o2);
                }
                return result;
            }
        }); // 추천 점수가 높은 순으로 아이디 정렬
    }

    public static HashMap<String, Integer> buildRecommendMap(String user, List<List<String>> friends, List<String> visitors){
        HashMap<String, Integer> recommendMap = new HashMap<String, Integer>();

        List<String> friendsOfUser = searchFriendsOfUser(user, friends);

        updateFriendScore(user, friendsOfUser, friends, recommendMap);
        updateTimelineScore(user, friendsOfUser, visitors, recommendMap);

        return recommendMap;
    }

    public static void updateTimelineScore(String user, List<String> friendsOfUser,
                                           List<String> visitors, HashMap<String, Integer> recommend){
        for(String visitor: visitors){
            if(friendsOfUser.contains(visitor) || user.equals(visitor)) continue;

            Integer prev = recommend.get(visitor);
            if(prev == null){
                prev = 0;
            }
            recommend.put(visitor, prev+1);
        } // 타임 라인 방문
    }

    public static void updateFriendScore(String user, List<String> friendsOfUser,
                                         List<List<String>> friends, HashMap<String, Integer> recommend){
        for(List<String> frd: friends){
            if(frd.contains(user)) continue;

            for(String frdUser: friendsOfUser){
                int frdIdx = frd.indexOf(frdUser);
                if(frdIdx != -1){
                    String nearby = frd.get(1-frdIdx);

                    Integer prev = recommend.get(nearby);

                    if(prev == null){
                        prev = 0;
                    }

                    recommend.put(nearby,prev+10);
                }
            }
        } // user와 함께 아는 친구
    }

    public static List<String> searchFriendsOfUser(String user, List<List<String>> friends){
        List<String> friendsOfUser = new ArrayList<String>();

        for(List<String> frd : friends){

            int userIdx = frd.indexOf(user);

            if(userIdx != -1){
                friendsOfUser.add(frd.get(1 - userIdx));
            }
        }
        return friendsOfUser;
    }// user의 친구 탐색
}
