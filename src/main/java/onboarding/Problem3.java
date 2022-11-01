package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        List<String> numStrings = new ArrayList<>();
        List<List<String>> divideNumArr = new ArrayList<>();
        for (int i = 0; i < number + 1; i++) {
            numStrings.add("" + i);
            divideNumArr.add(List.of(numStrings.get(i).split("")));
        }

        List<String> numList = divideNumArr.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        for (String s : numList) {
            if (s.contains("3") || s.contains("6") || s.contains("9")) {
                ++answer;
            }
        }
        return answer;
    }
}
