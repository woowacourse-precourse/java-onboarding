package onboarding;

import java.util.*;

public class Problem7 {
    // 모든 friends 목록 + 방문자 리스트를 탐색하면서 아이디를 담은 리스트 만들기 - (1)
    // -> 이걸 아예 사용자와 사용자의 친구를 뺀 리스트를 구현함
    // -> 그리고 알파벳 순으로 정렬!
    // 사용자의 친구를 담는 리스트 만들기
    // 다른 사용자들의 친구를 담는 List<List<String>> 리스트 만들기
    // -> (1)리스트에 담긴 사용자만의 친구들을 리스트로 담음
    // 사용자들의 점수를 매기는 리스트 만들기 (user와 다른 사람들 모두 이미 친구인 사람 인원수+방문자 수)
    // -> (1)리스트에 담긴 사용자만의 점수를 매김
    // 점수를 기반으로 (1)-리스트를 다시 배열하기 (퀵소트를 오름차순으로 배열함)
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
        Collections.sort(allId);
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
    public static List<Integer> findFriendNumber(List<List<String>> newFriend, List<String> userFriend, List<String> allId, List<String> visitors) {
        List<Integer> userScore = new ArrayList<>();
        int[] accessUserScore = new int[allId.size()];
        for(int i = 0; i < newFriend.size(); i++) {
            if(newFriend.get(i).size() != 0) {
                for(int j = 0; j < newFriend.get(i).size(); j++) {
                    if(accessUserScore[i] == 0) {//리스트 인덱스에 값을 넣는 경우가 처음일 때
                        userScore.add(10*Collections.frequency(userFriend, newFriend.get(i).get(j)));
                    } else {
                        userScore.set(i, userScore.get(i)+10*Collections.frequency(userFriend, newFriend.get(i).get(j)));
                    }
                    accessUserScore[i]++;
                }
            } else {
                userScore.add(i, 0);
            }
        }
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
        return userScore;
    }

    public static void quickSort(List<String> allId, List<Integer> userScore, int start, int end) {
        if(start < end) {
            int pivot = start;
            int left = start + 1;
            int right = end;

            while(left <= right) {
                while(left <= end && userScore.get(left) >= userScore.get(pivot)) { //start+1값 >= 시작 값, 그대로 순항
                    left += 1;
                }
                while(right > start && userScore.get(right) <= userScore.get(pivot)) { // 끝값 <= 시작값, 그대로 순항
                    right -= 1;
                }
                if(left > right) { // 마지막에 중간에서 만난 left와 right가 서로 값이 바뀔 때
                    int temp1 = userScore.get(right);
                    userScore.set(right, userScore.get(pivot));
                    userScore.set(pivot, temp1);
                    String temp2 = allId.get(right);
                    allId.set(right, allId.get(pivot));
                    allId.set(pivot, temp2);

                } else {
                    int temp = userScore.get(right);
                    userScore.set(right, userScore.get(left));
                    userScore.set(left, temp);
                    String temp2 = allId.get(right);
                    allId.set(right, allId.get(left));
                    allId.set(pivot, temp2);
                }
                quickSort(allId, userScore, start, right -1);
                quickSort(allId, userScore, right +1, end);
            }
        }
    }

    public static List<String> setRecommendList(List<String> allId, List<Integer> userScore) {
        List<String> recommendList = new ArrayList<>();
        quickSort(allId, userScore, 0, allId.size()-1);
        return allId;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriend = getUserFriend(friends, user); //사용자의 친구들 리스트
        List<String> allId = getFriend(friends, user, visitors, userFriend); //사용자 이외의 사용자들 아이디 리스트
        List<List<String>> friendsList = getNewFriend(allId, friends); //사용자이외 친구들의 친구 리스트
        List<Integer> userScore = findFriendNumber(friendsList, userFriend, allId, visitors);
        List<String> recommendList = setRecommendList(allId, userScore);

        return recommendList;
    }
}
