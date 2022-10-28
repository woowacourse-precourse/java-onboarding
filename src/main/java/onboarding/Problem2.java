package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static List<String> stringToList(String cryptogram) {
        String[] cryptogramArray = cryptogram.split("");
        List<String> result = new ArrayList<>(Arrays.asList(cryptogramArray));

        return result;
    }

    public static String listToString(List<String> stringList) {
        String result = stringList.toString()
            .replace("[", "")
            .replace("]", "")
            .replace(",", "")
            .replace(" ", "");

        return result;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
