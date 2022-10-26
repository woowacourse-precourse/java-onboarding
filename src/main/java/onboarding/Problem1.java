package onboarding;

import java.util.ArrayList;
import java.util.List;


class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkPageException(pobi) && checkPageException(crong)) {
            // 각 점수 계산
            int poingOfPobi = calcPoint(pobi);
            int pointOfCrong = calcPoint(crong);

            return calcWinner(poingOfPobi, pointOfCrong);
        }
        // 예외사항은 -1을 return
        return -1;
    }

    private static boolean checkPageException(List<Integer> pages) {
        int right = pages.get(1);
        // 오른쪽 페이지가 2 < right < 400 인지 확인
        if(2 < right && right < 400) {
            int left = pages.get(0);
            // 왼쪽 페이지 + 1이 오른쪽 페이지의 값이 맞는지 확인
            if (left + 1 == right) {
                // 오른쪽 페이지가 짝수가 맞는지 확인
                return right % 2 == 0;
            }
        }
        return false;
    }

    private static int calcPoint(List<Integer> pages) {
        int point = 0;
        for(Integer page: pages) {
            List<Integer> digits = digitPage(page);
            int addPoint = addDigit(digits);
            int multiplePoint = mutiplyDigit(digits);
            // 가장 큰 수를 return 한다.
            point = Math.max(point, Math.max(addPoint, multiplePoint));
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
        if (poingOfPobi > pointOfCrong) {
            return  1;
        } else if (pointOfCrong > poingOfPobi) {
            return  2;
        }
        return 0;
    }
}

