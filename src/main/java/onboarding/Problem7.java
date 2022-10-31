package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}

class User {

    private final String id;

    User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    static void validateIdLength(String id) {
        if (id.length() < 1 || 30 < id.length()) {
            throw new IllegalStateException("id는 1이상 30이하의 문자열로 입력해주세요");
        }
    }

}