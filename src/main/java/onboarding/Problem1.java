package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static boolean validation(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        // case1) 페이지가 2~399 사이의 범위에 있지 않다.
        if (leftPage <= 1 || leftPage >= 400 || rightPage <= 1 || rightPage >= 400){
            return false;
        }
        // case2) 왼쪽 페이지가 홀수가 아니다.
        if (leftPage % 2 != 1){
            return false;
        }
        //case3) 페이지가 연속된 숫자가 아니다.
        if (leftPage+1 != rightPage){
            return false;
        }

        return true;
    }

    public static List<Integer> getDigitList(Integer num){
        return Stream.of(String.valueOf(num).split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int getDigitSum(List<Integer> digitList){
        return digitList.stream()
                .mapToInt(i->i)
                .sum();
    }

    public static int getDigitMultiplied(List<Integer> digitList){
        return digitList.stream()
                .mapToInt(i->i)
                .reduce(1,(a,b)->a*b);
    }
}