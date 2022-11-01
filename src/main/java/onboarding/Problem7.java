package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    private static HashMap<String, List<String>> getfriendGraph(List<List<String>> friends){
        // 모든 friends 목록 해시맵 생성 (양방향 그래프)
        HashMap<String, List<String>> friendGraph = new HashMap<>();

        for (List<String> f : friends){
            if (!friendGraph.containsKey(f.get(0))){
                friendGraph.put(f.get(0), new ArrayList<>());
                friendGraph.get(f.get(0)).add(f.get(1));
            }else {
                friendGraph.get(f.get(0)).add(f.get(1));
            }

            if (!friendGraph.containsKey(f.get(1))){
                friendGraph.put(f.get(1), new ArrayList<>());
                friendGraph.get(f.get(1)).add(f.get(0));
            }else {
                friendGraph.get(f.get(1)).add(f.get(0));
            }
        }

        return friendGraph;
    }
    private static HashMap<String, Integer> getScoreBoard(String user, List<List<String>> friends, List<String> userFriend, List<String> visitors){
        // 모든 friends,visitors 목록 해시맵 생성 (key:이름/value:점수)
        // 이때 이미 친구인 경우는 거름
        HashMap<String, Integer> scoreBoard = new HashMap<>();

        for (List<String> f : friends){
            if (!(f.get(0).equals(user)) && scoreBoard.get(f.get(0)) == null && !(userFriend.contains(f.get(0)))){
                scoreBoard.put(f.get(0), 0);
            }

            if (!(f.get(1).equals(user)) && scoreBoard.get(f.get(1)) == null && !(userFriend.contains(f.get(1)))){
                scoreBoard.put(f.get(1), 0);
            }
        }

        for (String v : visitors){
            if (scoreBoard.get(v) == null && !(userFriend.contains(v))){
                scoreBoard.put(v, 0);
            }
        }

        return scoreBoard;
    }

    private static HashMap<String, Integer> getScoreBoardResult(HashMap<String, Integer> scoreBoard, HashMap<String, List<String>> friendGraph, List<String> userFriend, List<String> visitors){
        // 한다리 건너 친구는 +10
        for (String uf : userFriend){
            for (String k : friendGraph.get(uf)){
                if (scoreBoard.containsKey(k)){
                    scoreBoard.put(k, scoreBoard.get(k)+10);
                }
            }
        }

        // visit한 친구는 방문 횟수당 +1
        for (String v : visitors){
            if (scoreBoard.containsKey(v)) {
                scoreBoard.put(v, scoreBoard.get(v) + 1);
            }
        }

        return scoreBoard;
    }

    private static List<String> getRecommendFriend(HashMap<String, Integer> scoreBoardResult){
        List<String> recommendFriend = new ArrayList<>();

        // value 기준 정렬
        List<String> keySetList = new ArrayList<>(scoreBoardResult.keySet());
        Collections.sort(keySetList, (o1, o2) -> (scoreBoardResult.get(o2).compareTo(scoreBoardResult.get(o1))));

        int cnt = 0;
        for (String key : scoreBoardResult.keySet()){
            cnt += 1;
            if (cnt >= 6){
                break;
            }
            if (scoreBoardResult.get(key)>0){
                recommendFriend.add(key);
            }else{
                break;
            }
        }

        return recommendFriend;
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 모든 friends 목록 해시맵 생성 (양방향 그래프)
        HashMap<String, List<String>> friendGraph = getfriendGraph(friends);

        // user의 직접 친구들 목록
        List<String> userFriend = friendGraph.get(user);

        // 모든 friends,visitors 목록 해시맵 생성 (key:이름/value:점수)
        // 이때 이미 친구인 경우는 거름
        HashMap<String, Integer> scoreBoard = getScoreBoard(user, friends, userFriend, visitors);

        // 한다리 건너 친구는 +10
        // visit한 친구는 방문 횟수당 +1
        HashMap<String, Integer> scoreBoardResult = getScoreBoardResult(scoreBoard, friendGraph, userFriend, visitors);

        // 점수 높은순으로 최대 5명 return
        // 점수 0점이면 return 안함
        // 같은 점수면 이름 기준 sort
        List<String> answer = getRecommendFriend(scoreBoardResult);

        return answer;
    }
}
