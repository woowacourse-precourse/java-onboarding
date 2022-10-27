package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

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

    // arrayList -> string 로 변환
    private static String changeList(ArrayList<String> input) {
        String answer = "";
        for(int i = 0; i<input.size(); i++) {
            answer += input.get(i);
        }
        return answer;
    }

}
