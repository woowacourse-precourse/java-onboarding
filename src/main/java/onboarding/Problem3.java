package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if (!Validator.isValidate(number)) {
            return -1;
        }
        return getTotalClap(number);
    }

    private static int getTotalClap(int num){
        int totalResult = 0;
        for (int i = 1; i <= num; i++) {
            totalResult += getClap(i);
        }
        return totalResult;
    }

    private static int getClap(int num){
        int result = 0;
        String numString = String.valueOf(num);
        for (int i = 0; i < numString.length(); i++) {
            if (isClapIdx(numString, i)){
                result++;
            }
        }
        return result;
    }

    private static boolean isClapIdx(String numStr, int idx){
        final String CLAP_NUMS = "369";
        if (CLAP_NUMS.contains(numStr.substring(idx, idx + 1))){
            return true;
        }
        return false;
    }


    static class Validator{

        public static boolean isValidate(int num){
            try {
                isCorrectRange(num);
                return true;
            } catch (Exception error) {
                return false;
            }
        }

        private static void isCorrectRange(int num){
            if (num < 1 || num > 10000){
                throw new IllegalArgumentException("is not correct range");
            }
        }
    }
}
