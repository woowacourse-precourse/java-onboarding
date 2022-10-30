package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static boolean validateNicknameDuplication(String input, String target) {
        for (int left = 0; left < input.length() - 2; left++) {
            int right = left + 2;
            if (right > input.length()) right = input.length();

            String inputSub = input.substring(left, right);
            if (inputSub.length() < 2) return false;

            if (target.contains(inputSub)) return true;
        }

        return false;
    }

}
