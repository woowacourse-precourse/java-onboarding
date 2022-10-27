package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    // string -> arrayList 로 변환
    private static ArrayList<String> changeString(String input) {
        String[] strArr = input.split("");
        ArrayList<String> output = new ArrayList<String>(Arrays.asList(strArr));
        return output;
    }
}
