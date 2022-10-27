package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    //두 글자씩 문자 나누기
    private static List<String> divideByTwoChars(String nickNames) {
        List<String> eachTwoChars = new ArrayList<>();

        for (int i = 0; i < nickNames.length() - 1; i++) {
            eachTwoChars.add("" + nickNames.charAt(i) + nickNames.charAt(i + 1));
        }

        return eachTwoChars;
    }

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = List.of("answer");

        List<List<String>> indexTwoChars = new ArrayList<>();
        List<String> allTwoChars = new ArrayList<>();

        String nickname;

        
        return answer;
    }
}
