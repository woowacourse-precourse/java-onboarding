package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {

        List<Character> cryptogramList = cryptogram.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> result = new ArrayList<>(cryptogramList);

        String answer = "answer";
        return answer;
    }
}