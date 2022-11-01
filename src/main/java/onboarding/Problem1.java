package onboarding;

import java.util.List;

class Problem1 {
    private static final int POBI = 1;
    private static final int CRONG = 2;
    private static final int DRAW = 0;

    private static final int ERROR = -1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;


        if (checkWrongValue(pobi) || checkWrongValue(crong)) {
            answer = ERROR;

            return answer;
        }

        int pobiMaxValue = calculatePage(pobi);
        int crongMaxValue = calculatePage(crong);

        answer = calculateWinner(pobiMaxValue, crongMaxValue);

        return answer;
    }

    private static boolean checkWrongValue(List<Integer> list) {
        return list.get(1) - list.get(0) != 1;
    }

    private static int calculatePage(List<Integer> list) {
        int pobiPlus = 0;
        int[] plusResults = new int[2];

        int pobiMultiply = 1;
        int[] multiplyResults = new int[2];

        for (int i = 0; i < list.size(); i++) {
            int pageNum = list.get(i);
            while (pageNum > 0) {
                pobiPlus += pageNum % 10;
                pobiMultiply *= pageNum % 10;

                pageNum /= 10;
            }

            plusResults[i] = pobiPlus;
            multiplyResults[i] = pobiMultiply;

            pobiPlus = 0;
            pobiMultiply = 0;
        }

        int plusMaxValue = Math.max(plusResults[0], plusResults[1]);
        int multiplyMaxValue = Math.max(multiplyResults[0], multiplyResults[1]);

        return Math.max(plusMaxValue, multiplyMaxValue);
    }

    private static int calculateWinner(int pobi, int crong) {
        if (pobi > crong)
            return POBI;
        else if (crong > pobi) {
            return CRONG;
        } else {
            return DRAW;
        }
    }
}