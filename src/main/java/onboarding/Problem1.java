package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMax = calculateMaxValue(pobi);
        int crongMax = calculateMaxValue(crong);
        int answer = compareMaxValue(pobiMax, crongMax);
        return answer;
    }

    public static int calculateMaxValue(List<Integer> pageList) {
        List<Integer> resultList = new ArrayList<>();
        for (int num : pageList) {
            resultList.add(sumEveryDigits(num));
            resultList.add(multipleEveryDigits(num));
        }
        int result = Collections.max(resultList);
        return result;
    }

    static int sumEveryDigits(int num) {
        List<Integer> digitList = splitDigits(num);
        int result = digitList.stream().mapToInt(Integer::intValue).sum();
        return result;
    }

    static List<Integer> splitDigits(int num) {
        int[] arrayOfNum = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        List<Integer> result = Arrays.stream(arrayOfNum).boxed().collect(Collectors.toList());
        return result;
    }
}