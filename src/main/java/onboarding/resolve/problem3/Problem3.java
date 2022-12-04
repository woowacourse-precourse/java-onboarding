package onboarding.resolve.problem3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem3 {

    public static int solution(int number) {
        List<String> numStrs = splitNum(number);
        return count3or6or9(numStrs);

    }

    private static int count3or6or9(List<String> numStrs) {
        int answer = 0;
        for (String str : numStrs) {
            if ( str.equals("3") || str.equals("6") || str.equals("9") ) {
                answer += 1;
            }
        }
        return answer;
    }

    private static List<String> splitNum(int number) {
        List<String> numStrs = new ArrayList<>();
        IntStream numIntStream = IntStream.range(1,number);
        numIntStream.forEach(i -> {
            String iStr = String.valueOf(i);
            numStrs.addAll(List.of(iStr.split("")));
        });
        return numStrs;
    }


}
