package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    // 모든 friends 목록을 탐색하면서 아이디를 담은 리스트 만들기 - (1)
    // 사용자의 친구를 담는 리스트 만들기
    // 다른 사용자들의 친구를 담는 List<List<String>> 리스트 만들기
    // 사용자들의 점수를 매기는 리스트 만들기 (user와 다른 사람들 모두 이미 친구인 사람 인원수)
    // 점수를 기반으로 (1)-리스트를 다시 배열하기
    // 마지막에는 인덱스가 5를 넘어가면 잘라내기로 함, 추천 친구가 없으면 없는 채로 반환

    public static List<String> getFriend(List<List<String>> friends, String user) {
        List<String> allId = new ArrayList<>();
        for(int i = 0; i < friends.size(); i++) {
            for(int j = 0; j < 2; j++) {
                if(!friends.get(i).contains(user)) {
                    allId.add(friends.get(i).get(j));
                }
            }
        }
        return allId;
    }

    public static List<String> getUserFriend(List<List<String>> friends, String user) {
        List<String> userFriends = new ArrayList<>();
        for(int i = 0; i < friends.size(); i++) {
            for(int j = 0; j < 2; j++) {
                if(friends.get(i).contains(user) && !friends.get(i).get(j).equals(user)) {
                    userFriends.add(friends.get(i).get(j));
                }
            }
        }
        return userFriends;
    }

    public static List<List<String>> getNewFriend(List<String> allId, List<List<String>> friends) {
        List<List<String>> newFriends = new ArrayList<>();
        for(int k = 0; k < allId.size(); k++) {
            List<String> friendsList = new ArrayList<>();
            for(int i = 0; i < friends.size(); i++) {
                for(int j = 0; j < 2; j++) {
                    if(friends.get(i).contains(allId.get(k)) && !friends.get(i).get(j).equals(allId.get(k))) {
                        friendsList.add(friends.get(i).get(j));
                    }
                }
            }
            newFriends.add(friendsList);
        }
        return newFriends;
    }
    public static List<Integer> findFriendNumber(List<List<String>> newFriend, List<String> userFriend) {
        List<Integer> findCommonNumber = new ArrayList<>();
        for (List<String> strings : newFriend) {
            findCommonNumber.add(10*Collections.frequency(strings, userFriend));
        }

        return findCommonNumber;
    }

    public static List<Integer> findVisitNumber(List<String> visitors, List<Integer> findCommonNumber, List<String> allId) {
        List<Integer> userScore = new ArrayList<>();
        for(int i = 0; i < visitors.size(); i++) {
            for(int j = 0; j < allId.size(); j++) {
                if(allId.get(j).equals(visitors.get(i))) {
                    userScore.add(j, findCommonNumber.get(j)+1);
                }
            }
        }
        return userScore;
    }

    public static List<>
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> allId = getFriend(friends, user); //사용자 이외의 사용자들 아이디 리스트
        List<String> userFriend = getUserFriend(friends, user); //사용자의 친구들 리스트
        List<List<String>> friendsList = getNewFriend(allId, friends); //사용자이외 친구들의 친구 리스트
        List<Integer> findCommonNumber = findFriendNumber(friendsList, userFriend);
        List<Integer> userScore = findVisitNumber(visitors, findCommonNumber, allId);
        return friendCommon;
    }
}
