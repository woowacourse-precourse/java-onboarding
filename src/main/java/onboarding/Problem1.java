package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!validate(pobi, crong)) return -1;
        else {
            String[] pobiLeft = String.valueOf(pobi.get(0)).split("");
            String[] pobiRight = String.valueOf(pobi.get(1)).split("");
            String[] crongLeft = String.valueOf(crong.get(0)).split("");
            String[] crongRight = String.valueOf(crong.get(1)).split("");

            int pobiMax = getMax(pobiLeft, pobiRight);
            int crongMax = getMax(crongLeft, crongRight);

            if (pobiMax > crongMax) return 1;
            if (pobiMax < crongMax) return 2;
            return 0;
        }
    }

    private static int getMax(String[] leftPage, String[] rightPage) {
        int tmpLeft;
        int tmpRight;
        int sumLeft = 0;
        int byLeft = 1;
        int sumRight = 0;
        int byRight = 1;

        for (int i = 0; i < leftPage.length; i++) {
            sumLeft += Integer.parseInt(leftPage[i]);
            byLeft *= Integer.parseInt(leftPage[i]);
        }
        tmpLeft = Math.max(sumLeft, byLeft);

        int max = tmpLeft;

        for (int i = 0; i < rightPage.length; i++) {
            sumRight += Integer.parseInt(rightPage[i]);
            byRight *= Integer.parseInt(rightPage[i]);
        }
        tmpRight = Math.max(sumRight, byRight);

        if (tmpRight > max) max = tmpRight;
        return max;
    }

    private static boolean validate(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(1) - pobi.get(0) == 1 && crong.get(1) - crong.get(0) == 1
                && pobi.get(0) != 1 && pobi.get(1) != 400 && crong.get(0) != 1 && crong.get(1) != 400
                && pobi.get(0) % 2 == 1 && (pobi.get(1) % 2) == 0 && crong.get(0) % 2 == 1 && crong.get(1) % 2 == 0;
    }
}