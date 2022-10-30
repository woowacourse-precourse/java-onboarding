package onboarding;

import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    static TreeSet<String> emailSet = new TreeSet<>();

    /**
     * 중복된 문자열을 지닌 이메일을 전역변수 TreeSet에 추가하는 메서드
     *
     * @param email
     */
    static void addToSet(String email) {
        emailSet.add(email);
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
