package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (validate(pobi) || validate(crong)) return -1;

        int pobiResult = getMaxProcessedValue(pobi);
        int crongResult = getMaxProcessedValue(crong);

        int answer = getResult(pobiResult, crongResult);

        return answer;
    }

    private static boolean validate(List<Integer> pages) {
        if (pages.get(1) - pages.get(0) > 1) return true;
        if (pages.get(1) >= 400 || pages.get(0) <= 1) return true;
        if (pages.get(1) <= pages.get(0)) return true;

        return false;
    }

    private static int getResult(int pobiValue, int crongValue) {
        if (pobiValue == crongValue) return 0;
        else if (pobiValue > crongValue) return 1;
        else return 2;
    }

    private static int getMaxProcessedValue(List<Integer> pages) {
        int[] oddNumberDigits = spreadDigit(pages.get(0));
        int[] evenNumberDigits = spreadDigit(pages.get(1));

        int resultOdd = Math.max(getMultiValue(oddNumberDigits), getAddValue(oddNumberDigits));
        int resultEven = Math.max(getMultiValue(evenNumberDigits), getAddValue(evenNumberDigits));

        return Math.max(resultOdd, resultEven);
    }

    private static int[] spreadDigit(Integer value) {
        String valStr = value.toString();
        int[] singleDigitArray = new int[valStr.length()];

        for (int i = 0; i < valStr.length(); i++){
            singleDigitArray[i] = valStr.charAt(i) - '0';
        }

        return singleDigitArray;
    }

    private static int getAddValue(int[] numbers) {
        return Arrays.stream(numbers).reduce(0, Integer::sum);
    }

    private static int getMultiValue(int[] numbers) {
        return Arrays.stream(numbers).reduce(1, (a, b)-> a * b);
    }
}