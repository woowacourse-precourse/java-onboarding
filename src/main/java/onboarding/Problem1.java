package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        if (!IsExceptionCase(pobi) && !IsExceptionCase(crong)) {
            int pobiMaxResult = findMaxResult(pobi);
            int crongMaxResult = findMaxResult(crong);

            answer =  winner(pobiMaxResult, crongMaxResult);
        }

        return answer;
    }


    private static boolean IsExceptionCase(List<Integer> pages) {

        final int START_PAGE = 1;
        final int END_PAGE = 400;

        int leftPage = pages.get(0);
        int rightPage = pages.get(1);


        // 왼쪽이 홀수, 오른쪽이 짝수가 아닌 경우
        if (!(leftPage % 2 == 1 && rightPage % 2 == 0)) {
            return true;
        }

        // 첫번째 또는 마지막 페이지가 포함되어 있는 경우
        if (pages.contains(START_PAGE) || pages.contains(END_PAGE)) {
            return true;
        }

        // 연속된 숫자가 아닐 경우
        if (!(leftPage + 1 == rightPage)) {
            return true;
        }

        // 페이지 범위를 넘어선 경우
        if (leftPage < START_PAGE && rightPage > END_PAGE) {
            return true;
        }

        return false;
    }


    private static int pageAddition(int number) {
        int result = 0;

        while (number > 0) {
            result += number % 10;
            number /= 10;
        }

        return result;
    }


    private static int pageMultiply(int number) {
        int result = 1;

        while (number > 0) {
            result *= number % 10;
            number /= 10;
        }

        return result;
    }


    private static int findMaxResult(List<Integer> pages) {
        List<Integer> results = List.of(pageAddition(pages.get(0)),
                pageMultiply(pages.get(0)),
                pageAddition(pages.get(1)),
                pageMultiply(pages.get(1)));

        return results.stream().max(Integer::compare).orElse(-1);
    }


    private static int winner(int pobi, int crong) {
        if (pobi > crong) {
            return 1;
        } else if (pobi < crong) {
            return 2;
        } else {
            return 0;
        }
    }
}