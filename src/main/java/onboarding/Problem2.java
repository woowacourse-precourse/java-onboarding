package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<String> collect = Arrays.stream(cryptogram.split("")).collect(Collectors.toList());
        List<Integer> sames = new ArrayList<>();
        for (int i = 0; i < collect.size()-1; i++) {
            if (collect.get(i).equals(collect.get(i + 1))) {
                sames.add(i);
            }
        }
        String answer = "answer";
        return answer;
    }
}
