package onboarding;

import java.util.List;

class Problem1 {

    private static int sumScore(int number) {
        int result = 0;

        while (number != 0) {
            result += (number % 10);
            number /= 10;
        }
        return result;
    }

    private static int mulScore(int number) {
        int result = 1;

        while (number != 0) {
            result *= (number % 10);
            number /= 10;
        }
        return result;
    }

    private static boolean checkParam(List<Integer> list) {
        Integer leftPage;
        Integer rightPage;

        if (list.size() != 2) {
            return true;
        }

        leftPage = list.get(0);
        rightPage = list.get(1);

        if (leftPage == null || rightPage == null) {
            return true;
        } else if (leftPage % 2 == 0 || leftPage < 1 || 399 < leftPage || rightPage - leftPage != 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}
