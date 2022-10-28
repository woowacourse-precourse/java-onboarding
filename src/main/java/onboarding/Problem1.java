package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        List<List<Integer>> pobiSeperateedDigits = separateDigits(pobi);
        List<List<Integer>> crongSeperatedDigits = separateDigits(crong);

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static List<List<Integer>> separateDigits(List<Integer> pages) {
        List<List<Integer>> digitsNum = new ArrayList<>();

        for (int page : pages) {
            int [] onePage = Stream.of(String.valueOf(page).split("")).mapToInt(Integer::parseInt).toArray();
            List<Integer> al = Arrays.stream(onePage).boxed().collect(Collectors.toList());
            digitsNum.add(al);
        }

        return digitsNum;
    }
}