package onboarding;

import java.util.*;

public class Problem7 {
    // 모든 friends 목록 + 방문자 리스트를 탐색하면서 아이디를 담은 리스트 만들기 - (1)
    // -> 이걸 아예 사용자와 사용자의 친구를 뺀 리스트를 구현함
    // 사용자의 친구를 담는 리스트 만들기
    // 다른 사용자들의 친구를 담는 List<List<String>> 리스트 만들기
    // 사용자들의 점수를 매기는 리스트 만들기 (user와 다른 사람들 모두 이미 친구인 사람 인원수+방문자 수)

    // 점수를 기반으로 (1)-리스트를 다시 배열하기
    // 마지막에는 인덱스가 5를 넘어가면 잘라내기로 함, 추천 친구가 없으면 없는 채로 반환

    public static List<String> getFriend(List<List<String>> friends, String user, List<String> visitor, List<String> userFriends) {
        List<String> allId = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (!userFriends.contains(friends.get(i).get(j)) && !allId.contains(friends.get(i).get(j)) && !friends.get(i).contains(user)) {
                    allId.add(friends.get(i).get(j));
                }
            }
        }
        for (int i = 0; i < visitor.size(); i++) {
            for(int j = 0; j < friends.size(); j++) {
                if (!allId.contains(visitor.get(i)) && !friends.get(j).contains(user) && !userFriends.contains(visitor.get(i))) {
                    allId.add(visitor.get(i));
                }
            }
        }
        System.out.println(allId);
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
        System.out.println(userFriends);
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
        System.out.println(newFriends);
        return newFriends;
    }
    public static List<Integer> findFriendNumber(List<List<String>> newFriend, List<String> userFriend, List<String> allId, List<String> visitors) {
        List<Integer> userScore = new ArrayList<>();
        int[] accessUserScore = new int[allId.size()];
        for(int i = 0; i < newFriend.size(); i++) {
            for(int j = 0; j < newFriend.get(i).size(); j++) {
                if(accessUserScore[i] == 0) {//리스트 인덱스에 값을 넣는 경우가 처음일 때
                    userScore.add(10*Collections.frequency(userFriend, newFriend.get(i).get(j)));
                } else {
                    userScore.set(i, userScore.get(i)+10*Collections.frequency(userFriend, newFriend.get(i).get(j)));
                    //여기 수정을 바람..
                }
                accessUserScore[i]++;
            }
        }
        System.out.println(userScore);
        for(int i = 0; i < visitors.size(); i++) {
            for (int j = 0; j < allId.size(); j++) {
                if (userFriend.contains(visitors.get(i))) {
                    continue;
                }
                if (allId.get(j).equals(visitors.get(i))) {
                    if(userScore.size() <= j) {
                        userScore.add(j, 1);
                    } else {
                        userScore.set(j, userScore.get(j)+1);
                    }
                }
            }
        }
        System.out.println(userScore);
        return userScore;
    }

    public static List<String> setRecommendList(List<String> allId, List<Integer> userScore) {
        Map<String, Integer> idAndScore = new HashMap<>();
        List<String> recommendList = new ArrayList<>();
        for(int i = 0; i < allId.size(); i++) {
            if(userScore.get(i) > 0) {
                idAndScore.put(allId.get(i), userScore.get(i));
            }
        }

        for(int i = 0; i < allId.size(); i++){
            if(userScore.get(i) == 0){
                userScore.remove(i);
                allId.remove(i);
            }
        }

        for(int i = 0; i < allId.size(); i++){
            for(int j = 1; j < allId.size(); j++){
                if(userScore.get(j-1) < userScore.get(j)){
                    int tempScore = userScore.get(j-1);
                    userScore.set(j-1,userScore.get(j));
                    userScore.set(j,tempScore);

                    String temp = allId.get(j);
                    allId.set(j,allId.get(j-1));
                    allId.set(j-1, temp);
                }
            }
        }



//        userScore.sort(Collections.reverseOrder());
//        for(int i = 0; i < userScore.size(); i++) {
//            for(int j = 0; j < allId.size(); j++) {
//                if(userScore.get(i) == idAndScore.get(allId.get(j))) {
//                    if(Collections.frequency(allId, idAndScore.get(allId.get(j))) >= 2) {
//                        recommendList.add(allId.get(j));
//                    } else {
//                        recommendList.add(allId.get(j));
//                    }
//                }
//            }
//        }
        return allId;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriend = getUserFriend(friends, user); //사용자의 친구들 리스트
        List<String> allId = getFriend(friends, user, visitors, userFriend); //사용자 이외의 사용자들 아이디 리스트
        List<List<String>> friendsList = getNewFriend(allId, friends); //사용자이외 친구들의 친구 리스트
        List<Integer> userScore = findFriendNumber(friendsList, userFriend, allId, visitors);
        List<String> recommendList = setRecommendList(allId, userScore);
//        return List.of(new String[]{"friendCommon"});
        return recommendList;
    }
}
