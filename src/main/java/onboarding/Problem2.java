package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        return answer;
    }

    /**
     * @param str : 문자열
     * @return str을 한글자씩 자른 ArrayList<String>
     */
    private static ArrayList<String> splitStringToArrayList(String str){
        String[] strArray = str.split("");
        return  new ArrayList<>(Arrays.asList(strArray));
    }
}
