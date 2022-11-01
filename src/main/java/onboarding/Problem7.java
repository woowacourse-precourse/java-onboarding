package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {

    private static final int USER_MIN_LENGTH = 1;
    private static final int USER_MAX_LENGTH = 30;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    //user의 길이가 1이상 30이하인지 검증하는 기능
    public static boolean checkUserLengthValidation(String user) {
        return USER_MIN_LENGTH <= user.length() && user.length() <= USER_MAX_LENGTH;
    }

}
