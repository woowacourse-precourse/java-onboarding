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

    private static int calcMaxScore(int number) {
        int sum;
        int mul;

        sum = sumScore(number);
        mul = mulScore(number);

        return Math.max(mul, sum);
    }

    private static boolean checkParam(List<Integer> list) {
        Integer leftPage;
        Integer rightPage;

        if (list == null || list.size() != 2) {
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
        int answer;
        int pobiMax = Integer.MIN_VALUE;
        int crongMax = Integer.MIN_VALUE;

        if (checkParam(pobi) || checkParam(crong)) {
            return -1;
        }

        for (int i = 0; i < 2; i++) {
            pobiMax = Math.max(pobiMax, calcMaxScore(pobi.get(i)));
            crongMax = Math.max(crongMax, calcMaxScore(crong.get(i)));
        }

        if (pobiMax == crongMax) {
            answer = 0;
        } else if (pobiMax > crongMax) {
            answer = 1;
        } else {
            answer = 2;
        }
        return answer;
    }
}
