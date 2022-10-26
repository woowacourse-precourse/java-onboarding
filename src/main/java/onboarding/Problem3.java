package onboarding;

public class Problem3 {
    public static int solution(int number) {
        Validator.isValidate(number);

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
            if (numString.charAt(i) == '3' || numString.charAt(i) == '6' || numString.charAt(i) == '9'){
                result++;
            }
        }
        return result;
    }


    static class Validator{

        public static boolean isValidate(int num){
            try {
                isCorrectRange(num);
            } catch (Exception error) {
                return false;
            }
            return true;
        }

        private static void isCorrectRange(int num){
            if (num < 1 || num > 10000){
                throw new IllegalArgumentException("is not correct range");
            }
        }
    }
}
