package onboarding;

import java.util.*;

public class Problem7 {

    //<유저 : 친구목록>인 맵
    private static Map<String, HashSet<String>> friendMap = new HashMap<>();
    //<유저 : 점수>인 맵
    private static Map<String, Integer> scoreMap = new HashMap<>();
    // 내 이름
    private static String myName;
    // 이미 친구
    private static Set<String> userFriend;
    // 추천 명단
    private static List<String> answer = new LinkedList<>();

    //solution()
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        //class 내에서 정적 변수로 쓰기 위해서 초기화
        myName = user;
        //친구 관계 짓기
        setFriendMap(friends);
        //내친구 목록
        userFriend = friendMap.get(myName);
        //친구 관계로 인한 점수
        friendScore();
        //방문으로 인한 점수
        visitScore(visitors);
        //점수로 추천
        recommendFriend();
        return answer;
    }

    // 추천 친구
    private static void recommendFriend() {
        //점수를 키값으로 갖고 그 점수에 해당되는 유저를 리스트로 갖는 맵으로 변환
        HashMap<Integer, List<String>> scoreToUser = new HashMap<>();
        for (String user : scoreMap.keySet()) {
            int score = scoreMap.get(user);
            if (scoreToUser.containsKey(score)) {
                scoreToUser.get(score).add(user);
            } else {
                List<String> list = new ArrayList<>();
                list.add(user);
                scoreToUser.put(score, list);
            }
        }
        List<Integer> scoreList = new ArrayList<>(scoreToUser.keySet());
        scoreList.sort((o1, o2) -> o2.compareTo(o1));
        int idx = 0;
        loop : for (Integer score : scoreList) {
            List<String> users = scoreToUser.get(score);
            users.sort((o1, o2)-> o1.compareTo(o2));
            for (String user : users) {
                answer.add(user);
                idx++;
                if (idx == 5) break loop;
            }
        }
    }


    //친구 List를 읽는 메소드
    private static void setFriendMap(List<List<String>> friends) {
        String userA, userB;
        for (int i = 0; i < friends.size(); i++) {
            userA = friends.get(i).get(0);
            userB = friends.get(i).get(1);
            mappingFriend(userA, userB);
            mappingFriend(userB, userA);
        }
    }
    //두 사람을 친구로 맺어주는 메소드
    private static void mappingFriend(String userA, String userB) {
        if (friendMap.containsKey(userA)) {
            friendMap.get(userA).add(userB);
        } else {
            HashSet<String> set = new HashSet<>();
            set.add(userB);
            friendMap.put(userA, set);
        }
    }

    //친구 관계로 인한 점수
    private static void friendScore() {
        //친구의 친구 점수 추가
        for (String friend : userFriend) {
            // 친구의 친구들
            HashSet<String> friendFriends = friendMap.get(friend);
            for (String friendFriend : friendFriends) {
                addScore(friendFriend, 10);
            }
        }
    }

    //방문으로 인한 점수
    private static void visitScore(List<String> visitors) {
        //방문자 점수 추가
        for (String visitor : visitors) {
            addScore(visitor, 1);
        }
    }

    //점수를 주는 메소드
    private static void addScore(String user, int score){
        //이미 친구가 아니고, 자기자신이 아니라면 score 추가
        if (!userFriend.contains(user) && !user.equals(myName)) {
            scoreMap.put(user, scoreMap.getOrDefault(user, 0) + score);
        }
    }

}
