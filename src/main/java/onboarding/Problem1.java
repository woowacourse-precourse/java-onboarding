package onboarding;

import java.util.Arrays;
import java.util.List;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //예외사항 -1을 리턴한다.
        if (exceptionCase(pobi)) return -1;
        if (exceptionCase(crong)) return -1;

        //페이지의 각 숫자를 더하거나 곱한것 중 더 큰것을 구한다 -> pageNumValue
        //그중 가장 큰 값을 본인의 수로 한다.
        int pobiNum = pobi.stream()
                .mapToInt(i -> pageNumValue(i))
                .max()
                .orElseThrow();
        int crongNum = crong.stream()
                .mapToInt(i -> pageNumValue(i))
                .max()
                .orElseThrow();

        //점수를 비교한다
        //포비승=1, 크롱승=2, 무승부 0 리턴한다.
        if (pobiNum > crongNum) return 1;
        if (crongNum > pobiNum) return 2;
        return 0;
    }

    private static boolean exceptionCase(List<Integer> bookNumList) {
        //예외처리 메소드
        if (bookNumList.size() != 2) return true;
        return bookNumList.get(1) - bookNumList.get(0) != 1;
    }

    private static Integer pageNumValue(Integer pageNum) {
        //합과 곱중 더 큰값을 리턴하는 메소드

        //각 숫자의 합
        int plusNum = Arrays.stream(pageNum.toString().split(""))
                .mapToInt(Integer::parseInt).sum();

        //각 숫자의 곱
        int gobNum = Arrays.stream(pageNum.toString().split(""))
                .mapToInt(Integer::parseInt)
                .reduce(1, (num1, num2) -> num1*num2);

        return Math.max(plusNum, gobNum);
    }
}