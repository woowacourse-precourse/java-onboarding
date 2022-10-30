package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String,Integer> score=addScoreFriends(friends,user,visitors);
        List<String> answer =orderFriends(score);
        return answer;
    }

    /*
    사용자 제외 모든 유저별로 점수 초기화 하기
     */
    private static Map<String,Integer> initScore(List<List<String>> friends, String user, List<String> visitors){
        Map<String,Integer> map=new HashMap<>();
        for(List<String> friend:friends){
            if(!map.containsKey(friend.get(0))&&!user.equals(friend.get(0))){
                map.put(friend.get(0),0);
            }
            if(!map.containsKey(friend.get(1))&&!user.equals(friend.get(1))){
                map.put(friend.get(1),0);
            }
        }
        for(String visitor:visitors){
            if(!map.containsKey(visitor)){
                map.put(visitor,0);
            }
        }
        return map;
    }

    /*
    사용자의 직접적인 친구 구하기
     */
    private static List<String> getUserFriends(List<List<String>> friends,String user){
        List<String> userFriends=new ArrayList<>();
        for(List<String> friend:friends){
            if(friend.get(0).equals(user)&&!userFriends.contains(friend.get(1))){
                userFriends.add(friend.get(1));
            }
            if(friend.get(1).equals(user)&&!userFriends.contains(friend.get(0))){
                userFriends.add(friend.get(0));
            }
        }
        return userFriends;
    }

    /*
    사용자 추천시스템에 따라 점수 더하기
     */
    private static Map<String,Integer> addScoreFriends(List<List<String>> friends,String user,List<String> visitors){
        Map<String,Integer> score=initScore(friends,user,visitors);
        List<String> userFriends=getUserFriends(friends,user);
        //사용자의 친구의 친구 점수 더하기
        for(String friend:userFriends){
            for(List<String> scorefriend:friends){
                if(friend.equals(scorefriend.get(0))&&score.containsKey(scorefriend.get(1))){
                    score.put(scorefriend.get(1), score.get(scorefriend.get(1)) +10);
                }
                if(friend.equals(scorefriend.get(1))&&score.containsKey(scorefriend.get(0))){
                    score.put(scorefriend.get(0), score.get(scorefriend.get(1)) +10);
                }
            }
        }
        //방문자 점수 더하기
        for(String visitor:visitors){
            if(score.containsKey(visitor)) {
                score.put(visitor, score.get(visitor) + 1);
            }
        }

        //user 친구 제거하기
        for(String friend:userFriends){
            score.remove(friend);
        }

        return score;
    }

    /*
    정렬 조건에 따라 정렬하기
     */
    private static List<String> orderFriends(Map<String,Integer> map){
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() < o2.getValue()) return 1;
                else if (o1.getValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey());
                else return -1;
            }
        });
        List<String> answer=new ArrayList<>();
        int size=0;
        for(Map.Entry<String,Integer> li:list){
            answer.add(li.getKey());
            size++;
            if(size==5){
                break;
            }
        }
        return answer;
    }

}
