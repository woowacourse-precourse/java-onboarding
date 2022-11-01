package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * @Problem: 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.
 */
class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkPageException(pobi) || checkPageException(crong)) {
            return -1;      // 예외사항은 -1을 return
        }
        return calcWinner(calcPoint(pobi), calcPoint(crong));
    }

    private static boolean checkPageException(List<Integer> pages) {
        int right = pages.get(1);
        if(2 < right && right < 400 && pages.get(0) + 1 == right) { // 오른쪽 페이지가 2 < right < 400 인지 확인, 왼쪽 페이지 + 1이 오른쪽 페이지의 값이 맞는지 확인
            return right % 2 == 1; // 오른쪽 페이지가 짝수가 맞는지 확인
        }
        return true;
    }

    private static int calcPoint(List<Integer> pages) {
        int point = 0;
        for(Integer page: pages) {
            List<Integer> digits = digitPage(page);
            point = Math.max(point, Math.max(addDigit(digits), mutiplyDigit(digits))); // 가장 큰 수를 return 한다.
        }
        return point;
    }

    private static List<Integer> digitPage(Integer num) {
        List<Integer> digits = new ArrayList<>();
        // 각 페이지 번호를 받아 자릿수 별로 나눈다.
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        return digits;
    }

    private static int addDigit(List<Integer> digits) {
        return digits.stream().mapToInt(Integer::intValue).sum();
    }

    private static int mutiplyDigit(List<Integer> digits) {
        return digits.stream().reduce(1, (a, b) -> a * b);
    }

    private static int calcWinner(int poingOfPobi, int pointOfCrong) {
        // 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0을 return
        return (poingOfPobi == pointOfCrong) ? 0 : ((poingOfPobi > pointOfCrong) ? 1 : 2);
    }
}

