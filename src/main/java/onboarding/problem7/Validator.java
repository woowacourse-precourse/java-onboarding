package onboarding.problem7;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    // 입력된 사용자 아이디, 친구 목록, 방문자 목록의 유효성 검증 기능
    public static void validate(String user, List<List<String>> friendsList, List<String> visitors){
        userValidate(user);
        friendsValidate(friendsList);
        visitorsValidate(visitors);
    }

    // 아이디는 알파벳 소문자로만 이루어져 있다.
    public static void idValidate(String id) {
        if (!Pattern.matches("^[a-z]*$", id) ) {
            throw new IllegalArgumentException("아이디는 알파벳 소문자로만 이루어져야 합니다.");
        }
    }

    public static void userValidate(String user) {
        idValidate(user);
        userLengthBetween(user);
    }

    // user는 길이가 1 이상 30 이하인 문자열
    public static void userLengthBetween(String user) {
        if (user.length() < 1 || user.length() > 30) {
            throw new IllegalArgumentException("아이디는 1자 이상 30자 이하입니다.");
        }
    }

    public static void friendsValidate(List<List<String>> friendsList) {
        friendListSizeBetween(friendsList);
        for (List<String> friends: friendsList) {
            friendsSizeCheck(friends);
        }
    }

    // friends는 길이가 1 이상 10,000 이하인 리스트/배열
    public static void friendListSizeBetween(List<List<String>> friendsList) {
        if (friendsList.size() < 1 || friendsList.size() > 10000) {
            throw new IllegalArgumentException("친구 목록은 1 이상 10,000 이하인 배열입니다.");
        }
    }

    // friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
    public static void friendsSizeCheck(List<String> friends) {
        for (String friend : friends) {
            idValidate(friend);
        }
        if (friends.size() != 2) {
            throw new IllegalArgumentException("친구 목록의 각 원소의 길이는 2입니다.");
        }
    }

    // visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
    public static void visitorsValidate(List<String> visitors) {
        for (String visitor : visitors) {
            idValidate(visitor);
        }
        if (visitors.size() > 10000) {
            throw new IllegalArgumentException("사용자 타임라인 방문자 목록은 1 이상 10,000 이하인 배열입니다.");
       }
    }

}
