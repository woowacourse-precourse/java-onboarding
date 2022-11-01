package onboarding;

import java.util.List;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiSumScore = sumScore(pobi.get(0), pobi.get(1));
        int crongSumScore = sumScore(crong.get(0), crong.get(1));
        int pobiMulScore = mulScore(pobi.get(0), pobi.get(1));
        int crongMulScore = mulScore(crong.get(0), crong.get(1));

        int pobiScore = Math.max(pobiSumScore, pobiMulScore);
        int crongScore = Math.max(crongSumScore, crongMulScore);

        int Exceptions = pobi.get(1) - pobi.get(0);
        int Exceptions2 = crong.get(1) - crong.get(0);

        if ((Exceptions != 1 || Exceptions2 != 1) || (pobi.get(0) % 2 != 1) || (crong.get(0) % 2 != 1)) {
            return -1;
        }
        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }

    private static int sumScore(Integer pobiLeft, Integer crongLeft) {
        String pobiStr = pobiLeft.toString();
        String crongStr = crongLeft.toString();

        return Math.max(sumCalculation(pobiStr), sumCalculation(crongStr));
    }

    private static int sumCalculation(String page) {
        int result = 0;
        for (int i = 0; i < page.length(); i++) {
            result += Integer.parseInt(String.valueOf(page.charAt(i)));
        }
        return result;
    }

    private static int mulScore(Integer pobiRight, Integer crongRight) {
        String pobiStr = pobiRight.toString();
        String crongStr = crongRight.toString();

        return Math.max(mulCalculation(pobiStr),mulCalculation(crongStr));
    }

    private static int mulCalculation(String page) {
        int result = 1;
        for (int i = 0; i < page.length(); i++) {
            result *= Integer.parseInt(String.valueOf(page.charAt(i)));
        }
        return result;
    }
}
