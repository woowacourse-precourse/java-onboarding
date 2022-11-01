package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!isCorrectInput(pobi) || !isCorrectInput(crong)) {
            return -1;
        }

        int pobiNum = 0;
        int crongNum = 0;
        for (int i : pobi) {
            pobiNum = Math.max(pobiNum, getMaxValue(i));
        }

        for (int i : crong) {
            crongNum = Math.max(crongNum, getMaxValue(i));
        }
        return pobiNum > crongNum
                ? 1
                : pobiNum < crongNum ? 2
                : 0;
    }

    public static int getMaxValue(int num) {
        String stringNumber = String.valueOf(num);
        int sum = 0;
        int multi = 1;
        for (int i = 0; i < stringNumber.length(); i++) {
            int number = stringNumber.charAt(i) - '0';
            sum += number;
            multi *= number;

        }

        return Math.max(sum, multi);
    }

    public static boolean isCorrectInput(List<Integer> list) {
        if (list.get(1) - list.get(0) != 1) {
            return false;
        }
        return true;
    }
}