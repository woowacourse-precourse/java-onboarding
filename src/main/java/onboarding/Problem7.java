package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem7 {
    static void isCheck(String user, List<List<String>> friends, List<String> visitors) {
        userCheck(user);
        friendsCheck(friends);
        visitorsCheck(visitors);
    }

    static void userCheck(String user) {
        if (user.length() < 1 || user.length() > 30) {
            System.out.println("user의 길이가 잘못되었습니다.");
        }
        if (!Pattern.matches("[a-z]*$", user)) {
            System.out.println("user는 알파벳 소문자만 입력가능합니다.");
        }
    }

    static void friendsCheck(List<List<String>> friends) {
        if (friends.size() < 1 || friends.size() > 10000) {
            System.out.println("친구관계정보는 1이상 10,000이하까지 입력이 가능합니다.");
        }
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j <= 1; j++) {
                if (friends.get(i).get(j).length() < 1 || friends.get(i).get(j).length() > 30) {
                    System.out.println("친구아이디 길이는 1이상 30이하까지 입력이 가능합니다.");
                }
            }
        }
    }

    static void visitorsCheck(List<String> visitors) {
        if (visitors.size() < 0 || visitors.size() > 10000) {
            System.out.println("방문기록은 0이상 10,000이하까지 입력이 가능합니다.");
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        isCheck(user, friends, visitors);
        return answer;
    }
}
