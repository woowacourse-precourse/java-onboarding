package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        /*
        친구 추천 알고리즘 구현
        사용자와 함께 아는 친구의 수 = 10점
        사용자의 타임 라인에 방문한 횟수 1점
        사용자의 아이디 user, 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitor가 매개변수로 주어질 때
        친구 추천 규칙에 따라 점수가 가장 높은순으로 정렬하여 최대 5명을 return 하도록 메서드 구현
        (이미 친구인 경우 친구 추천에 뜨지 않는다!!!!)
        단, 추천 점수가 0이면 추천하지 않으며 추천 점수가 같은 경우 이름순으로 정렬하여 return하기

        제한 조건
        user는 길이가 1이상 30 이하이다. 알파벳 소문자로만 이루어져 있다
        friends의 길이는 1이상 10000 이하인 리스트/배열이다
        friends의 각 원소는 길이가 2인 리스트/배열로 (아이디A, 아이디B) 순으로 들어오는데 A와 B는 친구라는 의미이다
        동일한 친구 관계가 중복해서 주어지지 않는다. 추천할 친구가 없는 경우는 주어지지 않는다.
        visitors는 길이가 0이상 10000이하인 리스트/배열이다
         */

        HashSet<String> users = makeUsers(user, friends, visitors);

        HashMap<String, HashSet<String>> friendsList = makeFriendList(users, friends);

        Map<String, Integer> recommendScoreMap = makeRecommendScore(user, users, friendsList);

        recommendScoreMap = calculateRecommendScore(user, visitors, recommendScoreMap, friendsList);

        List<Map.Entry<String, Integer>> recommendFriendsList = new ArrayList<>(recommendScoreMap.entrySet());
        Collections.sort(recommendFriendsList, (listUser1, listUser2) -> listUser2.getValue().compareTo(listUser1.getValue()));

        List<String> answer = new ArrayList<>();
        if (recommendFriendsList.size() <= 5) {
            for (int i = 0; i < recommendFriendsList.size(); i++) {
                answer.add(recommendFriendsList.get(i).getKey());
            }
        } else {
            for (int i = 0; i < 5; i++) {
                answer.add(recommendFriendsList.get(i).getKey());
            }
        }
        for (String s : answer) {
            System.out.println("s = " + s);
        }
        return answer;
    }

    private static HashSet<String> makeUsers(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> users = new HashSet<>();
        //문제에서 제시한 모든 사용자들 묶어주기
        users.add(user);
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                users.add(friends.get(i).get(j));
            }
        }
        for (int i = 0; i < visitors.size(); i++) {
            users.add(visitors.get(i));
        }
        return users;
    }

    private static HashMap<String, HashSet<String>> makeFriendList(HashSet<String> users, List<List<String>> friends) {
        HashMap<String, HashSet<String>> friendsList = new HashMap<>();
        //users를 기반으로 친구관계 파악 Map 만들기
        for (String user : users) {
            //Map 초기화
            friendsList.put(user, new HashSet<>());
        }
        for (String s : friendsList.keySet()) {
            HashSet<String> friend = new HashSet<>();
            for (int i = 0; i < friends.size(); i++) {
                for (int j = 0; j < 2; j++) {
                    if (friends.get(i).get(0) == s) {
                        friend.add(friends.get(i).get(1));
                        friendsList.put(s, friend);
                    } else if (friends.get(i).get(1) == s) {
                        friend.add(friends.get(i).get(0));
                        friendsList.put(s, friend);
                    }
                }
            }
        }
        return friendsList;
    }

    private static Map<String, Integer> makeRecommendScore(String user, HashSet<String> users, HashMap<String, HashSet<String>> friendsList) {
        //TreeMap으로 만들어서 recommendScore에 friendsList를 넣을 때 알파벳 순서로 정렬하기
        Map<String, Integer> recommendScoreMap = new TreeMap<>();
        for (String s : users) {
            recommendScoreMap.put(s, 0);
        }

        //이미 user와 친구인 사용자는 recommendScoreMap에서 제외
        List<String> removeKey = new ArrayList<>(recommendScoreMap.keySet());
        for (String s : removeKey) {
            if (friendsList.get(user).contains(s)) {
                recommendScoreMap.remove(s);
            }
        }
        recommendScoreMap.remove(user);
        return recommendScoreMap;
    }

    private static Map<String, Integer> calculateRecommendScore(String user, List<String> visitors, Map<String, Integer> recommendScore, HashMap<String, HashSet<String>> friendsList) {

        for (String recommendFriend : recommendScore.keySet()) {
            //user와 공통으로 아는 친구가 있다면 +10점
            for (String userFriend : friendsList.get(user)) {
                if (friendsList.get(recommendFriend).contains(userFriend)) {
                    recommendScore.put(recommendFriend, recommendScore.get(recommendFriend) + 10);
                }
            }
            // 방문 횟수에 따른 추천 친구 점수 +1
            for (String visitor : visitors) {
                if (recommendFriend.equals(visitor)) {
                    recommendScore.put(recommendFriend, recommendScore.get(recommendFriend) + 1);
                }
            }
        }

        // 점수 계산 후 추천 점수가 0인 user 제거
        for (String s : recommendScore.keySet()) {
            if (recommendScore.get(s) == 0) {
                recommendScore.remove(s);
            }
        }
        return recommendScore;
    }

    public static List<String> solution2(String user, List<List<String>> friends, List<String> visitors) {

        //문제에 나오는 모든 crew를 리스트로 만들기
        HashSet<String> crewList = makeCrewList(user, friends, visitors);

        // user의 친구 리스트 만들기
        ArrayList<String> userFriendList = makeUserFriendsList(user, friends);

        // 추천 친구 목록 Map 만들기 (추천 crew, 추천 점수)
        Map<String, Integer> recommendFriendsMap = makeRecommendFriendsMap(user, crewList, userFriendList);

        // 추천 crew 점수계산 메서드
        recommendFriendsMap = makeRecommendFriendScore(friends, visitors, recommendFriendsMap, userFriendList);

        // 추천 친구 리스트 만들기 (정렬)
        List<Map.Entry<String, Integer>> recommendFriendsList = new ArrayList<>(recommendFriendsMap.entrySet());
        Collections.sort(recommendFriendsList, (listUser1, listUser2) -> listUser2.getValue().compareTo(listUser1.getValue()));

        //최대 5명을 조회할 수 있도록 제한 걸어주기
        List<String> answer = new ArrayList<>();
        if (recommendFriendsList.size() <= 5) {
            for (int i = 0; i < recommendFriendsList.size(); i++) {
                answer.add(recommendFriendsList.get(i).getKey());
            }
        } else {
            for (int i = 0; i < 5; i++) {
                answer.add(recommendFriendsList.get(i).getKey());
            }
        }
        return answer;
    }

    private static HashSet<String> makeCrewList(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> crewList = new HashSet<>();
        crewList.add(user);
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                crewList.add(friends.get(i).get(j));
            }
        }
        for (int i = 0; i < visitors.size(); i++) {
            crewList.add(visitors.get(i));
        }
        return crewList;
    }

    private static ArrayList<String> makeUserFriendsList(String user, List<List<String>> friends) {
        ArrayList<String> userFriendsList = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                userFriendsList.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1).equals(user)) {
                userFriendsList.add(friends.get(i).get(0));
            }
        }
        return userFriendsList;
    }

    private static TreeMap<String, Integer> makeRecommendFriendsMap(String user, HashSet<String> crewList, ArrayList<String> userFriendList) {
        TreeMap<String, Integer> recommendFriendList = new TreeMap<>();
        for (String crew : crewList) {
            recommendFriendList.put(crew, 0);
            for (String userFriend : userFriendList) {
                if (crew.equals(userFriend)) {
                    recommendFriendList.remove(crew);
                }
            }
        }
        recommendFriendList.remove(user);
        return recommendFriendList;
    }

    private static Map<String, Integer> makeRecommendFriendScore(List<List<String>> friends, List<String> visitors, Map<String, Integer> recommendFriendsList, ArrayList<String> userFriendList) {
        for (String recommendFriend : recommendFriendsList.keySet()) {
            for (int i = 0; i < friends.size(); i++) {
                if (friends.get(i).get(0) == recommendFriend && userFriendList.contains(friends.get(i).get(1))) {
                    recommendFriendsList.put(recommendFriend, recommendFriendsList.get(recommendFriend) + 10);
                } else if (friends.get(i).get(1) == recommendFriend && userFriendList.contains(friends.get(i).get(0))) {
                    recommendFriendsList.put(recommendFriend, recommendFriendsList.get(recommendFriend) + 10);
                }
            }
            for (int i = 0; i < visitors.size(); i++) {
                if (visitors.get(i).equals(recommendFriend)) {
                    recommendFriendsList.put(recommendFriend, recommendFriendsList.get(recommendFriend) + 1);
                }
            }
        }
        for (String recommendFriend : recommendFriendsList.keySet()) {
            if(recommendFriendsList.get(recommendFriend)==0){
                recommendFriendsList.remove(recommendFriend);
            }
        }
        return recommendFriendsList;
    }


    public static void main(String[] args) {
        Problem7 problem7 = new Problem7();
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        problem7.solution2(user, friends, visitors);
    }

}

