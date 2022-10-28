package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int sumResult = 0;
        for (int index = 1; index <= number; index++) {
            String indexStr = String.valueOf(index);
            String[] arrStr = new String[indexStr.length()];
            arrStr = indexStr.split("");
            sumResult = getSumResult(sumResult, arrStr);
            arrStr = null;
        }
        return sumResult;
    }

    private static int getSumResult(int sumResult, String[] arrStr) {
        for (String value : arrStr) {
            if (isThreeSixNine(value)) {
                sumResult = sumResult + 1;
            }
        }
        return sumResult;
    }

    private static boolean isThreeSixNine(String value) {
        if (value.equals("3") || value.equals("6") || value.equals("9")) {
            return true;
        } else {
            return false;
        }
    }
}

