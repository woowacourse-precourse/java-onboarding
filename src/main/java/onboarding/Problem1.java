package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 1;
        int pobiLeftNumber;
        int crongLeftNumber;
        int pobiRightNumber;
        int crongRightNumber;
        int pobiMax;
        int crongMax;

        if (raisePageLengthException(pobi, crong) == 1){
            return answer = -1;
        }

        if (raisePageBoundException(pobi.get(0), crong.get(0)) == 1
                || raisePageBoundException(pobi.get(1), crong.get(1)) == 1) {
            return answer = -1;
        }

        pobiLeftNumber = calculatePage(pobi.get(0));
        crongLeftNumber = calculatePage(crong.get(0));
        pobiRightNumber = calculatePage(pobi.get(1));
        crongRightNumber = calculatePage(crong.get(1));

        pobiMax = compare(pobiLeftNumber, pobiRightNumber);
        crongMax = compare(crongLeftNumber, crongRightNumber);

        if (crongMax > pobiMax) {
            answer = 2;
        }

        if (crongMax == pobiMax) {
            answer = 0;
        }
        return answer;
    }

    public static int raisePageLengthException(List<Integer> pobi, List<Integer> crong) {
        int pobiLength = pobi.get(1) - pobi.get(0);
        int crongLength = crong.get(1) - crong.get(0);

        if (pobiLength != 1 || crongLength != 1) {
            return 1;
        }

        return 0;
    }

    public static int raisePageBoundException(int pobiPage, int crongPage) {
        boolean pobiBound = (pobiPage < 1 || pobiPage > 400);
        boolean crongBound = (crongPage < 1 || pobiPage > 400);

        if (pobiBound == true || crongBound == true) {
            return 1;
        }
        return 0;
    }

    public static int calculatePage(int page) {
        int sum = 0;
        int multiply = 1;
        int lastNumber;

        while (page != 0) {
            lastNumber = page % 10;
            sum += lastNumber;
            multiply *= lastNumber;
            page /= 10;
        }

        if (sum > multiply){
            return sum;
        }

        return multiply;
    }

    public static int compare(int left, int right) {
        if (left > right) {
            return left;
        }

        return right;
    }

}