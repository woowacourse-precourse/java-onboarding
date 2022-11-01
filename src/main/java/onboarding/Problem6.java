package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        if (!isValidCrewSize(forms.size())) {
            return Collections.emptyList();
        }

        return answer;
    }

    private static boolean isValidCrewSize(int size) {
        return size >= 1 && size <= 10000;
    }

    private static boolean checkLength(String emails) {
        int emailLength = emails.length();
        return emailLength >= 11 && emailLength < 20;
    }

}
