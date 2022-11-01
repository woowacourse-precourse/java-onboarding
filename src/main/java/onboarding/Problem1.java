package onboarding;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;


        List<Integer> pobiSumList = pobi.stream().map(i -> sum(i)).collect(Collectors.toList());
        List<Integer> crongSumList = crong.stream().map(i -> sum(i)).collect(Collectors.toList());

        List<Integer> pobiMulList = pobi.stream().map(i -> mul(i)).collect(Collectors.toList());
        List<Integer> crongMulList = crong.stream().map(i -> mul(i)).collect(Collectors.toList());

        List<Integer> pobiTotalList = Stream.of(pobiSumList, pobiMulList)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        List<Integer> crongTotalList = Stream.of(crongSumList, crongMulList)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());

        // 예외사항 검사
        if (isException(pobiSumList) || isException(crongSumList)) {
            return -1;
        }

        if (findMaxValue(pobiTotalList) > findMaxValue(crongTotalList)) {
            answer = 1;
        }
        else if (findMaxValue(pobiTotalList) < findMaxValue(crongTotalList)) {
            answer = 2;
        }
        else if (findMaxValue(pobiTotalList) == findMaxValue(crongTotalList)) {
            answer = 0;
        }

        return answer;
    }
    public static int sum(Integer num) {
        String str = "" + num;
        List<String> stringList = new ArrayList<>(Arrays.asList(str.split("")));
        int result = stringList.stream()
                .map(s -> Integer.parseInt(s)) // 각각의 문자를 전부 숫자로 변환
                .mapToInt(Integer::intValue).sum(); // 모두 더함
        return result;
    }

    public static int mul(Integer num) {
        String str = "" + num;
        List<String> stringList = new ArrayList<>(Arrays.asList(str.split("")));
        int result = stringList.stream()
                .map(s -> Integer.parseInt(s)) // 각각의 문자를 전부 숫자로 변환
                .mapToInt(Integer::intValue).reduce(1, (a, b) -> a * b); // 모두 곱함
        return result;
    }

    public static boolean isException(List<Integer> integerList) {
        if (integerList.get(0) + 1 == integerList.get(1)) {
            return false;
        } else {
            return true;
        }
    }

    public static int findMaxValue(List<Integer> integerList) {
        return integerList.stream().max(Integer::compareTo).orElse(0);
    }
}