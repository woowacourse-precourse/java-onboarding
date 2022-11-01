package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> friendsScore = new HashMap<>();

        // user의 제한사항 검사
        if (!isValidUser(user)) {
            answer.add("[Error] user의 제한사항 만족하지 않음");
            return answer;
        }
        // friends의 제한사항 검사
        if (!isValidFriends(friends)) {
            answer.add("[Error] frends의 제한사항 만족하지 않음");
            return answer;
        }
        // visitos의 제한사항 검사
        if (!isValidVisitors(visitors)) {
            answer.add("[Error] vistors의 제한사랑 만족하지 않음");
            return answer;
        }
        // user의 친구
        List<String> userFriends = new ArrayList<>(isMyFriends(user, friends));
        // user의 친구의 친구
        List<String> knownFriends = new ArrayList<>(knownFriends(user, userFriends, friends));

        // user와 함께 아는 친구
        for (String knownFriend : knownFriends) {
            if (!friendsScore.containsKey(knownFriend)) {
                friendsScore.put(knownFriend, 10);
            } else friendsScore.put(knownFriend, friendsScore.get(knownFriend) + 10);
        }
        // user의 타임 라인에 방문한 횟수
        for (String visitor : visitors) {
            if (!friendsScore.containsKey(visitor) && !userFriends.contains(visitor)) {
                friendsScore.put(visitor, 1);
            } else if (friendsScore.containsKey(visitor) && !userFriends.contains(visitor)) {
                friendsScore.put(visitor, friendsScore.get(visitor) + 1);
            }
        }
        // map의 value 값을 내림차순으로 정렬
        List<String> ab = new ArrayList<>(friendsScore.keySet());
        Collections.sort(ab, (value1, value2) -> (friendsScore.get(value2).compareTo(friendsScore.get(value1))));

        for (String f : ab) {
            answer.add(f);
        }

        return answer;
    }

    // user의 제한사항
    public static boolean isValidUser(String user) {
        // user의 길이 제한
        if (user.length() < 1 || user.length() > 30) {
            return false;
        }
        // 소문자로만 구성
        return user.matches("^[a-z]*$");
    }

    // friends의 제한사항
    public static boolean isValidFriends(List<List<String>> friends) {
        // friends의 길이 제한
        if (friends.size() < 1 || friends.size() > 10000) {
            return false;
        }
        // friends의 원소 제한
        for (List<String> friend : friends) {
            if (friend.size() != 2) {
                return false;
            }
        }

        return true;
    }

    // visitors의 제한사항
    public static boolean isValidVisitors(List<String> visitors) {
        return visitors.size() <= 30;
    }

    // user의 친구 구하는 메소드
    public static List<String> isMyFriends(String user, List<List<String>> friends) {
        List<String> userFrineds = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                userFrineds.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                userFrineds.add(friend.get(0));
            }
        }

        return userFrineds;
    }

    // user와 함께 아는 친구 구하기
    public static List<String> knownFriends(String user, List<String> userFriends, List<List<String>> friends) {
        List<String> knownFriendList = new ArrayList<>();

        for (List<String> friend : friends) {
            for (String userFriend : userFriends) {
                if (friend.get(0).equals(userFriend) && !friend.get(1).equals(user)) {
                    knownFriendList.add(friend.get(1));
                } else if (friend.get(1).equals(userFriend) && !friend.get(0).equals(user)) {
                    knownFriendList.add(friend.get(0));
                }
            }
        }

        // 리스트 중복 제거
        List<String> nonOverlapKnowFriendList = new ArrayList<>();
        for (String knownfriend : knownFriendList) {
            if (!nonOverlapKnowFriendList.contains(knownfriend)) {
                nonOverlapKnowFriendList.add(knownfriend);
            }
        }

        return nonOverlapKnowFriendList;
    }
}