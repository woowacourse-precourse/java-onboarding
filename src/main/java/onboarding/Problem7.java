package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    //입력된 userId와 친구인 사람 list 반환하는 함수
    public static List<String> getFriends(String userId, List<List<String>> friends){
        List<String> userFriend = new ArrayList<>();
        for(List<String> friend : friends){
            if(friend.get(0).equals(userId)) {
                userFriend.add(friend.get(1));
                continue;
            }
            if(friend.get(1).equals(userId)){
                userFriend.add(friend.get(0));
            }
        }

        return userFriend;
    }

    //추천리스트에 등록된 사람에 포함되었는지 확인하는 함수
    public static boolean isContained(String userId, HashMap<String,Integer> recommandList){
        if(recommandList.get(userId)!=null) return true;
        return false;
    }

    //추천리스트에 사람 추가
    public static HashMap<String,Integer> addRecommandList(String userId, int score, HashMap<String,Integer> recommandList){
        recommandList.put(userId, score);
        return recommandList;
    }

    //추천리스트에 있는 사람의 점수 추가
    public static HashMap<String,Integer> increaseScore(String userId, int score, HashMap<String,Integer> recommandList){
        int currentScore = recommandList.get(userId);
        int newScore = currentScore + score;
        recommandList.replace(userId,newScore);

        return recommandList;
    }

    //점수순으로 정렬하는 함수
    public static HashMap<String,Integer> sortByScore(HashMap<String,Integer> recommandList){
        List<String> keySet = new ArrayList<>(recommandList.keySet());
        HashMap<String,Integer> sortedByScoreList = new HashMap<>();
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return recommandList.get(o2).compareTo(recommandList.get(o1));
            }
        });

        for(String key : keySet){
            sortedByScoreList.put(key,recommandList.get(key));
        }

        return sortedByScoreList;
    }

    //점수가 같은 경우 이름을 기준으로 정렬하는 함수
    public static HashMap<String, Integer> sortByUserId(HashMap<String,Integer> recommandList){
        List<String> keySet = new ArrayList<>(recommandList.keySet());
        HashMap<String,Integer> sortedByUserIdList = new HashMap<>();
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int score1 = recommandList.get(o1);
                int score2 = recommandList.get(o2);
                if(score1==score2){
                    return o1.compareTo(o2);
                }
                return 0;
            }
        });

        for(String key : keySet){
            sortedByUserIdList.put(key,recommandList.get(key));
        }

        return sortedByUserIdList;
    }
}
